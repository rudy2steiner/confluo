import logging
from dialog import rpc_type_conversions
from dialog import rpc_configuration_params
from dialog import dialog_service
from dialog.rpc_stream import record_stream, alert_stream
from dialog.rpc_record_batch_builder import rpc_record_batch_builder
from dialog.ttypes import *
from thrift.transport import TTransport, TSocket
from thrift.protocol.TBinaryProtocol import TBinaryProtocol

class dialog_client:
    def __init__(self, host='localhost', port=9090):
        logging.basicConfig(level=logging.INFO)  # TODO: Read from configuration file
        self.LOG = logging.getLogger(__name__)
        self.connect(host, port)
        self.builder_ = rpc_record_batch_builder()
        self.read_buf = ""
        self.read_buf_offset = -1
        self.cur_table_id_ = -1

    def close(self):
        self.disconnect()

    def connect(self, host, port):
        self.LOG.info("Connecting to %s:%d", host, port)
        self.socket_ = TSocket.TSocket(host, port)
        self.transport_ = TTransport.TBufferedTransport(self.socket_)
        self.protocol_ = TBinaryProtocol(self.transport_)
        self.client_ = dialog_service.Client(self.protocol_)
        self.transport_.open()
        self.client_.register_handler()

    def disconnect(self):
        if self.transport_.isOpen():
            host = self.socket_.host
            port = self.socket_.port
            self.LOG.info("Disconnecting from %s:%d", host, port)
            self.client_.deregister_handler()
            self.transport_.close()

    def create_table(self, table_name, schema, storage_mode):
        self.cur_schema_ = schema
        rpc_schema = rpc_type_conversions.convert_to_rpc_schema(schema)
        self.cur_table_id_ = self.client_.create_table(table_name, rpc_schema, storage_mode)
        
    def set_current_table(self, table_name):
        info = self.client_.get_table_info(table_name) 
        self.cur_schema_ = rpc_type_conversions.convert_to_schema(info.schema)
        self.cur_table_id_ = info.table_id
        
    def remove_table(self):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        self.client_.remove_table(self.cur_table_id_)
        self.cur_table_id_ = -1
    
    def add_index(self, field_name, bucket_size=1):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        self.client_.add_index(self.cur_table_id_, field_name, bucket_size)

    def remove_index(self, field_name):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        self.client_.remove_index(self.cur_table_id_, field_name)

    def add_filter(self, filter_name, filter_expr):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        self.client_.add_filter(self.cur_table_id_, filter_name, filter_expr)

    def remove_filter(self, filter_name):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        self.client_.remove_filter(self.cur_table_id_, filter_name)

    def add_trigger(self, trigger_name, filter_name, trigger_expr):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        self.client_.add_trigger(self.cur_table_id_, trigger_name, filter_name, trigger_expr)

    def remove_trigger(self, trigger_name):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        self.client_.remove_trigger(self.cur_table_id_, trigger_name)

    def buffer(self, record):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        schema_rec_size = self.cur_schema_.record_size_
        if len(record) != schema_rec_size:
            raise ValueError("Record must be of length " + str(schema_rec_size))
        self.builder_.add_record(record)
        
    def write(self, record):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        schema_rec_size = self.cur_schema_.record_size_
        if len(record) != schema_rec_size:
            raise ValueError("Record must be of length " + str(schema_rec_size))
        self.client_.append(self.cur_table_id_, record)

    def flush(self):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        if self.builder_.num_records_ > 0:
            self.client_.append_batch(self.cur_table_id_, self.builder_.get_batch())
            
    def read(self, offset):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        rbuf_lim = self.read_buf_offset + len(self.read_buf)
        if self.read_buf_offset == -1 or offset < self.read_buf_offset or offset >= rbuf_lim:
            self.read_buf_offset = offset
            self.read_buf = self.client_.read(self.cur_table_id_, offset, rpc_configuration_params.READ_BATCH_SIZE)
        start = offset - self.read_buf_offset
        stop = start + self.cur_schema_.record_size_ 
        return self.read_buf[start : stop]

    def adhoc_filter(self, filter_expr):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        handle = self.client_.adhoc_filter(self.cur_table_id_, filter_expr)
        return record_stream(self.cur_table_id_, self.cur_schema_, self.client_, handle)

    def predef_filter(self, filter_name, begin_ms, end_ms):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        handle = self.client_.predef_filter(self.cur_table_id_, filter_name, begin_ms, end_ms)
        return record_stream(self.cur_table_id_, self.cur_schema_, self.client_, handle)

    def combined_filter(self, filter_name, filter_expr, begin_ms, end_ms):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        handle = self.client_.combined_filter(self.cur_table_id_, filter_name, filter_expr, begin_ms, end_ms)
        return record_stream(self.cur_table_id_, self.cur_schema_, self.client_, handle)

    def get_alerts(self, begin_ms, end_ms):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        handle = self.client.alerts_by_time(self.cur_table_id_, handle, begin_ms, end_ms)
        return alert_stream(self.cur_table_id_, self.cur_schema_, self.client_, handle)

    def num_records(self):
        if self.cur_table_id_ == -1:
            raise ValueError("Must set table first.")
        return self.client_.num_records(self.cur_table_id_)

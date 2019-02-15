package confluo.streaming;

import confluo.rpc.Record;
import confluo.rpc.RpcClient;
import confluo.rpc.Schema;
import confluo.streaming.config.ConsumerConfig;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Properties;

/**
 * ConfluoConsumer is message consumer can pull messages  start from the target offset
 * batch pull message can be enable if batch size was set to bigger than 1
 * thread safe
 */
public class ConfluoConsumer implements Closeable {
  Logger logger = LoggerFactory.getLogger(ConfluoConsumer.class);
  private String topic;
  private String host;
  private int port;
  private int prefetchSize;
  private RpcClient client;
  private boolean prefetchEnable;
  private Schema schema;

  public ConfluoConsumer(Properties properties) throws TException {

    host = properties.getProperty(ConsumerConfig.BOOTSTRAP_ADDRESS, ConsumerConfig.BOOTSTRAP_ADDRESS_DEFAULT);
    port = Integer.valueOf(properties.getProperty(ConsumerConfig.BOOTSTRAP_PORT, ConsumerConfig.BOOTSTRAP_PORT_DEFAULT));
    topic = properties.getProperty(ConsumerConfig.TOPIC, ConsumerConfig.TOPIC_DEFAULT);
    prefetchSize = Integer.valueOf(properties.getProperty(ConsumerConfig.PREFETCH_SIZE, ConsumerConfig.PREFETCH_SIZE_DEFAULT));
    prefetchEnable = prefetchSize > 1 ? true : false;
    client = new RpcClient(host, port);
    client.setCurrentAtomicMultilog(topic);
    schema = client.getSchema();
    logger.info(
        String.format(
                "\n ------------------- "
                    + "\n consumer config"
                    + "\n server address: %s,port:%d,topic:%s,prefetch size:%d",
                host, port, topic, prefetchSize)
            + "\n ------------------- ");
  }

  /**
   * Best effort consume consume from target offset
   *
   * @param offset log offset
   * @return record count
   */
  public int pull(long offset, Consumer<List<Record>> messageListener) throws TException {
    int batchSize;
    if (prefetchEnable) {
      List<Record> records = client.readBatch(offset, prefetchSize);
      batchSize = records.size();
      messageListener.accept(records);
    } else {
      List<Record> messages=new ArrayList<>();
      messages.add(client.read(offset));
      messageListener.accept(messages);
      batchSize = 1;
    }
    return batchSize;
  }

  public Schema getSchema() {
    return schema;
  }

  /** The number of records for the topic */
  public long maxRecord() throws TException {
    return client.numRecords();
  }

  @Override
  public void close() throws IOException {
    try {
      client.close();
    } catch (TException e) {
      throw new IOException(e);
    }
  }
}

/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package confluo.rpc;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)")
public class rpc_iterator_descriptor implements org.apache.thrift.TBase<rpc_iterator_descriptor, rpc_iterator_descriptor._Fields>, java.io.Serializable, Cloneable, Comparable<rpc_iterator_descriptor> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("rpc_iterator_descriptor");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField DATA_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("DataType", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField HANDLER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("handler_id", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new rpc_iterator_descriptorStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new rpc_iterator_descriptorTupleSchemeFactory();

  private long id; // required
  private rpc_iterator_type type; // required
  private rpc_data_type data_type; // required
  private int handler_id; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    /**
     * 
     * @see rpc_iterator_type
     */
    TYPE((short)2, "type"),
    /**
     * 
     * @see rpc_data_type
     */
    DATA_TYPE((short)3, "DataType"),
    HANDLER_ID((short)4, "handler_id");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // TYPE
          return TYPE;
        case 3: // DATA_TYPE
          return DATA_TYPE;
        case 4: // HANDLER_ID
          return HANDLER_ID;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __HANDLER_ID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64        , "rpc_iterator_id")));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, rpc_iterator_type.class)));
    tmpMap.put(_Fields.DATA_TYPE, new org.apache.thrift.meta_data.FieldMetaData("DataType", org.apache.thrift.TFieldRequirementType.REQUIRED,
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, rpc_data_type.class)));
    tmpMap.put(_Fields.HANDLER_ID, new org.apache.thrift.meta_data.FieldMetaData("handler_id", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "rpc_handler_id")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(rpc_iterator_descriptor.class, metaDataMap);
  }

  public rpc_iterator_descriptor() {
  }

  public rpc_iterator_descriptor(
    long id,
    rpc_iterator_type type,
    rpc_data_type data_type,
    int handler_id)
  {
    this();
    this.id = id;
    set_id_isSet(true);
    this.type = type;
    this.data_type = data_type;
    this.handler_id = handler_id;
    set_handler_id_isSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public rpc_iterator_descriptor(rpc_iterator_descriptor other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.is_set_type()) {
      this.type = other.type;
    }
    if (other.is_set_data_type()) {
      this.data_type = other.data_type;
    }
    this.handler_id = other.handler_id;
  }

  public rpc_iterator_descriptor deepCopy() {
    return new rpc_iterator_descriptor(this);
  }

  @Override
  public void clear() {
    set_id_isSet(false);
    this.id = 0;
    this.type = null;
    this.data_type = null;
    set_handler_id_isSet(false);
    this.handler_id = 0;
  }

  public long get_id() {
    return this.id;
  }

  public rpc_iterator_descriptor set_id(long id) {
    this.id = id;
    set_id_isSet(true);
    return this;
  }

  public void unset_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if Field id is set (has been assigned a value) and false otherwise */
  public boolean is_set_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void set_id_isSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  /**
   * 
   * @see rpc_iterator_type
   */
  public rpc_iterator_type get_type() {
    return this.type;
  }

  /**
   * 
   * @see rpc_iterator_type
   */
  public rpc_iterator_descriptor set_type(rpc_iterator_type type) {
    this.type = type;
    return this;
  }

  public void unset_type() {
    this.type = null;
  }

  /** Returns true if Field type is set (has been assigned a value) and false otherwise */
  public boolean is_set_type() {
    return this.type != null;
  }

  public void set_type_isSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  /**
   * 
   * @see rpc_data_type
   */
  public rpc_data_type get_data_type() {
    return this.data_type;
  }

  /**
   * 
   * @see rpc_data_type
   */
  public rpc_iterator_descriptor set_data_type(rpc_data_type data_type) {
    this.data_type = data_type;
    return this;
  }

  public void unset_data_type() {
    this.data_type = null;
  }

  /** Returns true if Field DataType is set (has been assigned a value) and false otherwise */
  public boolean is_set_data_type() {
    return this.data_type != null;
  }

  public void set_data_type_isSet(boolean value) {
    if (!value) {
      this.data_type = null;
    }
  }

  public int get_handler_id() {
    return this.handler_id;
  }

  public rpc_iterator_descriptor set_handler_id(int handler_id) {
    this.handler_id = handler_id;
    set_handler_id_isSet(true);
    return this;
  }

  public void unset_handler_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __HANDLER_ID_ISSET_ID);
  }

  /** Returns true if Field handler_id is set (has been assigned a value) and false otherwise */
  public boolean is_set_handler_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __HANDLER_ID_ISSET_ID);
  }

  public void set_handler_id_isSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __HANDLER_ID_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unset_id();
      } else {
        set_id((java.lang.Long)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unset_type();
      } else {
        set_type((rpc_iterator_type)value);
      }
      break;

    case DATA_TYPE:
      if (value == null) {
        unset_data_type();
      } else {
        set_data_type((rpc_data_type)value);
      }
      break;

    case HANDLER_ID:
      if (value == null) {
        unset_handler_id();
      } else {
        set_handler_id((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return get_id();

    case TYPE:
      return get_type();

    case DATA_TYPE:
      return get_data_type();

    case HANDLER_ID:
      return get_handler_id();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if Field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return is_set_id();
    case TYPE:
      return is_set_type();
    case DATA_TYPE:
      return is_set_data_type();
    case HANDLER_ID:
      return is_set_handler_id();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof rpc_iterator_descriptor)
      return this.equals((rpc_iterator_descriptor)that);
    return false;
  }

  public boolean equals(rpc_iterator_descriptor that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_type = true && this.is_set_type();
    boolean that_present_type = true && that.is_set_type();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_data_type = true && this.is_set_data_type();
    boolean that_present_data_type = true && that.is_set_data_type();
    if (this_present_data_type || that_present_data_type) {
      if (!(this_present_data_type && that_present_data_type))
        return false;
      if (!this.data_type.equals(that.data_type))
        return false;
    }

    boolean this_present_handler_id = true;
    boolean that_present_handler_id = true;
    if (this_present_handler_id || that_present_handler_id) {
      if (!(this_present_handler_id && that_present_handler_id))
        return false;
      if (this.handler_id != that.handler_id)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(id);

    hashCode = hashCode * 8191 + ((is_set_type()) ? 131071 : 524287);
    if (is_set_type())
      hashCode = hashCode * 8191 + type.getValue();

    hashCode = hashCode * 8191 + ((is_set_data_type()) ? 131071 : 524287);
    if (is_set_data_type())
      hashCode = hashCode * 8191 + data_type.getValue();

    hashCode = hashCode * 8191 + handler_id;

    return hashCode;
  }

  @Override
  public int compareTo(rpc_iterator_descriptor other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(is_set_id()).compareTo(other.is_set_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(is_set_type()).compareTo(other.is_set_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(is_set_data_type()).compareTo(other.is_set_data_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_data_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data_type, other.data_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(is_set_handler_id()).compareTo(other.is_set_handler_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_handler_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.handler_id, other.handler_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("rpc_iterator_descriptor(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("type:");
    if (this.type == null) {
      sb.append("null");
    } else {
      sb.append(this.type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("DataType:");
    if (this.data_type == null) {
      sb.append("null");
    } else {
      sb.append(this.data_type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("handler_id:");
    sb.append(this.handler_id);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'id' because it's a primitive and you chose the non-beans generator.
    if (type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required Field 'type' was not present! Struct: " + toString());
    }
    if (data_type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required Field 'DataType' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'handler_id' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class rpc_iterator_descriptorStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public rpc_iterator_descriptorStandardScheme getScheme() {
      return new rpc_iterator_descriptorStandardScheme();
    }
  }

  private static class rpc_iterator_descriptorStandardScheme extends org.apache.thrift.scheme.StandardScheme<rpc_iterator_descriptor> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, rpc_iterator_descriptor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id = iprot.readI64();
              struct.set_id_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = confluo.rpc.rpc_iterator_type.findByValue(iprot.readI32());
              struct.set_type_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DATA_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.data_type = confluo.rpc.rpc_data_type.findByValue(iprot.readI32());
              struct.set_data_type_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // HANDLER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.handler_id = iprot.readI32();
              struct.set_handler_id_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.is_set_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required Field 'id' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.is_set_handler_id()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required Field 'handler_id' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, rpc_iterator_descriptor struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI64(struct.id);
      oprot.writeFieldEnd();
      if (struct.type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.data_type != null) {
        oprot.writeFieldBegin(DATA_TYPE_FIELD_DESC);
        oprot.writeI32(struct.data_type.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(HANDLER_ID_FIELD_DESC);
      oprot.writeI32(struct.handler_id);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class rpc_iterator_descriptorTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public rpc_iterator_descriptorTupleScheme getScheme() {
      return new rpc_iterator_descriptorTupleScheme();
    }
  }

  private static class rpc_iterator_descriptorTupleScheme extends org.apache.thrift.scheme.TupleScheme<rpc_iterator_descriptor> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, rpc_iterator_descriptor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI64(struct.id);
      oprot.writeI32(struct.type.getValue());
      oprot.writeI32(struct.data_type.getValue());
      oprot.writeI32(struct.handler_id);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, rpc_iterator_descriptor struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.id = iprot.readI64();
      struct.set_id_isSet(true);
      struct.type = confluo.rpc.rpc_iterator_type.findByValue(iprot.readI32());
      struct.set_type_isSet(true);
      struct.data_type = confluo.rpc.rpc_data_type.findByValue(iprot.readI32());
      struct.set_data_type_isSet(true);
      struct.handler_id = iprot.readI32();
      struct.set_handler_id_isSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

package com.sensing.core.thrift.bean;

/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2018-04-27")
public class FaceTemplateFea implements org.apache.thrift.TBase<FaceTemplateFea, FaceTemplateFea._Fields>, java.io.Serializable, Cloneable, Comparable<FaceTemplateFea> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FaceTemplateFea");

  private static final org.apache.thrift.protocol.TField UUID_FIELD_DESC = new org.apache.thrift.protocol.TField("uuid", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField FT_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("ft_type", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField FT_FEA_FIELD_DESC = new org.apache.thrift.protocol.TField("ft_fea", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FaceTemplateFeaStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FaceTemplateFeaTupleSchemeFactory();

  public java.lang.String uuid; // required
  public int ft_type; // required
  public java.nio.ByteBuffer ft_fea; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    UUID((short)1, "uuid"),
    FT_TYPE((short)2, "ft_type"),
    FT_FEA((short)3, "ft_fea");

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
        case 1: // UUID
          return UUID;
        case 2: // FT_TYPE
          return FT_TYPE;
        case 3: // FT_FEA
          return FT_FEA;
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
  private static final int __FT_TYPE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.UUID, new org.apache.thrift.meta_data.FieldMetaData("uuid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FT_TYPE, new org.apache.thrift.meta_data.FieldMetaData("ft_type", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FT_FEA, new org.apache.thrift.meta_data.FieldMetaData("ft_fea", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FaceTemplateFea.class, metaDataMap);
  }

  public FaceTemplateFea() {
  }

  public FaceTemplateFea(
    java.lang.String uuid,
    int ft_type,
    java.nio.ByteBuffer ft_fea)
  {
    this();
    this.uuid = uuid;
    this.ft_type = ft_type;
    setFt_typeIsSet(true);
    this.ft_fea = org.apache.thrift.TBaseHelper.copyBinary(ft_fea);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FaceTemplateFea(FaceTemplateFea other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetUuid()) {
      this.uuid = other.uuid;
    }
    this.ft_type = other.ft_type;
    if (other.isSetFt_fea()) {
      this.ft_fea = org.apache.thrift.TBaseHelper.copyBinary(other.ft_fea);
    }
  }

  public FaceTemplateFea deepCopy() {
    return new FaceTemplateFea(this);
  }

  @Override
  public void clear() {
    this.uuid = null;
    setFt_typeIsSet(false);
    this.ft_type = 0;
    this.ft_fea = null;
  }

  public java.lang.String getUuid() {
    return this.uuid;
  }

  public FaceTemplateFea setUuid(java.lang.String uuid) {
    this.uuid = uuid;
    return this;
  }

  public void unsetUuid() {
    this.uuid = null;
  }

  /** Returns true if field uuid is set (has been assigned a value) and false otherwise */
  public boolean isSetUuid() {
    return this.uuid != null;
  }

  public void setUuidIsSet(boolean value) {
    if (!value) {
      this.uuid = null;
    }
  }

  public int getFt_type() {
    return this.ft_type;
  }

  public FaceTemplateFea setFt_type(int ft_type) {
    this.ft_type = ft_type;
    setFt_typeIsSet(true);
    return this;
  }

  public void unsetFt_type() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __FT_TYPE_ISSET_ID);
  }

  /** Returns true if field ft_type is set (has been assigned a value) and false otherwise */
  public boolean isSetFt_type() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __FT_TYPE_ISSET_ID);
  }

  public void setFt_typeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __FT_TYPE_ISSET_ID, value);
  }

  public byte[] getFt_fea() {
    setFt_fea(org.apache.thrift.TBaseHelper.rightSize(ft_fea));
    return ft_fea == null ? null : ft_fea.array();
  }

  public java.nio.ByteBuffer bufferForFt_fea() {
    return org.apache.thrift.TBaseHelper.copyBinary(ft_fea);
  }

  public FaceTemplateFea setFt_fea(byte[] ft_fea) {
    this.ft_fea = ft_fea == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(ft_fea.clone());
    return this;
  }

  public FaceTemplateFea setFt_fea(java.nio.ByteBuffer ft_fea) {
    this.ft_fea = org.apache.thrift.TBaseHelper.copyBinary(ft_fea);
    return this;
  }

  public void unsetFt_fea() {
    this.ft_fea = null;
  }

  /** Returns true if field ft_fea is set (has been assigned a value) and false otherwise */
  public boolean isSetFt_fea() {
    return this.ft_fea != null;
  }

  public void setFt_feaIsSet(boolean value) {
    if (!value) {
      this.ft_fea = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case UUID:
      if (value == null) {
        unsetUuid();
      } else {
        setUuid((java.lang.String)value);
      }
      break;

    case FT_TYPE:
      if (value == null) {
        unsetFt_type();
      } else {
        setFt_type((java.lang.Integer)value);
      }
      break;

    case FT_FEA:
      if (value == null) {
        unsetFt_fea();
      } else {
        if (value instanceof byte[]) {
          setFt_fea((byte[])value);
        } else {
          setFt_fea((java.nio.ByteBuffer)value);
        }
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case UUID:
      return getUuid();

    case FT_TYPE:
      return getFt_type();

    case FT_FEA:
      return getFt_fea();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case UUID:
      return isSetUuid();
    case FT_TYPE:
      return isSetFt_type();
    case FT_FEA:
      return isSetFt_fea();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof FaceTemplateFea)
      return this.equals((FaceTemplateFea)that);
    return false;
  }

  public boolean equals(FaceTemplateFea that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_uuid = true && this.isSetUuid();
    boolean that_present_uuid = true && that.isSetUuid();
    if (this_present_uuid || that_present_uuid) {
      if (!(this_present_uuid && that_present_uuid))
        return false;
      if (!this.uuid.equals(that.uuid))
        return false;
    }

    boolean this_present_ft_type = true;
    boolean that_present_ft_type = true;
    if (this_present_ft_type || that_present_ft_type) {
      if (!(this_present_ft_type && that_present_ft_type))
        return false;
      if (this.ft_type != that.ft_type)
        return false;
    }

    boolean this_present_ft_fea = true && this.isSetFt_fea();
    boolean that_present_ft_fea = true && that.isSetFt_fea();
    if (this_present_ft_fea || that_present_ft_fea) {
      if (!(this_present_ft_fea && that_present_ft_fea))
        return false;
      if (!this.ft_fea.equals(that.ft_fea))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetUuid()) ? 131071 : 524287);
    if (isSetUuid())
      hashCode = hashCode * 8191 + uuid.hashCode();

    hashCode = hashCode * 8191 + ft_type;

    hashCode = hashCode * 8191 + ((isSetFt_fea()) ? 131071 : 524287);
    if (isSetFt_fea())
      hashCode = hashCode * 8191 + ft_fea.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(FaceTemplateFea other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetUuid()).compareTo(other.isSetUuid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUuid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uuid, other.uuid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFt_type()).compareTo(other.isSetFt_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFt_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ft_type, other.ft_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFt_fea()).compareTo(other.isSetFt_fea());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFt_fea()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ft_fea, other.ft_fea);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("FaceTemplateFea(");
    boolean first = true;

    sb.append("uuid:");
    if (this.uuid == null) {
      sb.append("null");
    } else {
      sb.append(this.uuid);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ft_type:");
    sb.append(this.ft_type);
    first = false;
    if (!first) sb.append(", ");
    sb.append("ft_fea:");
    if (this.ft_fea == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.ft_fea, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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

  private static class FaceTemplateFeaStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FaceTemplateFeaStandardScheme getScheme() {
      return new FaceTemplateFeaStandardScheme();
    }
  }

  private static class FaceTemplateFeaStandardScheme extends org.apache.thrift.scheme.StandardScheme<FaceTemplateFea> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FaceTemplateFea struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // UUID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.uuid = iprot.readString();
              struct.setUuidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // FT_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.ft_type = iprot.readI32();
              struct.setFt_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // FT_FEA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ft_fea = iprot.readBinary();
              struct.setFt_feaIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, FaceTemplateFea struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.uuid != null) {
        oprot.writeFieldBegin(UUID_FIELD_DESC);
        oprot.writeString(struct.uuid);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(FT_TYPE_FIELD_DESC);
      oprot.writeI32(struct.ft_type);
      oprot.writeFieldEnd();
      if (struct.ft_fea != null) {
        oprot.writeFieldBegin(FT_FEA_FIELD_DESC);
        oprot.writeBinary(struct.ft_fea);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FaceTemplateFeaTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FaceTemplateFeaTupleScheme getScheme() {
      return new FaceTemplateFeaTupleScheme();
    }
  }

  private static class FaceTemplateFeaTupleScheme extends org.apache.thrift.scheme.TupleScheme<FaceTemplateFea> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FaceTemplateFea struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetUuid()) {
        optionals.set(0);
      }
      if (struct.isSetFt_type()) {
        optionals.set(1);
      }
      if (struct.isSetFt_fea()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetUuid()) {
        oprot.writeString(struct.uuid);
      }
      if (struct.isSetFt_type()) {
        oprot.writeI32(struct.ft_type);
      }
      if (struct.isSetFt_fea()) {
        oprot.writeBinary(struct.ft_fea);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FaceTemplateFea struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.uuid = iprot.readString();
        struct.setUuidIsSet(true);
      }
      if (incoming.get(1)) {
        struct.ft_type = iprot.readI32();
        struct.setFt_typeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.ft_fea = iprot.readBinary();
        struct.setFt_feaIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

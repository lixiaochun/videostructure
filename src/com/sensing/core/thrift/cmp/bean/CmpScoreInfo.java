/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sensing.core.thrift.cmp.bean;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "all"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2018-07-03")
public class CmpScoreInfo implements org.apache.thrift.TBase<CmpScoreInfo, CmpScoreInfo._Fields>, java.io.Serializable, Cloneable, Comparable<CmpScoreInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CmpScoreInfo");

  private static final org.apache.thrift.protocol.TField FEATUREID_FIELD_DESC = new org.apache.thrift.protocol.TField("featureid", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SCOREINFO_FIELD_DESC = new org.apache.thrift.protocol.TField("scoreinfo", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CmpScoreInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CmpScoreInfoTupleSchemeFactory();

  public java.lang.String featureid; // required
  public java.util.List<ScoreInfo> scoreinfo; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FEATUREID((short)1, "featureid"),
    SCOREINFO((short)2, "scoreinfo");

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
        case 1: // FEATUREID
          return FEATUREID;
        case 2: // SCOREINFO
          return SCOREINFO;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FEATUREID, new org.apache.thrift.meta_data.FieldMetaData("featureid", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SCOREINFO, new org.apache.thrift.meta_data.FieldMetaData("scoreinfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ScoreInfo.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CmpScoreInfo.class, metaDataMap);
  }

  public CmpScoreInfo() {
  }

  public CmpScoreInfo(
    java.lang.String featureid,
    java.util.List<ScoreInfo> scoreinfo)
  {
    this();
    this.featureid = featureid;
    this.scoreinfo = scoreinfo;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CmpScoreInfo(CmpScoreInfo other) {
    if (other.isSetFeatureid()) {
      this.featureid = other.featureid;
    }
    if (other.isSetScoreinfo()) {
      java.util.List<ScoreInfo> __this__scoreinfo = new java.util.ArrayList<ScoreInfo>(other.scoreinfo.size());
      for (ScoreInfo other_element : other.scoreinfo) {
        __this__scoreinfo.add(new ScoreInfo(other_element));
      }
      this.scoreinfo = __this__scoreinfo;
    }
  }

  public CmpScoreInfo deepCopy() {
    return new CmpScoreInfo(this);
  }

  @Override
  public void clear() {
    this.featureid = null;
    this.scoreinfo = null;
  }

  public java.lang.String getFeatureid() {
    return this.featureid;
  }

  public CmpScoreInfo setFeatureid(java.lang.String featureid) {
    this.featureid = featureid;
    return this;
  }

  public void unsetFeatureid() {
    this.featureid = null;
  }

  /** Returns true if field featureid is set (has been assigned a value) and false otherwise */
  public boolean isSetFeatureid() {
    return this.featureid != null;
  }

  public void setFeatureidIsSet(boolean value) {
    if (!value) {
      this.featureid = null;
    }
  }

  public int getScoreinfoSize() {
    return (this.scoreinfo == null) ? 0 : this.scoreinfo.size();
  }

  public java.util.Iterator<ScoreInfo> getScoreinfoIterator() {
    return (this.scoreinfo == null) ? null : this.scoreinfo.iterator();
  }

  public void addToScoreinfo(ScoreInfo elem) {
    if (this.scoreinfo == null) {
      this.scoreinfo = new java.util.ArrayList<ScoreInfo>();
    }
    this.scoreinfo.add(elem);
  }

  public java.util.List<ScoreInfo> getScoreinfo() {
    return this.scoreinfo;
  }

  public CmpScoreInfo setScoreinfo(java.util.List<ScoreInfo> scoreinfo) {
    this.scoreinfo = scoreinfo;
    return this;
  }

  public void unsetScoreinfo() {
    this.scoreinfo = null;
  }

  /** Returns true if field scoreinfo is set (has been assigned a value) and false otherwise */
  public boolean isSetScoreinfo() {
    return this.scoreinfo != null;
  }

  public void setScoreinfoIsSet(boolean value) {
    if (!value) {
      this.scoreinfo = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case FEATUREID:
      if (value == null) {
        unsetFeatureid();
      } else {
        setFeatureid((java.lang.String)value);
      }
      break;

    case SCOREINFO:
      if (value == null) {
        unsetScoreinfo();
      } else {
        setScoreinfo((java.util.List<ScoreInfo>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FEATUREID:
      return getFeatureid();

    case SCOREINFO:
      return getScoreinfo();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case FEATUREID:
      return isSetFeatureid();
    case SCOREINFO:
      return isSetScoreinfo();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof CmpScoreInfo)
      return this.equals((CmpScoreInfo)that);
    return false;
  }

  public boolean equals(CmpScoreInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_featureid = true && this.isSetFeatureid();
    boolean that_present_featureid = true && that.isSetFeatureid();
    if (this_present_featureid || that_present_featureid) {
      if (!(this_present_featureid && that_present_featureid))
        return false;
      if (!this.featureid.equals(that.featureid))
        return false;
    }

    boolean this_present_scoreinfo = true && this.isSetScoreinfo();
    boolean that_present_scoreinfo = true && that.isSetScoreinfo();
    if (this_present_scoreinfo || that_present_scoreinfo) {
      if (!(this_present_scoreinfo && that_present_scoreinfo))
        return false;
      if (!this.scoreinfo.equals(that.scoreinfo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetFeatureid()) ? 131071 : 524287);
    if (isSetFeatureid())
      hashCode = hashCode * 8191 + featureid.hashCode();

    hashCode = hashCode * 8191 + ((isSetScoreinfo()) ? 131071 : 524287);
    if (isSetScoreinfo())
      hashCode = hashCode * 8191 + scoreinfo.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(CmpScoreInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetFeatureid()).compareTo(other.isSetFeatureid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFeatureid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.featureid, other.featureid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetScoreinfo()).compareTo(other.isSetScoreinfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetScoreinfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.scoreinfo, other.scoreinfo);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("CmpScoreInfo(");
    boolean first = true;

    sb.append("featureid:");
    if (this.featureid == null) {
      sb.append("null");
    } else {
      sb.append(this.featureid);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("scoreinfo:");
    if (this.scoreinfo == null) {
      sb.append("null");
    } else {
      sb.append(this.scoreinfo);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CmpScoreInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CmpScoreInfoStandardScheme getScheme() {
      return new CmpScoreInfoStandardScheme();
    }
  }

  private static class CmpScoreInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<CmpScoreInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CmpScoreInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FEATUREID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.featureid = iprot.readString();
              struct.setFeatureidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SCOREINFO
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list8 = iprot.readListBegin();
                struct.scoreinfo = new java.util.ArrayList<ScoreInfo>(_list8.size);
                ScoreInfo _elem9;
                for (int _i10 = 0; _i10 < _list8.size; ++_i10)
                {
                  _elem9 = new ScoreInfo();
                  _elem9.read(iprot);
                  struct.scoreinfo.add(_elem9);
                }
                iprot.readListEnd();
              }
              struct.setScoreinfoIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CmpScoreInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.featureid != null) {
        oprot.writeFieldBegin(FEATUREID_FIELD_DESC);
        oprot.writeString(struct.featureid);
        oprot.writeFieldEnd();
      }
      if (struct.scoreinfo != null) {
        oprot.writeFieldBegin(SCOREINFO_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.scoreinfo.size()));
          for (ScoreInfo _iter11 : struct.scoreinfo)
          {
            _iter11.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CmpScoreInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CmpScoreInfoTupleScheme getScheme() {
      return new CmpScoreInfoTupleScheme();
    }
  }

  private static class CmpScoreInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<CmpScoreInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CmpScoreInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetFeatureid()) {
        optionals.set(0);
      }
      if (struct.isSetScoreinfo()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetFeatureid()) {
        oprot.writeString(struct.featureid);
      }
      if (struct.isSetScoreinfo()) {
        {
          oprot.writeI32(struct.scoreinfo.size());
          for (ScoreInfo _iter12 : struct.scoreinfo)
          {
            _iter12.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CmpScoreInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.featureid = iprot.readString();
        struct.setFeatureidIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.scoreinfo = new java.util.ArrayList<ScoreInfo>(_list13.size);
          ScoreInfo _elem14;
          for (int _i15 = 0; _i15 < _list13.size; ++_i15)
          {
            _elem14 = new ScoreInfo();
            _elem14.read(iprot);
            struct.scoreinfo.add(_elem14);
          }
        }
        struct.setScoreinfoIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}


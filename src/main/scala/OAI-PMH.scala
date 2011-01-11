// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
/** 
    XML Schema which can be used to validate replies to all OAI-PMH 
    v2.0 requests. Herbert Van de Sompel, 2002-05-13.
    Validated with XML Spy v.4.3 on 2002-05-13.
    Validated with XSV 1.203.2.45/1.106.2.22 on 2002-05-13.
    Added definition of protocolVersionType instead of using anonymous 
    type. No change of function. Simeon Warner, 2004-03-29.
    Tightened definition of UTCdatetimeType to enforce the restriction 
    to UTC Z notation. Simeon Warner, 2004-09-14.
    Corrected pattern matches for setSpecType and metadataPrefixType
    to agree with protocol specification. Simeon Warner, 2004-10-12.
    Spelling correction. Simeon Warner, 2008-12-07.
    $Date: 2004/10/12 15:20:29 $
    
*/

package org.smop.oai

case class OAIPMHtype(responseDate: javax.xml.datatype.XMLGregorianCalendar,
  request: org.smop.oai.RequestType,
  oaipmhtypeoption: Seq[scalaxb.DataRecord[org.smop.oai.OAIPMHtypeOption]])

trait OAIPMHtypeOption

/** Define requestType, indicating the protocol request that 
      led to the response. Element content is BASE-URL, attributes are arguments 
      of protocol request, attribute-values are values of arguments of protocol 
      request
*/
case class RequestType(value: java.net.URI,
  verb: Option[org.smop.oai.VerbType] = None,
  identifier: Option[java.net.URI] = None,
  metadataPrefix: Option[String] = None,
  from: Option[String] = None,
  until: Option[String] = None,
  set: Option[String] = None,
  resumptionToken: Option[String] = None)

trait VerbType

object VerbType {
  def fromString(value: String): VerbType = value match {
    case "Identify" => Identify
    case "ListMetadataFormats" => ListMetadataFormats
    case "ListSets" => ListSets
    case "GetRecord" => GetRecord
    case "ListIdentifiers" => ListIdentifiers
    case "ListRecords" => ListRecords

  }
}

case object Identify extends VerbType { override def toString = "Identify" }
case object ListMetadataFormats extends VerbType { override def toString = "ListMetadataFormats" }
case object ListSets extends VerbType { override def toString = "ListSets" }
case object GetRecord extends VerbType { override def toString = "GetRecord" }
case object ListIdentifiers extends VerbType { override def toString = "ListIdentifiers" }
case object ListRecords extends VerbType { override def toString = "ListRecords" }


case class OAIPMHerrorType(value: String,
  code: org.smop.oai.OAIPMHerrorcodeType) extends OAIPMHtypeOption

trait OAIPMHerrorcodeType

object OAIPMHerrorcodeType {
  def fromString(value: String): OAIPMHerrorcodeType = value match {
    case "cannotDisseminateFormat" => CannotDisseminateFormat
    case "idDoesNotExist" => IdDoesNotExist
    case "badArgument" => BadArgument
    case "badVerb" => BadVerb
    case "noMetadataFormats" => NoMetadataFormats
    case "noRecordsMatch" => NoRecordsMatch
    case "badResumptionToken" => BadResumptionToken
    case "noSetHierarchy" => NoSetHierarchy

  }
}

case object CannotDisseminateFormat extends OAIPMHerrorcodeType { override def toString = "cannotDisseminateFormat" }
case object IdDoesNotExist extends OAIPMHerrorcodeType { override def toString = "idDoesNotExist" }
case object BadArgument extends OAIPMHerrorcodeType { override def toString = "badArgument" }
case object BadVerb extends OAIPMHerrorcodeType { override def toString = "badVerb" }
case object NoMetadataFormats extends OAIPMHerrorcodeType { override def toString = "noMetadataFormats" }
case object NoRecordsMatch extends OAIPMHerrorcodeType { override def toString = "noRecordsMatch" }
case object BadResumptionToken extends OAIPMHerrorcodeType { override def toString = "badResumptionToken" }
case object NoSetHierarchy extends OAIPMHerrorcodeType { override def toString = "noSetHierarchy" }


case class IdentifyType(repositoryName: String,
  baseURL: java.net.URI,
  protocolVersion: org.smop.oai.ProtocolVersionType,
  adminEmail: Seq[String],
  earliestDatestamp: String,
  deletedRecord: org.smop.oai.DeletedRecordType,
  granularity: org.smop.oai.GranularityType,
  compression: Seq[String],
  description: Seq[org.smop.oai.DescriptionType]) extends OAIPMHtypeOption


case class ListMetadataFormatsType(metadataFormat: org.smop.oai.MetadataFormatType*) extends OAIPMHtypeOption


case class ListSetsType(set: Seq[org.smop.oai.SetType],
  resumptionToken: Option[org.smop.oai.ResumptionTokenType]) extends OAIPMHtypeOption


case class GetRecordType(record: org.smop.oai.RecordType) extends OAIPMHtypeOption


case class ListRecordsType(record: Seq[org.smop.oai.RecordType],
  resumptionToken: Option[org.smop.oai.ResumptionTokenType]) extends OAIPMHtypeOption


case class ListIdentifiersType(header: Seq[org.smop.oai.HeaderType],
  resumptionToken: Option[org.smop.oai.ResumptionTokenType]) extends OAIPMHtypeOption


/** A record has a header, a metadata part, and
        an optional about container
*/
case class RecordType(header: org.smop.oai.HeaderType,
  metadata: Option[org.smop.oai.MetadataType],
  about: Seq[org.smop.oai.AboutType])


/** A header has a unique identifier, a datestamp,
        and setSpec(s) in case the item from which
        the record is disseminated belongs to set(s).
        the header can carry a deleted status indicating
        that the record is deleted.
*/
case class HeaderType(identifier: java.net.URI,
  datestamp: String,
  setSpec: Seq[String],
  status: Option[org.smop.oai.StatusType] = None)

trait StatusType

object StatusType {
  def fromString(value: String): StatusType = value match {
    case "deleted" => Deleted

  }
}

case object Deleted extends StatusType { override def toString = "deleted" }


/** Metadata must be expressed in XML that complies
       with another XML Schema (namespace=#other). Metadata must be 
       explicitly qualified in the response.
*/
case class MetadataType(any: scalaxb.DataRecord[Any])


/** Data "about" the record must be expressed in XML
      that is compliant with an XML Schema defined by a community.
*/
case class AboutType(any: scalaxb.DataRecord[Any])


/** A resumptionToken may have 3 optional attributes
       and can be used in ListSets, ListIdentifiers, ListRecords
       responses.
*/
case class ResumptionTokenType(value: String,
  expirationDate: Option[javax.xml.datatype.XMLGregorianCalendar] = None,
  completeListSize: Option[Int] = None,
  cursor: Option[Int] = None)


/** The descriptionType is used for the description
      element in Identify and for setDescription element in ListSets.
      Content must be compliant with an XML Schema defined by a 
      community.
*/
case class DescriptionType(any: scalaxb.DataRecord[Any])

trait ProtocolVersionType

object ProtocolVersionType {
  def fromString(value: String): ProtocolVersionType = value match {
    case "2.0" => Number20

  }
}

case object Number20 extends ProtocolVersionType { override def toString = "2.0" }

trait DeletedRecordType

object DeletedRecordType {
  def fromString(value: String): DeletedRecordType = value match {
    case "no" => No
    case "persistent" => Persistent
    case "transient" => Transient

  }
}

case object No extends DeletedRecordType { override def toString = "no" }
case object Persistent extends DeletedRecordType { override def toString = "persistent" }
case object Transient extends DeletedRecordType { override def toString = "transient" }

trait GranularityType

object GranularityType {
  def fromString(value: String): GranularityType = value match {
    case "YYYY-MM-DD" => YYYYMMDD
    case "YYYY-MM-DDThh:mm:ssZ" => YYYYMMDDThhmmssZ

  }
}

case object YYYYMMDD extends GranularityType { override def toString = "YYYY-MM-DD" }
case object YYYYMMDDThhmmssZ extends GranularityType { override def toString = "YYYY-MM-DDThh:mm:ssZ" }


case class MetadataFormatType(metadataPrefix: String,
  schema: java.net.URI,
  metadataNamespace: java.net.URI)


case class SetType(setSpec: String,
  setName: String,
  setDescription: Seq[org.smop.oai.DescriptionType])

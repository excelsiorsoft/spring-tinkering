
package gov.hhs.cms.dsh.sim.ee.hubc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.hhs.cms.dsh.sim.ee.hubc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HubConnectivityRequest_QNAME = new QName("http://hubc.ee.sim.dsh.cms.hhs.gov", "HubConnectivityRequest");
    private final static QName _HubConnectivityResponse_QNAME = new QName("http://hubc.ee.sim.dsh.cms.hhs.gov", "HubConnectivityResponse");
    private final static QName _ResponseMetadata_QNAME = new QName("http://hubc.ee.sim.dsh.cms.hhs.gov", "ResponseMetadata");
    private final static QName _ResponseCode_QNAME = new QName("http://hubc.ee.sim.dsh.cms.hhs.gov", "ResponseCode");
    private final static QName _ResponseDescriptionText_QNAME = new QName("http://hubc.ee.sim.dsh.cms.hhs.gov", "ResponseDescriptionText");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.hhs.cms.dsh.sim.ee.hubc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HubConnectivityResponseType }
     * 
     */
    public HubConnectivityResponseType createHubConnectivityResponseType() {
        return new HubConnectivityResponseType();
    }

    /**
     * Create an instance of {@link ResponseMetadataType }
     * 
     */
    public ResponseMetadataType createResponseMetadataType() {
        return new ResponseMetadataType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hubc.ee.sim.dsh.cms.hhs.gov", name = "HubConnectivityRequest")
    public JAXBElement<Object> createHubConnectivityRequest(Object value) {
        return new JAXBElement<Object>(_HubConnectivityRequest_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HubConnectivityResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hubc.ee.sim.dsh.cms.hhs.gov", name = "HubConnectivityResponse")
    public JAXBElement<HubConnectivityResponseType> createHubConnectivityResponse(HubConnectivityResponseType value) {
        return new JAXBElement<HubConnectivityResponseType>(_HubConnectivityResponse_QNAME, HubConnectivityResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseMetadataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hubc.ee.sim.dsh.cms.hhs.gov", name = "ResponseMetadata")
    public JAXBElement<ResponseMetadataType> createResponseMetadata(ResponseMetadataType value) {
        return new JAXBElement<ResponseMetadataType>(_ResponseMetadata_QNAME, ResponseMetadataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hubc.ee.sim.dsh.cms.hhs.gov", name = "ResponseCode")
    public JAXBElement<String> createResponseCode(String value) {
        return new JAXBElement<String>(_ResponseCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hubc.ee.sim.dsh.cms.hhs.gov", name = "ResponseDescriptionText")
    public JAXBElement<String> createResponseDescriptionText(String value) {
        return new JAXBElement<String>(_ResponseDescriptionText_QNAME, String.class, null, value);
    }

}

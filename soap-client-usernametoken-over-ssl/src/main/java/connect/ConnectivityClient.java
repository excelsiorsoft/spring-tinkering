package connect;

import gov.hhs.cms.dsh.sim.ee.hubc.HubConnectivityResponseType;
import gov.hhs.cms.dsh.sim.ee.hubc.ObjectFactory;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.SoapMessage;

public class ConnectivityClient extends WebServiceGatewaySupport {
	
	@Value("${soap.action}")
	private String soapAction;
	
	@SuppressWarnings("unchecked")
	public String connect(/*Currency fromCurrency, Currency toCurrency*/) {
        
		/*ConversionRate conversionRate = new ObjectFactory().createConversionRate();
        conversionRate.setFromCurrency(fromCurrency);
        conversionRate.setToCurrency(toCurrency);
 
        ConversionRateResponse response = (ConversionRateResponse) getWebServiceTemplate().marshalSendAndReceive(conversionRate, message ->  ((SoapMessage)message).setSoapAction(soapAction)
        		*/
        		/*new WebServiceMessageCallback() {

            public void doWithMessage(WebServiceMessage message) {
                ((SoapMessage)message).setSoapAction(soapAction);
            }
        }*//*);*/
 
        //return response.getConversionRateResult();
		
		WebServiceTemplate template = getWebServiceTemplate();
		//template.setInterceptors(new ClientInterceptor[]{new LogbackInterceptor()});
		
		JAXBElement<Object> request = new ObjectFactory().createHubConnectivityRequest("");
		HubConnectivityResponseType response = ((JAXBElement<HubConnectivityResponseType>) template.marshalSendAndReceive(request, message ->  ((SoapMessage)message).setSoapAction(soapAction))).getValue();
		
		
		return response.toString();
    }

}

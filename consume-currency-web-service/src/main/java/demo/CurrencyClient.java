package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import demo.wsdl.currency.ConversionRate;
import demo.wsdl.currency.ConversionRateResponse;
import demo.wsdl.currency.Currency;
import demo.wsdl.currency.ObjectFactory;

public class CurrencyClient extends WebServiceGatewaySupport {
	
	@Value("${soap.action}")
	private String soapAction;
	
	public Double getConversionRate(Currency fromCurrency, Currency toCurrency) {
        
		ConversionRate conversionRate = new ObjectFactory().createConversionRate();
        conversionRate.setFromCurrency(fromCurrency);
        conversionRate.setToCurrency(toCurrency);
 
        ConversionRateResponse response = (ConversionRateResponse) getWebServiceTemplate().marshalSendAndReceive(conversionRate, new WebServiceMessageCallback() {

            public void doWithMessage(WebServiceMessage message) {
                ((SoapMessage)message).setSoapAction(soapAction);
            }
        });
 
        return response.getConversionRateResult();
    }

}

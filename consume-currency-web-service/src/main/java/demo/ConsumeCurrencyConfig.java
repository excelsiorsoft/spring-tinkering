package demo;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
@ComponentScan("demo.wsdl.currency")
public class ConsumeCurrencyConfig {

	@Bean
	public CurrencyClient currencyClient(Jaxb2Marshaller marshaller) {
		CurrencyClient client = new CurrencyClient();
		client.setMessageSender(new HttpComponentsMessageSender());
		client.setDefaultUri(/*"http://www.webservicex.net/CurrencyConvertor.asmx/ConversionRate"*/"http://www.webservicex.net/CurrencyConvertor.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("demo.wsdl.currency");
		return marshaller;
	}
	
}

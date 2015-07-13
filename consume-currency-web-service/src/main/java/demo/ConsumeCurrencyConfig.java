package demo;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
@ComponentScan("demo.wsdl.currency")
@PropertySource("classpath:/currency.properties")
public class ConsumeCurrencyConfig {

	@Value("${marshaller.contextPath}")
    private String marshallerContextPath;
	
	@Value("${default.Uri}")
	private String defaultUri;
	
	@Bean
	public CurrencyClient currencyClient(Jaxb2Marshaller marshaller) {
		CurrencyClient client = new CurrencyClient();
		client.setMessageSender(new HttpComponentsMessageSender());
		client.setDefaultUri(defaultUri);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(marshallerContextPath);
		return marshaller;
	}
	
	@Configuration
	 static class DatabaseConfig {
	     @Bean @Lazy
	     DataSource dataSource() {
	         return null;
	     }
	 }
	
}

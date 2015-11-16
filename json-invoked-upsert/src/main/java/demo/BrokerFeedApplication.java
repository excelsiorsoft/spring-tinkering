package demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class BrokerFeedApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BrokerFeedApplication.class);
		app.addListeners(new ApplicationPidFileWriter());
		app.run(/*BrokerFeedApplication.class,*/ args);
	}
	
	/*@Bean
	public ObjectMapper jacksonObjectMapper() {
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.setSerializationInclusion(Include.NON_NULL);
	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	return objectMapper;
	}

	@Bean
	public MappingJackson2HttpMessageConverter jsonConverter() {
	MappingJackson2HttpMessageConverter jacksonConverter = new
	MappingJackson2HttpMessageConverter();
	jacksonConverter.setSupportedMediaTypes(Arrays.asList(MediaType.valueOf("application/json")));
	jacksonConverter.setObjectMapper(jacksonObjectMapper());
	return jacksonConverter;
	}
*/
}

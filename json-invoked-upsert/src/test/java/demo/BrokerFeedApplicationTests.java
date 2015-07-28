package demo;

import java.sql.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BrokerFeedApplication.class) 
@WebAppConfiguration
public class BrokerFeedApplicationTests {
	
	@Autowired BrokerService service;

	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void upsert(){
		
		Broker broker = new Broker();
		broker.setId(11L);
		broker.setAccountName("accountName"); 
		broker.setBrokerNumber("brokerNumber1");
		//broker.setBirthdate(java.sql.Date.valueOf(LocalDate.now()));
		broker.setBirthdate(new Date((new java.util.Date()).getTime())); 
		
		broker.setEmail("email");

		service.upsert(broker, "i");
		
	}
}

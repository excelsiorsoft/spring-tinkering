package demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerFeedController {
	
	private final Logger logger = LoggerFactory.getLogger(BrokerFeedController.class);
	
	@Autowired @Qualifier("brokerService")private BrokerService service;
	
/*
	 
	 [{
  "SFID": 587,
  "action": "i",
  "accountName": null,
  "firstName": null,
  "lastName": null,
  "title": null,
  "ssn": null,
  "phone": null,
  "mobile_phone": null,
  "fax": null,
  "email": null,
  "mailingStreet": null,
  "mailingCity": null,
  "mailingState": null,
  "mailingPostalCode": null,
  "mailingCountry": null,
  "brokerNumber": null,
  "npn": null,
  "ga": null,
  "gaNumber": null,
  "birthdate": null,
  "status": null,
  "legalEntity": null
}, 

{
  "SFID": 767894,
  "action": "i",
  "accountName": null,
  "firstName": null,
  "lastName": null,
  "title": null,
  "ssn": null,
  "phone": null,
  "mobile_phone": null,
  "fax": null,
  "email": null,
  "mailingStreet": null,
  "mailingCity": null,
  "mailingState": null,
  "mailingPostalCode": null,
  "mailingCountry": null,
  "brokerNumber": null,
  "npn": null,
  "ga": null,
  "gaNumber": null,
  "birthdate": null,
  "status": null,
  "legalEntity": null
}
] 
*/
	
	@RequestMapping(value = "/process", method = RequestMethod.POST, consumes="application/json")
	public List<Broker> processFeed(@RequestBody List<Broker> brokers){
	
		logger.info("Received feed: {}, start processing...", brokers);
		
		for(Broker broker: brokers){
			String action = broker.getAction();
			service.upsert(broker, action);
		}
		return brokers;
	}

}

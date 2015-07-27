package demo;

import static demo.Broker.*;

import java.io.IOException;
import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;

public class BrokerDeserializer extends JsonDeserializer<Broker> {

	private final Logger logger = LoggerFactory.getLogger(BrokerDeserializer.class);
	
	@Override
	public Broker deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		
		ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
       
        final String sfid = node.get(SFID).asText();
        final String action = node.get(ACTION).asText();
        
        Assert.notNull(sfid, "Salesforce Id must be present");
        Assert.notNull(action, "Action must be present");
        
        final String birthdate = (node.get(BIRTHDATE).getClass().isInstance(NullNode.class))?node.get(BIRTHDATE).asText():"1970-01-01";
		
        Broker broker = new Broker();
        broker.setSaleforceId(sfid);
        broker.setAction(action);
        broker.setAccountName(node.get(ACCOUNT_NAME).asText());
        broker.setFirstName(node.get(FIRST_NAME).asText());
        broker.setLastName(node.get(LAST_NAME).asText());
        broker.setTitle(node.get(TITLE).asText());
        broker.setSsn(node.get(SSN).asText());
        broker.setPhone(node.get(PHONE).asText());
        broker.setMobile_phone(node.get(MOBILE_PHONE).asText());
        broker.setFax(node.get(FAX).asText());
        broker.setEmail(node.get(EMAIL).asText());
        broker.setMailingStreet(node.get(MAILING_STREET).asText());
        broker.setMailingCity(node.get(MAILING_CITY).asText());
        broker.setMailingState(node.get(MAILING_STATE).asText());
        broker.setMailingPostalCode(node.get(MAILING_POSTAL_CODE).asText());
        broker.setMailingCountry(node.get(MAILING_COUNTRY).asText());
        broker.setBrokerNumber(node.get(BROKER_NUMBER).asText());
        broker.setNpn(node.get(NPN).asText());
        broker.setGa(node.get(GA).asText());
        broker.setGaNumber(node.get(GA_NUMBER).asText());
        
		broker.setBirthdate(birthdate != null?Date.valueOf(birthdate):Date.valueOf("1970-01-01"));
        broker.setStatus(node.get(STATUS).asText());
        broker.setLegalEntity(node.get(LEGAL_ENTITY).asText());
        
        logger.info("Created Broker: {}", broker);
        return broker;
	}

}

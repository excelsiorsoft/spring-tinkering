package connect;



import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.sql.DataSource;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j.support.CryptoFactoryBean;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;
import org.springframework.ws.soap.security.support.KeyManagersFactoryBean;
import org.springframework.ws.soap.security.support.KeyStoreFactoryBean;

@Configuration
@ComponentScan({"gov.hhs.cms.dsh.sim.ee.hubc", "connect"})
@PropertySource("classpath:/connectivity.properties")
public class ConnectivityTestingConfig {

	@Value("${marshaller.contextPath}")
    private String marshallerContextPath;
	
	@Value("${default.Uri}")
	private String defaultUri;
	
	@Bean
	public ConnectivityClient connectivityClient() throws Throwable {
		ConnectivityClient client = new ConnectivityClient();
		client.setWebServiceTemplate(webServiceTemplate());
		return client;
	}
	
	@Bean
	public KeyStore keyStore() throws Throwable {
		KeyStoreFactoryBean keyStoreFactory = new KeyStoreFactoryBean();
		keyStoreFactory.setPassword("Z!par!836!");
		keyStoreFactory.setLocation(new ClassPathResource("zipari.jks"));
		keyStoreFactory.setType("jks");
		keyStoreFactory.afterPropertiesSet();
		return keyStoreFactory.getObject();
	}
	
	@Bean 
	public KeyManager[] keyManagers() throws Throwable{
		KeyManagersFactoryBean keyManagerFactory = new KeyManagersFactoryBean();
		keyManagerFactory.setKeyStore(keyStore());
		keyManagerFactory.setPassword("Z!par!836!");
		keyManagerFactory.afterPropertiesSet();
		return keyManagerFactory.getObject();
	}
	
	@Bean
	public HttpsUrlConnectionMessageSender httpsUrlSender() throws Throwable {
		HttpsUrlConnectionMessageSender sender = new HttpsUrlConnectionMessageSender();
		sender.setSslProtocol("TLS");
		sender.setKeyManagers(keyManagers());
		return sender;
	}
	
	@Bean
    public WebServiceTemplate webServiceTemplate() throws Throwable {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller());
        webServiceTemplate.setUnmarshaller(marshaller());
        webServiceTemplate.setDefaultUri(defaultUri);
        webServiceTemplate.setMessageFactory(messageFactory());
        webServiceTemplate.setMessageSender(/*new HttpComponentsMessageSender()*/httpsUrlSender());
        webServiceTemplate.setInterceptors(new ClientInterceptor[] { wss4jSecurityInterceptor(),  new LogbackInterceptor() }); //order matters
        webServiceTemplate.setMessageSender(httpsUrlSender());
        return webServiceTemplate;
    }
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(marshallerContextPath);
		return marshaller;
	}
	
	@Bean
	public SaajSoapMessageFactory messageFactory() {
	    SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
	    messageFactory.setSoapVersion(SoapVersion.SOAP_12);
	    return messageFactory;
	}
	
	@Bean
	 public Wss4jSecurityInterceptor wss4jSecurityInterceptor() throws Throwable{
		Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
		wss4jSecurityInterceptor.setSecurementActions(/*"UsernameToken"*/WSHandlerConstants.USERNAME_TOKEN + " "+ WSHandlerConstants.TIMESTAMP);
		//wss4jSecurityInterceptor.setSecurementActions("Signature");
		wss4jSecurityInterceptor.setSecurementUsername("04.ZIP.NY*.320.609");
		wss4jSecurityInterceptor.setSecurementPassword("oLF@cDhdKHYEnCM");
		wss4jSecurityInterceptor.setSecurementPasswordType(/*"PasswordDigest"*/WSConstants.PW_DIGEST);
		wss4jSecurityInterceptor.setSecurementEncryptionCrypto(crypto());
		wss4jSecurityInterceptor.setSecurementEncryptionKeyIdentifier("DirectReference");
		//wss4jSecurityInterceptor.setValidationActions("Signature");
		//wss4jSecurityInterceptor.setValidationSignatureCrypto( crypto() );
		
		wss4jSecurityInterceptor.setSecurementTimeToLive(300);
		return wss4jSecurityInterceptor;
	}
	
	
	
	
	@Bean
	public Crypto crypto() throws Throwable {
		CryptoFactoryBean cryptoFactoryBean = new CryptoFactoryBean();
		cryptoFactoryBean.setKeyStoreLocation(new ClassPathResource("zipari.jks"));
		cryptoFactoryBean.setKeyStorePassword("Z!par!836!");
		cryptoFactoryBean.afterPropertiesSet();
		Crypto crypto = cryptoFactoryBean.getObject();
		System.out.println("created crypto store: "+ crypto);
		return crypto;
	}
	
	
	
	
	@Configuration
	 static class DatabaseConfig {
	     @Bean @Lazy
	     DataSource dataSource() {
	         return null;
	     }
	 }
	
}

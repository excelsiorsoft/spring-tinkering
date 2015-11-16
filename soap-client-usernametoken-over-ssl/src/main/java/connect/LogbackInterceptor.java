package connect;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

public class LogbackInterceptor implements ClientInterceptor {

    private final Logger logger = LoggerFactory.getLogger(LogbackInterceptor .class);


     public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
         
    	 OutputStream output = new ByteArrayOutputStream();
    	 
    	 try {
			messageContext.getRequest().writeTo(output);
			logger.info("Sent request [" + output.toString() + "]");
		} catch (IOException e) {
			
			e.printStackTrace();
		}  
    	 
           return true;
     }

     public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
           logger.info("Received response [" + messageContext.getResponse() + "] for request [" +
                                messageContext.getRequest() + "]");
           return true;
}

	@Override
	public boolean handleFault(MessageContext messageContext)
			throws WebServiceClientException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterCompletion(MessageContext messageContext, Exception ex)
			throws WebServiceClientException {
		
		messageContext.getResponse();
		
		logger.info("After completion of [" + messageContext.getResponse() + "] for request [" +
                messageContext.getRequest() + "]");
		
	}


}
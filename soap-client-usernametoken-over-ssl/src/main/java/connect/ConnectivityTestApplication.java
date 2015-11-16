package connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConnectivityTestApplication {

	public static void main(String[] args) {
    	ApplicationContext ctx =  SpringApplication.run(ConnectivityTestApplication.class, args);
        
    	
    	ConnectivityClient client = ctx.getBean(ConnectivityClient.class);
    	String response = client.connect();
    	
    	System.out.println("response: "+response);
    	/*CurrencyClient currencyClient = ctx.getBean(CurrencyClient.class);

    	Currency fromCurrency = Currency.USD;
        Currency toCurrency = Currency.GBP;
        Double conversionRate = currencyClient.getConversionRate(fromCurrency, toCurrency);
 
        System.out.println("The confersion rate from " + fromCurrency + " to "+ "toCurrency is " + conversionRate);
        */

    
    }
	
}




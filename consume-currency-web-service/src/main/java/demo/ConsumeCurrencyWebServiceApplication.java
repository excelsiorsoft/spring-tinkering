package demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import demo.wsdl.currency.Currency;

@SpringBootApplication
public class ConsumeCurrencyWebServiceApplication {

    public static void main(String[] args) {
    	ApplicationContext ctx =  SpringApplication.run(ConsumeCurrencyWebServiceApplication.class, args);
        
    	CurrencyClient currencyClient = ctx.getBean(CurrencyClient.class);

    	Currency fromCurrency = Currency.USD;
        Currency toCurrency = Currency.GBP;
        Double conversionRate = currencyClient.getConversionRate(fromCurrency, toCurrency);
 
        System.out.println("The confersion rate from " + fromCurrency + " to "+ "toCurrency is " + conversionRate);
        
        //log.info(String.format("The conversion rate from %s to %s is %s.", fromCurrency, toCurrency, conversionRate));
    
    }
}

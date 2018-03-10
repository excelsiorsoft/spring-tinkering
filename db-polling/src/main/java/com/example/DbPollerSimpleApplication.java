package com.example;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class DbPollerSimpleApplication {

	@Bean
    public MessageChannel fromdb() {
        return new DirectChannel();
    }
	
	@Bean
	public PollerMetadata poller(PlatformTransactionManager transactionManager) {
	    PeriodicTrigger trigger = new PeriodicTrigger(4000);
	    trigger.setFixedRate(true);

	    /*MatchAlwaysTransactionAttributeSource attributeSource = new MatchAlwaysTransactionAttributeSource();
	    attributeSource.setTransactionAttribute(new DefaultTransactionAttribute());
	    TransactionInterceptor interceptor = new TransactionInterceptor(transactionManager, attributeSource);*/

	    PollerMetadata poller = new PollerMetadata();
	    poller.setTrigger(trigger);
	    //poller.setAdviceChain(Collections.singletonList(interceptor));
	    return poller;
	}

	@Bean
	@InboundChannelAdapter(value = "fromdb", poller = @Poller("poller"))
	public MessageSource<?> counterMessageSource(DataSource dataSource) {
	    JdbcPollingChannelAdapter adapter =
	            new JdbcPollingChannelAdapter(dataSource, "SELECT * FROM Items WHERE INVENTORY_STATUS = 0");
	    adapter.setUpdateSql("UPDATE Items SET INVENTORY_STATUS = 1");
	    return adapter;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(DbPollerSimpleApplication.class, args);
	}
}

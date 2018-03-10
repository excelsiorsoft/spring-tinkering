package com.example;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;
import org.springframework.messaging.MessageChannel;


/**
 * Inspired by:
 *   https://stackoverflow.com/questions/27247013/jdbc-spring-integration-with-annotations
 *   https://stackoverflow.com/questions/49204369/spring-integrations-java-dsl-with-h2-adapter
 * 
 */
@SpringBootApplication
public class DbPollerSimpleDSLApplication {

	@Bean
	public MessageSource<?> jdbcAdapter(DataSource dataSource) {
	    JdbcPollingChannelAdapter adapter =
	            new JdbcPollingChannelAdapter(dataSource, "SELECT * FROM Items WHERE INVENTORY_STATUS = 0");
	    adapter.setUpdateSql("UPDATE Items SET INVENTORY_STATUS = 1");
	    return adapter;
	}

	@Bean
	public IntegrationFlow jdbcFlow(MessageSource<?> jdbcAdapter) {
	    return IntegrationFlows
	            .from(jdbcAdapter, e -> e.poller(p -> p.fixedRate(4000)/*.transactional(transactionManager())*/))
	            .channel(/*c -> c.direct(*/"fromdb"/*)*/)
	            .get();
	}
	
	/*@Bean
    public MessageChannel fromdb() {
        return new DirectChannel();
    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(DbPollerSimpleDSLApplication.class, args);
	}
}

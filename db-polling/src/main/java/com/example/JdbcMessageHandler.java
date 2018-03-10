package com.example;

import java.util.List;
import java.util.Map;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class JdbcMessageHandler {
	@ServiceActivator(inputChannel= "fromdb")
	public void handleJdbcMessage(List<Map<String, Object>> message) {
		for (Map<String, Object> resultMap: message) {
			System.out.println("Row");
			for (String column: resultMap.keySet()) {
				System.out.println("column: " + column + " value: " + resultMap.get(column));
			}
		}
	}
}

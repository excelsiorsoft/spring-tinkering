package demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class StartupLoggingBean implements InitializingBean {

	private static final String ENV_TARGET = "envTarget";

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Environment env;

	@Override
	public void afterPropertiesSet() throws Exception {

		logger.info("=====================================================Collecting application initialization info ===================================================================================");

		try {
			
			logEnvVariables();
			logActiveSpringProfiles();
			logRelevantProperties();
			
		} catch (Throwable t) {
			logger.error("StartupLoggingBean failed: {}", t);
		}

		logger.info("=====================================================Initialization info collection ends here =============================================================================");

	}

	private void logRelevantProperties() {
		
		final String key = "spring.datasource.url";
		final String value = getValueOfProperty(env, key, "local", null);
		logger.info("\n{} = {}", key, value);
	}

	private void logActiveSpringProfiles() {
		
		final String key = "spring.profiles.active";
		final String value = getValueOfProperty(env, key, "local", null);
		logger.info("\n{} = {}", key, value);
		
	}

	private void logEnvVariables() {
		
		final String envTargetValue = getValueOfProperty(env, ENV_TARGET, "local", Lists.newArrayList("local","staging","UAT", "prod"));
		logger.info("\n{} = {}", ENV_TARGET, envTargetValue);
		
	}
	
	
	private final String getValueOfProperty(final Environment environment, final String propertyKey, final String propertyDefaultValue, final List<String> acceptablePropertyValues){
		
		String propertyValue = environment.getProperty(propertyKey);
		
		if(propertyValue == null){
			propertyValue = propertyDefaultValue;
			logger.warn("The {} property doesn't have an explicit value; default value is {}", propertyKey, propertyDefaultValue); 
		}
		
		if(acceptablePropertyValues != null){
			if(!acceptablePropertyValues.contains(propertyValue)){
				logger.warn("The property {} has an invalid value {}", propertyKey, propertyValue);
			}
		}
		
		if(propertyValue == null){
			logger.warn("The property {} is null!", propertyKey);
		}
		
		return propertyValue ;
	}

}

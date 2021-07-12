package com.ssd.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// this @Cofiguration tells spring that this is configuration file, follow directions from here.(no need of xml file)
@Configuration

// add component scanning support
//@ComponentScan("com.ssd.springdemo")

//load the properties file in spring config
@PropertySource("classpath:sport.properties")

public class SportConfig {

	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for our swim coach and inject dependency(i.e.
	// sadFortuneService())
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}

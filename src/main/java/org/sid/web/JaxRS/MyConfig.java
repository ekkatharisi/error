package org.sid.web.JaxRS;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
	//@Bean
	public ResourceConfig getJersey() {
		ResourceConfig config = new ResourceConfig();
		config.register(EtudiantWebServiceRest.class);
		return config;
	}
	
}

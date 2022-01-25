package com.t3b.msinventory;

import java.util.Collections;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.t3b.msinventory.utils.Config;

@SpringBootApplication
public class AuthMServicesInventoryApplication {

	@SuppressWarnings("unused")
	private org.slf4j.Logger logger = LoggerFactory.getLogger(AuthMServicesInventoryApplication.class);

	
	public static void main(String[] args) {
		Config.cargaConfig();
		SpringApplication app = new SpringApplication(AuthMServicesInventoryApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", Config.ms_port));
        
        app.setDefaultProperties(Collections.singletonMap("spring.datasource.host", Config.host));
        app.setDefaultProperties(Collections.singletonMap("server.port", Config.port));
        app.setDefaultProperties(Collections.singletonMap("spring.datasource.username", Config.user));
        app.setDefaultProperties(Collections.singletonMap("spring.datasource.password", Config.pass));
        app.setDefaultProperties(Collections.singletonMap("spring.datasource.url", Config.surl));
        app.setDefaultProperties(Collections.singletonMap("spring.datasource.driver-class-name", Config.driv));
        //app.setDefaultProperties(Collections.singletonMap("spring.datasource.driver-class-name", Config.bdServiceName));        
                
        app.run(args);
	}

}
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*this is a convenience annotation that consists of several other annotations. these include:
 * @SpringBootConfiguration: This is an alternative to the @Configuration tag. It allows spring to auto detect ocnfiguration.
 * @EnableAutoConfiguration: this enables the auto configuration of the application context
 * @ComponentScan: this indicates that Spring should 
 */
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}

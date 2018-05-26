package Controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication

@EntityScan(basePackages = {"model"})
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class LanzasSpring {

	public LanzasSpring() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LanzasSpring.class, args);
		
	}
}

package domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DebitAndCreditControlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebitAndCreditControlApiApplication.class, args);
	}

}

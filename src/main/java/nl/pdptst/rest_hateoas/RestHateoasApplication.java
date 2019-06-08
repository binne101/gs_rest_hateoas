package nl.pdptst.rest_hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.lang.String; //Code smell 1 for sonar
import java.lang.Exception; //Code smell 2 for sonar

@SpringBootApplication
public class RestHateoasApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestHateoasApplication.class, args);
	}
}

package net.cvergara.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@OpenAPIDefinition(
		info = @Info(title = "Organizacion Service Rest APIs" ,
		description = "Organization Service REST APIs Documentation",
		version = "v1.0",
		contact = @Contact(
				name = "Cristopher Vergara",
				email = "cristopher.vergara.colombo@outlook.com",
				url = "https://www.linkedin.com/in/cristophervergaracolombo/"
		     ),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.linkedin.com/in/cristophervergaracolombo/"
				)
		),
		externalDocs = @ExternalDocumentation (description = "external docs" , url = "https://www.linkedin.com/in/cristophervergaracolombo/")
)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}

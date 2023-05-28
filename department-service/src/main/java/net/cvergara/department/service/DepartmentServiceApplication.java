package net.cvergara.department.service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
		info = @Info(
				title = "Department Service Rest Api" ,
				description = "Department Service REST API Documentation" ,
				version = "1.0" ,
				contact = @Contact( name = "https://www.linkedin.com/in/cristophervergaracolombo/" ,
									email ="https://www.linkedin.com/in/cristophervergaracolombo/" ,
									url = "https://www.linkedin.com/in/cristophervergaracolombo/"
			),
				license = @License(name = "Apache 2.0" ,
									url = "https://www.linkedin.com/in/cristophervergaracolombo/"
				)
		),
		externalDocs = @ExternalDocumentation(description = "External documentation" ,
												url = "https://www.linkedin.com/in/cristophervergaracolombo/")

)
@SpringBootApplication
//@EnableEurekaClient
public class DepartmentServiceApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper() ;
	}

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}

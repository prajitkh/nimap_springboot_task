package com.springbootproject;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
@ComponentScan("com.springbootproject")
@EntityScan("com.springbootproject")
public class SpringbootprojectApplication {



	public static void main(String[] args) {

		SpringApplication.run(SpringbootprojectApplication.class, args);
	}

	//spring container auto create object 
	@Bean
	public ModelMapper modelMapper() {
		return  new ModelMapper();


	}


}





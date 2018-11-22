package com.sda.javapoz11.hellospring.hellospring;

import com.sda.javapoz11.hellospring.hellospring.service.BigNumbersGenerator;
import com.sda.javapoz11.hellospring.hellospring.service.RandomGenerator;
import com.sda.javapoz11.hellospring.hellospring.service.SmallNumberGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class HellospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}

	@Primary
	@Bean
	public RandomGenerator smallNumbersGenerator (){
		return new SmallNumberGenerator();
	}

	@Bean
	public RandomGenerator bigNumbersGenerator (){
		return new BigNumbersGenerator();
	}
}



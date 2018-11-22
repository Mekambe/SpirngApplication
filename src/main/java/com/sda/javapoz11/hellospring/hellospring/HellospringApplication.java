package com.sda.javapoz11.hellospring.hellospring;

import com.sda.javapoz11.hellospring.hellospring.service.BigNumbersGenerator;
import com.sda.javapoz11.hellospring.hellospring.service.RandomGenerator;
import com.sda.javapoz11.hellospring.hellospring.service.SmallNumberGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class HellospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}


	@Bean
	public RandomGenerator smallNumbersGenerator (){
		return new SmallNumberGenerator();
	}

	@Profile("!prod")
	@Primary
	@Bean
	public RandomGenerator bigNumbersGenerator (){
		return new BigNumbersGenerator();
	}

	@Profile("prod")
	@Primary
	@Bean
	public RandomGenerator myBigNumberGenerator (){
		return new BigNumbersGenerator();
	}
}



package com.puzzle.nim;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class NimApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimApplication.class, args);
	}

}

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IbmProiectJucariiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbmProiectJucariiApplication.class, args);

		for(String arg : args){
			System.out.println(arg);
		}
	}



}

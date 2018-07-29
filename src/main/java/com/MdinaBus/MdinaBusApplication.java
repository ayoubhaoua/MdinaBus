package com.MdinaBus;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MdinaBusApplication implements CommandLineRunner{
	

	public static void main(String[] args) {
		SpringApplication.run(MdinaBusApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		// clear all record if existed before do the tutorial with new data 
	}
}

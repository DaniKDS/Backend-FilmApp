package com.example.moviematchbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class MovieMatchBackendApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	//asta e un bean care imi face maparea dintre clasele mele
	//de exemplu, daca am o clasa Utilizator si o clasa UtilizatorDTO
	public static void main(String[] args) {
		SpringApplication.run(MovieMatchBackendApplication.class, args);
	}
	//asta e metoda main care imi porneste aplicatia

}

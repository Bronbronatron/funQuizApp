package com.bronwyn.movieRecommendation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 
@SpringBootApplication
public class MovieRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationApplication.class, args);
	}
	
}

package co.edu.javeriana.Proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import co.edu.javeriana.Proyecto.Model.Monstruo;



//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ProyectoDwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDwApplication.class, args);
	}

	@Bean
	public Monstruo CrearMostro(){

		return new Monstruo((long) 1, "Monstruo pete", 10, 15, 1, "desc", 100, "wiki", "cat");
	}
}

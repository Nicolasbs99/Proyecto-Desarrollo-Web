package co.edu.javeriana.Proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ProyectoDwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDwApplication.class, args);
	}

}

package co.edu.javeriana.Proyecto;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ProyectoDwApplication {
	Logger log = LoggerFactory.getLogger(getClass());   
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoDwApplication.class, args);
	}
	

}

package co.edu.javeriana.Proyecto;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.edu.javeriana.Proyecto.Model.Habitacion;



@SpringBootApplication
public class ProyectoDwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDwApplication.class, args);
	}
	@Bean
    ArrayList<Habitacion> createRooms(){
        ArrayList<Habitacion> retorno = new ArrayList<>();
        return retorno;
    }

}

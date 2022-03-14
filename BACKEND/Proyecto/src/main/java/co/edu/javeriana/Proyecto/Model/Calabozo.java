package co.edu.javeriana.Proyecto.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Calabozo {
    
    @Id
    @GeneratedValue
    private Long Id;
    private String nombre;

    @OneToMany(mappedBy = "Calabozo")
    private List <Habitacion> habitaciones = new ArrayList<>();


    
    public Calabozo() {
    }

    

    public Calabozo( String nombre) {
        this.nombre = nombre;
    }




    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

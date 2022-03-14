package co.edu.javeriana.Proyecto.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Habitacion {
    
    @Id
    @GeneratedValue
    Long Id;

    String nombre;
    

    @OneToOne
    Calabozo Calabozo;

    @OneToMany( mappedBy = "cal")
    List<Jugador> jugadores = new ArrayList<>();

    
    public Habitacion() {
    }

    

    public Habitacion(String nombre) {
        this.nombre = nombre;
        
    }



    public Calabozo getCalabozo() {
        return Calabozo;
    }

    public void setCalabozo(Calabozo calabozo) {
        Calabozo = calabozo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
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
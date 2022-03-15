package co.edu.javeriana.Proyecto.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Habitacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String nombre;
    

    @OneToOne
    Calabozo Calabozo;

    @OneToMany( mappedBy = "habitacion")
    List<Jugador> jugadores = new ArrayList<>();

    @OneToMany( mappedBy = "habi")
    List<Item> obje = new ArrayList<>();

    @OneToMany( mappedBy = "habit")
    List<Decoracion> Deco = new ArrayList<>();

    @OneToOne
    Monstruo monstruo;

    public Habitacion() {
    }

    

    public Habitacion(String nombre) {
        this.nombre = nombre;
        
    }



    public List<Decoracion> getDeco() {
        return Deco;
    }



    public void setDeco(List<Decoracion> deco) {
        Deco = deco;
    }



    public List<Item> getObje() {
        return obje;
    }



    public void setObje(List<Item> obje) {
        this.obje = obje;
    }



    public Monstruo getMonstruo() {
        return monstruo;
    }



    public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
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
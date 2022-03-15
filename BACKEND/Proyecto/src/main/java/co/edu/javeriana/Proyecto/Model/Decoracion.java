package co.edu.javeriana.Proyecto.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Decoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String Nombre;

    @OneToOne
    Habitacion habit;

    
    public Decoracion() {
    }


    public Decoracion( String nombre) {
        
        Nombre = nombre;
        
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public Habitacion getHabi() {
        return habit;
    }


    public void setHabi(Habitacion habi) {
        this.habit = habi;
    }


    
    
}

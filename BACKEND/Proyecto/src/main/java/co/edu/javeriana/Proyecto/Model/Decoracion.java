package co.edu.javeriana.Proyecto.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Decoracion {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    String name;

    @OneToOne
    Habitacion habit;

    
    public Decoracion() {
    }


    public Decoracion( String name) {
        
        this.name = name;
        
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public String getname() {
        return name;
    }


    public void setname(String name) {
        this.name = name;
    }


    public Habitacion getHabi() {
        return habit;
    }


    public void setHabi(Habitacion habi) {
        this.habit = habi;
    }


    
    
}

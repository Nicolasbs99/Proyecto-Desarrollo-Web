package co.edu.javeriana.Proyecto.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Decoracion")
public class Decoracion {
    
   
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "decorativeItems")
    private Set<Habitacion> locations;

    public Decoracion(){
        locations = new HashSet<>();
    }

    public Decoracion(String name) {
        this.name = name;  
    }

    public Decoracion(String name,Set<Habitacion> locations) {
        this.name = name;
        this.locations = locations;   
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Habitacion> getLocations() {
        return locations;
    }

    public void setLocations(Set<Habitacion> locations) {
        this.locations = locations;
    };


}
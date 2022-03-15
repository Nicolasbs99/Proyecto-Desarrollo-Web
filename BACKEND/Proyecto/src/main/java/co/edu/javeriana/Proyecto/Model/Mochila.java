package co.edu.javeriana.Proyecto.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Mochila {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    
    Float peso;

    @OneToMany( mappedBy = "mochila")
    List<Item> Objetos = new ArrayList<>();

    public Mochila() {
    }

    public List<Item> getObjetos() {
        return Objetos;
    }

    public void setObjetos(List<Item> objetos) {
        Objetos = objetos;
    }

    public Mochila(Float peso) {
        
        this.peso = peso;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
}

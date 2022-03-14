package co.edu.javeriana.Proyecto.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mochila {
    
    @Id
    @GeneratedValue
    Long Id;
    
    Float peso;

    @OneToOne
    Jugador jugador;

    public Mochila() {
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

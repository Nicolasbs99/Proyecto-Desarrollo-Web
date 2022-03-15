package co.edu.javeriana.Proyecto.Model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    
    String Nombre;
    Date Actualizacion;
    int costo;
    float pesot;
    String Descri;
    String wiki;
    
    @OneToOne
    Mochila mochila;

    @OneToOne
    Habitacion habi;

    
    public Item() {
    }


    public Item( String nombre,  int costo, float pesot, String descri, String wiki) {
        
        Nombre = nombre;
        this.costo = costo;
        this.pesot = pesot;
        Descri = descri;
        this.wiki = wiki;
    }


    public Habitacion getHabi() {
        return habi;
    }


    public void setHabi(Habitacion habi) {
        this.habi = habi;
    }


    public Mochila getMochila() {
        return mochila;
    }


    public void setMochila(Mochila mochila) {
        this.mochila = mochila;
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


    public Date getActualizacion() {
        return Actualizacion;
    }


    public void setActualizacion(Date actualizacion) {
        Actualizacion = actualizacion;
    }


    public int getCosto() {
        return costo;
    }


    public void setCosto(int costo) {
        this.costo = costo;
    }


    public float getPesot() {
        return pesot;
    }


    public void setPesot(float pesot) {
        this.pesot = pesot;
    }


    public String getDescri() {
        return Descri;
    }


    public void setDescri(String descri) {
        Descri = descri;
    }


    public String getWiki() {
        return wiki;
    }


    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
    
}

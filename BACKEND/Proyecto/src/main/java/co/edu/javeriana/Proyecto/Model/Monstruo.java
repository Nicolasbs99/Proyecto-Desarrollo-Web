package co.edu.javeriana.Proyecto.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;


    private String nombre;
    private Date actualizacion;
    private int atack;
    private int defence;
    private int tamano;
    private String desc;
    private int vida;
    private String wiki;
    private String cat;
    
    public Monstruo(){

    };

    public Monstruo( String nombre, int atack, int defence, int tamano, String desc,
            int vida, String wiki, String cat) {
        
        this.nombre = nombre;
        this.atack = atack;
        this.defence = defence;
        this.tamano = tamano;
        this.desc = desc;
        this.vida = vida;
        this.wiki = wiki;
        this.cat = cat;
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
    public Date getActualizacion() {
        return actualizacion;
    }
    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }
    public int getAtack() {
        return atack;
    }
    public void setAtack(int atack) {
        this.atack = atack;
    }
    public int getDefence() {
        return defence;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }
    public int getTamano() {
        return tamano;
    }
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public String getWiki() {
        return wiki;
    }
    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
    public String getCat() {
        return cat;
    }
    public void setCat(String cat) {
        this.cat = cat;
    }
}

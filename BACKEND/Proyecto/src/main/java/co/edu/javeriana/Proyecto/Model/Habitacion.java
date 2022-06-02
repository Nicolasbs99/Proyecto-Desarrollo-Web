package co.edu.javeriana.Proyecto.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Habitacion {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Room_decoItems", joinColumns = { @JoinColumn(name = "Room_Id") }, inverseJoinColumns = {
            @JoinColumn(name = "decoItem_id") })
    private Set<Decoracion> decorativeItems;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "Room_Items", joinColumns = { @JoinColumn(name = "Room_Id") }, inverseJoinColumns = {
            @JoinColumn(name = "Item_id") })
    private Set<Item> items;

    
    @ManyToOne
    @JoinColumn(name = "monster_id")
    private Monstruo monstruo;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jugador> jugador;

    @ManyToMany
    @JoinTable(name = "Exits", joinColumns = @JoinColumn(name = "Room_id"), inverseJoinColumns = @JoinColumn(name = "Exit_id"))
    private Set<Habitacion> exits;

    @ManyToMany
    @JoinTable(name = "Exits", joinColumns = @JoinColumn(name = "Exit_id"), inverseJoinColumns = @JoinColumn(name = "Room_id"))
    @Transient
    private Set<Habitacion> exitOf;

    @JsonIgnore
    @Transient
    String decoItemsAdd;

    @JsonIgnore
    @Transient
    String itemsAdd;

    @JsonIgnore
    @Transient
    String playersAdd;

    @JsonIgnore
    @Transient
    String monsterAdd;

    @JsonIgnore
    @Transient
    String exitsAdd;

    public Habitacion() {
        this.decorativeItems = new HashSet<>();
        this.items = new HashSet<>();
        this.jugador = new ArrayList<>();
        this.exits = new HashSet<>();
    }

    public Habitacion(String name, Set<Decoracion> decorativeItems, Set<Item> items, Monstruo monster,
            ArrayList<Jugador> players, Set<Habitacion> exits) {

        this.name = name;
        this.decorativeItems = decorativeItems;
        this.items = items;
        this.monstruo = monster;
        this.jugador = players;
        this.exits = exits;
    }
    public Habitacion(Long id, String name) {
        this.decorativeItems = new HashSet<>();
        this.items = new HashSet<>();
        this.jugador = new ArrayList<>();
        this.exits = new HashSet<>();
    }
    public Habitacion(String name) {
        this.name = name;
        this.decorativeItems = new HashSet<>();
        this.items = new HashSet<>();
        this.jugador = new ArrayList<>();
        this.exits = new HashSet<>();
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

    public Set<Decoracion> getDecorativeItems() {
        return decorativeItems;
    }

    public void setDecorativeItems(Set<Decoracion> decorativeItems) {
        this.decorativeItems = decorativeItems;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Monstruo getMonster() {
        return monstruo;
    }

    public void setMonster(Monstruo monster) {
        this.monstruo = monster;
    }

    public List<Jugador> getPlayers() {
        return jugador;
    }

    public void setPlayers(List<Jugador> players) {
        this.jugador = players;
    }
    
    public Set<Habitacion> getExits() {
        return exits;
    }

    public void setExits(Set<Habitacion> exits) {
        this.exits = exits;
    }

    public Set<Habitacion> getExitOf() {
        return exitOf;
    }

    public void setExitOf(Set<Habitacion> exitOf) {
        this.exitOf = exitOf;
    }

    public String getDecoItemsAdd() {

        if(decorativeItems.size() != 0){

            String retorno = "";

            for(Decoracion item: decorativeItems){

                retorno = retorno + item.getId() + ",";
            }

            return retorno;

        }

        return decoItemsAdd;
    }

    public void setDecoItemsAdd(String decoItemsAdd) {
        this.decoItemsAdd = decoItemsAdd;
    }

    public String getItemsAdd() {

        if(items.size() != 0){

            String retorno = "";
            for(Item item: items){
                retorno = retorno + item.getId() + ",";
            }
            return retorno;
        }
        
        return itemsAdd;
    }

    public void setItemsAdd(String itemsAdd) {

        this.itemsAdd = itemsAdd;
    }

    public String getPlayersAdd() {

        if(jugador.size() != 0){

            String retorno = "";
            for(Jugador item: jugador){
                retorno = retorno + item.getId() + ",";
            }
            return retorno;
        }

        return playersAdd;
    }

    public void setPlayersAdd(String playersAdd) {
        this.playersAdd = playersAdd;
    }

    public String getMonsterAdd() {

        if(monstruo != null){

            return this.getMonster().getId().toString();

        }

        return monsterAdd;
    }

    public void setMonsterAdd(String monsterAdd) {
        this.monsterAdd = monsterAdd;
    }

    public String getExitsAdd() {

        if(exits.size() != 0){

            String retorno = "";
            for(Habitacion item: exits){
                retorno = retorno + item.getId() + ",";
            }
            return retorno;
        }

        return exitsAdd;
    }

    public void setExitsAdd(String exitsAdd) {
        this.exitsAdd = exitsAdd;
    }
        
}
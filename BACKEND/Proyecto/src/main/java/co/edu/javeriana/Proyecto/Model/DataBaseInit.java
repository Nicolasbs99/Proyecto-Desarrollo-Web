package co.edu.javeriana.Proyecto.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;


@Component
@Profile("develop")
public class DataBaseInit implements ApplicationRunner{

    @Autowired
    DecoracionRepo decoItemRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    MonstruoRepo monsterRepo;

    @Autowired
    JugadorRepo playerRepo;

    @Autowired
    HabRepo roomRepo;

    /// se ejecuta una sola vez al inicio de la aplicacion.
    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadDecoItems();
        loadItems();
        loadMonsters();
        loadPlayers();
        loadRooms();       
        
    }
    
    void loadDecoItems(){

        List<Decoracion> itemList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
                itemList = objectMapper.readValue(
                new File("Assets/objetos-decorativos.json"), 
                new TypeReference<List<Decoracion>>(){});

        } catch (IOException e) {

            e.printStackTrace();
        }
    

        decoItemRepo.saveAll(itemList);
        
    }

    void loadItems() {
        
		List<Item> itemList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
                itemList = objectMapper.readValue(
                new File("Assets/items.json"), 
                new TypeReference<List<Item>>(){});

        } catch (IOException e) {

            e.printStackTrace();
        } 
        itemRepo.saveAll(itemList);
        
	}

    void loadMonsters(){
  
		List<Monstruo> monsterList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
                monsterList = objectMapper.readValue(
                new File("Assets/monstruos.json"), 
                new TypeReference<List<Monstruo>>(){});

        } catch (IOException e) {

            e.printStackTrace();
        }
        monsterRepo.saveAll(monsterList);

    }

    void loadPlayers(){

        Jugador pA = new Jugador();
        pA.setName("Alice");
        pA.setAttack_level(30);
        pA.setSize(30);
        pA.setWeight(0l);
        pA.setMaxWeight(100l);
        pA.getCategory().add("Categoria Uno");
        pA.getCategory().add("Categoria Dos");

        Jugador pB = new Jugador();
        pB.setName("Bob");
        pB.setAttack_level(20);
        pB.setSize(20);
        pB.setWeight(0l);
        pB.setMaxWeight(100l);
        pB.getCategory().add("Categoria Uno");
        pB.getCategory().add("Categoria Dos");

        playerRepo.save(pA);
        playerRepo.save(pB);
        
    }

    void loadRooms(){

        

        Habitacion roomA = new Habitacion();
        roomA.setName("Room A");
        roomRepo.save(roomA);

        Habitacion roomB = new Habitacion();
        roomB.setName("Room B");
        roomRepo.save(roomB);

    }

}

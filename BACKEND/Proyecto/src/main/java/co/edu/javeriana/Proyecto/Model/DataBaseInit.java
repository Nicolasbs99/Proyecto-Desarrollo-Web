package co.edu.javeriana.Proyecto.Model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataBaseInit implements ApplicationRunner {

    @Autowired
    MonstruoRepo monsRepo;

    @Autowired
    HabRepo habRepos;

    @Autowired
    CalaRepo calRepos;

    @Autowired
    JugadorRepo jugadoRepo;

    @Autowired
    MochilaRepo Mochilas;

    @Autowired
    ItemRepo itemRepos;

    @Autowired
    DecoracionRepo decoRepo;

    

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        
        monsRepo.save(new Monstruo("Monstruo 1", 10, 15, 1, "desc", 100, "wiki", "cat"));
        monsRepo.save(new Monstruo("Monstruo 2", 14, 19, 3, "desc", 150, "wiki", "cat"));
        monsRepo.save(new Monstruo("Monstruo 3", 5, 25, 2, "desc", 90, "wiki", "cat"));
        habRepos.save(new Habitacion("Habitacion 1"));
        habRepos.save(new Habitacion("Habitacion 2"));
        habRepos.save(new Habitacion("Habitacion 3"));
        calRepos.save(new Calabozo("Calabozo 1"));
        calRepos.save(new Calabozo("Calabozo 2"));
        calRepos.save(new Calabozo("Calabozo 3"));
        Mochilas.save(new Mochila((float) 93.5));
        Mochilas.save(new Mochila((float) 67.03));
        Mochilas.save(new Mochila((float) 54.5));
        jugadoRepo.save(new Jugador("Nicolas", 10, 15, 1, "desc", 100, "wiki", "cat"));
        jugadoRepo.save(new Jugador("Sergio", 14, 19, 3, "desc", 150, "wiki", "cat"));
        jugadoRepo.save(new Jugador("Santiago", 5, 25, 2, "desc", 90, "wiki", "cat"));
        itemRepos.save(new Item( "Espada", 12, (float)9.6, "descrip", "op"));
        itemRepos.save(new Item( "Escudo", 20, (float)18.2, "descrip", "op"));
        itemRepos.save(new Item( "Botas", 6, (float)3.6, "descrip", "op"));
        cargarDeco();
        //loadItems();
        //loadMonsters();

        Calabozo cal = calRepos.findById(1l).orElseThrow();
        for (Habitacion h : habRepos.findAll()) {
            h.setCalabozo(cal);
            habRepos.save(h);
        }

        Habitacion hab = habRepos.findById(1l).orElseThrow();
        for (Jugador j : jugadoRepo.findAll()) {
            j.setHabitacion(hab);
            jugadoRepo.save(j);
        }
        Habitacion habi = habRepos.findById(1l).orElseThrow();
        for (Decoracion d : decoRepo.findAll()) {
            d.setHabi(habi);
            decoRepo.save(d);
        }
        Mochila mj = Mochilas.findById(2l).orElseThrow();
        for (Item j : itemRepos.findAll()) {
            j.setMochila(mj);
            itemRepos.save(j);
        }
        for (long i = 1; i < 4; i++) {
            Mochila m = Mochilas.findById(i).orElseThrow();
            Jugador j = jugadoRepo.findById(i).orElseThrow();
            j.setMochila(m);
            jugadoRepo.save(j);
        }
        Habitacion habs = habRepos.findById(1l).orElseThrow();
        Monstruo j = monsRepo.findById(2l).orElseThrow();
        habs.setMonstruo(j);
        habRepos.save(habs);
        Habitacion habs2 = habRepos.findById(3l).orElseThrow();
        Monstruo js = monsRepo.findById(1l).orElseThrow();
        habs2.setMonstruo(js);
        habRepos.save(habs2);
    }
    void cargarDeco(){

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		TypeReference<List<Decoracion>> typeReference = new TypeReference<List<Decoracion>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/objetos-decorativos.json");

		List<Decoracion> itemList = new ArrayList<>();
        
        try {
            itemList = (mapper.readValue(inputStream,typeReference));
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

       
        decoRepo.saveAll(itemList);
    }
    void loadItems() {
        
      
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<Item>> typeReference = new TypeReference<List<Item>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/items.json");

		List<Item> itemList = new ArrayList<>();
        try {
            itemList = (mapper.readValue(inputStream,typeReference));
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
        itemRepos.saveAll(itemList);
        
	}

    void loadMonsters(){

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<List<Monstruo>> typeReference = new TypeReference<List<Monstruo>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/assets/monstruos.json");       
		List<Monstruo> monsterList = new ArrayList<>();

        try {
            monsterList = (mapper.readValue(inputStream,typeReference));     
        } catch (StreamReadException e) {
            
            e.printStackTrace();
        } catch (DatabindException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
		
        monsRepo.saveAll(monsterList);

    }

}

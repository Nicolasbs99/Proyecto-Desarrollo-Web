package co.edu.javeriana.Proyecto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.Proyecto.Model.Habitacion;
import co.edu.javeriana.Proyecto.Model.ItemRepo;
import co.edu.javeriana.Proyecto.Model.Jugador;
import co.edu.javeriana.Proyecto.Model.JugadorRepo;

@RestController
@RequestMapping("/jugador")
public class JugadorControl {
    
    @Autowired
    JugadorRepo playerRepository;
    
    @Autowired
    ItemRepo itemRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Jugador> showPlayers(){
        List<Jugador> list =(List<Jugador>) playerRepository.findAll();

        for(Jugador p: list){
            resolveRedundancy(p.getLocation());
        }

        return list;
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Jugador showPlayer(@PathVariable Long id){
        Jugador selected = playerRepository.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Jugador saveData(@RequestBody Jugador player){
        Jugador saved = playerRepository.save(player);

        resolveRedundancy(saved.getLocation());

        return saved;
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    String deleteMonster(@PathVariable Long id){
        playerRepository.deleteById(id);
        return "player deleted";
    }
    public void resolveRedundancy(Habitacion selected){

        if(selected != null){

            Set<Habitacion> exits = new HashSet<Habitacion>();
            for(Habitacion r : selected.getExits()){
    
                Habitacion aux = new Habitacion();
                aux.setName(r.getName());
                aux.setId(r.getId());
                exits.add(aux); 
            }
            
            selected.setExits(exits);

        }

    }
}   

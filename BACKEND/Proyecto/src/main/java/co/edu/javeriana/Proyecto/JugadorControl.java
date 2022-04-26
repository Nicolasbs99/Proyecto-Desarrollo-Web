package co.edu.javeriana.Proyecto;

import java.util.List;
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
        return (List<Jugador>) playerRepository.findAll();
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
        return playerRepository.save(player);
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    void deleteMonster(@PathVariable Long id){
       playerRepository.deleteById(id);
    }
    
}   

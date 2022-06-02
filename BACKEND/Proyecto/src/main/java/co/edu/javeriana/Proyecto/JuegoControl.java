package co.edu.javeriana.Proyecto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import co.edu.javeriana.Proyecto.Model.Habitacion;
import co.edu.javeriana.Proyecto.Model.Jugador;
import co.edu.javeriana.Proyecto.Model.JugadorRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class JuegoControl {
    
    @Autowired
    JugadorRepo playerRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/roomPlayers/{roomName}")
    @CrossOrigin("http://localhost:4200")
    List<Jugador> getRoomPlayers(@PathVariable String roomName){
        
        List<Jugador> list =(List<Jugador>) playerRepository.findAll();
        List<Jugador> ret =  new ArrayList<>();

        for(Jugador p: list){
            
            if(p.getLocation() != null && roomName != ""){

                if(p.getLocation().getName().equals(roomName)){

                    resolveRedundancy(p.getLocation());    
                    ret.add(p);
                    
                }   

            }            
        }

        return ret;
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
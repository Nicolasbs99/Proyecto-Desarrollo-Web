package co.edu.javeriana.Proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.javeriana.Proyecto.Model.Jugador;
import co.edu.javeriana.Proyecto.Model.JugadorRepo;

@Controller
@RequestMapping("/jugador")
public class JugadorControl {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JugadorRepo jugadores;

    @GetMapping("/lista")
    String findAll(){
        Iterable<Jugador> jugador = jugadores.findAll();
        for (Jugador jugador2 : jugador) {
           log.info("{}",jugador2.getNombre()); 
        }
        
        
        return "jugador-list";
    }

    @GetMapping("/{id}")
    String findJugador(@PathVariable Long id, Model model){
        Jugador jugador = jugadores.findById(id).orElseThrow();
        model.addAttribute("Jugador",jugador);
        log.info("{}",jugador.getNombre()); 
        
        
        
        return "jugador-list";
    }
    
}

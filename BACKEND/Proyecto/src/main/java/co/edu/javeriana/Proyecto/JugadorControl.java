package co.edu.javeriana.Proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        Jugador jugador = jugadores.findById(1l).orElseThrow();
        
        log.info("{}",jugador.getNombre());
        
        return "jugador-list";
    }

    
    
}

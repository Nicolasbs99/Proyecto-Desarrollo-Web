package co.edu.javeriana.Proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.javeriana.Proyecto.Model.Jugador;
import co.edu.javeriana.Proyecto.Model.JugadorRepo;

@Controller
@RequestMapping("/jugador")
public class JugadorControl {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JugadorRepo jugadores;

    @PostMapping("/guardar")
    public String guardarJugador(){
        return "redirect:/jugador/crear";
    }

    @GetMapping("crear")
    public String inicio(){
        return "CRUDadminAgrega";
    }   
    
    @GetMapping("/lista")
    String findJugador(Model model){
        model.addAttribute("jugador",jugadores.findAll()); 
            
        return "jugador-list";
    }
    
}

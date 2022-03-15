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
    JugadorRepo jugadorRepo;

    @PostMapping("/guardar")
    public String guardarJugador(){
        return "redirect:/";
    }

    @GetMapping("crear")
    public String inicio(){ 
        return "CRUDadminAgrega";
    }   
    @GetMapping("comingsoon")
    public String iniciod(){ 
        return "Jugador";
    }   
    @GetMapping("/list")
    String findJugador(Model model){
        model.addAttribute("jugadores",jugadorRepo.findAll()); 
             
        return "CRUDadminVerJuga";  
    }
    
}

package co.edu.javeriana.Proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

   
    @GetMapping("eliminar") 
    public String eliminarj(){  
        return "CRUDadminElimina";
    }  

    @GetMapping("mod")
    public String modj(){ 
        return "CRUDadminModifica";
    }  

    @GetMapping("/comingsoon")
    public String iniciod(){ 
        return "Jugador";
    }  

    @GetMapping("/list")
    String findJugador(Model model){
        model.addAttribute("jugadores",jugadorRepo.findAll()); 
             
        return "CRUDadminVerJuga";  
    }
  
    @GetMapping("/crear") 
    public String crearJugadorer(Model model){
        model.addAttribute("newItem", new Jugador());

        return "CRUDadminAgrega";
    }

    @PostMapping("guardar")
    public String guardarJugador(@ModelAttribute Jugador item, Model model){
        jugadorRepo.save(item);
        return "redirect:/jugador/list";
    }
 

    
}

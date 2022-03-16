package co.edu.javeriana.Proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/eliminar")
    public String deleteJugador(Model model, @ModelAttribute Jugador item){
        model.addAttribute("newItem", new Jugador());
        return "CRUDadminElimina";
    }

    @PostMapping("eliminado")
    public String eliminandoJugador(@ModelAttribute Jugador item, Model model){
        jugadorRepo.delete(item);
        return "redirect:/jugador/list";
    }

    @GetMapping("/mod")
    public String modificarJugador(Model model, @ModelAttribute Jugador item){
        model.addAttribute("newItem", new Jugador());
        return "CRUDadminModifica";
    }

    @PostMapping("modificado")
    public String modificarJugador(@ModelAttribute Jugador item, Model model){
        
        return "redirect:/jugador/list";
    }

   



 

    
}

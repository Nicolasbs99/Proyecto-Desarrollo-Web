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
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.javeriana.Proyecto.Model.Jugador;

import co.edu.javeriana.Proyecto.Model.JugadorRepo;
import co.edu.javeriana.Proyecto.Model.Mochila;
import co.edu.javeriana.Proyecto.Model.MochilaRepo;

@Controller
@RequestMapping("/jugador") 
public class JugadorControl {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JugadorRepo jugadorRepo;


    @Autowired
    MochilaRepo mochilas;

    @GetMapping("modificar")
    public String modj(Model model, @RequestParam Long id){ 
        Jugador selected = jugadorRepo.findById(id).orElseThrow();
        model.addAttribute("selected", selected);
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
    @PostMapping("guardarm")
    public String guardarJugadorm(@ModelAttribute Jugador item, Model model){
        jugadorRepo.save(item); 
        return "redirect:/jugador/list";
    } 
    @PostMapping("guardar")
    public String guardarJugador(@ModelAttribute Jugador item, Model model){
        float numero = (float) (Math.random() * 100 + 1);
        jugadorRepo.save(item); 
        mochilas.save(new Mochila(numero));
        
        for (long i = 1; i <= mochilas.count(); i++) {
            Mochila m = mochilas.findById(i).orElseThrow();
            item.setMochila(m);
            jugadorRepo.save(item);
        }
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
        Mochila m = mochilas.findById(item.getId()).orElseThrow();
        System.out.println(m.getId());
        mochilas.delete(m);
        return "redirect:/jugador/list";
    }

    

    

   



 

    
}

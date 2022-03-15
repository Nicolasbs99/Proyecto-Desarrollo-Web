package co.edu.javeriana.Proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.javeriana.Proyecto.Model.JugadorRepo;



@Controller
@RequestMapping("/")
public class Indexcont {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JugadorRepo jugadorRepo;

    
    @GetMapping("")
    public String inicio(){
        return "Index";
    }   
    @GetMapping("disenador")
    public String inicios(){
        return "Disenador";
    }  
    @GetMapping("disenar")
    public String inicioss(){
        return "CRUDdisena";
    }  
    @GetMapping("administrador")
    public String iniciosss(){
        return "Admin";
    }  
    @GetMapping("/administrador/list")
    String findJugador(Model model){
        model.addAttribute("jugadores",jugadorRepo.findAll()); 
             
        return "CRUDadminVerJuga";  
    }
    @GetMapping("administrador/crear")
    public String crearj(){ 
        
        return "CRUDadminAgrega";
    }
    
    @GetMapping("/disenar/CRUDHabitaciones")
    public String crearhab(){ 
        
        return "CRUDdisenaAgregaHabitat";
    }
    @GetMapping("/disenar/CRUDItem")
    public String creari(){ 
        
        return "CRUDdisenaAgregaItem";
    }
    @GetMapping("/disenar/CRUDMonstruo")
    public String crearm(){ 
        
        return "CRUDdisenaAgregaMonstruo";
    }
    @GetMapping("/disenar/CRUDDeco")
    public String creard(){ 
        
        return "CRUDdisenaAgregaDecor"; 
    }
} 

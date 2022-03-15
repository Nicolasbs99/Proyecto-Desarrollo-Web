package co.edu.javeriana.Proyecto;

import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import co.edu.javeriana.Proyecto.Model.Habitacion;

import co.edu.javeriana.Proyecto.Model.HabRepo;
<<<<<<< HEAD
import co.edu.javeriana.Proyecto.Model.Habitacion;
import co.edu.javeriana.Proyecto.Model.Item;
import co.edu.javeriana.Proyecto.Model.ItemRepo;
=======

>>>>>>> 5efc2ab40ee3afe3aa7a9f20d9b2718517ac64c9


@Controller
@RequestMapping("/habitacion")
public class HabitatControl {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    HabRepo repositorio;

    @GetMapping("/crearHabitacion") 
    public String crearItem(Model model){
        model.addAttribute("newItem", new Habitacion());
        return "CRUDdisenaAgregaHabitat";
    }

    @PostMapping("guardar")
    public String guardarJugador(@ModelAttribute Habitacion item, Model model){
        repositorio.save(item);
        return "redirect:/disenador";
    }

    @GetMapping("/salidaHabitacion") 
    public String eliminarItem(Model model){
        model.addAttribute("newItem", new Habitacion());
        return "CRUDdisenaSalidasHabitat";
    }
    @GetMapping("/monstruoHabitacion") 
    public String modificarItem(Model model){
        model.addAttribute("newItem", new Habitacion());
        return "CRUDdisenaMonstruosHabitat";
    }
    @GetMapping("/modificarHabitacion") 
    public String modificarItems(Model model){
        model.addAttribute("newItem", new Habitacion());
        return "CRUDdisenaAgregaItem";
    }
    @GetMapping("/ItemHabitacion") 
    public String item(Model model){
        model.addAttribute("newItem", new Habitacion());
        return "CRUDdisenaItemHabitat";
    }
    @GetMapping("/DecoHabitacion") 
    public String decoitem(Model model){
        model.addAttribute("newItem", new Habitacion());
        return "CRUDdisenaDecorHabitat";
    }
}

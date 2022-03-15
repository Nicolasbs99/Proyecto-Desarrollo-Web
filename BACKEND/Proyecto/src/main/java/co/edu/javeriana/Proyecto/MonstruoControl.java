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

import co.edu.javeriana.Proyecto.Model.Item;
import co.edu.javeriana.Proyecto.Model.ItemRepo;
import co.edu.javeriana.Proyecto.Model.Monstruo;
import co.edu.javeriana.Proyecto.Model.MonstruoRepo;


@Controller
@RequestMapping("/monstruo")
public class MonstruoControl {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MonstruoRepo repositorio;

    @GetMapping("/crearMonstruo") 
    public String crearItem(Model model){
        model.addAttribute("newItem", new Item());
        return "CRUDdisenaAgregaMonstruo";
    }

    @PostMapping("guardar")
    public String guardarJugador(@ModelAttribute Monstruo item, Model model){
        repositorio.save(item);
        return "redirect:/disenador";
    }


    
}

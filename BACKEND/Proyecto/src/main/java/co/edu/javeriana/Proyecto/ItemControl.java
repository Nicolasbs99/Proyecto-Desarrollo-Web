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


@Controller
@RequestMapping("/item")
public class ItemControl {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ItemRepo repositorio;

    @GetMapping("/crearItem") 
    public String crearItem(Model model){
        model.addAttribute("newItem", new Item());
        return "CRUDdisenaAgregaItem";
    }

    @PostMapping("guardar")
    public String guardarJugador(@ModelAttribute Item item, Model model){
        repositorio.save(item);
        return "redirect:/disenador";
    }

    @GetMapping("/eliminarItem") 
    public String eliminarItem(Model model){
        model.addAttribute("newItem", new Item());
        return "CRUDdisenaAgregaItem";
    }
    
    @GetMapping("/modificarItem") 
    public String modificarItem(Model model){
        model.addAttribute("newItem", new Item());
        return "CRUDdisenaAgregaItem";
    }
    
}

package co.edu.javeriana.Proyecto;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.Proyecto.Model.Decoracion;
import co.edu.javeriana.Proyecto.Model.DecoracionRepo;

@RestController
@RequestMapping("/decoItem")
public class DecoControl {

    @Autowired
    DecoracionRepo ItemDecoracion;

    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Decoracion> showDecoItems() {
        return (List<Decoracion>) ItemDecoracion.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Decoracion getDecoItem(@PathVariable Long id) {
        Decoracion selected = ItemDecoracion.findById(id).orElseThrow();
        return selected;
    }
    
    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Decoracion saveData(@RequestBody Decoracion dItem) {
        return ItemDecoracion.save(dItem);
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    String deleteDecoItem(@PathVariable Long id) {
        ItemDecoracion.deleteById(id);
        return "item deleted";
    }
    
}

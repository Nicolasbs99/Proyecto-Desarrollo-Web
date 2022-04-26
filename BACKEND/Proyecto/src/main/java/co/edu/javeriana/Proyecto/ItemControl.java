package co.edu.javeriana.Proyecto;

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

import co.edu.javeriana.Proyecto.Model.Item;
import co.edu.javeriana.Proyecto.Model.ItemRepo;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemControl {

    @Autowired
    ItemRepo ItemRepo;
    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Item> showItems() {
        return (List<Item>) ItemRepo.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Item getItem(@PathVariable Long id) {
        Item selected = ItemRepo.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Item saveData(@RequestBody Item item) {
        return ItemRepo.save(item);
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    void deleteItem(@PathVariable Long id) {
        ItemRepo.deleteById(id);  
    }

}

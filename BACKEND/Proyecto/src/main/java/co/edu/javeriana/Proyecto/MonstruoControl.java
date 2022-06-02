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

import co.edu.javeriana.Proyecto.Model.Monstruo;
import co.edu.javeriana.Proyecto.Model.MonstruoRepo;

@RestController
@RequestMapping("/monstruo")
public class MonstruoControl {

    @Autowired
    MonstruoRepo MonstruoRepo;
    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Monstruo> showMonsters() {
        return (List<Monstruo>) MonstruoRepo.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Monstruo getMonster(@PathVariable Long id) {
        Monstruo selected = MonstruoRepo.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Monstruo saveData(@RequestBody Monstruo newMonster) {
        return MonstruoRepo.save(newMonster);
    }

    @GetMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    String deleteMonster(@PathVariable Long id) {
        
        log.info("TRIED");
        MonstruoRepo.deleteById(id);

        return "monster deleted";
    }

}


package co.edu.javeriana.Proyecto;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import co.edu.javeriana.Proyecto.Model.Monstruo;
import co.edu.javeriana.Proyecto.Model.MonstruoRepo;

@Controller
@RequestMapping("/Monstruo")
public class MonstruoControl {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MonstruoRepo monsRepository;


    @GetMapping("/lista")
    String findAll(){
        Iterable<Monstruo> monstruos = monsRepository.findAll();
        for(Monstruo monstruo : monstruos)
        {
            log.info("{} ", monstruo.getNombre());
        } 
        return "Monstruo-list";
    }
}

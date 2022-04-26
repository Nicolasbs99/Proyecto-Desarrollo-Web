package co.edu.javeriana.Proyecto;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import co.edu.javeriana.Proyecto.Model.Habitacion;
import co.edu.javeriana.Proyecto.Model.ItemRepo;
import co.edu.javeriana.Proyecto.Model.JugadorRepo;
import co.edu.javeriana.Proyecto.Model.MonstruoRepo;
import co.edu.javeriana.Proyecto.Model.DecoracionRepo;
import co.edu.javeriana.Proyecto.Model.HabRepo;


@Controller
@RequestMapping("/habitacion")
public class HabitatControl {

    @Autowired
    ItemRepo itemRepository;

    @Autowired
    DecoracionRepo decorativeItemRepository;

    @Autowired
    MonstruoRepo monsterRepository;

    @Autowired
    JugadorRepo playerRepository;

    @Autowired
    HabRepo roomRepository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/list")
    @CrossOrigin("http://localhost:4200")
    List<Habitacion> listRooms() {
        return (List<Habitacion>) roomRepository.findAll();
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Habitacion getRoom(@PathVariable Long id) {
        Habitacion selected = roomRepository.findById(id).orElseThrow();
        return selected;
    }

    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Habitacion saveData(@ModelAttribute Habitacion room) {
        return roomRepository.save(room);
    }

    @PostMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    void deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
    }
    
}


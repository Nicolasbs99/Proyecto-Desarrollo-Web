package co.edu.javeriana.Proyecto;

import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
       
        List<Habitacion> found = (List<Habitacion>) roomRepository.findAll();
        for (Habitacion r : found) {
            resolveRedundancy(r);
        }
        return found;
    }

    @GetMapping("/{id}/get")
    @CrossOrigin("http://localhost:4200")
    Habitacion getRoom(@PathVariable Long id) {
        Habitacion selected = roomRepository.findById(id).orElseThrow();
        resolveRedundancy(selected);
        return selected;
    }


    @PostMapping("/{id}/delete")
    @CrossOrigin("http://localhost:4200")
    String deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
        return "room deleted";
    }
    
    @PostMapping("/save")
    @CrossOrigin("http://localhost:4200")
    Habitacion saveData(@RequestBody Habitacion room) {

        if (room.getMonster() != null) {

            if (room.getMonster().getName().isEmpty()) {
                room.setMonster(null);
            }
        }

        Habitacion saved = roomRepository.save(room);
        resolveRedundancy(saved);

        return saved;
    }

    public void resolveRedundancy(Habitacion selected) {

        Set<Habitacion> exits = new HashSet<Habitacion>();
        for (Habitacion r : selected.getExits()) {

            Habitacion aux = new Habitacion();
            aux.setName(r.getName());
            aux.setId(r.getId());
            exits.add(aux);
        }

        selected.setExits(exits);
    }
    
}


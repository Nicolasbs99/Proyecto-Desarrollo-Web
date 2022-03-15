package co.edu.javeriana.Proyecto.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataBaseInit implements ApplicationRunner {

    @Autowired
    MonstruoRepo monsRepo;

    @Autowired
    HabRepo habRepos;

    @Autowired
    CalaRepo calRepos;

    @Autowired
    JugadorRepo jugadoRepo;

    @Autowired
    MochilaRepo Mochilas;

    @Autowired
    ItemRepo itemRepos;

    @Autowired
    DecoracionRepo decoRepo;

    

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        
        monsRepo.save(new Monstruo("Monstruo 1", 10, 15, 1, "desc", 100, "wiki", "cat"));
        monsRepo.save(new Monstruo("Monstruo 2", 14, 19, 3, "desc", 150, "wiki", "cat"));
        monsRepo.save(new Monstruo("Monstruo 3", 5, 25, 2, "desc", 90, "wiki", "cat"));
        habRepos.save(new Habitacion("Habitacion 1"));
        habRepos.save(new Habitacion("Habitacion 2"));
        habRepos.save(new Habitacion("Habitacion 3"));
        calRepos.save(new Calabozo("Calabozo 1"));
        calRepos.save(new Calabozo("Calabozo 2"));
        calRepos.save(new Calabozo("Calabozo 3"));
        Mochilas.save(new Mochila((float) 93.5));
        Mochilas.save(new Mochila((float) 67.03));
        Mochilas.save(new Mochila((float) 54.5));
        jugadoRepo.save(new Jugador("Nicolas", 10, 15, 1, "desc", 100, "wiki", "cat"));
        jugadoRepo.save(new Jugador("Sergio", 14, 19, 3, "desc", 150, "wiki", "cat"));
        jugadoRepo.save(new Jugador("Santiago", 5, 25, 2, "desc", 90, "wiki", "cat"));
        itemRepos.save(new Item( "Espada", 12, (float)9.6, "descrip", "op"));
        itemRepos.save(new Item( "Escudo", 20, (float)18.2, "descrip", "op"));
        itemRepos.save(new Item( "Botas", 6, (float)3.6, "descrip", "op"));
        decoRepo.save(new Decoracion("Florero"));
        decoRepo.save(new Decoracion("Estante"));
        decoRepo.save(new Decoracion("Perchero"));


        Calabozo cal = calRepos.findById(1l).orElseThrow();
        for (Habitacion h : habRepos.findAll()) {
            h.setCalabozo(cal);
            habRepos.save(h);
        }

        Habitacion hab = habRepos.findById(1l).orElseThrow();
        for (Jugador j : jugadoRepo.findAll()) {
            j.setHabitacion(hab);
            jugadoRepo.save(j);
        }
        Habitacion habi = habRepos.findById(1l).orElseThrow();
        for (Decoracion d : decoRepo.findAll()) {
            d.setHabi(habi);
            decoRepo.save(d);
        }
        Mochila mj = Mochilas.findById(2l).orElseThrow();
        for (Item j : itemRepos.findAll()) {
            j.setMochila(mj);
            itemRepos.save(j);
        }
        for (long i = 1; i < 4; i++) {
            Mochila m = Mochilas.findById(i).orElseThrow();
            Jugador j = jugadoRepo.findById(i).orElseThrow();
            j.setMochila(m);
            jugadoRepo.save(j);
        }
        Habitacion habs = habRepos.findById(1l).orElseThrow();
        Monstruo j = monsRepo.findById(2l).orElseThrow();
        habs.setMonstruo(j);
        habRepos.save(habs);
        Habitacion habs2 = habRepos.findById(3l).orElseThrow();
        Monstruo js = monsRepo.findById(1l).orElseThrow();
        habs2.setMonstruo(js);
        habRepos.save(habs2);
    }
}

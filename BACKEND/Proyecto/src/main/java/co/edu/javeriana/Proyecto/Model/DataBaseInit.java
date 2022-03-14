package co.edu.javeriana.Proyecto.Model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataBaseInit implements ApplicationRunner{


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

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception{

        monsRepo.save(new Monstruo( "Monstruo 1", 10, 15, 1, "desc", 100, "wiki", "cat"));
        monsRepo.save(new Monstruo( "Monstruo 2", 14, 19, 3, "desc", 150, "wiki", "cat"));
        monsRepo.save(new Monstruo("Monstruo 3", 5,25, 2, "desc", 90, "wiki", "cat"));
        habRepos.save(new Habitacion("Habitacion 1"));
        habRepos.save(new Habitacion("Habitacion 2"));
        habRepos.save(new Habitacion("Habitacion 3"));
        calRepos.save(new Calabozo( "Calabozo 1"));
        calRepos.save(new Calabozo( "Calabozo 2"));
        calRepos.save(new Calabozo( "Calabozo 3"));
        Mochilas.save(new Mochila( (float) 93.5));
        Mochilas.save(new Mochila( (float) 67.03));
        Mochilas.save(new Mochila( (float) 54.5));
        jugadoRepo.save(new Jugador( "Nicolas", 10, 15, 1, "desc", 100, "wiki", "cat"));
        jugadoRepo.save(new Jugador( "Sergio", 14, 19, 3, "desc", 150, "wiki", "cat"));
        jugadoRepo.save(new Jugador("Santiago", 5,25, 2, "desc", 90, "wiki", "cat"));

        Calabozo c = calRepos.findById("Calabozo 3");
        for (Habitacion Hab : habRepos.findAll()) {
            Hab.setCalabozo(c);
            habRepos.save(Hab);
        }
        
    }
}

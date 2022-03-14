package co.edu.javeriana.Proyecto.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements ApplicationRunner{


    @Autowired
    MonstruoRepo monsRepo;


    @Override
    public void run(ApplicationArguments args) throws Exception{

        monsRepo.save(new Monstruo((long) 1, "Monstruo 1", 10, 15, 1, "desc", 100, "wiki", "cat"));
        monsRepo.save(new Monstruo((long) 2, "Monstruo 2", 14, 19, 3, "desc", 150, "wiki", "cat"));
        monsRepo.save(new Monstruo((long) 3, "Monstruo 3", 5,25, 2, "desc", 90, "wiki", "cat"));
    }
}

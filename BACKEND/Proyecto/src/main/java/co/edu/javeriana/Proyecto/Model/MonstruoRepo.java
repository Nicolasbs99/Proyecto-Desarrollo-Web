package co.edu.javeriana.Proyecto.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MonstruoRepo extends CrudRepository <Monstruo, Long> {
    
}

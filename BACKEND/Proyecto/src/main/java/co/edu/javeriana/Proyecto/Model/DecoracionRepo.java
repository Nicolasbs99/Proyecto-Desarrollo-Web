package co.edu.javeriana.Proyecto.Model;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DecoracionRepo  extends CrudRepository <Decoracion, Long> {
    
}

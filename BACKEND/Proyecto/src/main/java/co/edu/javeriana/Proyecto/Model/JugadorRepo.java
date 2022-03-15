package co.edu.javeriana.Proyecto.Model;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JugadorRepo extends CrudRepository <Jugador, Long> {
    
    List<Jugador> findAll();

}
package co.edu.javeriana.Proyecto.Model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JugadorRepo extends CrudRepository <Jugador, Long> {
    
    @Query("select c from Jugador c where c.id<150")
    List<Jugador> getAllJugadores();

    
}
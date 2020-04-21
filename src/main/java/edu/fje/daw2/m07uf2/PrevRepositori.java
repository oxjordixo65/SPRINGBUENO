package edu.fje.daw2.m07uf2;

import edu.fje.daw2.m07uf2.model.Prev;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Interficie de persistència amb Spring Data i MongoDB.
 * @author sergi.grau@fje.edu
 * @version 1.0 02.4.20
 */

public interface PrevRepositori extends MongoRepository<Prev, String> {

    Prev findByDia(String dia);
    List<Prev> findByTemps(String temps);
    List<Prev> findByTemperatura(int temperatura);

}
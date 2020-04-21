package edu.fje.daw2.m07uf2;

import edu.fje.daw2.m07uf2.model.Prev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * Classe principal d'Spring
 * utilitza un microservei per accedir a MongoDB.
 * A més realitza una càrrega inicial de dades
 * @author sergi.grau@fje.edu
 * @version 1.0 02.4.20
 */
@SpringBootApplication
@RestController
public class M07uf2Application implements CommandLineRunner {


    @Autowired
    private PrevRepositori repositori;

    public static void main(String[] args) {
        SpringApplication.run(M07uf2Application.class, args);
    }

    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @Override
    public void run(String... args) throws Exception {

        //repositori.deleteAll();

        /*
        repositori.save(new Prev("2020-01-10", "Sol", 25));
        repositori.save(new Prev("2020-01-11", "Nuvol", 30));

        for (Prev c : repositori.findAll()) {
            System.out.println(c);
        }
        System.out.println();
        System.out.println(repositori.findByDia("2020-01-11"));

        for (Prev c : repositori.findByTemps("Nuvol")) {
            System.out.println(c);
        }

         */

    }
}

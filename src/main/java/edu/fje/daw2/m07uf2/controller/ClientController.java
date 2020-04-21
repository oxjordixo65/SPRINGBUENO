package edu.fje.daw2.m07uf2.controller;

import edu.fje.daw2.m07uf2.ClientRepositori;
import edu.fje.daw2.m07uf2.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de clients
 * Verifica el funcionament de curl
 * @author sergi.grau@fje.edu
 * @version 1.0 02.4.20
 */
@Controller
@SessionAttributes("clients")
public class ClientController {

    @Autowired
    private ClientRepositori repositori;

    @ModelAttribute("clients")
    public List<Client> inicialitzar() {

        List<Client> clients = new ArrayList<>();
        for (Client c : repositori.findAll()) {
           clients.add(c);
        }
        return clients;
    }



    @RequestMapping(value={"/client", "/usuari"})
    String mostrarFormulari() {
        return("formulari");
    }

    @RequestMapping(value="/desarClient", method = RequestMethod.POST)
    String desarClient(@SessionAttribute("clients") List<Client> clients,
                            @RequestParam (defaultValue = "") String dia,
                            @RequestParam (defaultValue = "") String temps,
                       @RequestParam (defaultValue = "") int temperatura,
                            ModelMap model){
        Client c = new Client(dia, temps, temperatura);
        repositori.save(c);

        if(!model.containsAttribute("clients")) {
            model.addAttribute("clients", clients);
        }
        clients.add(c);


        return("llistaClients");
    }

    @RequestMapping(value="/esborrarClient", method = RequestMethod.GET)
    String esborrarClient(@SessionAttribute("clients") List<Client> clients,
                       @RequestParam (defaultValue = "") String id){

        System.out.println(id);

        repositori.deleteById(id);
        Client t = new Client();
        t.setId(id);
        clients.remove(0);

        return("llistaClients");
    }

}

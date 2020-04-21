package edu.fje.daw2.m07uf2.controller;

import edu.fje.daw2.m07uf2.PrevRepositori;
import edu.fje.daw2.m07uf2.model.Prev;

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
@SessionAttributes("prevs")
public class PrevController {

    @Autowired
    private PrevRepositori repositori;

    @ModelAttribute("prevs")
    public List<Prev> inicialitzar() {

        List<Prev> prevs = new ArrayList<>();
        for (Prev c : repositori.findAll()) {
            prevs.add(c);
        }
        return prevs;
    }



    @RequestMapping(value={"/prev", "/usuari"})
    String mostrarFormulari() {
        return("formulari");
    }

    @RequestMapping(value="/desarPrev", method = RequestMethod.POST)
    String desarPrev(@SessionAttribute("prevs") List<Prev> prevs,
                            @RequestParam (defaultValue = "") String dia,
                            @RequestParam (defaultValue = "") String temps,
                       @RequestParam (defaultValue = "") int temperatura,
                            ModelMap model){
        Prev c = new Prev(dia, temps, temperatura);
        repositori.save(c);

        if(!model.containsAttribute("prevs")) {
            model.addAttribute("prevs", prevs);
        }
        prevs.add(c);


        return("llistaPrevs");
    }

    @RequestMapping(value="/esborrarPrev", method = RequestMethod.GET)
    String esborrarPrev(@SessionAttribute("prevs") List<Prev> prevs,
                       @RequestParam (defaultValue = "") String id){

        System.out.println(id);

        repositori.deleteById(id);
        Prev t = new Prev();
        t.setId(id);
        prevs.remove(0);

        return("llistaPrevs");
    }

}

package cz.czechitas.java2webapps.ukol6.controller;


import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.service.VizitkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class VizitkaController {
    private VizitkaService vizitkaService;

    @Autowired
    public VizitkaController(VizitkaService vizitkaService) {
        this.vizitkaService = vizitkaService; //ulozeni repository do fieldu
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/") //zobrazi seznam vsech vizitek z databaze
    public ModelAndView seznam() {
        return new ModelAndView("seznam") //vytvori MAV a preda se sablona seznam.ftlh
                .addObject("seznam", vizitkaService.seznamVsech()); // do modelu se prida objekt seznam, ktery zobrazi vsechny dostupne vizitky z databaze
    }

    @GetMapping("/detail/{id}") //URL pozadavek ve formatu /detail/{id}
    public Object detail(@PathVariable int id) { //id se ziska z URL a preda se metode jako cislo
        Optional<Vizitka> optionalVizitka = vizitkaService.detailPodleId(id); //kontejner - obsahuje bud hodnotu nebo je prazdny, vola se sluzba vizitkaService -> vraci Optional<Vizitka>
        if (optionalVizitka.isPresent()) { //kontrola - vraci true, pokud Optional obsahuje hodnotu, pokud existuje vizitka -> zobrazi se
            Vizitka vizitka = optionalVizitka.get(); // z Optional se ziska Vizitka
            return new ModelAndView("vizitka") // vytvori se ModelAndView a preda se sablona vizitka.ftlh
                    .addObject("vizitka", vizitka); //do modelu se prida objekt vizitka, ktery bude pod timto nazvem dostupny v sablone

        }else{ //vizitka nenalezena
            return ResponseEntity.notFound().build(); // odpoved se stavem 404

        }
    }

    @GetMapping("/nova")//metoda GET reagujici na pozadavku /nova pro zobrazeni formulare
    public ModelAndView nova() {
        return new ModelAndView("formular") // zobrazi sablonu formular.ftlh
                .addObject("vizitka", new Vizitka()); //vytvori novou instanci Vizitka, preda ji do sablony pod nazvem vizitka
    }

    @PostMapping("/nova") //metoda POST reaguje na /nova
    public ModelAndView nova(@ModelAttribute Vizitka vizitka) { //prijima parametr Vizitka
        vizitkaService.pridat(vizitka);
        return new ModelAndView("redirect:/");
    }





}

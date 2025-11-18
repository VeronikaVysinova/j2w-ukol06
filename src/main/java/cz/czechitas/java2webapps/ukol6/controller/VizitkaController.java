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

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("seznam", vizitkaService.seznamVsech());
    }

    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable int id) {
        Optional<Vizitka> optionalVizitka = vizitkaService.detailPodleId(id);
        if (optionalVizitka.isPresent()) {
            Vizitka vizitka = optionalVizitka.get();
            return new ModelAndView("vizitka")
                    .addObject("vizitka", vizitka);

        }else{
            return ResponseEntity.notFound().build();

        }
    }




}

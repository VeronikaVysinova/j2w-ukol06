package cz.czechitas.java2webapps.ukol6.controller;


import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.service.VizitkaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VizitkaController {
    private VizitkaService vizitkaService;

    @Autowired
    public VizitkaController(VizitkaService vizitkaService) {
        this.vizitkaService = vizitkaService;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping ("/")
    public ModelAndView seznam() {
      return new ModelAndView("seznam")
                .addObject("vizitky", vizitkaService.seznamVsech());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        return new ModelAndView("vizitka")
                .addObject("detail", vizitkaService.detailVizitka(id));
    }

    @PostMapping("/nova")
    public String pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        vizitkaService.pridat(vizitka);
        return "redirect:/";
    }




}

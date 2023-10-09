package hu.progmatic.kiadasok.controller;

import hu.progmatic.kiadasok.entity.Ember;
import hu.progmatic.kiadasok.service.EmberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emberek")
public class EmberController {

    @Autowired
    private EmberService emberService;
    @GetMapping("/lista")
    public String listEmber(Model model) {
        List<Ember> emberek = emberService.findAll();
        model.addAttribute("emberek", emberek);
        return "ember";
    }

    @GetMapping("/frissit/{id}")
    public String updateEmberForm(@PathVariable int id, Model model) {
        Ember ember = emberService.findById(id);
        model.addAttribute("ember", ember);
        return "ember-frissit";
    }
    @PostMapping("/frissit/{id}")
    public String updateEmber(@PathVariable int id, @ModelAttribute("ember") Ember ember) {
        emberService.save(ember);
        return "redirect:/emberek/lista";
    }
    @GetMapping("/hozzaad")
    public String addEmberForm(Model model) {
        Ember ember = new Ember();
        model.addAttribute("ember", ember);
        return "ember-hozzaad-form";
    }

    @PostMapping("/hozzaad")
    public String addEmber(@ModelAttribute("ember") Ember ember) {
        emberService.save(ember);
        return "redirect:/emberek/lista";
    }
}
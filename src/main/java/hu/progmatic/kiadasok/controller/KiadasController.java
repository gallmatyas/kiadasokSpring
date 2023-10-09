package hu.progmatic.kiadasok.controller;
import hu.progmatic.kiadasok.entity.Ember;
import hu.progmatic.kiadasok.entity.Kiadas;
import hu.progmatic.kiadasok.service.EmberService;
import hu.progmatic.kiadasok.service.KiadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/kiadasok")
public class KiadasController {

    @Autowired
    private KiadasService kiadasService;

    @Autowired
    private EmberService emberService;
    @GetMapping("/hozzaad")
    public String addKiadasForm(Model model) {
        Kiadas kiadas = new Kiadas();
        model.addAttribute("kiadas", kiadas);

        List<Ember> emberek = emberService.findAll();
        model.addAttribute("emberek", emberek);

        return "kiadas-adatlap";
    }
    @PostMapping("/hozzaad")
    public String addKiadas(@ModelAttribute("kiadas") Kiadas kiadas) {
        kiadasService.addKiadas(kiadas);
        return "redirect:/kiadasok/lista";
    }

    @GetMapping("/lista/{emberId}")
    public String listKiadasesByEmber(@PathVariable int emberId, Model model) {
        Ember ember = emberService.findById(emberId);
        List<Kiadas> kiadases = kiadasService.findByEmber(ember);

        model.addAttribute("ember", ember);
        model.addAttribute("kiadases", kiadases);

        return "kiadas-lista";
    }

}

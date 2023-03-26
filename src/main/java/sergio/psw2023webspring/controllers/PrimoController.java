package sergio.psw2023webspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sergio.psw2023webspring.services.CaricaDatiService;

@Controller
@RequestMapping("/caricacatandprod")
public class PrimoController {

    @Autowired
    CaricaDatiService caricaDatiService;

    @RequestMapping(method = RequestMethod.GET)
    public String primo(Model m){
        caricaDatiService.caricaCategoriEProdotti();
        caricaDatiService.caricaClienti();
        m.addAttribute("messaggio","Categorie e Prodotti Caricati");
        return "primo.jsp";
    }
}

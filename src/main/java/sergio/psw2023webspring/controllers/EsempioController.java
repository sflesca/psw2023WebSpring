package sergio.psw2023webspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/esempio/{id}")
public class EsempioController {

    @RequestMapping(method = RequestMethod.GET)
    public String metodo(Model m, @PathVariable("id") int id){
        m.addAttribute("messaggio", ""+id);
        return "/esempio1.jsp";
    }
}

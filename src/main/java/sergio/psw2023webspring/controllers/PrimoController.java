package sergio.psw2023webspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/primo")
public class PrimoController {

    @RequestMapping(method = RequestMethod.GET)
    public String primo(Model m){
        return "primo.jsp";
    }
}

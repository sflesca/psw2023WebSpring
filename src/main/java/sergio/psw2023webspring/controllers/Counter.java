package sergio.psw2023webspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sergio.psw2023webspring.utility.Carrello;

@Controller
@RequestMapping("/count")
public class Counter {

    @Autowired
    Carrello cart;

    @RequestMapping(method = RequestMethod.GET)
    public String count(Model m) {
        if (cart==null) System.out.println("è nullo");
        cart.inc();
        m.addAttribute("counter",cart);
        return "count.jsp";
    }
}

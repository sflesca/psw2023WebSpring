package sergio.psw2023webspring.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sergio.psw2023webspring.model.Cliente;
import sergio.psw2023webspring.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ProvaRest {

    @Autowired
    ClienteService serv;

    @GetMapping
    public List<Cliente> getClienti(){ return serv.getClienti();}
}

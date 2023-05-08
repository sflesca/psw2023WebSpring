package sergio.psw2023webspring.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sergio.psw2023webspring.model.Cliente;
import sergio.psw2023webspring.services.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente")
public class ProvaRest {

    @Autowired
    ClienteService serv;

    @GetMapping("/all")
    public List<Cliente> getClienti(){ return serv.getClienti();}

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable long id){
        Cliente c = serv.getCliente(id);
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity<Long> crea(@RequestBody Cliente c){
        return  ResponseEntity.ok(serv.crea(c));
    }
}

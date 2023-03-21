package sergio.psw2023webspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergio.psw2023webspring.model.Cliente;
import sergio.psw2023webspring.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository rep;

    public Cliente getCliente(long id){
        return rep.findById(id).get();
    }
}

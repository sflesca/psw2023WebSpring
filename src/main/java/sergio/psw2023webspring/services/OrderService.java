package sergio.psw2023webspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sergio.psw2023webspring.model.Cliente;
import sergio.psw2023webspring.model.Ordine;
import sergio.psw2023webspring.repositories.ClienteRepository;
import sergio.psw2023webspring.repositories.DettaglioOrdineRepository;
import sergio.psw2023webspring.repositories.OrdineRepository;
import sergio.psw2023webspring.repositories.ProdottoRepository;
import sergio.psw2023webspring.utility.ItemDetails;
import sergio.psw2023webspring.utility.PriceChangedException;
import sergio.psw2023webspring.utility.QtaUnAvaliableException;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderService {
    @Autowired
    private OrdineRepository orderrep;

    @Autowired
    private DettaglioOrdineRepository dettrep;

    @Autowired
    private ProdottoRepository prep;

    @Autowired
    private ClienteRepository crep;

    public List<Ordine> getOrdini(){
        return orderrep.findAll();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {QtaUnAvaliableException.class, PriceChangedException.class})
    public void crea(List<ItemDetails> items) throws QtaUnAvaliableException, PriceChangedException{
        Cliente c = crep.findById(102L).get();
        Ordine o = new Ordine();
        o.setCliente(c);
        o.setData(new Date(System.currentTimeMillis()));
        orderrep.save(o);
    }

}

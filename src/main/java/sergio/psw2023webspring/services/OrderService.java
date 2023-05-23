package sergio.psw2023webspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sergio.psw2023webspring.model.Cliente;
import sergio.psw2023webspring.model.DettaglioOrdine;
import sergio.psw2023webspring.model.Ordine;
import sergio.psw2023webspring.model.Prodotto;
import sergio.psw2023webspring.repositories.ClienteRepository;
import sergio.psw2023webspring.repositories.DettaglioOrdineRepository;
import sergio.psw2023webspring.repositories.OrdineRepository;
import sergio.psw2023webspring.repositories.ProdottoRepository;
import sergio.psw2023webspring.utility.ItemDetails;
import sergio.psw2023webspring.utility.PriceChangedException;
import sergio.psw2023webspring.utility.QtaUnAvaliableException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Cliente c = crep.findById(1L).get();
        Ordine o = new Ordine();
        o.setCliente(c);
        o.setData(new Date(System.currentTimeMillis()));
        orderrep.save(o);
        for(ItemDetails itd:items){
            Optional<Prodotto> op = prep.findById(itd.getPid());
            if(!op.isPresent()) throw new RuntimeException();
            Prodotto p = op.get();
            if(p.getQta()< itd.getQta())
                throw new QtaUnAvaliableException(p.getId());
            if(p.getPrezzo()!=itd.getPrice())
                throw new PriceChangedException(p.getId());
            DettaglioOrdine dto = new DettaglioOrdine();
            dto.setProdotto(p);
            dto.setPrezzo(itd.getPrice());
            dto.setQta(itd.getQta());
            dettrep.save(dto);
            o.getDettagli().add(dto);
            p.setQta(p.getQta()-dto.getQta());
        }
    }

}

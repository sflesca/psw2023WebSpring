package sergio.psw2023webspring.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sergio.psw2023webspring.model.Ordine;
import sergio.psw2023webspring.services.OrderService;
import sergio.psw2023webspring.utility.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@CrossOrigin
public class OrderREST {

    @Autowired
    private OrderService oserv;

    @GetMapping
    public List<Ordine> getAllOrders(){
        return oserv.getOrdini();
    }

    @PostMapping
    public ResponseEntity<RispostaOrdine> crea(@RequestBody List<ItemDetails> items){
        for(ItemDetails it:items)
            System.out.println(it);
        try {
            oserv.crea(items);
        } catch (QtaUnAvaliableException e) {
            return ResponseEntity.ok(new RispostaOrdine(e.getPid(), OrderErrorTypes.QTA));
        } catch (PriceChangedException e) {
            return ResponseEntity.ok(new RispostaOrdine(e.getPid(), OrderErrorTypes.PRICE));
        }
        return ResponseEntity.ok(new RispostaOrdine());
    }

}

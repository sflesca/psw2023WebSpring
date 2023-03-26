package sergio.psw2023webspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sergio.psw2023webspring.model.Categoria;
import sergio.psw2023webspring.model.Cliente;
import sergio.psw2023webspring.model.Prodotto;
import sergio.psw2023webspring.repositories.CategoriaRepository;
import sergio.psw2023webspring.repositories.ClienteRepository;
import sergio.psw2023webspring.repositories.ProdottoRepository;

@Service
@Transactional
public class CaricaDatiService {

    private final String[] categorynames = {"elettrodomestici", "computer"};
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public void caricaCategoriEProdotti(){
        for (String cname:categorynames) {
            Categoria c = new Categoria();
            c.setNome(cname);
            categoriaRepository.save(c);
            for(int i=0;i<5;i++){
                Prodotto p = new Prodotto();
                p.setNome("p"+i);
                p.setPrezzo(10+i*2.0);
                p.setQta(1+i);
                p.setCategoria(c);
                c.getProdotti().add(p);
                prodottoRepository.save(p);

            }
        }
    }

    public void caricaClienti(){
        Cliente c = new Cliente();
        c.setNome("Mario");
        c.setCognome("Rossi");
        c.setTessera("1234");

        clienteRepository.save(c);
    }
}

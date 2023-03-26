package sergio.psw2023webspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sergio.psw2023webspring.model.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
}
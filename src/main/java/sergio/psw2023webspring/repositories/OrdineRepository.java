package sergio.psw2023webspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sergio.psw2023webspring.model.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Long> {
}
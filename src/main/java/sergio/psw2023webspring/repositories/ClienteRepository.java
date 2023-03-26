package sergio.psw2023webspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sergio.psw2023webspring.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}

package sergio.psw2023webspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sergio.psw2023webspring.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
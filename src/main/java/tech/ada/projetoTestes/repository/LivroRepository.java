package tech.ada.projetoTestes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.projetoTestes.domain.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

}

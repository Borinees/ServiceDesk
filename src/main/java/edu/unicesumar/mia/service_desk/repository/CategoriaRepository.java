package edu.unicesumar.mia.service_desk.repository;

import edu.unicesumar.mia.service_desk.bean.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}

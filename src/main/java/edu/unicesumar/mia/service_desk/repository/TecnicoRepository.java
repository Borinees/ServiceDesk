package edu.unicesumar.mia.service_desk.repository;

import edu.unicesumar.mia.service_desk.bean.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}

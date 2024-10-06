package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.PlanoOdontologico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoOdontologicoRepository extends JpaRepository<PlanoOdontologico, Integer> {
}
package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.TipoPlanoOdontologico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPlanoOdontologicoRepository extends JpaRepository<TipoPlanoOdontologico, Integer> {
}
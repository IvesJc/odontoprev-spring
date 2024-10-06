package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.TipoRecompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRecompensaRepository extends JpaRepository<TipoRecompensa, Integer> {
}
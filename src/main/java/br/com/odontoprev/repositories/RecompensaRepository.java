package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, Integer> {
}
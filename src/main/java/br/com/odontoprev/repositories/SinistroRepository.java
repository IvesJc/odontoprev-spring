package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.Sinistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinistroRepository extends JpaRepository<Sinistro, Integer> {
}
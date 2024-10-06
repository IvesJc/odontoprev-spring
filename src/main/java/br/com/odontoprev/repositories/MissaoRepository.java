package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.Missao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Integer> {
}
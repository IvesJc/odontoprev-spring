package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.PrestadorServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, Integer> {
}
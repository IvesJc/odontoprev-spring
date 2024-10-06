package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Integer> {
}
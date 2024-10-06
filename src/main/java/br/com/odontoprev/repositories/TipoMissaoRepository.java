package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.TipoMissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMissaoRepository extends JpaRepository<TipoMissao, Integer> {
}
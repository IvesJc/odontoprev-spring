package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.ProgramaRelacionamentoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaRelacionamentoStatusRepository extends JpaRepository<ProgramaRelacionamentoStatus, Integer> {
}
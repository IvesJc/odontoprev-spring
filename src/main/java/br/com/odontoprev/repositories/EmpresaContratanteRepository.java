package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.EmpresaContratante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaContratanteRepository extends JpaRepository<EmpresaContratante, Integer> {
}
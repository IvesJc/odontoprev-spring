package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.RedeCredenciada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeCredenciadaRepository extends JpaRepository<RedeCredenciada, Integer> {
}
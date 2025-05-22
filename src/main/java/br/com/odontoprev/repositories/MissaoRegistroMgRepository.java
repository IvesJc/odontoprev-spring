package br.com.odontoprev.repositories;

import br.com.odontoprev.entities.MissaoRegistroMg;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MissaoRegistroMgRepository extends MongoRepository<MissaoRegistroMg, String> {
}

package br.com.odontoprev.usecases;

import br.com.odontoprev.entities.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnderecoUsecase {
    ResponseEntity<List<Endereco>> getAllEnderecos();
    ResponseEntity<Endereco> getEnderecoById(int id);
    ResponseEntity<Endereco> createEndereco(Endereco endereco);
    ResponseEntity<Endereco> updateEndereco(int id, Endereco endereco);
    ResponseEntity<Void> deleteEndereco(int id);
}

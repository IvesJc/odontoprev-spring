package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.entities.Endereco;
import br.com.odontoprev.repositories.EnderecoRepository;
import br.com.odontoprev.usecases.EnderecoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EnderecoUsecaseImpl implements EnderecoUsecase {

    private final EnderecoRepository enderecoRepository;

    @Override
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return ResponseEntity.ok(enderecos);
    }

    @Override
    public ResponseEntity<Endereco> getEnderecoById(int id) {
        return enderecoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Endereco> createEndereco(Endereco endereco) {
        Endereco savedEndereco = enderecoRepository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEndereco);
    }

    @Override
    public ResponseEntity<Endereco> updateEndereco(int id, Endereco endereco) {
        if (!enderecoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        endereco.setId(id);
        Endereco updatedEndereco = enderecoRepository.save(endereco);
        return ResponseEntity.ok(updatedEndereco);
    }

    @Override
    public ResponseEntity<Void> deleteEndereco(int id) {
        if (!enderecoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        enderecoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package br.com.odontoprev.gateways;

import br.com.odontoprev.entities.Endereco;
import br.com.odontoprev.usecases.EnderecoUsecase;
import br.com.odontoprev.usecases.impl.EnderecoUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoUsecaseImpl enderecoUsecase;

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        return enderecoUsecase.getAllEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable int id) {
        return enderecoUsecase.getEnderecoById(id);
    }

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        return enderecoUsecase.createEndereco(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable int id, @RequestBody Endereco endereco) {
        return enderecoUsecase.updateEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable int id) {
        return enderecoUsecase.deleteEndereco(id);
    }
}
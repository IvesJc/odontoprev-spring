package br.com.odontoprev.gateways;

import br.com.odontoprev.dto.endereco.CreateEnderecoDto;
import br.com.odontoprev.dto.endereco.EnderecoDto;
import br.com.odontoprev.dto.endereco.UpdateEnderecoDto;
import br.com.odontoprev.entities.Endereco;
import br.com.odontoprev.usecases.EnderecoUsecase;
import br.com.odontoprev.usecases.impl.EnderecoUsecaseImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
@Tag(name = "Endereco", description = "Endpoints destinados para a classe Endereco")

public class EnderecoController {

    private final EnderecoUsecaseImpl enderecoUsecase;

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> getAllEnderecos() {
        return enderecoUsecase.getAllEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> getEnderecoById(@PathVariable int id) {
        return enderecoUsecase.getEnderecoById(id);
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> createEndereco(@RequestBody CreateEnderecoDto endereco) {
        return enderecoUsecase.createEndereco(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDto> updateEndereco(@PathVariable int id, @RequestBody UpdateEnderecoDto endereco) {
        return enderecoUsecase.updateEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable int id) {
        return enderecoUsecase.deleteEndereco(id);
    }
}
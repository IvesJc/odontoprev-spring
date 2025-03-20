package br.com.odontoprev.usecases.impl;

import br.com.odontoprev.dto.endereco.CreateEnderecoDto;
import br.com.odontoprev.dto.endereco.EnderecoDto;
import br.com.odontoprev.dto.endereco.UpdateEnderecoDto;
import br.com.odontoprev.entities.Endereco;
import br.com.odontoprev.mappers.EnderecoMapper;
import br.com.odontoprev.repositories.EnderecoRepository;
import br.com.odontoprev.usecases.EnderecoUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EnderecoUsecaseImpl implements EnderecoUsecase {

    private final EnderecoRepository enderecoRepository;

    @Override
    public ResponseEntity<List<EnderecoDto>> getAllEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        List<EnderecoDto> enderecosDto = enderecos.stream()
                .map(EnderecoMapper::toEnderecoDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(enderecosDto);
    }

    @Override
    public ResponseEntity<EnderecoDto> getEnderecoById(int id) {
        return enderecoRepository.findById(id)
                .map(endereco -> ResponseEntity.ok(EnderecoMapper.toEnderecoDto(endereco)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<EnderecoDto> createEndereco(CreateEnderecoDto createDto) {
        Endereco endereco = EnderecoMapper.toEnderecoFromCreate(createDto);

        // Salva o endereço no repositório
        Endereco savedEndereco = enderecoRepository.save(endereco);

        // Retorna a resposta com o DTO do endereço recém-criado
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EnderecoMapper.toEnderecoDto(savedEndereco));
    }

    @Override
    public ResponseEntity<EnderecoDto> updateEndereco(int id, UpdateEnderecoDto updateDto) {
        if (!enderecoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Endereco endereco = EnderecoMapper.toEnderecoFromUpdate(updateDto);
        endereco.setId(id);

        Endereco updatedEndereco = enderecoRepository.save(endereco);

        return ResponseEntity.ok(EnderecoMapper.toEnderecoDto(updatedEndereco));
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

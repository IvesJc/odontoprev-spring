package br.com.odontoprev.usecases;

import br.com.odontoprev.dto.endereco.CreateEnderecoDto;
import br.com.odontoprev.dto.endereco.EnderecoDto;
import br.com.odontoprev.dto.endereco.UpdateEnderecoDto;
import br.com.odontoprev.entities.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnderecoUsecase {
    ResponseEntity<List<EnderecoDto>> getAllEnderecos();
    ResponseEntity<EnderecoDto> getEnderecoById(int id);
    ResponseEntity<EnderecoDto> createEndereco(CreateEnderecoDto endereco);
    ResponseEntity<EnderecoDto> updateEndereco(int id, UpdateEnderecoDto endereco);
    ResponseEntity<Void> deleteEndereco(int id);
}

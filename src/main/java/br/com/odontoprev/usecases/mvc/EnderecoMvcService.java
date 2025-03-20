package br.com.odontoprev.usecases.mvc;

import br.com.odontoprev.dto.endereco.EnderecoDto;
import br.com.odontoprev.entities.Endereco;
import br.com.odontoprev.mappers.EnderecoMapper;
import br.com.odontoprev.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoMvcService {
    private final EnderecoRepository enderecoRepository;


    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco getEnderecoById(int id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public void saveEndereco(EnderecoDto endereco) {
        Endereco enderecoEntity = EnderecoMapper.toEnderecoFromDto(endereco);  // Converte o DTO para a entidade
        enderecoRepository.save(enderecoEntity);  // Salva no banco de dados
    }
    public void updateEndereco(EnderecoDto enderecoDto) {
        Endereco enderecoExistente = enderecoRepository.findById(enderecoDto.id())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        enderecoExistente.setRua(enderecoDto.rua());
        enderecoExistente.setNumero(enderecoDto.numero());
        enderecoExistente.setCidade(enderecoDto.cidade());
        enderecoExistente.setEstado(enderecoDto.estado());
        enderecoExistente.setCep(enderecoDto.cep());
        enderecoExistente.setComplemento(enderecoDto.complemento());

        enderecoRepository.save(enderecoExistente);
    }

    public void deleteEndereco(int id) {
        enderecoRepository.deleteById(id);
    }
}
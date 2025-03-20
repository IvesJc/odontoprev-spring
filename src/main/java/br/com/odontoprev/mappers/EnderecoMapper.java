package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.endereco.CreateEnderecoDto;
import br.com.odontoprev.dto.endereco.EnderecoDto;
import br.com.odontoprev.dto.endereco.UpdateEnderecoDto;
import br.com.odontoprev.entities.Endereco;

public class EnderecoMapper {

    public static EnderecoDto toEnderecoDto(Endereco endereco) {
        return new EnderecoDto(
                endereco.getId(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getComplemento()
        );
    }
    public static Endereco toEnderecoFromDto(EnderecoDto createDto) {
        Endereco endereco = new Endereco();
        endereco.setId(createDto.id());
        endereco.setRua(createDto.rua());
        endereco.setNumero(createDto.numero());
        endereco.setCidade(createDto.cidade());
        endereco.setEstado(createDto.estado());
        endereco.setCep(createDto.cep());
        endereco.setComplemento(createDto.complemento());
        return endereco;
    }
    public static Endereco toEnderecoFromCreate(CreateEnderecoDto createDto) {
        Endereco endereco = new Endereco();
        endereco.setRua(createDto.rua());
        endereco.setNumero(createDto.numero());
        endereco.setCidade(createDto.cidade());
        endereco.setEstado(createDto.estado());
        endereco.setCep(createDto.cep());
        endereco.setComplemento(createDto.complemento());
        return endereco;
    }

    public static Endereco toEnderecoFromUpdate(UpdateEnderecoDto updateDto) {
        Endereco endereco = new Endereco();
        endereco.setRua(updateDto.rua());
        endereco.setNumero(updateDto.numero());
        endereco.setCidade(updateDto.cidade());
        endereco.setEstado(updateDto.estado());
        endereco.setCep(updateDto.cep());
        endereco.setComplemento(updateDto.complemento());
        return endereco;
    }
}

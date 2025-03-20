package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.tipoPlano.CreateTipoPlanoDto;
import br.com.odontoprev.dto.tipoPlano.TipoPlanoDto;
import br.com.odontoprev.dto.tipoPlano.UpdateTipoPlanoDto;
import br.com.odontoprev.entities.TipoPlanoOdontologico;
import java.util.List;
import java.util.stream.Collectors;

public class TipoPlanoOdontologicoMapper {

    // Converte TipoPlanoOdontologico para TipoPlanoOdontologicoDto
    public static TipoPlanoDto toDto(TipoPlanoOdontologico tipoPlanoOdontologico) {
        return new TipoPlanoDto(
                tipoPlanoOdontologico.getId(),
                tipoPlanoOdontologico.getNome(),
                tipoPlanoOdontologico.getTipo(),
                tipoPlanoOdontologico.getPreco(),
                tipoPlanoOdontologico.getCarenciaDias(),
                tipoPlanoOdontologico.getValidadeDias()
        );
    }

    // Converte CreateTipoPlanoOdontologicoDto para TipoPlanoOdontologico
    public static TipoPlanoOdontologico toEntity(CreateTipoPlanoDto createDto) {
        TipoPlanoOdontologico tipoPlanoOdontologico = new TipoPlanoOdontologico();
        tipoPlanoOdontologico.setNome(createDto.nome());
        tipoPlanoOdontologico.setTipo(createDto.tipo());
        tipoPlanoOdontologico.setPreco(createDto.preco());
        tipoPlanoOdontologico.setCarenciaDias(createDto.carenciaDias());
        tipoPlanoOdontologico.setValidadeDias(createDto.validadeDias());
        return tipoPlanoOdontologico;
    }

    // Converte UpdateTipoPlanoOdontologicoDto para TipoPlanoOdontologico
    public static TipoPlanoOdontologico toEntity(UpdateTipoPlanoDto updateDto) {
        TipoPlanoOdontologico tipoPlanoOdontologico = new TipoPlanoOdontologico();
        tipoPlanoOdontologico.setNome(updateDto.nome());
        tipoPlanoOdontologico.setTipo(updateDto.tipo());
        tipoPlanoOdontologico.setPreco(updateDto.preco());
        tipoPlanoOdontologico.setCarenciaDias(updateDto.carenciaDias());
        tipoPlanoOdontologico.setValidadeDias(updateDto.validadeDias());
        return tipoPlanoOdontologico;
    }

    // Converte uma lista de TipoPlanoOdontologico para uma lista de TipoPlanoOdontologicoDto
    public static List<TipoPlanoDto> toDtoList(List<TipoPlanoOdontologico> tipoPlanoOdontologicos) {
        return tipoPlanoOdontologicos.stream()
                .map(TipoPlanoOdontologicoMapper::toDto)
                .collect(Collectors.toList());
    }
}


package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.tipoRecompensa.CreateTipoRecompensaDto;
import br.com.odontoprev.dto.tipoRecompensa.TipoRecompensaDto;
import br.com.odontoprev.dto.tipoRecompensa.UpdateTipoRecompensaDto;
import br.com.odontoprev.entities.TipoRecompensa;

import java.util.List;
import java.util.stream.Collectors;

public class TipoRecompensaMapper {

    // Converte TipoRecompensa para TipoRecompensaDto
    public static TipoRecompensaDto toDto(TipoRecompensa tipoRecompensa) {
        return new TipoRecompensaDto(
                tipoRecompensa.getId(),
                tipoRecompensa.getNome(),
                tipoRecompensa.getExpiracaoDias(),
                tipoRecompensa.getAplicacao()
        );
    }

    // Converte TipoRecompensaDto para TipoRecompensa
    public static TipoRecompensa toEntity(CreateTipoRecompensaDto createDto) {
        TipoRecompensa tipoRecompensa = new TipoRecompensa();
        tipoRecompensa.setNome(createDto.nome());
        tipoRecompensa.setExpiracaoDias(createDto.expiracaoDias());
        tipoRecompensa.setAplicacao(createDto.aplicacao());
        return tipoRecompensa;
    }

    // Converte TipoRecompensaDto para TipoRecompensa (para atualização)
    public static TipoRecompensa toEntity(UpdateTipoRecompensaDto updateDto) {
        TipoRecompensa tipoRecompensa = new TipoRecompensa();
        tipoRecompensa.setNome(updateDto.nome());
        tipoRecompensa.setExpiracaoDias(updateDto.expiracaoDias());
        tipoRecompensa.setAplicacao(updateDto.aplicacao());
        return tipoRecompensa;
    }

    // Converte uma lista de TipoRecompensa para uma lista de TipoRecompensaDto
    public static List<TipoRecompensaDto> toDtoList(List<TipoRecompensa> tipoRecompensas) {
        return tipoRecompensas.stream()
                .map(TipoRecompensaMapper::toDto)
                .collect(Collectors.toList());
    }
}


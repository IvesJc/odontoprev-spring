package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.tipoMissao.CreateTipoMissaoDto;
import br.com.odontoprev.dto.tipoMissao.TipoMissaoDto;
import br.com.odontoprev.dto.tipoMissao.UpdateTipoMissaoDto;
import br.com.odontoprev.entities.TipoMissao;

public class TipoMissaoMapper {

    // Converte de TipoMissao para TipoMissaoDto
    public static TipoMissaoDto toTipoMissaoDto(TipoMissao tipoMissao) {
        return new TipoMissaoDto(
                tipoMissao.getId(),
                tipoMissao.getTitulo(),
                tipoMissao.getDuracaoPadraoDias(),
                tipoMissao.getRecompensaPadrao(),
                tipoMissao.getFrequencia()
        );
    }

    // Converte de CreateTipoMissaoDto para TipoMissao
    public static TipoMissao toTipoMissaoFromCreate(CreateTipoMissaoDto createTipoMissaoDto) {
        TipoMissao tipoMissao = new TipoMissao();
        tipoMissao.setTitulo(createTipoMissaoDto.titulo());
        tipoMissao.setDuracaoPadraoDias(createTipoMissaoDto.duracaoPadraoDias());
        tipoMissao.setRecompensaPadrao(createTipoMissaoDto.recompensaPadrao());
        tipoMissao.setFrequencia(createTipoMissaoDto.frequencia());
        return tipoMissao;
    }

    // Converte de UpdateTipoMissaoDto para TipoMissao
    public static TipoMissao toTipoMissaoFromUpdate(UpdateTipoMissaoDto updateTipoMissaoDto) {
        TipoMissao tipoMissao = new TipoMissao();
        tipoMissao.setTitulo(updateTipoMissaoDto.titulo());
        tipoMissao.setDuracaoPadraoDias(updateTipoMissaoDto.duracaoPadraoDias());
        tipoMissao.setRecompensaPadrao(updateTipoMissaoDto.recompensaPadrao());
        tipoMissao.setFrequencia(updateTipoMissaoDto.frequencia());
        return tipoMissao;
    }
}




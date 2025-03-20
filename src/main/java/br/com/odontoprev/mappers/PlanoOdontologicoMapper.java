package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.plano.CreatePlanoDto;
import br.com.odontoprev.dto.plano.PlanoDto;
import br.com.odontoprev.dto.plano.UpdatePlanoDto;
import br.com.odontoprev.entities.PlanoOdontologico;

public class PlanoOdontologicoMapper {

    public static PlanoDto toPlanoDto(PlanoOdontologico plano) {
        return new PlanoDto(
                plano.getId(),
                plano.getDataExpiracao(),
                plano.getPrecoCobrado(),
                plano.getDataFinalCarencia(),
                plano.getTipoPlano().getId(),
                plano.getEmpresaContratante() != null ? plano.getEmpresaContratante().getId() : null
        );
    }

    public static PlanoOdontologico toPlanoFromCreate(CreatePlanoDto createDto) {
        PlanoOdontologico plano = new PlanoOdontologico();
        plano.setDataExpiracao(createDto.dataExpiracao());
        plano.setPrecoCobrado(createDto.precoCobrado());
        plano.setDataFinalCarencia(createDto.dataFinalCarencia());
        return plano;
    }

    public static PlanoOdontologico toPlanoFromUpdate(UpdatePlanoDto updateDto) {
        PlanoOdontologico plano = new PlanoOdontologico();
        plano.setId(updateDto.id());
        plano.setDataExpiracao(updateDto.dataExpiracao());
        plano.setPrecoCobrado(updateDto.precoCobrado());
        plano.setDataFinalCarencia(updateDto.dataFinalCarencia());
        return plano;
    }
}

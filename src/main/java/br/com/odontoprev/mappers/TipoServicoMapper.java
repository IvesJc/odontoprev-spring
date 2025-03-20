package br.com.odontoprev.mappers;


import br.com.odontoprev.dto.tipoServico.CreateTipoServicoDto;
import br.com.odontoprev.dto.tipoServico.TipoServicoDto;
import br.com.odontoprev.dto.tipoServico.UpdateTipoServicoDto;
import br.com.odontoprev.entities.TipoServico;

public class TipoServicoMapper {

    public static TipoServicoDto totipoServicoDto(TipoServico tipoServico) {
        return new TipoServicoDto(
                tipoServico.getId(),
                tipoServico.getNome(),
                tipoServico.getValorReais()
        );
    }

    public static TipoServico toTipoServicoFromCreate(CreateTipoServicoDto createDto) {
        TipoServico tipoServico = new TipoServico();
        tipoServico.setNome(createDto.nome());
        tipoServico.setValorReais(createDto.valorReais());
        return tipoServico;
    }

    public static TipoServico toTipoServicoFromUpdate(UpdateTipoServicoDto updateDto, Integer id) {
        TipoServico tipoServico = new TipoServico();
        tipoServico.setId(id);
        tipoServico.setNome(updateDto.nome());
        tipoServico.setValorReais(updateDto.valorReais());
        return tipoServico;
    }
}

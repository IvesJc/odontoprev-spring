package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.servico.CreateServicoDto;
import br.com.odontoprev.dto.servico.ServicoDto;
import br.com.odontoprev.dto.servico.UpdateServicoDto;
import br.com.odontoprev.entities.Servico;
import br.com.odontoprev.entities.Sinistro;
import br.com.odontoprev.entities.TipoServico;
import br.com.odontoprev.repositories.TipoServicoRepository;

public class ServicoMapper {

    public static ServicoDto toServicoDto(Servico servico) {
        return new ServicoDto(
                servico.getId(),
                servico.getValorPago(),
                servico.getTipoServico().getId(),
                servico.getSinistro().getId()
        );
    }

    public static Servico toServicoFromCreate(CreateServicoDto createDto, TipoServico tipoServico, Sinistro sinistro) {
        Servico servico = new Servico();
        servico.setValorPago(createDto.valorPago());
        servico.setTipoServico(tipoServico);
        servico.setSinistro(sinistro);
        return servico;
    }

    public static Servico toServicoFromUpdate(UpdateServicoDto updateDto, Integer id, TipoServico tipoServico, Sinistro sinistro) {
        Servico servico = new Servico();
        servico.setId(id);
        servico.setValorPago(updateDto.valorPago());
        servico.setTipoServico(tipoServico);
        servico.setSinistro(sinistro);
        return servico;
    }
}


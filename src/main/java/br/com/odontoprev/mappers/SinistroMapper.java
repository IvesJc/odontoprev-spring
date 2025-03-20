package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.sinistro.CreateSinistroDto;
import br.com.odontoprev.dto.sinistro.SinistroDto;
import br.com.odontoprev.dto.sinistro.UpdateSinistroDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.entities.PrestadorServico;
import br.com.odontoprev.entities.Sinistro;

public class SinistroMapper {

    // Mapear de Sinistro (Entity) para SinistroDto
    public static SinistroDto toSinistroDto(Sinistro sinistro) {
        return new SinistroDto(
                sinistro.getId(),
                sinistro.getDataSolicitacao(),
                sinistro.getDataAutorizacao(),
                sinistro.getValorPagoParaPrestador(),
                sinistro.getBeneficiario().getId(),
                sinistro.getPrestadorServico().getId()
        );
    }

    // Mapear de CreateSinistroDto para Sinistro (Entity)
    public static Sinistro toSinistroFromCreate(CreateSinistroDto createDto, Beneficiario beneficiario, PrestadorServico prestadorServico) {
        Sinistro sinistro = new Sinistro();
        sinistro.setDataSolicitacao(createDto.dataSolicitacao());
        sinistro.setDataAutorizacao(createDto.dataAutorizacao());
        sinistro.setValorPagoParaPrestador(createDto.valorPagoParaPrestador());
        sinistro.setBeneficiario(beneficiario);
        sinistro.setPrestadorServico(prestadorServico);
        return sinistro;
    }

    // Mapear de UpdateSinistroDto para Sinistro (Entity)
    public static Sinistro toSinistroFromUpdate(UpdateSinistroDto updateDto, Integer id, Beneficiario beneficiario, PrestadorServico prestadorServico) {
        Sinistro sinistro = new Sinistro();
        sinistro.setId(id);
        sinistro.setDataSolicitacao(updateDto.dataSolicitacao());
        sinistro.setDataAutorizacao(updateDto.dataAutorizacao());
        sinistro.setValorPagoParaPrestador(updateDto.valorPagoParaPrestador());
        sinistro.setBeneficiario(beneficiario);
        sinistro.setPrestadorServico(prestadorServico);
        return sinistro;
    }
}

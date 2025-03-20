package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.programaRelacionamentoStatus.CreateProgramaRelacionamentoStatusDto;
import br.com.odontoprev.dto.programaRelacionamentoStatus.ProgramaRelacionamentoStatusDto;
import br.com.odontoprev.dto.programaRelacionamentoStatus.UpdateProgramaRelacionamentoStatusDto;
import br.com.odontoprev.entities.ProgramaRelacionamentoStatus;

public class ProgramaRelacionamentoStatusMapper {
    public static ProgramaRelacionamentoStatusDto toProgramaRelacionamentoStatusDto(ProgramaRelacionamentoStatus status) {
        return new ProgramaRelacionamentoStatusDto(
                status.getId(),
                status.getQtdePontos(),
                status.getDataAdesao(),
                status.getBeneficiario().getId()  // Supondo que Beneficiario tenha um getId()
        );
    }

    public static ProgramaRelacionamentoStatus toProgramaRelacionamentoStatusFromCreate(CreateProgramaRelacionamentoStatusDto createDto) {
        ProgramaRelacionamentoStatus status = new ProgramaRelacionamentoStatus();
        status.setQtdePontos(createDto.qtdePontos());
        status.setDataAdesao(createDto.dataAdesao());
        return status;
    }

    public static ProgramaRelacionamentoStatus toProgramaRelacionamentoStatusFromUpdate(UpdateProgramaRelacionamentoStatusDto updateDto) {
        ProgramaRelacionamentoStatus status = new ProgramaRelacionamentoStatus();
        status.setQtdePontos(updateDto.qtdePontos());
        status.setDataAdesao(updateDto.dataAdesao());
        return status;
    }
}

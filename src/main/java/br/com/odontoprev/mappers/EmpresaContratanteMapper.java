package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.empresaContratante.CreateEmpresaContratanteDto;
import br.com.odontoprev.dto.empresaContratante.EmpresaContratanteDto;
import br.com.odontoprev.dto.empresaContratante.UpdateEmpresaContratanteDto;
import br.com.odontoprev.entities.EmpresaContratante;

public class EmpresaContratanteMapper {

    public static EmpresaContratanteDto toEmpresaContratanteDto(EmpresaContratante empresaContratante) {
        return new EmpresaContratanteDto(
                empresaContratante.getId(),
                empresaContratante.getNome(),
                empresaContratante.getCnpj(),
                empresaContratante.getNumeroContrato()
        );
    }

    public static EmpresaContratante toEmpresaContratanteFromCreate(CreateEmpresaContratanteDto createDto) {
        EmpresaContratante empresaContratante = new EmpresaContratante();
        empresaContratante.setNome(createDto.nome());
        empresaContratante.setCnpj(createDto.cnpj());
        empresaContratante.setNumeroContrato(createDto.numeroContrato());
        return empresaContratante;
    }

    public static EmpresaContratante toEmpresaContratanteFromUpdate(UpdateEmpresaContratanteDto updateDto) {
        EmpresaContratante empresaContratante = new EmpresaContratante();
        empresaContratante.setNome(updateDto.nome());
        empresaContratante.setCnpj(updateDto.cnpj());
        empresaContratante.setNumeroContrato(updateDto.numeroContrato());
        return empresaContratante;
    }
}

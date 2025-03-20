package br.com.odontoprev.mappers;

import br.com.odontoprev.dto.beneficiario.BeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.CreateBeneficiarioDto;
import br.com.odontoprev.dto.beneficiario.UpdateBeneficiarioDto;
import br.com.odontoprev.entities.Beneficiario;
import br.com.odontoprev.entities.TipoBeneficiarioEnum;

public class BeneficiarioMapper {

    public static BeneficiarioDto toBeneficiarioDto(Beneficiario beneficiario) {
        return new BeneficiarioDto(
                beneficiario.getId(),
                beneficiario.getNome(),
                beneficiario.getPassword(),
                beneficiario.getCpf(),
                beneficiario.getTipo().ordinal(),  // Converte o enum TipoBeneficiarioEnum para um inteiro
                beneficiario.getTelefone(),
                beneficiario.getDataAdesao(),
                beneficiario.getFotoUrl(),
                beneficiario.getNumeroContrato(),
                beneficiario.getEndereco() != null ? beneficiario.getEndereco().getId() : null,  // Extraindo o id do endereço
                beneficiario.getEmpresaContratante() != null ? beneficiario.getEmpresaContratante().getId() : null  // Extraindo o id da empresa contratante
        );
    }

    public static Beneficiario toBeneficiarioFromCreate(CreateBeneficiarioDto createBeneficiarioDto) {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNome(createBeneficiarioDto.nome());
        beneficiario.setPassword(createBeneficiarioDto.password());
        beneficiario.setCpf(createBeneficiarioDto.cpf());
        beneficiario.setTipo(TipoBeneficiarioEnum.values()[createBeneficiarioDto.tipo()]);  // Convertendo o int para o enum
        beneficiario.setTelefone(createBeneficiarioDto.telefone());
        beneficiario.setDataAdesao(createBeneficiarioDto.dataAdesao());
        beneficiario.setFotoUrl(createBeneficiarioDto.fotoUrl());
        beneficiario.setNumeroContrato(createBeneficiarioDto.numeroContrato());

        return beneficiario;
    }

    public static Beneficiario toBeneficiarioFromUpdate(UpdateBeneficiarioDto updateBeneficiarioDto) {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNome(updateBeneficiarioDto.nome());
        beneficiario.setPassword(updateBeneficiarioDto.password());
        beneficiario.setCpf(updateBeneficiarioDto.cpf());
        beneficiario.setTipo(TipoBeneficiarioEnum.values()[updateBeneficiarioDto.tipo()]);  // Convertendo o int para o enum
        beneficiario.setTelefone(updateBeneficiarioDto.telefone());
        beneficiario.setDataAdesao(updateBeneficiarioDto.dataAdesao());
        beneficiario.setFotoUrl(updateBeneficiarioDto.fotoUrl());
        beneficiario.setNumeroContrato(updateBeneficiarioDto.numeroContrato());

        return beneficiario;
    }
}

package br.com.odontoprev.dto;

import br.com.odontoprev.entities.TipoBeneficiarioEnum;

import java.util.Date;

public record BeneficiarioRequestDto(

        String password,
        String cpf,
        TipoBeneficiarioEnum tipo,
        String telefone,
        Date dataAdesao,
        String fotoUrl,
        String numeroContrato
) {
}

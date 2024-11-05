package br.com.odontoprev.dto;

import br.com.odontoprev.entities.TipoBeneficiarioEnum;

import java.util.Date;

public record BeneficiarioRequestTelaPrincipalDto(

        String nome,
        String tipoPlanoOdontologico,
        String numero,
        String cns

) {
}

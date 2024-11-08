package br.com.odontoprev.dto;

import lombok.Builder;

@Builder
public record BeneficiarioRequestTelaPrincipalDto(

        String nome,
        String cns,
        String nomePlanoOdontologico,
        String numeroPlano
) {
}

package br.com.odontoprev.dto.empresaContratante;

public record UpdateEmpresaContratanteDto(
        String nome,
        String cnpj,
        String numeroContrato) {
}

package br.com.odontoprev.dto.empresaContratante;

public record CreateEmpresaContratanteDto(
        String nome,
        String cnpj,
        String numeroContrato) {
}

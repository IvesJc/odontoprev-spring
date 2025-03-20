package br.com.odontoprev.dto.empresaContratante;

public record EmpresaContratanteDto(Integer id,
                                    String nome,
                                    String cnpj,
                                    String numeroContrato) {
}

package br.com.odontoprev.dto.servico;

public record ServicoDto(
        int id,
        double valorPago,
        int tipoServicoId,
        int sinistroId
) {
}

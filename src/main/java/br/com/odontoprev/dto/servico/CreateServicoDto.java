package br.com.odontoprev.dto.servico;

public record CreateServicoDto(
        double valorPago,
        int tipoServicoId,
        int sinistroId
) {
}

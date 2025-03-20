package br.com.odontoprev.dto.endereco;

public record CreateEnderecoDto(
        String rua,
        int numero,
        String cidade,
        String estado,
        String cep,
        String complemento
) {
}

package br.com.odontoprev.dto.register;

public record RegisterRequest(
        String nome,
        String email,
        String password,
        String cpf,
        String telefone,
        int tipoBeneficiario
) {

}

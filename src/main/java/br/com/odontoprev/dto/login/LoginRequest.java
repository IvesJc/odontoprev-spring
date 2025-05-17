package br.com.odontoprev.dto.login;

import lombok.Data;

public record LoginRequest(String email,
                           String senha) {

}

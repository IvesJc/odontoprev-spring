package br.com.odontoprev.entities;

import jakarta.persistence.Table;

@Table(name = "beneficiario_permissao")
public class BeneficiarioPermissao {

    private Integer id_beneficiario;
    private Integer id_permissao;
}

package br.com.odontoprev.entities;

import lombok.Getter;

@Getter
public enum TipoBeneficiarioEnum {
        Pessoal(0),
        Empresa(1),
        Familiar(2); // Para planos familiares, onde o contratante terá o tipo Pessoal, e o familiar terá o
        // tipo Familiar


        private final int value;

        TipoBeneficiarioEnum(int value) {
                this.value = value;
        }

    public static TipoBeneficiarioEnum fromValue(int value) {
                for (TipoBeneficiarioEnum tipo : TipoBeneficiarioEnum.values()) {
                        if (tipo.getValue() == value) {
                                return tipo;
                        }
                }
                throw new IllegalArgumentException("TipoBeneficiarioEnum inválido: " + value);
        }
}


package com.renan.cursomc.domain.enums;

public enum EstadoPagamento {
    PEDENTE(1, "PENDENTE"),
    QUITADO(2, "QUITADO"),
    CANCELADO(3, "CANCELADO");

    private int cod;
    private String descricao;

    EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null)
            return null;

        for (EstadoPagamento x : EstadoPagamento.values())
            if (cod.equals(x.getCod()))
                return x;


        throw new IllegalAccessException("Id inválido: " + cod);
    }
}

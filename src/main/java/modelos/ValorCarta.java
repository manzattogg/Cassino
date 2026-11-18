package src.main.java.modelos;

public enum ValorCarta {
    AS("A"),
    DOIS("2"),
    TRES("3"),
    QUATRO("4"),
    CINCO("5"),
    SEIS("6"),
    SETE("7"),
    OITO("8"),
    NOVE("9"),
    DEZ("10"),
    VALETE("J"),
    DAMA("Q"),
    REI("K");

    private String simbolo;

    // define o valor das cartas, pode ser usado para qualquer jogo de cartas
    ValorCarta(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }
}

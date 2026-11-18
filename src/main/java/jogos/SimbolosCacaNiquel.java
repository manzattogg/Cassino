package src.main.java.jogos;

public enum SimbolosCacaNiquel {
    CEREJA(2),
    LIMAO(3),
    SINO(5),
    DIAMANTE(10),
    SETE(25),
    NENHUM(0);

    private final int multiplicador;

    SimbolosCacaNiquel(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    // getters
    public int getMultiplicador() {
        return multiplicador;
    }
}

package src.main.java.jogos;

public class PalpiteNumRoleta implements AvaliadorPalpite {
    
    private int numeroEscolhido;

    public PalpiteNumRoleta(int numeroEscolhido) {
        if (numeroEscolhido < 0 || numeroEscolhido > 36) {
            throw new IllegalArgumentException("Número inválido. O número deve estar entre 0 e 36.");
        }
        this.numeroEscolhido = numeroEscolhido;
    }

    @Override
    public boolean ganhou(int resultado) {
        return this.numeroEscolhido == resultado;
    }

    @Override
    public int getMultiplicador() {
        return 35; // multiplicador padrão
    }
}

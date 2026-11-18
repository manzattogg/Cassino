package src.main.java.modelos;

import src.main.java.jogos.TipoJogo;

public class RegistroJogada {
    
    private TipoJogo jogo;
    private int aposta;
    private boolean vitoria;
    private int premio;

    public RegistroJogada(TipoJogo jogo, int aposta, boolean vitoria, int premio) {
        this.jogo = jogo;
        this.aposta = aposta;
        this.vitoria = vitoria;
        this.premio = premio;
    }

    // getters

    public TipoJogo getJogo() {
        return jogo;
    }

    public int getAposta() {
        return aposta;
    }

    public boolean isVitoria() {
        return vitoria;
    }

    public int getPremio() {
        return premio;
    }
}

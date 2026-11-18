package src.main.java.jogos;

import java.util.Random;

public class JogoCacaNiquel extends JogoCassino {
    
    private Random random;

    public JogoCacaNiquel() {
        this.tipoJogo = TipoJogo.CACA_NIQUEL;
        this.random = new Random();
    }

    @Override
    public void executarJogo() {
}

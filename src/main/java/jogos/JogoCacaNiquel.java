package src.main.java.jogos;

import java.util.Random;

import src.main.java.apostas.ApostaCacaNiquel;
import src.main.java.excecoes.ApostaInvalidaException;

public class JogoCacaNiquel extends JogoCassino {
    
    private Random random;
    private final RoloVirtual rolo1;
    private final RoloVirtual rolo2;
    private final RoloVirtual rolo3;

    public JogoCacaNiquel() {
        super(TipoJogo.CACA_NIQUEL);
        this.random = new Random();

        // inicializar os rolos
        this.rolo1 = iniciarRoloVirtual();
        this.rolo2 = iniciarRoloVirtual();
        this.rolo3 = iniciarRoloVirtual();
    }

    public RoloVirtual iniciarRoloVirtual(){
        RoloVirtual rolo = new RoloVirtual();

        rolo.adicionarSimbolo(SimbolosCacaNiquel.SETE, 1);
        rolo.adicionarSimbolo(SimbolosCacaNiquel.DIAMANTE, 3);
        rolo.adicionarSimbolo(SimbolosCacaNiquel.SINO, 6);
        rolo.adicionarSimbolo(SimbolosCacaNiquel.LIMAO, 9);
        rolo.adicionarSimbolo(SimbolosCacaNiquel.CEREJA, 13);

        return rolo;
    }

    @Override
    public void executarJogo() throws ApostaInvalidaException {

        SimbolosCacaNiquel s1 = rolo1.girar(this.random);
        SimbolosCacaNiquel s2 = rolo2.girar(this.random);
        SimbolosCacaNiquel s3 = rolo3.girar(this.random);

        SimbolosCacaNiquel simboloResultado = SimbolosCacaNiquel.NENHUM;
        if (s1 == s2 && s2 == s3) {
            simboloResultado = s1;
        }

        ApostaCacaNiquel aposta = (ApostaCacaNiquel) this.getAposta();
        int premioTotal = aposta.calcularPremio(simboloResultado);
        encerrarRodada(premioTotal);
    }
}

package src.main.java.jogos;

import java.util.Random;

import src.main.java.apostas.ApostaPalpite;
import src.main.java.excecoes.ApostaInvalidaException;

public class JogoRoleta extends JogoCassino {

    private Random random;
    private int ultimoResultado;

    public JogoRoleta(){
        super(TipoJogo.ROLETA);
        this.random = new Random();
    }

    public int getUltimoResultado() {
        return ultimoResultado;
    }

    @Override
    public void executarJogo() throws ApostaInvalidaException  {

        ApostaPalpite aposta = (ApostaPalpite) this.aposta;

        ultimoResultado = this.random.nextInt(37);
        encerrarRodada(aposta.calcularPremio(ultimoResultado));
    }

}

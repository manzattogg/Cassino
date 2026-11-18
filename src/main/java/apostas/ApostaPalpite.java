package src.main.java.apostas;

import src.main.java.excecoes.ApostaInvalidaException;
import src.main.java.jogos.AvaliadorPalpite;

public class ApostaPalpite extends Aposta<Integer> {
    
    private AvaliadorPalpite palpite;

    public ApostaPalpite(int valor, AvaliadorPalpite palpite) throws ApostaInvalidaException {
        super(valor);
        this.palpite = palpite;
    }

    @Override 
    public int calcularPremio(Integer resultado) throws ApostaInvalidaException { 
        if (palpite.ganhou(resultado)){
            return super.getValor() * palpite.getMultiplicador();
        } else {
            return 0;
        }
    }
}

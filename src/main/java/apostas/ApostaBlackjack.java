package src.main.java.apostas;

import src.main.java.excecoes.ApostaInvalidaException;
import src.main.java.jogos.ResultadosBlackjack;

public class ApostaBlackjack extends Aposta<ResultadosBlackjack> {
    
    public ApostaBlackjack(int valor) throws ApostaInvalidaException {
        super(valor);
    }

    @Override 
    public int calcularPremio(ResultadosBlackjack resultado) throws ApostaInvalidaException {
        switch (resultado) {
            case VITORIA:
                return this.valor * 2; // dobro
            case BLACKJACK_NATURAL:
                return (int)(this.valor * 2.5); // duas vezes e meia
            case EMPATE:
                return this.valor; // valor da aposta
            case DERROTA:
                return 0; // perdeu a aposta
            default:
                throw new ApostaInvalidaException("Resultado inválido para ApostaBlackjack.");
        }
    }
}

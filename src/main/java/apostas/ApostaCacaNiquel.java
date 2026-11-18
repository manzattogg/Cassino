package src.main.java.apostas;

import src.main.java.excecoes.ApostaInvalidaException;
import src.main.java.jogos.SimbolosCacaNiquel;

public class ApostaCacaNiquel extends Aposta<SimbolosCacaNiquel> {
    
    public ApostaCacaNiquel(int valor) throws ApostaInvalidaException {
        super(valor);
    }

    @Override 
    public int calcularPremio(SimbolosCacaNiquel simboloVencedor) throws ApostaInvalidaException{ 
        return simboloVencedor.getMultiplicador() * getValor();
    }
}

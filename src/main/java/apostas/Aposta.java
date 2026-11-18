package src.main.java.apostas;

import src.main.java.excecoes.ApostaInvalidaException;

public abstract class Aposta<T> {
    
    protected int valor;

    public Aposta(int valor) throws ApostaInvalidaException {
        if (valor <= 0) {
            throw new ApostaInvalidaException("O valor da aposta deve ser maior que zero.");
        }
        this.valor = valor;
    }

    public int getValor() { 
        return valor;
    }

    public void dobrarAposta() {
        this.valor *= 2;
    }

    public abstract int calcularPremio(T resultado) throws ApostaInvalidaException;
}

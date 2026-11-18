package src.main.java.jogos;

import src.main.java.apostas.Aposta;
import src.main.java.excecoes.ApostaInvalidaException;
import src.main.java.excecoes.FichasInsuficientesException;
import src.main.java.modelos.Jogador;

public interface Jogavel {

    public void iniciarJogo(Jogador jogador, Aposta<?> aposta) throws FichasInsuficientesException, ApostaInvalidaException;
}
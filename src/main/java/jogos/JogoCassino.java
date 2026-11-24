package src.main.java.jogos;

import src.main.java.apostas.Aposta;
import src.main.java.excecoes.ApostaInvalidaException;
import src.main.java.excecoes.FichasInsuficientesException;
import src.main.java.modelos.Jogador;

public abstract class JogoCassino implements Jogavel {
    
    protected Jogador jogador;
    protected Aposta<?> aposta;
    protected boolean rodadaEmAndamento;
    protected TipoJogo tipoJogo;

    public JogoCassino(TipoJogo tipoJogo) {
        this.tipoJogo = tipoJogo;
        this.rodadaEmAndamento = false;
    }

    // getters
    public Jogador getJogador() {
        return jogador;
    }

    public Aposta<?> getAposta() {
        return aposta;
    }

    // recebe a aposta inicial e o jogador, inicia a mesa e a rodada, a lógica do jogo é implementada na subclasse pela função executarJogo()
    @Override 
    public void iniciarJogo(Jogador jogador, Aposta<?> aposta) throws FichasInsuficientesException, ApostaInvalidaException {
        if (aposta == null || aposta.getValor() <= 0) {
            throw new ApostaInvalidaException("Aposta inválida. O valor da aposta deve ser maior que zero.");
        }

        if (aposta.getValor() > jogador.getFichas()){
            throw new FichasInsuficientesException("Fichas insuficientes para realizar a aposta.");
        }

        this.jogador = jogador;
        this.aposta = aposta;
        
        this.jogador.removerFichas(aposta.getValor());

        this.rodadaEmAndamento = true;

        executarJogo();
    }

    public void encerrarRodada(int premio) {
        if (!rodadaEmAndamento) {
            throw new IllegalStateException("Não há rodada em andamento para encerrar.");
        }
        
        if (premio > 0){
            this.jogador.adicionarFichas(premio);
        }

        this.rodadaEmAndamento = false;
    }

    // depende de cada jogo
    protected abstract void executarJogo() throws ApostaInvalidaException;
}

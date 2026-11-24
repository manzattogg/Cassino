package src.main.java.jogos;

import java.util.ArrayList;
import java.util.List;

import src.main.java.apostas.ApostaBlackjack;
import src.main.java.excecoes.ApostaInvalidaException;
import src.main.java.modelos.Baralho;
import src.main.java.modelos.Carta;
import src.main.java.modelos.ValorCarta;

public class JogoBlackjack extends JogoCassino implements JogodeCarta {
    
    private Baralho baralho;
    private List<Carta> maoJogador;
    private List<Carta> maoDealer;

    public JogoBlackjack() {
        super(TipoJogo.BLACKJACK);
        this.baralho = new Baralho();
    }

    @Override
    public int calcularValorCarta(Carta carta) {
        int n = carta.getValor().getValor();
        if (n>=11) return 10;  
        if (n==1) return 11;
        return n;
    }

    @Override
    public void executarJogo() throws ApostaInvalidaException {

        // inicia a mão do dealer e do jogador
        maoJogador = new ArrayList<>();
        maoDealer = new ArrayList<>();

        // inicia o baralho e embaralha
        baralho.iniciarBaralho();
        baralho.embaralhar();

        // distribui duas cartas para o jogador e duas para o dealer
        maoJogador.add(baralho.comprarCarta());
        maoJogador.add(baralho.comprarCarta());
        
        maoDealer.add(baralho.comprarCarta());
        maoDealer.add(baralho.comprarCarta());

        int valorMaoJogador = calcularValorMao(maoJogador);
        int valorMaoDealer = calcularValorMao(maoDealer);

        ApostaBlackjack apostaBlackjack = (ApostaBlackjack) this.aposta;

        // testar blackjack natural
        if (valorMaoJogador == 21 && valorMaoDealer == 21) {
            encerrarRodada(apostaBlackjack.calcularPremio(ResultadosBlackjack.EMPATE));
        } else if (valorMaoJogador == 21) {
            encerrarRodada(apostaBlackjack.calcularPremio(ResultadosBlackjack.BLACKJACK_NATURAL));
        } else if (valorMaoDealer == 21) {
            encerrarRodada(apostaBlackjack.calcularPremio(ResultadosBlackjack.DERROTA));
        }

    }

    public int calcularValorMao(List<Carta> mao){

        int valorMao = 0;
        int ases = 0;

        // para cada carta adiciona o valor da carta
        for (Carta carta : mao){

            int valorCarta = this.calcularValorCarta(carta);
            
            // se essa carta for um as, separa
            if (carta.getValor() == ValorCarta.AS){
                ases ++;
            }

            valorMao += valorCarta;
        }

        // se a mão tiver um as, e o valor da mão passar de 21, transforma o as em 1 ao invés de 11
        while (valorMao > 21 && ases>0){
            valorMao -= 10;
            ases --;
        }

        return valorMao;

    }

    public void pedirCartaJogador() throws ApostaInvalidaException {
        maoJogador.add(baralho.comprarCarta());
        int valorMaoJogador = calcularValorMao(maoJogador);

        ApostaBlackjack apostaBlackjack = (ApostaBlackjack) this.aposta;

        if (valorMaoJogador > 21){
            encerrarRodada(apostaBlackjack.calcularPremio(ResultadosBlackjack.DERROTA));
        }
    }

    public void parar() throws ApostaInvalidaException{

        ApostaBlackjack apostaBlackjack = (ApostaBlackjack) this.aposta;

        jogarDealer();

        int valorMaoJogador = calcularValorMao(maoJogador);
        int valorMaoDealer = calcularValorMao(maoDealer);

        if (valorMaoDealer > 21) {
            encerrarRodada(apostaBlackjack.calcularPremio(ResultadosBlackjack.VITORIA));
        } else if (valorMaoJogador == valorMaoDealer) {
            encerrarRodada(apostaBlackjack.calcularPremio(ResultadosBlackjack.EMPATE));
        } else if (valorMaoJogador > valorMaoDealer) {
            encerrarRodada(apostaBlackjack.calcularPremio(ResultadosBlackjack.VITORIA));
        } else {
            encerrarRodada(apostaBlackjack.calcularPremio(ResultadosBlackjack.DERROTA));
        }

    }

    private void jogarDealer() {
        while (calcularValorMao(maoDealer) < 17){
            maoDealer.add(baralho.comprarCarta());
        }
    }

    public void pegarCartaDealer() {
        maoDealer.add(baralho.comprarCarta());
    }
}

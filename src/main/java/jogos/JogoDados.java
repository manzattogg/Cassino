package src.main.java.jogos;


import src.main.java.apostas.ApostaPalpite;
import src.main.java.excecoes.ApostaInvalidaException;
import src.main.java.modelos.Dado;

public class JogoDados extends JogoCassino {

    private Dado dado1;
    private Dado dado2;     

    public JogoDados() {
        super(TipoJogo.DADOS);
        this.dado1 = new Dado();
        this.dado2 = new Dado();
    }

    @Override
    public void executarJogo() throws ApostaInvalidaException{
    
        dado1.rolar();
        dado2.rolar();

        int resultado = dado1.getValor() + dado2.getValor();
        ApostaPalpite aposta = (ApostaPalpite) this.getAposta();
        int premioTotal = aposta.calcularPremio(resultado);
        encerrarRodada(premioTotal);
    }
}

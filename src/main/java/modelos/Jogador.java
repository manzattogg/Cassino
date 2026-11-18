package src.main.java.modelos;

import java.util.ArrayList;
import java.util.List;

import src.main.java.excecoes.FichasInsuficientesException;

public class Jogador {
    
    private String usuario;
    private String senha;
    private int fichas;
    private List<RegistroJogada> historico;

    public Jogador(String usuario, String senha, int fichas) {
        this.usuario = usuario;
        this.senha = senha;
        this.fichas = fichas;
        this.historico = new ArrayList<>();
    }

    // getters

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public int getFichas() {
        return fichas;
    }

    public List<RegistroJogada> getHistorico() {
        return historico;
    }

    // métodos de fichas e histórico
    
    public void adicionarFichas(int valor) {
        this.fichas += valor;
    }

    // gasta fichas, se não tiver fichas suficientes, lança exceção
    public void removerFichas(int valor) throws FichasInsuficientesException {
        if (valor > this.fichas) {
            throw new FichasInsuficientesException("Fichas insuficientes para realizar a aposta.");
        }
        this.fichas -= valor;
    }

    public void adicionarRegistro(RegistroJogada registro) { // cada jogador está assiociado a um histórico de jogadas, que é atualizado a cada aposta
        this.historico.add(registro);
    }

}

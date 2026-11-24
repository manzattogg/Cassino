package src.main.java.controle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import src.main.java.modelos.Jogador;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GerenciarArquivos {

    private static final String ARQUIVO = "jogadores.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // lê o arquivo e retorna a lista de jogadores
    public List<Jogador> carregarJogadores() {
        File arquivo = new File(ARQUIVO);
        if (!arquivo.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(arquivo)) {
            Type tipo = new TypeToken<List<Jogador>>(){}.getType();
            List<Jogador> lista = gson.fromJson(reader, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    // salva a lista inteira no arquivo
    public void salvarJogadores(List<Jogador> jogadores) {
        try (Writer writer = new FileWriter(ARQUIVO)) {
            gson.toJson(jogadores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // busca um jogador pelo nome de usuário
    public Jogador buscarJogador(String usuario) {
        for (Jogador j : carregarJogadores()) {
            if (j.getUsuario().equals(usuario)) {
                return j;
            }
        }
        return null;
    }

    // adiciona novo jogador se o usuário ainda não existir
    public boolean cadastrarJogador(Jogador jogador) {
        List<Jogador> jogadores = carregarJogadores();
        for (Jogador j : jogadores) {
            if (j.getUsuario().equals(jogador.getUsuario())) {
                return false; // usuário já existe
            }
        }
        jogadores.add(jogador);
        salvarJogadores(jogadores);
        return true;
    }

    // substitui os dados do jogador no arquivo
    public void atualizarJogador(Jogador jogador) {
        List<Jogador> jogadores = carregarJogadores();
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).getUsuario().equals(jogador.getUsuario())) {
                jogadores.set(i, jogador);
                salvarJogadores(jogadores);
                return;
            }
        }
    }
}

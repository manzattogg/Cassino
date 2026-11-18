package src.main.java.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Baralho {
 
    public List<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
    }

    void iniciarBaralho() { // inicia o baralho inteiro sem os coringas
        for (Naipe naipe : Naipe.values()) {
            for (ValorCarta valor : ValorCarta.values()) {
                this.cartas.add(new Carta(naipe, valor));
            }
        }
    }

    void embaralhar() {
        Collections.shuffle(this.cartas);
    }

    public Carta comprarCarta() { // verifica se o baralho está vazio, se estiver, inicia e embaralha novamente
        if (this.cartas.isEmpty()) {
            iniciarBaralho();
            embaralhar();
        }
        return this.cartas.remove(0);
    }
}

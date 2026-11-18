package src.main.java.jogos;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Random;

public class RoloVirtual {
    
    private final NavigableMap<Integer, SimbolosCacaNiquel> distribuicao;
    private int pesoTotal;

    public RoloVirtual(){
        this.distribuicao = new TreeMap<>();
        this.pesoTotal = 0;
    }

    public void adicionarSimbolo(SimbolosCacaNiquel simbolo, int quantidade) {
        if (quantidade <= 0) return; 

        this.pesoTotal += quantidade;
        this.distribuicao.put(this.pesoTotal, simbolo);
    
    }

    public SimbolosCacaNiquel girar(Random random) {
        int valorSorteado = random.nextInt(pesoTotal) + 1; 

        return this.distribuicao.ceilingEntry(valorSorteado).getValue();
    }

}

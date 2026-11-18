package src.main.java.modelos;

import java.util.Random;

public class Dado {
    
    private int valor;
    private Random random;

    public Dado() {
        this.valor = 1;
        this.random = new Random();
    }

    // getter
    public int getValor() {
        return valor;
    }

    public void rolar() {
       this.valor = this.random.nextInt(6) + 1; // gera um número aleatório entre 1 e 6
    }
}

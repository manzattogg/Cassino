package src.main.java.modelos;
public class Carta {
    
    private Naipe naipe;
    private ValorCarta valor;

    public Carta(Naipe naipe, ValorCarta valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    // getters
    public Naipe getNaipe() {
        return naipe;
    }

    public ValorCarta getValor() {
        return valor;
    }
}

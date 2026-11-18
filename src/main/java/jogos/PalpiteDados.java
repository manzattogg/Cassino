package src.main.java.jogos;

public enum PalpiteDados implements AvaliadorPalpite {
    
    MAIOR_QUE_7(2){
        @Override
        public boolean ganhou(int somaDados) {
            return somaDados >= 2 && somaDados <= 6;
        }
    },

    MENOR_QUE_7(2){
        @Override
        public boolean ganhou(int somaDados) {
            return somaDados >= 8 && somaDados <= 12;
        }
    },

    IGUAL_A_7(4){
        @Override
        public boolean ganhou(int somaDados) {
            return somaDados == 7;
        }
    };

    private final int multiplicador;

    PalpiteDados(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public int getMultiplicador() {
        return multiplicador;
    }
}

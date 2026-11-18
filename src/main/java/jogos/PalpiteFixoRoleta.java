package src.main.java.jogos;

public enum PalpiteFixoRoleta implements AvaliadorPalpite {
    VERMELHO(2){
        @Override
        public boolean ganhou(int resultado) {
            int[] vermelhos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
            for (int num : vermelhos) {
                if (num == resultado) {
                    return true;
                }
            }
            return false;
        }
    },
    PRETO(2){
        @Override
        public boolean ganhou(int resultado) {
            int[] pretos = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
            for (int num : pretos) {
                if (num == resultado) {
                    return true;
                }
            }
            return false;
        }
    },
    PAR(2){
        @Override
        public boolean ganhou(int resultado) {
            return resultado >= 1 && resultado <= 36 && resultado % 2 == 0;
        }
    },
    IMPAR(2){
        @Override
        public boolean ganhou(int resultado) {
            return resultado >= 1 && resultado <= 36 && resultado % 2 == 1;
        }
    };

    private final int multiplicador;

    PalpiteFixoRoleta(int multiplicador) {
        this.multiplicador = multiplicador;
    };

    @Override 
    public int getMultiplicador() {
        return multiplicador;
    }
}

package Tabuleiro;

import pecas.Peca;

public class Casa {
    private int[] pos = new int[2];
    private int cor; //0 - branco e 1 - preto
    private Peca peca;

    private static final int X = 0;
    private static final int Y = 1;

    public Casa(int coluna, int fileira, int cor){
        this.pos[X] = coluna;
        this.pos[Y] = fileira;
        this.cor = cor;
        this.peca = null;           //A casa é criada vazia, e apenas troca de estado dentro do escopo do objeto Peça.
    }

    public int[] getPos() {
        return pos;
    }

    public int getColuna(){
        return pos[X];
    }

    public int getFileira(){
        return pos[Y];
    }

    public int getCor() {
        return cor;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    public Peca getPeca() {
        return peca;
    }

    public String posString(){
        char notacaoColuna = '?';

        switch(this.getColuna()){
            case 0:
                notacaoColuna = 'a';
                break;
            case 1:
                notacaoColuna = 'b';
                break;
            case 2:
                notacaoColuna = 'c';
                break;
            case 3:
                notacaoColuna = 'd';
                break;
            case 4:
                notacaoColuna = 'e';
                break;
            case 5:
                notacaoColuna = 'f';
                break;
            case 6:
                notacaoColuna = 'g';
                break;
            case 7:
                notacaoColuna = 'h';
                break;
        }

        int fileiraCorrigida = this.getFileira() + 1;

        return "Casa: "+notacaoColuna+fileiraCorrigida;
    }

}

package Tabuleiro;

public class Pos {
    private int coluna;
    private int fileira;

    public Pos(int coluna, int fileira) {
        this.coluna = coluna;
        this.fileira = fileira;
    }

    public int getColuna() {
        return coluna;
    }
    public int getFileira() {
        return fileira;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    public void setFileira(int fileira) {
        this.fileira = fileira;
    }
}

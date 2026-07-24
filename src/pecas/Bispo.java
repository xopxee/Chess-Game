package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;
import Tabuleiro.Pos;
import Tabuleiro.BoardIterator;
import Tabuleiro.Dir;

import java.util.ArrayList;

import static Tabuleiro.Casa.BY_BLACK;
import static Tabuleiro.Casa.BY_WHITE;
import static Tabuleiro.Tabuleiro.*;
import static Tabuleiro.Tabuleiro.COLUNAS;
import static Tabuleiro.Tabuleiro.FILEIRAS;

public class Bispo extends Peca{

    public Bispo(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♝' : '♗';  //notação em inglês (Bishop).
        super.casasLegais = new ArrayList<>(14);
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

        Pos currentPos = getPos();
        Dir[] dirs = new Dir[]{NE, SE, SW, NW};

        for(Dir dir: dirs) {
            analisarDirecao(new BoardIterator(currentPos, dir));
        }
    }
}

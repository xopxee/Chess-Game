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

public class Rainha extends Peca{

    public Rainha(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♛' : '♕';  //notação em inglês (Queen).
        super.casasLegais = new ArrayList<>(28);
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

        Pos currentPos = getPos();
        Dir[] dirs = new Dir[]{N, E, S, W, NE, SE, SW, NW};

        for(Dir dir : dirs) {
            analisarDirecao(new BoardIterator(currentPos, dir));
        }
    }
}
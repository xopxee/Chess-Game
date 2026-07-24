package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Casa.BY_BLACK;
import static Tabuleiro.Casa.BY_WHITE;
import static Tabuleiro.Tabuleiro.*;

public class Cavalo extends Peca{

    public Cavalo(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♞' : '♘';  //notação em inglês (Knight).
        super.casasLegais = new ArrayList<>(8);
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

        ArrayList<Casa> arrayCorrespondente = (this.getCor() == BRANCO) ? casasLegaisPecasBrancas : casasLegaisPecasPretas;
        int byCorAtual = (super.getCor() == BRANCO)? BY_WHITE : BY_BLACK;

        final int umaDireita  = super.getColuna() + 1;
        final int duasDireita = super.getColuna() + 2;
        final int umaEsquerda  = super.getColuna() - 1;
        final int duasEsquerda = super.getColuna() - 2;

        final int umaCima  = super.getFileira() + 1;
        final int duasCima = super.getFileira() + 2;
        final int umaBaixo  = super.getFileira() - 1;
        final int duasBaixo = super.getFileira() - 2;

        final int[] umaCasaHorizontal = new int[]{umaDireita, umaEsquerda};
        final int[] umaCasaVertical = new int[]{umaCima, umaBaixo};
        final int[] duasCasasHorizontal = new int[]{duasDireita, duasEsquerda};
        final int[] duasCasasVertical = new int[]{duasCima, duasBaixo};

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
               analisarCasa(umaCasaHorizontal[i], duasCasasVertical[j], arrayCorrespondente, byCorAtual);
               analisarCasa(duasCasasHorizontal[i], umaCasaVertical[j], arrayCorrespondente, byCorAtual);
            }
        }
    }

    private void analisarCasa(int coluna, int fileira, ArrayList<Casa> arrayCorrespondente, int byCorAtual) {

        if(!dentroTabuleiro(coluna, fileira))
            return;

        Casa casaTeste = Tabuleiro.getCasa(coluna, fileira);
        Peca pecaNaCasa = casaTeste.getPeca();

        //Se a casa estiver vazia, podemos nos mover para lá.
        if (pecaNaCasa == null) {
            casasLegais.add(casaTeste);
            arrayCorrespondente.add(casaTeste);
        }
        else {
            int corPecaNaCasa = pecaNaCasa.getCor();

            if (corPecaNaCasa != super.getCor()) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);

                if(pecaNaCasa instanceof Rei){
                    ((Rei) pecaNaCasa).setIsInCheck(true);
                    ((Rei) pecaNaCasa).incPecasAtacantes();
                }
            }
        }
        casaTeste.setAtacked(byCorAtual);
    }
}

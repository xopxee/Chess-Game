package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Tabuleiro.*;

public class Cavalo extends Peca{
    private ArrayList<Casa> casasLegais = new ArrayList<>(8);

    public Cavalo(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♞' : '♘';  //notação em inglês (Knight).
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();
        ArrayList<Casa> arrayCorrespondente = (this.getCor() == BRANCO) ? casasBrancasLegais : casasPretasLegais;

        final int umaDireita  = super.getColuna() + 1;
        final int duasDireita = super.getColuna() + 2;
        final int umaEsquerda  = super.getColuna() - 1;
        final int duasEsquerda = super.getColuna() - 2;

        final int umaCima  = super.getFileira() + 1;
        final int duasCima = super.getFileira() + 2;
        final int umaBaixo  = super.getFileira() - 1;
        final int duasBaixo = super.getFileira() - 2;

        Casa casaTeste;
        Peca pecaNaCasa;

        if(umaDireita < COLUNAS && duasCima < FILEIRAS){
            casaTeste = Tabuleiro.getCasa(umaDireita, duasCima);
            pecaNaCasa = casaTeste.getPeca();

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor();
                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste);
                    arrayCorrespondente.add(casaTeste);
                }
            }
        }

        if(duasDireita < COLUNAS && umaCima < FILEIRAS) {
            casaTeste = Tabuleiro.getCasa(duasDireita, umaCima);
            pecaNaCasa = casaTeste.getPeca();

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor();
                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste);
                    arrayCorrespondente.add(casaTeste);
                }
            }
        }

        if(duasEsquerda >= 0 && umaCima < FILEIRAS) {
            casaTeste = Tabuleiro.getCasa(duasEsquerda, umaCima);
            pecaNaCasa = casaTeste.getPeca();

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor();
                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste);
                    arrayCorrespondente.add(casaTeste);
                }
            }
        }

        if(umaEsquerda >= 0 && duasCima < FILEIRAS) {
            casaTeste = Tabuleiro.getCasa(umaEsquerda, duasCima);
            pecaNaCasa = casaTeste.getPeca();

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor();
                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste);
                    arrayCorrespondente.add(casaTeste);
                }
            }
        }

        if(duasEsquerda >= 0 && umaBaixo >= 0) {
            casaTeste = Tabuleiro.getCasa(duasEsquerda, umaBaixo);
            pecaNaCasa = casaTeste.getPeca();

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor();
                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste);
                    arrayCorrespondente.add(casaTeste);
                }
            }
        }

        if(umaEsquerda >= 0 && duasBaixo >= 0) {
            casaTeste = Tabuleiro.getCasa(umaEsquerda, duasBaixo);
            pecaNaCasa = casaTeste.getPeca();

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor();
                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste);
                    arrayCorrespondente.add(casaTeste);
                }
            }
        }

        if(umaDireita < COLUNAS && duasBaixo >= 0) {
            casaTeste = Tabuleiro.getCasa(umaDireita, duasBaixo);
            pecaNaCasa = casaTeste.getPeca();

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor();
                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste);
                    arrayCorrespondente.add(casaTeste);
                }
            }
        }

        if(duasDireita < COLUNAS && umaBaixo >= 0) {
            casaTeste = Tabuleiro.getCasa(duasDireita, umaBaixo);
            pecaNaCasa = casaTeste.getPeca();

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste);
                arrayCorrespondente.add(casaTeste);
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor();
                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste);
                    arrayCorrespondente.add(casaTeste);
                }
            }
        }
    }

    @Override
    public ArrayList<Casa> getCasasLegais() {
        return casasLegais;
    }
}

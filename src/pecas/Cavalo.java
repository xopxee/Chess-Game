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

        //Todas 8 direções possíveis (2 casas para uma direção mais 1 para outra) :

        if(umaDireita < COLUNAS && duasCima < FILEIRAS){

            casaTeste = Tabuleiro.getCasa(umaDireita, duasCima); //Uma casa para direita e duas para cima.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor(); //Se tem uma peça na casa, pegue a cor dela.

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Como a peça é de outra cor, podemos capturar.
                }
            }
        }

        if(duasDireita < COLUNAS && umaCima < FILEIRAS) {

            casaTeste = Tabuleiro.getCasa(duasDireita, umaCima); //Duas casas para direita e uma para cima.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor(); //Se tem uma peça na casa, pegue a cor dela.

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Como a peça é de outra cor, podemos capturar.
                }
            }
        }

        if(duasEsquerda >= 0 && umaCima < FILEIRAS) {

            casaTeste = Tabuleiro.getCasa(duasEsquerda, umaCima); //Duas casas para esquerda e uma para cima.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor(); //Se tem uma peça na casa, pegue a cor dela.

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Como a peça é de outra cor, podemos capturar.
                }
            }
        }

        if(umaEsquerda >= 0 && duasCima < FILEIRAS) {

            casaTeste = Tabuleiro.getCasa(umaEsquerda, duasCima); //Uma casa para esquerda e duas para cima.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor(); //Se tem uma peça na casa, pegue a cor dela.

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Como a peça é de outra cor, podemos capturar.
                }
            }
        }

        if(duasEsquerda >= 0 && umaBaixo >= 0) {

            casaTeste = Tabuleiro.getCasa(duasEsquerda, umaBaixo); //Duas casas para esquerda e uma para baixo.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor(); //Se tem uma peça na casa, pegue a cor dela.

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Como a peça é de outra cor, podemos capturar.
                }
            }
        }

        if(umaEsquerda >= 0 && duasBaixo >= 0) {

            casaTeste = Tabuleiro.getCasa(umaEsquerda, duasBaixo); //Uma casa para esquerda e duas para baixo.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor(); //Se tem uma peça na casa, pegue a cor dela.

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Como a peça é de outra cor, podemos capturar.
                }
            }
        }

        if(umaDireita < COLUNAS && duasBaixo >= 0) {

            casaTeste = Tabuleiro.getCasa(umaDireita, duasBaixo); //Uma casa para direita e duas para baixo.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor(); //Se tem uma peça na casa, pegue a cor dela.

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Como a peça é de outra cor, podemos capturar.
                }
            }
        }

        if(duasDireita < COLUNAS && umaBaixo >= 0) {

            casaTeste = Tabuleiro.getCasa(duasDireita, umaBaixo); //Duas casas para direita e uma para baixo.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            } else {
                int corPecaNaCasa = pecaNaCasa.getCor(); //Se tem uma peça na casa, pegue a cor dela.

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Como a peça é de outra cor, podemos capturar.
                }
            }
        }
    }
    @Override
    public ArrayList<Casa> getCasasLegais() {
        return casasLegais;
    }
}

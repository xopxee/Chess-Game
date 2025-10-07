package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Casa.BY_BLACK;
import static Tabuleiro.Casa.BY_WHITE;
import static Tabuleiro.Tabuleiro.*;

public class Torre extends Peca{

    public Torre(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♜' : '♖';  //notação em inglês (Rook).
        super.casasLegais = new ArrayList<>(14);
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

        ArrayList<Casa> arrayCorrespondente = (this.getCor() == BRANCO) ? casasLegaisPecasBrancas : casasLegaisPecasPretas;

        int byCorAtual = (super.getCor() == BRANCO)? BY_WHITE : BY_BLACK;

        //Movimentos para direita
        for (int idColuna = super.getColuna() + 1; idColuna < COLUNAS; idColuna++) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.

            Peca pecaNaFileira = casaNaFileira.getPeca();  //Peças que estão (ou não) nessas casas.

            if(pecaNaFileira == null) {
                casasLegais.add(casaNaFileira); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaFileira);
                casaNaFileira.setAtacked(byCorAtual);
            }
            else{
                int corPecaNaFileira = pecaNaFileira.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaFileira != super.getCor()) {
                    casasLegais.add(casaNaFileira);  //Como a peça é de outra cor, podemos capturar.
                    arrayCorrespondente.add(casaNaFileira);

                    if(pecaNaFileira instanceof Rei){
                        ((Rei) pecaNaFileira).setIsInCheck(true);
                        ((Rei) pecaNaFileira).incPecasAtacantes();

                        if(idColuna + 1 <= COLUNA_H){
                            Tabuleiro.getCasa(idColuna + 1, super.getFileira()).setAtacked(byCorAtual);  //Adiciona a casa imediatamente a frente como atacked.
                        }

                        for (idColuna = pecaNaFileira.getColuna() - 1; idColuna >= this.getColuna(); idColuna--){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                            Casa casaNaFileiraVolta = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.
                            if(corPecaNaFileira == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaFileiraVolta);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaFileiraVolta);
                            }
                        }
                    }
                }
                casaNaFileira.setAtacked(byCorAtual);
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para esquerda
        for (int idColuna = super.getColuna() - 1; idColuna >= 0; idColuna--) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.

            Peca pecaNaFileira = casaNaFileira.getPeca();  //Peças que estão (ou não) nessas casas.

            if(pecaNaFileira == null) {
                casasLegais.add(casaNaFileira); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaFileira);
                casaNaFileira.setAtacked(byCorAtual);
            }
            else{
                int corPecaNaFileira = pecaNaFileira.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaFileira != super.getCor()) {
                    casasLegais.add(casaNaFileira);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaFileira);

                    if(pecaNaFileira instanceof Rei){
                        ((Rei) pecaNaFileira).setIsInCheck(true);
                        ((Rei) pecaNaFileira).incPecasAtacantes();

                        if(idColuna - 1 >= COLUNA_A){
                            Tabuleiro.getCasa(idColuna - 1, super.getFileira()).setAtacked(byCorAtual);  //Adiciona a casa imediatamente a frente como atacked.
                        }

                        for (idColuna = pecaNaFileira.getColuna() + 1; idColuna <= this.getColuna(); idColuna++){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                            Casa casaNaFileiraVolta = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.
                            if(corPecaNaFileira == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaFileiraVolta);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaFileiraVolta);
                            }
                        }
                    }
                }
                casaNaFileira.setAtacked(byCorAtual);
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para cima
        for (int idFileira = super.getFileira() + 1; idFileira < FILEIRAS; idFileira++) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma coluna.

            Peca pecaNaColuna = casaNaColuna.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaColuna == null) {
                casasLegais.add(casaNaColuna); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaColuna);
                casaNaColuna.setAtacked(byCorAtual);
            }
            else{
                int corPecaNaColuna = pecaNaColuna.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaColuna != super.getCor()) {
                    casasLegais.add(casaNaColuna);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaColuna);

                    if(pecaNaColuna instanceof Rei){
                        ((Rei) pecaNaColuna).setIsInCheck(true);
                        ((Rei) pecaNaColuna).incPecasAtacantes();

                        if(idFileira + 1 <= OITAVA_FILEIRA){
                            Tabuleiro.getCasa(super.getColuna(), idFileira + 1).setAtacked(byCorAtual);  //Adiciona a casa imediatamente a frente como atacked.
                        }

                        for (idFileira = pecaNaColuna.getFileira() - 1; idFileira >= this.getFileira(); idFileira--){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                            Casa casaNaColunaVolta = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma fileira.
                            if(corPecaNaColuna == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaColunaVolta);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaColunaVolta);
                            }
                        }
                    }
                }
                casaNaColuna.setAtacked(byCorAtual);
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para baixo
        for (int idFileira = super.getFileira() - 1; idFileira >= 0; idFileira--) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma coluna.

            Peca pecaNaColuna = casaNaColuna.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaColuna == null) {
                casasLegais.add(casaNaColuna); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaColuna);

                casaNaColuna.setAtacked(byCorAtual);casaNaColuna.setAtacked(byCorAtual);
            }
            else{
                int corPecaNaColuna = pecaNaColuna.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaColuna != super.getCor()) {
                    casasLegais.add(casaNaColuna);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaColuna);

                    if(pecaNaColuna instanceof Rei){
                        ((Rei) pecaNaColuna).setIsInCheck(true);
                        ((Rei) pecaNaColuna).incPecasAtacantes();

                        if(idFileira - 1 >= PRIMEIRA_FILEIRA){
                            Tabuleiro.getCasa(super.getColuna(), idFileira - 1).setAtacked(byCorAtual);  //Adiciona a casa imediatamente a frente como atacked.
                        }

                        for (idFileira = pecaNaColuna.getFileira() + 1; idFileira <= this.getFileira(); idFileira++){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                            Casa casaNaColunaVolta = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma fileira.
                            if(corPecaNaColuna == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaColunaVolta);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaColunaVolta);
                            }
                        }
                    }
                }
                casaNaColuna.setAtacked(byCorAtual);
                break; //Caminho está bloqueado.
            }
        }
    }
}

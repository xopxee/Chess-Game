package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Casa.BY_BLACK;
import static Tabuleiro.Casa.BY_WHITE;
import static Tabuleiro.Tabuleiro.*;

public class Peao extends Peca{
    private int jogadaDuasCasas = -13;
    private Peao alvoEnPassant = null;

    public Peao(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♟' : '♙';  //notação em inglês (Pawn).
        super.casasLegais = new ArrayList<>(4);
    }

    public void setJogadaDuasCasas(int jogadaDuasCasas) {
        this.jogadaDuasCasas = jogadaDuasCasas;
    }
    public int getJogadaDuasCasas() {
        return jogadaDuasCasas;
    }

    public Peao getAlvoEnPassant() {
        return alvoEnPassant;
    }

    @Override
    public void setCasasLegais() {
        super.casasLegais.clear();
        this.alvoEnPassant = null;

        ArrayList<Casa> arrayCorrespondente = (this.getCor() == BRANCO) ? casasLegaisPecasBrancas : casasLegaisPecasPretas;

        int byCorAtual = (super.getCor() == BRANCO)? BY_WHITE : BY_BLACK;

        final int umaDireita = super.getColuna() + 1;
        final int umaEsquerda = super.getColuna() - 1;

        int umaCimaTeste = super.getFileira();
        int duasCimaTeste = super.getFileira();

        if(super.getCor() == BRANCO) {
            umaCimaTeste++;
            duasCimaTeste += 2;
        }
        else{
            umaCimaTeste--;  //Caso seja um peão preto, andar para cima decresce a sua posição em fileiras.
            duasCimaTeste -= 2;
        }

        final int umaCima = umaCimaTeste;
        final int duasCima = duasCimaTeste;

        final int fileiraInicial = (super.getCor() == BRANCO) ? SEGUNDA_FILEIRA : SETIMA_FILEIRA;
        final int fileiraEnPassant = (super.getCor() == BRANCO) ? QUINTA_FILEIRA : QUARTA_FILEIRA;

        boolean isBlocked = false;

        Casa casaTeste;
        Peca pecaNaCasa;

        casaTeste = Tabuleiro.getCasa(super.getColuna(), umaCima); //Uma casa para cima.

        pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

        if(pecaNaCasa == null){
            super.casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            arrayCorrespondente.add(casaTeste);
        }
        else{
            isBlocked = true;
        }

        if((super.getFileira() == fileiraInicial) && !isBlocked) {

            casaTeste = Tabuleiro.getCasa(super.getColuna(), duasCima); //Duas casas para cima.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                super.casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaTeste);
            }
        }

        if(this.getColuna() < COLUNA_H) {

            casaTeste = Tabuleiro.getCasa(umaDireita, umaCima); //Possível captura na diagonal direita.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa != null) {
                int corPecaNaCasa = pecaNaCasa.getCor();

                if (corPecaNaCasa != super.getCor()) {
                    super.casasLegais.add(casaTeste); //Peça inimiga em posição de captura.
                    arrayCorrespondente.add(casaTeste);

                    if(pecaNaCasa instanceof Rei){
                        ((Rei) pecaNaCasa).setIsInCheck(true);
                        ((Rei) pecaNaCasa).incPecasAtacantes();
                    }
                }
            }
            casaTeste.setAtacked(byCorAtual);
        }

        if(this.getColuna() > COLUNA_A) {

            casaTeste = Tabuleiro.getCasa(umaEsquerda, umaCima); //Possível captura na diagonal esquerda.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa != null) {
                int corPecaNaCasa = pecaNaCasa.getCor();

                if (corPecaNaCasa != super.getCor()) {
                    super.casasLegais.add(casaTeste); //Peça inimiga em posição de captura.
                    arrayCorrespondente.add(casaTeste);

                    if(pecaNaCasa instanceof Rei){
                        ((Rei) pecaNaCasa).setIsInCheck(true);
                        ((Rei) pecaNaCasa).incPecasAtacantes();
                    }
                }
            }
            casaTeste.setAtacked(byCorAtual);
        }

        //EN PASSANT

        Casa casaCaptura;

        if(this.getColuna() < COLUNA_H) {
            if(this.getFileira() == fileiraEnPassant) {
                casaTeste = Tabuleiro.getCasa(umaDireita, this.getFileira()); //Casa ao lado direito desse peão.

                pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

                casaCaptura = Tabuleiro.getCasa(umaDireita, umaCima); //Casa de captura do En Passant.

                if (pecaNaCasa instanceof Peao) {
                    int corPecaNaCasa = pecaNaCasa.getCor();

                    if (((Peao) pecaNaCasa).getJogadaDuasCasas() == Tabuleiro.getJogadas() - 1) {
                        if (corPecaNaCasa != super.getCor()) {
                            this.alvoEnPassant = ((Peao) pecaNaCasa);
                            super.casasLegais.add(casaCaptura); //Peão inimigo em posição de captura.
                            arrayCorrespondente.add(casaCaptura);
                        }
                    }
                }
                casaTeste.setAtacked(byCorAtual);
            }
        }

        if(this.getColuna() > COLUNA_A) {
            if(this.getFileira() == fileiraEnPassant) {
                casaTeste = Tabuleiro.getCasa(umaEsquerda, this.getFileira()); //Casa ao lado esquerdo desse peão.

                pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

                casaCaptura = Tabuleiro.getCasa(umaEsquerda, umaCima); //Casa de captura do En Passant.

                if (pecaNaCasa instanceof Peao) {
                    int corPecaNaCasa = pecaNaCasa.getCor();

                    if (((Peao) pecaNaCasa).getJogadaDuasCasas() == Tabuleiro.getJogadas() - 1) {
                        if (corPecaNaCasa != super.getCor()) {
                            this.alvoEnPassant = ((Peao) pecaNaCasa);
                            super.casasLegais.add(casaCaptura); //Peão inimigo em posição de captura.
                            arrayCorrespondente.add(casaCaptura);
                        }
                    }
                }
                casaTeste.setAtacked(byCorAtual);
            }
        }
    }
}

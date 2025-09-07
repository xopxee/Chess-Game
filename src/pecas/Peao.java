package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Tabuleiro.*;

//DELETAR A PEÇA CAPTURADA PELO EN PASSANT!!!

public class Peao extends Peca{
    private ArrayList<Casa> casasLegais = new ArrayList<>();
    private int jogadaDuasCasas = -1;

    public Peao(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? 'P' : 'p';  //notação em inglês (Pawn).
    }

    public void setJogadaDuasCasas(int jogadaDuasCasas) {
        this.jogadaDuasCasas = jogadaDuasCasas;
    }
    public int getJogadaDuasCasas() {
        return jogadaDuasCasas;
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

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
            casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
        }
        else{
            isBlocked = true;
        }

        if((super.getFileira() == fileiraInicial) && !isBlocked) {

            casaTeste = Tabuleiro.getCasa(super.getColuna(), duasCima); //Duas casas para cima.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa == null) {
                casasLegais.add(casaTeste); //A casa está livre, logo é um movimento legal.
            }
        }

        if(this.getColuna() < COLUNAS) {

            casaTeste = Tabuleiro.getCasa(umaDireita, umaCima); //Possível captura na diagonal direita.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa != null) {
                int corPecaNaCasa = pecaNaCasa.getCor();

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Peça inimiga em posição de captura.
                }
            }
        }

        if(this.getColuna() > 0) {

            casaTeste = Tabuleiro.getCasa(umaEsquerda, umaCima); //Possível captura na diagonal esquerda.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            if (pecaNaCasa != null) {
                int corPecaNaCasa = pecaNaCasa.getCor();

                if (corPecaNaCasa != super.getCor()) {
                    casasLegais.add(casaTeste); //Peça inimiga em posição de captura.
                }
            }

        }

        Casa casaCaptura;

        if(this.getColuna() < COLUNAS) {

            casaTeste = Tabuleiro.getCasa(umaDireita, fileiraEnPassant); //Casa ao lado direito desse peão.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            casaCaptura = Tabuleiro.getCasa(umaDireita, umaCima); //Casa de captura do En Passant.

            if (pecaNaCasa instanceof Peao) {
                int corPecaNaCasa = pecaNaCasa.getCor();

                if (((Peao) pecaNaCasa).getJogadaDuasCasas() == Tabuleiro.getJogadas()-1) {
                    if (corPecaNaCasa != super.getCor()) {
                        casasLegais.add(casaCaptura); //Peão inimigo em posição de captura.
                    }
                }
            }
        }

        if(this.getColuna() > 0) {

            casaTeste = Tabuleiro.getCasa(umaEsquerda, fileiraEnPassant); //Casa ao lado esquerdo desse peão.

            pecaNaCasa = casaTeste.getPeca(); //Peça que está (ou não) nessa casa.

            casaCaptura = Tabuleiro.getCasa(umaEsquerda, umaCima); //Casa de captura do En Passant.

            if (pecaNaCasa instanceof Peao) {
                int corPecaNaCasa = pecaNaCasa.getCor();

                if (((Peao) pecaNaCasa).getJogadaDuasCasas() == Tabuleiro.getJogadas()-1) {
                    if (corPecaNaCasa != super.getCor()) {
                        casasLegais.add(casaCaptura); //Peão inimigo em posição de captura.
                    }
                }
            }
        }


    }

    @Override
    public ArrayList<Casa> getCasasLegais() {
        return casasLegais;
    }
}

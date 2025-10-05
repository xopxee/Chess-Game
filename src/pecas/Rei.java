package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Casa.BY_BLACK;
import static Tabuleiro.Casa.BY_WHITE;
import static Tabuleiro.Tabuleiro.*;

public class Rei extends Peca {
    private int pecasAtacantes = 0;
    private boolean isInCheck = false;

    public Rei(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♚' : '♔';
        super.casasLegais = new ArrayList<>(10);

        if(super.cor == BRANCO){
            setReiBranco(this);
        }
        else{
            setReiPreto(this);
        }
    }

    @Override
    public void setCasasLegais() {
        super.casasLegais.clear();
        ArrayList<Casa> arrayCorrespondente = (this.getCor() == BRANCO) ? casasLegaisPecasBrancas : casasLegaisPecasPretas;

        int byCorAtual = (super.getCor() == BRANCO)? BY_WHITE : BY_BLACK;

        // Movimentos para direita
        int idColuna = super.getColuna() + 1;
        if (idColuna < 8) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira());
            Peca pecaNaFileira = casaNaFileira.getPeca();

            if (pecaNaFileira == null) {
                super.casasLegais.add(casaNaFileira);
                arrayCorrespondente.add(casaNaFileira);
            } else {
                if (pecaNaFileira.getCor() != super.getCor()) {
                    super.casasLegais.add(casaNaFileira);
                    arrayCorrespondente.add(casaNaFileira);
                }
            }
            casaNaFileira.setAtacked(byCorAtual);
        }

        // Movimentos para esquerda
        idColuna = super.getColuna() - 1;
        if (idColuna >= 0) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira());
            Peca pecaNaFileira = casaNaFileira.getPeca();

            if (pecaNaFileira == null) {
                super.casasLegais.add(casaNaFileira);
                arrayCorrespondente.add(casaNaFileira);
            } else {
                if (pecaNaFileira.getCor() != super.getCor()) {
                    super.casasLegais.add(casaNaFileira);
                    arrayCorrespondente.add(casaNaFileira);
                }
            }
            casaNaFileira.setAtacked(byCorAtual);
        }

        // Movimentos para cima
        int idFileira = super.getFileira() + 1;
        if (idFileira < 8) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira);
            Peca pecaNaColuna = casaNaColuna.getPeca();

            if (pecaNaColuna == null) {
                super.casasLegais.add(casaNaColuna);
                arrayCorrespondente.add(casaNaColuna);
            } else {
                if (pecaNaColuna.getCor() != super.getCor()) {
                    super.casasLegais.add(casaNaColuna);
                    arrayCorrespondente.add(casaNaColuna);
                }
            }
            casaNaColuna.setAtacked(byCorAtual);
        }

        // Movimentos para baixo
        idFileira = super.getFileira() - 1;
        if (idFileira >= 0) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira);
            Peca pecaNaColuna = casaNaColuna.getPeca();

            if (pecaNaColuna == null) {
                super.casasLegais.add(casaNaColuna);
                arrayCorrespondente.add(casaNaColuna);
            } else {
                if (pecaNaColuna.getCor() != super.getCor()) {
                    super.casasLegais.add(casaNaColuna);
                    arrayCorrespondente.add(casaNaColuna);
                }
            }
            casaNaColuna.setAtacked(byCorAtual);
        }

        // Movimento para diagonal direita superior
        idColuna = super.getColuna() + 1;
        idFileira = super.getFileira() + 1;
        if (idColuna < 8 && idFileira < 8) {
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira);
            Peca pecaNaDiagonal = casaNaDiagonal.getPeca();

            if (pecaNaDiagonal == null) {
                super.casasLegais.add(casaNaDiagonal);
                arrayCorrespondente.add(casaNaDiagonal);
            } else {
                if (pecaNaDiagonal.getCor() != super.getCor()) {
                    super.casasLegais.add(casaNaDiagonal);
                    arrayCorrespondente.add(casaNaDiagonal);
                }
            }
            casaNaDiagonal.setAtacked(byCorAtual);
        }

        // Movimento para diagonal esquerda superior
        idColuna = super.getColuna() - 1;
        idFileira = super.getFileira() + 1;
        if (idColuna >= 0 && idFileira < 8) {
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira);
            Peca pecaNaDiagonal = casaNaDiagonal.getPeca();

            if (pecaNaDiagonal == null) {
                super.casasLegais.add(casaNaDiagonal);
                arrayCorrespondente.add(casaNaDiagonal);
            } else {
                if (pecaNaDiagonal.getCor() != super.getCor()) {
                    super.casasLegais.add(casaNaDiagonal);
                    arrayCorrespondente.add(casaNaDiagonal);
                }
            }
            casaNaDiagonal.setAtacked(byCorAtual);
        }

        // Movimento para diagonal esquerda inferior
        idColuna = super.getColuna() - 1;
        idFileira = super.getFileira() - 1;
        if (idColuna >= 0 && idFileira >= 0) {
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira);
            Peca pecaNaDiagonal = casaNaDiagonal.getPeca();

            if (pecaNaDiagonal == null) {
                super.casasLegais.add(casaNaDiagonal);
                arrayCorrespondente.add(casaNaDiagonal);
            } else {
                if (pecaNaDiagonal.getCor() != super.getCor()) {
                    super.casasLegais.add(casaNaDiagonal);
                    arrayCorrespondente.add(casaNaDiagonal);
                }
            }
            casaNaDiagonal.setAtacked(byCorAtual);
        }

        // Movimento para diagonal direita inferior
        idColuna = super.getColuna() + 1;
        idFileira = super.getFileira() - 1;
        if (idColuna < 8 && idFileira >= 0) {
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira);
            Peca pecaNaDiagonal = casaNaDiagonal.getPeca();

            if (pecaNaDiagonal == null) {
                super.casasLegais.add(casaNaDiagonal);
                arrayCorrespondente.add(casaNaDiagonal);
            } else {
                if (pecaNaDiagonal.getCor() != super.getCor()) {
                    super.casasLegais.add(casaNaDiagonal);
                    arrayCorrespondente.add(casaNaDiagonal);
                }
            }
            casaNaDiagonal.setAtacked(byCorAtual);
        }
    }

    @Override
    public void filtrarCasasLegais(){
        int byCorInimiga = (super.getCor() == BRANCO)? BY_BLACK : BY_WHITE;

        ArrayList<Casa> temp = new ArrayList<>();
        for(Casa casa : super.casasLegais ){
            if(!casa.isAtacked().contains(byCorInimiga)){
                temp.add(casa);
            }
        }
        super.casasLegais.clear(); //Esvazia as casas legais,
        super.casasLegais = temp;  //e troca pela interseção encontrada.
    }

    public void setIsInCheck(boolean isInCheck){
        this.isInCheck = isInCheck;
    }

    public boolean isInCheck() {
        ArrayList<Casa> casasInimigas = (this.getCor() == BRANCO)? casasLegaisPecasPretas : casasLegaisPecasBrancas;

        setIsInCheck(false);
        for(Casa casa : casasInimigas){
            if(casa == this.getCasa()){
                setIsInCheck(true);
                break;
            }
        }

        return isInCheck;
    }

    public int getPecasAtacantes() {
        return pecasAtacantes;
    }

    public void setPecasAtacantes(int pecasAtacantes) {
        this.pecasAtacantes = pecasAtacantes;
    }
    public void incPecasAtacantes() {
        this.pecasAtacantes++;
    }
}
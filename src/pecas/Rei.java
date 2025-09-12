package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Tabuleiro.*;

public class Rei extends Peca {
    private ArrayList<Casa> casasLegais = new ArrayList<>(10);
    private ArrayList<Peca> pecasAtacantes = new ArrayList<>(2);

    public Rei(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♚' : '♔';
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

        // Movimentos para direita
        int idColuna = super.getColuna() + 1;
        // VERIFICA SE A COLUNA ESTÁ DENTRO DO TABULEIRO (0-7)
        if (idColuna < 8) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira());
            Peca pecaNaFileira = casaNaFileira.getPeca();

            if (pecaNaFileira == null) {
                casasLegais.add(casaNaFileira);
            } else {
                if (pecaNaFileira.getCor() != super.getCor()) {
                    casasLegais.add(casaNaFileira);
                }
            }
        }

        // Movimentos para esquerda
        idColuna = super.getColuna() - 1;
        // VERIFICA SE A COLUNA ESTÁ DENTRO DO TABULEIRO (0-7)
        if (idColuna >= 0) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira());
            Peca pecaNaFileira = casaNaFileira.getPeca();

            if (pecaNaFileira == null) {
                casasLegais.add(casaNaFileira);
            } else {
                if (pecaNaFileira.getCor() != super.getCor()) {
                    casasLegais.add(casaNaFileira);
                }
            }
        }

        // Movimentos para cima
        int idFileira = super.getFileira() + 1;
        // VERIFICA SE A FILEIRA ESTÁ DENTRO DO TABULEIRO (0-7)
        if (idFileira < 8) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira);
            Peca pecaNaColuna = casaNaColuna.getPeca();

            if (pecaNaColuna == null) {
                casasLegais.add(casaNaColuna);
            } else {
                if (pecaNaColuna.getCor() != super.getCor()) {
                    casasLegais.add(casaNaColuna);
                }
            }
        }

        // Movimentos para baixo
        idFileira = super.getFileira() - 1;
        // VERIFICA SE A FILEIRA ESTÁ DENTRO DO TABULEIRO (0-7)
        if (idFileira >= 0) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira);
            Peca pecaNaColuna = casaNaColuna.getPeca();

            if (pecaNaColuna == null) {
                casasLegais.add(casaNaColuna);
            } else {
                if (pecaNaColuna.getCor() != super.getCor()) {
                    casasLegais.add(casaNaColuna);
                }
            }
        }

        // Movimento para diagonal direita superior
        idColuna = super.getColuna() + 1;
        idFileira = super.getFileira() + 1;
        // VERIFICA SE AMBAS AS COORDENADAS ESTÃO DENTRO DO TABULEIRO (0-7)
        if (idColuna < 8 && idFileira < 8) {
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira);
            Peca pecaNaDiagonal = casaNaDiagonal.getPeca();

            if (pecaNaDiagonal == null) {
                casasLegais.add(casaNaDiagonal);
            } else {
                if (pecaNaDiagonal.getCor() != super.getCor()) {
                    casasLegais.add(casaNaDiagonal);
                }
            }
        }

        // Movimento para diagonal esquerda superior
        idColuna = super.getColuna() - 1;
        idFileira = super.getFileira() + 1;
        // VERIFICA SE AMBAS AS COORDENADAS ESTÃO DENTRO DO TABULEIRO (0-7)
        if (idColuna >= 0 && idFileira < 8) {
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira);
            Peca pecaNaDiagonal = casaNaDiagonal.getPeca();

            if (pecaNaDiagonal == null) {
                casasLegais.add(casaNaDiagonal);
            } else {
                if (pecaNaDiagonal.getCor() != super.getCor()) {
                    casasLegais.add(casaNaDiagonal);
                }
            }
        }

        // Movimento para diagonal esquerda inferior
        idColuna = super.getColuna() - 1;
        idFileira = super.getFileira() - 1;
        // VERIFICA SE AMBAS AS COORDENADAS ESTÃO DENTRO DO TABULEIRO (0-7)
        if (idColuna >= 0 && idFileira >= 0) {
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira);
            Peca pecaNaDiagonal = casaNaDiagonal.getPeca();

            if (pecaNaDiagonal == null) {
                casasLegais.add(casaNaDiagonal);
            } else {
                if (pecaNaDiagonal.getCor() != super.getCor()) {
                    casasLegais.add(casaNaDiagonal);
                }
            }
        }

        // Movimento para diagonal direita inferior
        idColuna = super.getColuna() + 1;
        idFileira = super.getFileira() - 1;
        // VERIFICA SE AMBAS AS COORDENADAS ESTÃO DENTRO DO TABULEIRO (0-7)
        if (idColuna < 8 && idFileira >= 0) {
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira);
            Peca pecaNaDiagonal = casaNaDiagonal.getPeca();

            if (pecaNaDiagonal == null) {
                casasLegais.add(casaNaDiagonal);
            } else {
                if (pecaNaDiagonal.getCor() != super.getCor()) {
                    casasLegais.add(casaNaDiagonal);
                }
            }
        }
    }

    @Override
    public ArrayList<Casa> getCasasLegais() {
        return casasLegais;
    }
}
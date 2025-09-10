package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Tabuleiro.*;

public class Rainha extends Peca{
    private ArrayList<Casa> casasLegais = new ArrayList<>();

    public Rainha(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♛' : '♕';  //notação em inglês (Queen).
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

        //Movimentos Horizontais e Verticais:

        //Movimentos para direita
        for (int idColuna = super.getColuna() + 1; idColuna < COLUNAS; idColuna++) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.

            Peca pecaNaFileira = casaNaFileira.getPeca();  //Peças que estão (ou não) nessas casas.

            if(pecaNaFileira == null) {
                casasLegais.add(casaNaFileira); //Caminho está livre, logo é um movimento legal.
            }
            else{
                int corPecaNaFileira = pecaNaFileira.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaFileira != super.getCor()) {
                    casasLegais.add(casaNaFileira);  //Como a peça é de outra cor, podemos capturar,
                }
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para esquerda
        for (int idColuna = super.getColuna() - 1; idColuna >= 0; idColuna--) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.

            Peca pecaNaFileira = casaNaFileira.getPeca();  //Peças que estão (ou não) nessas casas.

            if(pecaNaFileira == null) {
                casasLegais.add(casaNaFileira); //Caminho está livre, logo é um movimento legal.
            }
            else{
                int corPecaNaFileira = pecaNaFileira.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaFileira != super.getCor()) {
                    casasLegais.add(casaNaFileira);  //Como a peça é de outra cor, podemos capturar,
                }
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para cima
        for (int idFileira = super.getFileira() + 1; idFileira < FILEIRAS; idFileira++) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma coluna.

            Peca pecaNaColuna = casaNaColuna.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaColuna == null) {
                casasLegais.add(casaNaColuna); //Caminho está livre, logo é um movimento legal.
            }
            else{
                int corPecaNaColuna = pecaNaColuna.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaColuna != super.getCor()) {
                    casasLegais.add(casaNaColuna);  //Como a peça é de outra cor, podemos capturar,
                }
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para baixo
        for (int idFileira = super.getFileira() - 1; idFileira >= 0; idFileira--) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma coluna.

            Peca pecaNaColuna = casaNaColuna.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaColuna == null) {
                casasLegais.add(casaNaColuna); //Caminho está livre, logo é um movimento legal.
            }
            else{
                int corPecaNaColuna = pecaNaColuna.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaColuna != super.getCor()) {
                    casasLegais.add(casaNaColuna);  //Como a peça é de outra cor, podemos capturar,
                }
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos Diagonais:

        //Movimento para diagonal direita superior

        int idColuna  = super.getColuna()  + 1;
        int idFileira = super.getFileira() + 1;

        for( ; ((idColuna < COLUNAS) && (idFileira < FILEIRAS)); idColuna++, idFileira++){
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma diagonal.

            Peca pecaNaDiagonal = casaNaDiagonal.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaDiagonal == null){
                casasLegais.add(casaNaDiagonal); //Caminho está livre, logo é um movimento legal.
            }
            else{
                int corPecaNaDiagonal = pecaNaDiagonal.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaDiagonal != super.getCor()) {
                    casasLegais.add(casaNaDiagonal); //Como a peça é de outra cor, podemos capturar,
                }
                break;  //Caminho está bloqueado.
            }
        }


        //Movimento para diagonal esquerda superior

        idColuna  = super.getColuna()  - 1;
        idFileira = super.getFileira() + 1;

        for( ; ((idColuna >= 0) && (idFileira < FILEIRAS)); idColuna--, idFileira++){
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma diagonal.

            Peca pecaNaDiagonal = casaNaDiagonal.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaDiagonal == null){
                casasLegais.add(casaNaDiagonal); //Caminho está livre, logo é um movimento legal.
            }
            else{
                int corPecaNaDiagonal = pecaNaDiagonal.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaDiagonal != super.getCor()) {
                    casasLegais.add(casaNaDiagonal); //Como a peça é de outra cor, podemos capturar,
                }
                break;  //Caminho está bloqueado.
            }
        }


        //Movimento para diagonal esquerda inferior

        idColuna  = super.getColuna()  - 1;
        idFileira = super.getFileira() - 1;

        for( ; ((idColuna >= 0) && (idFileira >= 0)); idColuna--, idFileira--){
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma diagonal.

            Peca pecaNaDiagonal = casaNaDiagonal.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaDiagonal == null){
                casasLegais.add(casaNaDiagonal); //Caminho está livre, logo é um movimento legal.
            }
            else{
                int corPecaNaDiagonal = pecaNaDiagonal.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaDiagonal != super.getCor()) {
                    casasLegais.add(casaNaDiagonal); //Como a peça é de outra cor, podemos capturar,
                }
                break;  //Caminho está bloqueado.
            }
        }


        //Movimento para diagonal direita inferior

        idColuna  = super.getColuna()  + 1;
        idFileira = super.getFileira() - 1;

        for( ; ((idColuna < COLUNAS) && (idFileira >= 0)); idColuna++, idFileira--){
            Casa casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma diagonal.

            Peca pecaNaDiagonal = casaNaDiagonal.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaDiagonal == null){
                casasLegais.add(casaNaDiagonal); //Caminho está livre, logo é um movimento legal.
            }
            else{
                int corPecaNaDiagonal = pecaNaDiagonal.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaDiagonal != super.getCor()) {
                    casasLegais.add(casaNaDiagonal); //Como a peça é de outra cor, podemos capturar,
                }
                break;  //Caminho está bloqueado.
            }
        }
    }
    @Override
    public ArrayList<Casa> getCasasLegais() {
        return casasLegais;
    }
}

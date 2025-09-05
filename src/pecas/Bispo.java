package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Tabuleiro.*;
import static Tabuleiro.Tabuleiro.COLUNAS;
import static Tabuleiro.Tabuleiro.FILEIRAS;

public class Bispo extends Peca{
    private ArrayList<Casa> casasLegais = new ArrayList<>();

    public Bispo(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? 'B' : 'b';  //notação em inglês (Bishop).
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

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

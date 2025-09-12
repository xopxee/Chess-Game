package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Tabuleiro.*;

public class Torre extends Peca{
    private ArrayList<Casa> casasLegais = new ArrayList<>(14);

    public Torre(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♜' : '♖';  //notação em inglês (Rook).
    }

    @Override
    public void setCasasLegais() {
        casasLegais.clear();

        ArrayList<Casa> arrayCorrespondente = (this.getCor() == BRANCO) ? casasBrancasLegais : casasPretasLegais;

        //Movimentos para direita
        for (int idColuna = super.getColuna() + 1; idColuna < COLUNAS; idColuna++) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.

            Peca pecaNaFileira = casaNaFileira.getPeca();  //Peças que estão (ou não) nessas casas.

            if(pecaNaFileira == null) {
                casasLegais.add(casaNaFileira); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaFileira);
            }
            else{
                int corPecaNaFileira = pecaNaFileira.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaFileira != super.getCor()) {
                    casasLegais.add(casaNaFileira);  //Como a peça é de outra cor, podemos capturar.
                    arrayCorrespondente.add(casaNaFileira);
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
                arrayCorrespondente.add(casaNaFileira);
            }
            else{
                int corPecaNaFileira = pecaNaFileira.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaFileira != super.getCor()) {
                    casasLegais.add(casaNaFileira);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaFileira);
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
                arrayCorrespondente.add(casaNaColuna);
            }
            else{
                int corPecaNaColuna = pecaNaColuna.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaColuna != super.getCor()) {
                    casasLegais.add(casaNaColuna);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaColuna);
                }
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para baixo
        for (int idFileira = super.getFileira() - 1; idFileira >= 0; idFileira--) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma coluna.

            Peca pecaNaColuna = casaNaColuna.getPeca();                 //Peças que estão (ou não) nessas casas.

            if(pecaNaColuna == null) {
                casasLegais.add(casaNaColuna); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaColuna);
            }
            else{
                int corPecaNaColuna = pecaNaColuna.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaColuna != super.getCor()) {
                    casasLegais.add(casaNaColuna);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaColuna);
                }
                break; //Caminho está bloqueado.
            }
        }
    }
    @Override
    public ArrayList<Casa> getCasasLegais() {
        return casasLegais;
    }
}

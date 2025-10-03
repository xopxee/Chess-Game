package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Tabuleiro.*;

public class Rainha extends Peca{

    public Rainha(int coluna, int fileira, int cor){
        super(coluna, fileira, cor);
        super.tipo = (super.cor == BRANCO) ? '♛' : '♕';  //notação em inglês (Queen).
        super.casasLegais = new ArrayList<>(28);
    }

    @Override
    public void setCasasLegais() {
        super.casasLegais.clear();

        ArrayList<Casa> arrayCorrespondente = (this.getCor() == BRANCO) ? casasLegaisPecasBrancas : casasLegaisPecasPretas;

        int byCorAtual = (super.getCor() == BRANCO)? BY_WHITE : BY_BLACK;

        //Movimentos Horizontais e Verticais:

        //Movimentos para direita
        for (int idColuna = super.getColuna() + 1; idColuna < COLUNAS; idColuna++) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.

            Peca pecaNaFileira = casaNaFileira.getPeca();  //Peças que estão (ou não) nessas casas.

            if(pecaNaFileira == null) {
                super.casasLegais.add(casaNaFileira); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaFileira);
            }
            else{
                int corPecaNaFileira = pecaNaFileira.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaFileira != super.getCor()) {
                    super.casasLegais.add(casaNaFileira);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaFileira);

                    if(pecaNaFileira instanceof Rei){
                        ((Rei) pecaNaFileira).setIsInCheck(true);
                        ((Rei) pecaNaFileira).incPecasAtacantes();

                        for (idColuna = pecaNaFileira.getColuna() - 1; idColuna >= this.getColuna(); idColuna--){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                            casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.
                            if(corPecaNaFileira == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaFileira);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaFileira);
                            }
                        }
                    }
                }
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para esquerda
        for (int idColuna = super.getColuna() - 1; idColuna >= 0; idColuna--) {
            Casa casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.

            Peca pecaNaFileira = casaNaFileira.getPeca();  //Peças que estão (ou não) nessas casas.

            if(pecaNaFileira == null) {
                super.casasLegais.add(casaNaFileira); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaFileira);
            }
            else{
                int corPecaNaFileira = pecaNaFileira.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaFileira != super.getCor()) {
                    super.casasLegais.add(casaNaFileira);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaFileira);

                    if(pecaNaFileira instanceof Rei){
                        ((Rei) pecaNaFileira).setIsInCheck(true);
                        ((Rei) pecaNaFileira).incPecasAtacantes();

                        for (idColuna = pecaNaFileira.getColuna() + 1; idColuna <= this.getColuna(); idColuna++){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                            casaNaFileira = Tabuleiro.getCasa(idColuna, super.getFileira()); //Casas que estão na mesma fileira.
                            if(corPecaNaFileira == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaFileira);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaFileira);
                            }
                        }
                    }
                }
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para cima
        for (int idFileira = super.getFileira() + 1; idFileira < FILEIRAS; idFileira++) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma coluna.

            Peca pecaNaColuna = casaNaColuna.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaColuna == null) {
                super.casasLegais.add(casaNaColuna); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaColuna);
            }
            else{
                int corPecaNaColuna = pecaNaColuna.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaColuna != super.getCor()) {
                    super.casasLegais.add(casaNaColuna);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaColuna);

                    if(pecaNaColuna instanceof Rei){
                        ((Rei) pecaNaColuna).setIsInCheck(true);
                        ((Rei) pecaNaColuna).incPecasAtacantes();

                        for (idFileira = pecaNaColuna.getFileira() - 1; idFileira >= this.getFileira(); idFileira--){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                            casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma fileira.
                            if(corPecaNaColuna == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaColuna);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaColuna);
                            }
                        }
                    }
                }
                break; //Caminho está bloqueado.
            }
        }


        //Movimentos para baixo
        for (int idFileira = super.getFileira() - 1; idFileira >= 0; idFileira--) {
            Casa casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma coluna.

            Peca pecaNaColuna = casaNaColuna.getPeca(); //Peças que estão (ou não) nessas casas.

            if(pecaNaColuna == null) {
                super.casasLegais.add(casaNaColuna); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaColuna);
            }
            else{
                int corPecaNaColuna = pecaNaColuna.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaColuna != super.getCor()) {
                    super.casasLegais.add(casaNaColuna);  //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaColuna);

                    if(pecaNaColuna instanceof Rei){
                        ((Rei) pecaNaColuna).setIsInCheck(true);
                        ((Rei) pecaNaColuna).incPecasAtacantes();

                        for (idFileira = pecaNaColuna.getFileira() + 1; idFileira <= this.getColuna(); idFileira++){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                            casaNaColuna = Tabuleiro.getCasa(super.getColuna(), idFileira); //Casas que estão na mesma fileira.
                            if(corPecaNaColuna == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaColuna);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaColuna);
                            }
                        }
                    }
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
                super.casasLegais.add(casaNaDiagonal); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaDiagonal);
            }
            else{
                int corPecaNaDiagonal = pecaNaDiagonal.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaDiagonal != super.getCor()) {
                    super.casasLegais.add(casaNaDiagonal); //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaDiagonal);

                    if(pecaNaDiagonal instanceof Rei){
                        ((Rei) pecaNaDiagonal).setIsInCheck(true);
                        ((Rei) pecaNaDiagonal).incPecasAtacantes();

                        idColuna  = pecaNaDiagonal.getColuna()  - 1;
                        idFileira = pecaNaDiagonal.getFileira() - 1;
                        for( ; ((idColuna >= this.getColuna()) && (idFileira >= this.getFileira())); idColuna--, idFileira--){
                            casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma fileira.
                            if(corPecaNaDiagonal == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaDiagonal);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaDiagonal);
                            }
                        }
                    }
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
                super.casasLegais.add(casaNaDiagonal); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaDiagonal);
            }
            else{
                int corPecaNaDiagonal = pecaNaDiagonal.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaDiagonal != super.getCor()) {
                    super.casasLegais.add(casaNaDiagonal); //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaDiagonal);

                    if(pecaNaDiagonal instanceof Rei){
                        ((Rei) pecaNaDiagonal).setIsInCheck(true);
                        ((Rei) pecaNaDiagonal).incPecasAtacantes();

                        idColuna  = pecaNaDiagonal.getColuna()  + 1;
                        idFileira = pecaNaDiagonal.getFileira() - 1;
                        for( ; ((idColuna <= this.getColuna()) && (idFileira >= this.getFileira())); idColuna++, idFileira--){
                            casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma fileira.
                            if(corPecaNaDiagonal == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaDiagonal);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaDiagonal);
                            }
                        }
                    }
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
                super.casasLegais.add(casaNaDiagonal); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaDiagonal);
            }
            else{
                int corPecaNaDiagonal = pecaNaDiagonal.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaDiagonal != super.getCor()) {
                    super.casasLegais.add(casaNaDiagonal); //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaDiagonal);

                    if(pecaNaDiagonal instanceof Rei){
                        ((Rei) pecaNaDiagonal).setIsInCheck(true);
                        ((Rei) pecaNaDiagonal).incPecasAtacantes();

                        idColuna  = pecaNaDiagonal.getColuna()  + 1;
                        idFileira = pecaNaDiagonal.getFileira() + 1;
                        for( ; ((idColuna <= this.getColuna()) && (idFileira <= this.getFileira())); idColuna++, idFileira++){
                            casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma fileira e coluna.
                            if(corPecaNaDiagonal == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaDiagonal);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaDiagonal);
                            }
                        }
                    }
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
                super.casasLegais.add(casaNaDiagonal); //Caminho está livre, logo é um movimento legal.
                arrayCorrespondente.add(casaNaDiagonal);
            }
            else{
                int corPecaNaDiagonal = pecaNaDiagonal.getCor(); //Se tem uma peça no caminho, pegue a cor dela.

                if (corPecaNaDiagonal != super.getCor()) {
                    super.casasLegais.add(casaNaDiagonal); //Como a peça é de outra cor, podemos capturar,
                    arrayCorrespondente.add(casaNaDiagonal);

                    if(pecaNaDiagonal instanceof Rei){
                        ((Rei) pecaNaDiagonal).setIsInCheck(true);
                        ((Rei) pecaNaDiagonal).incPecasAtacantes();

                        idColuna  = pecaNaDiagonal.getColuna()  - 1;
                        idFileira = pecaNaDiagonal.getFileira() + 1;
                        for( ; ((idColuna >= this.getColuna()) && (idFileira <= this.getFileira())); idColuna--, idFileira++){
                            casaNaDiagonal = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma fileira e coluna.
                            if(corPecaNaDiagonal == BRANCO){
                                Tabuleiro.casasDeBloqueioBrancas.add(casaNaDiagonal);
                            }
                            else{
                                Tabuleiro.casasDeBloqueioPretas.add(casaNaDiagonal);
                            }
                        }
                    }
                }
                break;  //Caminho está bloqueado.
            }
        }
    }
}

package Tabuleiro;

import pecas.Peao;
import pecas.Peca;

import java.util.ArrayList;

public class Tabuleiro {
    public static final int COLUNAS = 8;
    public static final int FILEIRAS = 8;

    public static final int BRANCO = 0;
    public static final int PRETO = 1;

    public static final int COLUNA_A = 0;
    public static final int COLUNA_B = 1;
    public static final int COLUNA_C = 2;
    public static final int COLUNA_D = 3;
    public static final int COLUNA_E = 4;
    public static final int COLUNA_F = 5;
    public static final int COLUNA_G = 6;
    public static final int COLUNA_H = 7;

    public static final int PRIMEIRA_FILEIRA = 0;
    public static final int SEGUNDA_FILEIRA = 1;
    public static final int TERCEIRA_FILEIRA = 2;
    public static final int QUARTA_FILEIRA = 3;
    public static final int QUINTA_FILEIRA = 4;
    public static final int SEXTA_FILEIRA = 5;
    public static final int SETIMA_FILEIRA = 6;
    public static final int OITAVA_FILEIRA = 7;

    private static Casa[][] casas = new Casa[COLUNAS][FILEIRAS];
    private static ArrayList<Peca> pecasNoTabuleiro = new ArrayList<>(32);

    private static int jogadas = 0;

    public static Casa getCasa(int coluna, int fileira) {
        return casas[coluna][fileira];
    }

    public static void criarCasas() {
        for (int idColuna = 0; idColuna < COLUNAS; idColuna++) {
            for (int idFileira = 0; idFileira < FILEIRAS; idFileira++) {
                if((idColuna + idFileira) % 2 == 0) {
                    int cor = PRETO;
                    casas[idColuna][idFileira] = new Casa(idColuna, idFileira, cor);  //Cria uma casa preta
                }
                else{
                    int cor = BRANCO;
                    casas[idColuna][idFileira] = new Casa(idColuna, idFileira, cor);  //Cria uma casa branca
                }
            }
        }
    }

    public static void analisarCasasLegais(Peca peca){
        peca.setCasasLegais();
        ArrayList<Casa> casas = peca.getCasasLegais();

        for (int i = 0; i < casas.size(); i++) {
            String posCasa = casas.get(i).posString();

            System.out.println(posCasa); //Printa a posição da casa em coluna e fileira.
        }
        System.out.println();
    }

    public static void moverPeca(Peca peca, int coluna, int fileira){
        Casa casaAtual = peca.getCasa();
        Casa casaAlvo = getCasa(coluna, fileira);

        peca.setCasasLegais();

        if(peca.getCasasLegais().contains(casaAlvo)){ //Se é um movimento legal...
            peca.setPos(coluna, fileira); //Mova a peça para a casa desejada,
            peca.setCasa(casaAlvo); //Guarde a casa nova na instância da peça,

            casaAlvo.setPeca(peca); //Guarde a instância da peça na casa nova.

            casaAtual.setPeca(null); //Esvazie a casa antiga.

            jogadas++;

            if(peca instanceof Peao){
                int deslocamento = (peca.getCor() == BRANCO) ? 2 : -2;

                if(casaAlvo.getFileira() == casaAtual.getFileira() + deslocamento){
                    ((Peao) peca).setJogadaDuasCasas(jogadas);
                }
            }

        }
        else{
            System.out.println("Movimento ilegal!");
        }
    }

    public static int getJogadas() {
        return jogadas;
    }

    public static ArrayList<Peca> getPecasNoTabuleiro() {
        return pecasNoTabuleiro;
    }
}

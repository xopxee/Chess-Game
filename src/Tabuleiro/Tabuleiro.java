package Tabuleiro;

import pecas.*;

import java.util.ArrayList;
import java.util.Scanner;

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

    public static final ArrayList<String> casasToString = new ArrayList<>(128);

    public static void preencherCasasToString(){
        for(int i = 1; i <= 8; i++){
            char letra;

            letra = switch (i){
                case 1 -> 'a';
                case 2 -> 'b';
                case 3 -> 'c';
                case 4 -> 'd';
                case 5 -> 'e';
                case 6 -> 'f';
                case 7 -> 'g';
                case 8 -> 'h';
                default -> '?';
            };

            for(int j = 1; j <= 8; j++){
                char num = (char)(j + '0');

                String ToString = "" + letra + num;
                casasToString.add(ToString);
                casasToString.add(ToString.toUpperCase());  //Aceita letras em maíusculo também, user-friendly
            }
        }
    }
    public static int parseNotationFileira(String origem){
        int fileira = 0;
        switch (origem.charAt(1)){
            case '1':
                fileira = PRIMEIRA_FILEIRA;
                break;
            case '2':
                fileira = SEGUNDA_FILEIRA;
                break;
            case '3':
                fileira = TERCEIRA_FILEIRA;
                break;
            case '4':
                fileira = QUARTA_FILEIRA;
                break;
            case '5':
                fileira = QUINTA_FILEIRA;
                break;
            case '6':
                fileira = SEXTA_FILEIRA;
                break;
            case '7':
                fileira = SETIMA_FILEIRA;
                break;
            case '8':
                fileira = OITAVA_FILEIRA;
                break;
            default:
                System.out.println("Error");
                break;
        }
        return fileira;
    }
    public static int parseNotationColuna(String origem){
        int coluna = 0;
        switch (origem.charAt(0)) {
            case 'A':
            case 'a':
                coluna = COLUNA_A;
                break;
            case 'B':
            case 'b':
                coluna = COLUNA_B;
                break;
            case 'C':
            case 'c':
                coluna = COLUNA_C;
                break;
            case 'D':
            case 'd':
                coluna = COLUNA_D;
                break;
            case 'E':
            case 'e':
                coluna = COLUNA_E;
                break;
            case 'F':
            case 'f':
                coluna = COLUNA_F;
                break;
            case 'G':
            case 'g':
                coluna = COLUNA_G;
                break;
            case 'H':
            case 'h':
                coluna = COLUNA_H;
                break;
            default:
                System.out.println("Error");
                break;
        }
        return coluna;
    }


    private static Casa[][] casas = new Casa[COLUNAS][FILEIRAS];
    private static ArrayList<Peca> pecasNoTabuleiro = new ArrayList<>(32);

    private static int jogadas = 0;

    public static Casa getCasa(int coluna, int fileira) {
        return casas[coluna][fileira];
    }

    public static void criarCasas() {
        for (int idColuna = 0; idColuna < COLUNAS; idColuna++) {
            for (int idFileira = 0; idFileira < FILEIRAS; idFileira++) {
                if ((idColuna + idFileira) % 2 == 0) {
                    int cor = PRETO;
                    casas[idColuna][idFileira] = new Casa(idColuna, idFileira, cor);  //Cria uma casa preta
                } else {
                    int cor = BRANCO;
                    casas[idColuna][idFileira] = new Casa(idColuna, idFileira, cor);  //Cria uma casa branca
                }
            }
        }
        preencherCasasToString();
    }

    public static void imprimir() {
        System.out.print("\n\n\n\n");
        for (int idFileira = OITAVA_FILEIRA; idFileira >= 0; idFileira--) {
            for (int idColuna = COLUNA_A; idColuna < COLUNAS; idColuna++) {
                Peca pecaNaCasa = getCasa(idColuna, idFileira).getPeca();

                if (pecaNaCasa != null) {
                    char charPeca = pecaNaCasa.getTipo();
                    System.out.print("["+charPeca+"]" + " ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }

    public static void organizar() {
        for (int idColuna = 0; idColuna < COLUNAS; idColuna++) {
            new Peao(idColuna, SEGUNDA_FILEIRA, BRANCO);            //Cria os peões brancos nas suas casas iniciais
        }

        for (int idColuna = 0; idColuna < COLUNAS; idColuna++) {
            new Peao(idColuna, SETIMA_FILEIRA, PRETO);              //Cria os peões pretos nas suas casas iniciais
        }

        for(int i = 1; i <= 4; i++){
            int coluna = (i % 2 == 0) ? COLUNA_C : COLUNA_F;                //Alterna a coluna a cada iteração
            int fileira = (i <= 2) ? PRIMEIRA_FILEIRA : OITAVA_FILEIRA;     //ALterna a fileira a cada 2 iterações
            int cor = (i <= 2) ? BRANCO : PRETO;                            //Alterna a cor a cada 2 iterações

            new Bispo(coluna, fileira, cor);
        }

        for(int i = 1; i <= 4; i++){
            int coluna = (i % 2 == 0) ? COLUNA_B : COLUNA_G;                //Alterna a coluna a cada iteração
            int fileira = (i <= 2) ? PRIMEIRA_FILEIRA : OITAVA_FILEIRA;     //ALterna a fileira a cada 2 iterações
            int cor = (i <= 2) ? BRANCO : PRETO;                            //Alterna a cor a cada 2 iterações

            new Cavalo(coluna, fileira, cor);
        }

        for(int i = 1; i <= 4; i++){
            int coluna = (i % 2 == 0) ? COLUNA_A : COLUNA_H;                //Alterna a coluna a cada iteração
            int fileira = (i <= 2) ? PRIMEIRA_FILEIRA : OITAVA_FILEIRA;     //ALterna a fileira a cada 2 iterações
            int cor = (i <= 2) ? BRANCO : PRETO;                            //Alterna a cor a cada 2 iterações

            new Torre(coluna, fileira, cor);
        }

        for(int i = 1; i <= 2; i++){
            int coluna = COLUNA_D;
            int fileira = (i == 1) ? PRIMEIRA_FILEIRA : OITAVA_FILEIRA;     //ALterna a fileira a cada 2 iterações
            int cor = (i == 1) ? BRANCO : PRETO;                            //Alterna a cor a cada 2 iterações

            new Rainha(coluna, fileira, cor);
        }

        for(int i = 1; i <= 2; i++){
            int coluna = COLUNA_E;
            int fileira = (i == 1) ? PRIMEIRA_FILEIRA : OITAVA_FILEIRA;     //ALterna a fileira a cada 2 iterações
            int cor = (i == 1) ? BRANCO : PRETO;                            //Alterna a cor a cada 2 iterações

            new Rei(coluna, fileira, cor);
        }


    }

    public static void analisarCasasLegais(Peca peca) {
        peca.setCasasLegais();
        ArrayList<Casa> casas = peca.getCasasLegais();

        for (int i = 0; i < casas.size(); i++) {
            String posCasa = casas.get(i).posString();

            System.out.println(posCasa); //Printa a posição da casa em coluna e fileira.
        }
        System.out.println();
    }

    public static void moverPeca(int colunaAtual, int fileiraAtual, int coluna, int fileira) {
        Scanner sc = new Scanner(System.in);

        Casa casaAtual = getCasa(colunaAtual, fileiraAtual);
        Casa casaAlvo = getCasa(coluna, fileira);

        Peca peca = casaAtual.getPeca();

        peca.setCasasLegais();

        if (peca.getCasasLegais().contains(casaAlvo)) { //Se é um movimento legal...
            peca.setPos(coluna, fileira); //Mova a peça para a casa desejada,
            peca.setCasa(casaAlvo); //Guarde a casa nova na instância da peça,

            casaAlvo.setPeca(peca); //Guarde a instância da peça na casa nova.

            casaAtual.setPeca(null); //Esvazie a casa antiga.

            if (peca instanceof Peao) {
                //EN PASSANT

                int deslocamento = (peca.getCor() == BRANCO) ? 2 : -2;

                if (casaAlvo.getFileira() == casaAtual.getFileira() + deslocamento) {
                    ((Peao) peca).setJogadaDuasCasas(jogadas);
                }

                //PROMOÇÃO

                if (peca.getFileira() == PRIMEIRA_FILEIRA || peca.getFileira() == OITAVA_FILEIRA) {
                    char novapeca = sc.next().charAt(0);
                    // turno branco ent upper
                    if(Tabuleiro.getJogadas()%2 == 0){
                        novapeca = Character.toUpperCase(novapeca);
                    }
                    else{
                        novapeca = Character.toLowerCase(novapeca);
                    }
                    // turno preto ent lower
                    int tf = peca.getFileira();
                    int tc = peca.getColuna();
                    pecasNoTabuleiro.remove(peca);
                    // setando peca null
                    // ifs para caso seja preta ou branca
                    Peca p = null;
                    if (novapeca == 'r') {
                        p = new Torre(tf, tc, PRETO);
                    } else if (novapeca == 'n') {
                        p = new Cavalo(tf, tc, PRETO);
                    } else if (novapeca == 'b') {
                        p = new Bispo(tf, tc, PRETO);
                    } else if (novapeca == 'q') {
                        p = new Rainha(tf, tc, PRETO);
                    } else if (novapeca == 'R') {
                        p = new Torre(tf, tc, BRANCO);
                    } else if (novapeca == 'N') {
                        p = new Cavalo(tf, tc, BRANCO);
                    } else if (novapeca == 'B') {
                        p = new Bispo(tf, tc, BRANCO);
                    } else if (novapeca == 'Q') {
                        p = new Rainha(tf, tc, BRANCO);
                    } else {
                        System.out.println("Peça inválida.");
                    }
                    pecasNoTabuleiro.add(p);
                    casaAlvo.setPeca(p);
                }
                jogadas++;
            }

            } else {
                System.out.println("Movimento ilegal!");
            }
        }

        public static int getJogadas(){
            return jogadas;
        }

        public static ArrayList<Peca> getPecasNoTabuleiro(){
            return pecasNoTabuleiro;
        }
    }


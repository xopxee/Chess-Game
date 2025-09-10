import Tabuleiro.Tabuleiro;

import java.util.Scanner;

import static Tabuleiro.Tabuleiro.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Tabuleiro.criarCasas();
        Tabuleiro.preencherCasasToString();
        lerFEN(FEN_POS_INICIAL);
        imprimirBranco();

        while(true) {
            System.out.println("\n");

            System.out.println("Digite a casa de origem: ");
            String origem;
            while(true){
                origem = sc.nextLine();

                if(casasToString.contains(origem)){
                    break;
                }
            }

            int colOrigem = Tabuleiro.parseNotationColuna(origem);
            int filOrigem = Tabuleiro.parseNotationFileira(origem);

            System.out.println("Digite a casa de destino: ");
            String destino;
            while(true){
                destino = sc.nextLine();
                if(casasToString.contains(destino)){
                    break;
                }
            }

            int colDestino = Tabuleiro.parseNotationColuna(destino);
            int filDestino = Tabuleiro.parseNotationFileira(destino);

            if(Tabuleiro.getCasa(colOrigem, filOrigem).getPeca() != null) {

                if (Tabuleiro.getJogadas() % 2 == 0) {
                    int corDaPeca = Tabuleiro.getCasa(colOrigem, filOrigem).getPeca().getCor();

                    if (corDaPeca == PRETO) {
                        System.out.println("Vez do branco");
                        continue;
                    }
                } else {
                    int corDaPeca = Tabuleiro.getCasa(colOrigem, filOrigem).getPeca().getCor();

                    if (corDaPeca == BRANCO) {
                        System.out.println("Vez do preto");
                        continue;
                    }
                }
                Tabuleiro.moverPeca(colOrigem, filOrigem, colDestino, filDestino);
            }
            else{
                System.out.println("Não existe nenhuma peça nesta casa!");
            }
            virar();
        }
    }
}
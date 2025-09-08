import Tabuleiro.Tabuleiro;
import pecas.*;

import java.util.Scanner;

import static Tabuleiro.Tabuleiro.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Tabuleiro.criarCasas();
        Tabuleiro.preencherCasasToString();
        Tabuleiro.organizar();

        while(true) {
            Tabuleiro.imprimir();
            System.out.println("\n");

            System.out.println("Digite a casa de origem: ");
            String origem = "";
            while(true){
                origem = sc.nextLine();

                if(casasToString.contains(origem)){
                    break;
                }
            }

            int colorigem = Tabuleiro.parseNotationColuna(origem);
            int filorigem = Tabuleiro.parseNotationFileira(origem);

            System.out.println("Digite a casa de destino: ");
            String destino ="";
            while(true){
                destino = sc.nextLine();
                if(casasToString.contains(destino)){
                    break;
                }
            }

            int coldestino = Tabuleiro.parseNotationColuna(destino);
            int fildestino = Tabuleiro.parseNotationFileira(destino);

            if(Tabuleiro.getCasa(colorigem, filorigem).getPeca() != null) {

                if (Tabuleiro.getJogadas() % 2 == 0) {
                    int corDaPeca = Tabuleiro.getCasa(colorigem, filorigem).getPeca().getCor();

                    if (corDaPeca == PRETO) {
                        System.out.println("Vez do branco");
                        continue;
                    }
                } else {
                    int corDaPeca = Tabuleiro.getCasa(colorigem, filorigem).getPeca().getCor();

                    if (corDaPeca == BRANCO) {
                        System.out.println("Vez do preto");
                        continue;
                    }
                }
                Tabuleiro.moverPeca(colorigem, filorigem, coldestino, fildestino);
            }
            else{
                System.out.println("Não existe nenhuma peça nesta casa, burro do caralho!");
            }
        }
    }
}
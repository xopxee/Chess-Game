import Tabuleiro.Casa;

import Tabuleiro.Tabuleiro;

import java.util.Scanner;

import static Tabuleiro.Tabuleiro.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        criarCasas();
        preencherCasasToString();
        lerFEN("7k/8/1p2Q3/pP6/P3K3/8/8/8");
        //lerFEN(FEN_POS_INICIAL);
        imprimirBranco();

        while(true) {
            int turno = getJogadas();

            clearCasasLegais();           //Esvazia as casas legais antes de analisar novamente.
            clearCasasDeBloqueio();       //Esvazia as casas de bloqueio antes de analisar novamente.
            resetPecasAtacantes();        //Zera a contagem das peças que estão atacando o rei.
            refreshIsAtacked();

            refreshCasasLegais();         //Analisa as casas legais de todas as peças do tabuleiro.
            refreshIsInCheck();           //Verifica se os reis estão em cheque.
            refreshFiltroCasasLegais();   //Filtra a interseção entre casas legais e as casas de bloqueio.
            uniteCasasLegais();

            System.out.println(getReiPreto().isInCheck());
            System.out.println(getReiPreto().getPecasAtacantes());
            for(Casa casa : casasLegaisPecasBrancas){
                System.out.print(casa.posString() + " ");
            }
            System.out.println("Peças brancas ^");

            for(Casa casa : casasLegaisPecasPretas){
                System.out.print(casa.posString() + " ");
            }
            System.out.println("Peças pretas ^");

            System.out.println("\n");

            System.out.println("Digite a casa de origem: ");
            String origem;
            while(true){
                origem = sc.nextLine();

                if(casasToString.contains(origem)){
                    break; //Só aceita a entrada se a casa de origem existir
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
                        imprimirCorAtual();
                        continue;
                    }
                } else {
                    int corDaPeca = Tabuleiro.getCasa(colOrigem, filOrigem).getPeca().getCor();

                    if (corDaPeca == BRANCO) {
                        System.out.println("Vez do preto");
                        imprimirCorAtual();
                        continue;
                    }
                }
                Tabuleiro.moverPeca(colOrigem, filOrigem, colDestino, filDestino);
            }
            else{
                System.out.println("Não existe nenhuma peça nesta casa!");
                imprimirCorAtual();
            }
        }
    }
}
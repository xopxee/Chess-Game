import Tabuleiro.Tabuleiro;
import pecas.*;

import static Tabuleiro.Tabuleiro.*;

public class Main{
    public static void main(String[] args){
        Tabuleiro.criarCasas();

        /*
        Peao peaoPreto = new Peao(COLUNA_D, SETIMA_FILEIRA, PRETO);
        Peao peaoBranco = new Peao(COLUNA_C, SEGUNDA_FILEIRA, BRANCO);
        Torre torreBranca = new Torre(COLUNA_A, PRIMEIRA_FILEIRA, BRANCO);

        Tabuleiro.moverPeca(peaoPreto, COLUNA_D, QUINTA_FILEIRA);
        Tabuleiro.moverPeca(peaoPreto, COLUNA_D, QUARTA_FILEIRA);
        Tabuleiro.moverPeca(peaoBranco, COLUNA_C, QUARTA_FILEIRA);

        System.out.println("Movimentos legais do Peão Preto:");
        Tabuleiro.analisarCasasLegais(peaoPreto);

        System.out.println(peaoBranco.getJogadaDuasCasas());
        System.out.println(Tabuleiro.getJogadas());

        Tabuleiro.moverPeca(torreBranca, COLUNA_B, PRIMEIRA_FILEIRA);

        System.out.println("Movimentos legais do Peão Preto:");
        Tabuleiro.analisarCasasLegais(peaoPreto);

        System.out.println(peaoBranco.getJogadaDuasCasas());
        System.out.println(Tabuleiro.getJogadas());
         */

        Cavalo cavalo = new Cavalo(COLUNA_A, PRIMEIRA_FILEIRA, BRANCO);
        Cavalo cavalo2 = new Cavalo(COLUNA_B, TERCEIRA_FILEIRA, BRANCO);
        Cavalo cavalo3 = new Cavalo(COLUNA_H, PRIMEIRA_FILEIRA, BRANCO);
        Cavalo cavalo4 = new Cavalo(COLUNA_H, OITAVA_FILEIRA, BRANCO);

        Tabuleiro.analisarCasasLegais(cavalo);
        Tabuleiro.analisarCasasLegais(cavalo2);
        Tabuleiro.analisarCasasLegais(cavalo3);
        Tabuleiro.analisarCasasLegais(cavalo4);
    }
}
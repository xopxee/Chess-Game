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

    private static Rei reiBranco;
    private static Rei reiPreto;

    public static ArrayList<Casa> casasLegaisPecasBrancas = new ArrayList<>(64);
    public static ArrayList<Casa> casasLegaisPecasPretas = new ArrayList<>(64);

    public static ArrayList<Casa> casasDeBloqueioBrancas = new ArrayList<>(32);
    public static ArrayList<Casa> casasDeBloqueioPretas = new ArrayList<>(32);

    public static final String FEN_POS_INICIAL = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

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

    private static int perspectiva = BRANCO;

    public static int getPerspectiva() {
        return perspectiva;
    }

    public static void setPerspectiva(int perspectiva) {
        Tabuleiro.perspectiva = perspectiva;
    }

    public static void imprimirBranco() {
        System.out.print("\n\n\n\n");
        for (int idFileira = OITAVA_FILEIRA; idFileira >= PRIMEIRA_FILEIRA; idFileira--) {
            for (int idColuna = COLUNA_A; idColuna <= COLUNA_H; idColuna++) {
                Peca pecaNaCasa = Tabuleiro.getCasa(idColuna, idFileira).getPeca();

                if(idColuna == COLUNA_A) {
                    if (pecaNaCasa != null) {
                        char charPeca = pecaNaCasa.getTipo();
                        System.out.print((idFileira + 1) + "[" + charPeca + "|");
                    } else {
                        System.out.print((idFileira + 1) + "[ |");
                    }
                } else if (idColuna == COLUNA_H) {
                    if (pecaNaCasa != null) {
                        char charPeca = pecaNaCasa.getTipo();
                        System.out.print(charPeca + "]");
                    } else {
                        System.out.print(" ]");
                    }
                }
                else{
                    if (pecaNaCasa != null) {
                        char charPeca = pecaNaCasa.getTipo();
                        System.out.print(charPeca + "|");
                    } else {
                        System.out.print(" |");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h ");
        setPerspectiva(BRANCO);
    }

    public static void imprimirPreto() {
        System.out.print("\n\n\n\n");
        for (int idFileira = PRIMEIRA_FILEIRA; idFileira < FILEIRAS; idFileira++) {
            for (int idColuna = COLUNA_H; idColuna >= COLUNA_A; idColuna--) {
                Peca pecaNaCasa = getCasa(idColuna, idFileira).getPeca();

                if(idColuna == COLUNA_H) {
                    if (pecaNaCasa != null) {
                        char charPeca = pecaNaCasa.getTipo();
                        System.out.print((idFileira + 1) + "[" + charPeca + "|");
                    } else {
                        System.out.print((idFileira + 1) + "[ |");
                    }
                } else if (idColuna == COLUNA_A) {
                    if (pecaNaCasa != null) {
                        char charPeca = pecaNaCasa.getTipo();
                        System.out.print(charPeca + "]");
                    } else {
                        System.out.print(" ]");
                    }
                }
                else{
                    if (pecaNaCasa != null) {
                        char charPeca = pecaNaCasa.getTipo();
                        System.out.print(charPeca + "|");
                    } else {
                        System.out.print(" |");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("  h g f e d c b a ");
        setPerspectiva(PRETO);
    }

    public static void imprimirCorAtual(){
        if(getPerspectiva() == BRANCO){
            imprimirBranco();
        }
        else{
            imprimirPreto();
        }
    }

    public static void virar(){
        if(getPerspectiva() == BRANCO){
            imprimirPreto();
        }
        else{
            imprimirBranco();
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

    public static void limpar(){
        for (int idColuna = 0; idColuna < COLUNAS; idColuna++) {
            for (int idFileira = 0; idFileira < FILEIRAS; idFileira++) {
                getCasa(idColuna, idFileira).esvaziar();
            }
        }
    }

    public static void lerFEN(String FEN){
        //Contar quantas casas foram passadas
        int contCasas = 0;

        for (int i = 0, idColuna = COLUNA_A, idFileira = OITAVA_FILEIRA; i < FEN.length(); i++) {
            switch(FEN.charAt(i)) {
                case 'r' -> new Torre(idColuna, idFileira, PRETO);
                case 'n' -> new Cavalo(idColuna, idFileira, PRETO);
                case 'b' -> new Bispo(idColuna, idFileira, PRETO);
                case 'q' -> new Rainha(idColuna, idFileira, PRETO);
                case 'k' -> new Rei(idColuna, idFileira, PRETO);
                case 'p' -> new Peao(idColuna, idFileira, PRETO);
                case 'R' -> new Torre(idColuna, idFileira, BRANCO);
                case 'N' -> new Cavalo(idColuna, idFileira, BRANCO);
                case 'B' -> new Bispo(idColuna, idFileira, BRANCO);
                case 'Q' -> new Rainha(idColuna, idFileira, BRANCO);
                case 'K' -> new Rei(idColuna, idFileira, BRANCO);
                case 'P' -> new Peao(idColuna, idFileira, BRANCO);
                case '/' -> {
                    try {
                        idFileira--;                        //Pula para a fileira de baixo.
                        getCasa(0, idFileira);       //Tenta acessar a casa para ver se ela está dentro dos limites do array. Caso contrário, entra no catch.
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("FEN digitado inválido! (Mais de 8 fileiras lidas!)");
                        limpar();
                        return;
                    }
                    idColuna = COLUNA_A;   //Recomeça da Coluna A.
                    continue;
                }
                default ->{
                    try{
                        int pulos = Integer.parseInt(String.valueOf(FEN.charAt(i)));  //Tenta converter o char para inteiro. Caso não consiga, entra no catch.

                        try {
                            idColuna += pulos;
                            contCasas += pulos;
                            getCasa(idColuna - 1, 0);  //Tenta acessar a casa ANTERIOR para ver se ela está dentro dos limites do array (Já que a Coluna H também pode ser pulada). Caso contrário, entra no catch.
                            continue;
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("FEN digitado inválido! (Mais de 8 colunas lidas!)");
                            limpar();
                            return;
                        }
                    }
                    catch(NumberFormatException e){
                        System.out.println("FEN digitado inválido! (Caracter inválido!)");  //Foi passado um caracter diferente de um número e dos listados acima.
                        limpar();
                        return;
                    }
                }
            }

            try {
                if(i != FEN.length() - 1) {           //Se não for a última iteração,
                    if (FEN.charAt(i + 1) != '/') {   //Verificar se o próximo char é uma quebra de fileira.
                        idColuna++;
                        getCasa(idColuna, 0);   //Tenta acessar a casa para ver se ela está dentro dos limites do array. Caso contrário, entra no catch.
                    }
                }
                contCasas++;
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("FEN digitado inválido! (Mais de 8 colunas lidas!)");
                limpar();
                return;
            }
        }
        if(contCasas < 64){
            System.out.println("FEN digitado inválido! (Menos de 64 casas lidas!)");
            limpar();
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

    public static void refreshCasasLegais() {
        for (Peca p : pecasNoTabuleiro) {
            p.setCasasLegais();
        }
    }

    public static void uniteCasasLegais() {
        casasLegaisPecasBrancas.clear();
        casasLegaisPecasPretas.clear();

        for (Peca p : pecasNoTabuleiro) {
            if (p.getCor() == BRANCO) {
                casasLegaisPecasBrancas.addAll(p.getCasasLegais());
            } else {
                casasLegaisPecasPretas.addAll(p.getCasasLegais());
            }
        }
    }

    public static void refreshFiltroCasasLegais() {
        for (Peca p : pecasNoTabuleiro) {
            p.filtrarCasasLegais();
        }
    }

    public static void refreshCravaPecas(){
        getReiBranco().cravaPecas();
        getReiPreto().cravaPecas();
    }

    public static void clearCasasDeBloqueio() {
        casasDeBloqueioBrancas.clear();
        casasDeBloqueioPretas.clear();
    }

    public static void clearCasasLegais() {
        casasLegaisPecasBrancas.clear();
        casasLegaisPecasPretas.clear();
    }

    public static void refreshIsInCheck() {
        reiBranco.isInCheck();
        reiPreto.isInCheck();
    }

    public static void refreshIsCheckmated() {
        reiBranco.isCheckmated();
        reiPreto.isCheckmated();
    }

    public static void refreshIsAtacked(){
        for (int idColuna = 0; idColuna < COLUNAS; idColuna++) {
            for (int idFileira = 0; idFileira < FILEIRAS; idFileira++) {
                getCasa(idColuna, idFileira).isAtacked().clear();
            }
        }
    }

    public static void resetPecasAtacantes() {
        reiBranco.setPecasAtacantes(0);
        reiPreto.setPecasAtacantes(0);
    }

    public static void moverPeca(int colOrigem, int filOrigem, int colDestino, int filDestino) {
        Scanner sc = new Scanner(System.in);

        Casa casaOrigem = getCasa(colOrigem, filOrigem);
        Casa casaDestino = getCasa(colDestino, filDestino);

        Peca peca = casaOrigem.getPeca();
        Peca pecaCasaDestino = casaDestino.getPeca();

        boolean movimentoLegal = peca.getCasasLegais().contains(casaDestino);
        if (movimentoLegal) { //Se é um movimento legal...
            peca.setJaMoveu(true);
            peca.setPos(colDestino, filDestino); //Mova a peça para a casa desejada,
            peca.setCasa(casaDestino); //Guarde a casa nova na instância da peça,

            casaDestino.setPeca(peca); //Guarde a instância da peça na casa nova.

            casaOrigem.setPeca(null); //Esvazie a casa antiga.

            if (peca instanceof Peao) {
                //EN PASSANT

                int deslocamento = (peca.getCor() == BRANCO) ? 1 : -1;

                if (filDestino == filOrigem + 2 * deslocamento) {
                    ((Peao) peca).setJogadaDuasCasas(jogadas);
                }

                if(colOrigem != colDestino){
                    if(pecaCasaDestino == null){
                        if(((Peao) peca).getAlvoEnPassant() != null) {
                            pecasNoTabuleiro.remove(((Peao) peca).getAlvoEnPassant());
                            ((Peao) peca).getAlvoEnPassant().getCasa().esvaziar();
                            ((Peao) peca).getAlvoEnPassant().setCasa(null);
                        }
                    }
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
                    int tc = peca.getColuna();
                    int tf = peca.getFileira();
                    pecasNoTabuleiro.remove(peca);

                    // setando peca null
                    // ifs para caso seja preta ou branca
                    Peca p = null;
                    p = switch (novapeca) {
                        case 'r' -> new Torre(tc, tf, PRETO);
                        case 'n' -> new Cavalo(tc, tf, PRETO);
                        case 'b' -> new Bispo(tc, tf, PRETO);
                        case 'q' -> new Rainha(tc, tf, PRETO);
                        case 'R' -> new Torre(tc, tf, BRANCO);
                        case 'N' -> new Cavalo(tc, tf, BRANCO);
                        case 'B' -> new Bispo(tc, tf, BRANCO);
                        case 'Q' -> new Rainha(tc, tf, BRANCO);
                        default -> {
                            System.out.println("Peça inválida.");
                            yield null;
                        }
                    };
                    pecasNoTabuleiro.add(p);
                    p.setCasa(casaDestino);
                    casaDestino.setPeca(p);
                }

            }
            jogadas++;
            imprimirCorAtual();
            //virar();                  //Vire o tabuleiro.

        } else{
            System.out.println("Movimento ilegal!");
            imprimirCorAtual();
        }

    }
    public static void moverTorreNoRoque(int colOrigem, int filOrigem, int colDestino, int filDestino) {
        Scanner sc = new Scanner(System.in);

        Casa casaOrigem = getCasa(colOrigem, filOrigem);
        Casa casaDestino = getCasa(colDestino, filDestino);

        Peca peca = casaOrigem.getPeca();
        Peca pecaCasaDestino = casaDestino.getPeca();

        boolean movimentoLegal = peca.getCasasLegais().contains(casaDestino);
        if (movimentoLegal) { //Se é um movimento legal...
            peca.setJaMoveu(true);
            peca.setPos(colDestino, filDestino); //Mova a peça para a casa desejada,
            peca.setCasa(casaDestino); //Guarde a casa nova na instância da peça,

            casaDestino.setPeca(peca); //Guarde a instância da peça na casa nova.

            casaOrigem.setPeca(null); //Esvazie a casa antiga.

        } else{
            System.out.println("Movimento ilegal!");
        }

    }

    public static int getJogadas(){
        return jogadas;
    }
    public static void increaseDecreaseJogadas(int jogadas){
        Tabuleiro.jogadas += jogadas;
    }

    public static ArrayList<Peca> getPecasNoTabuleiro(){
        return pecasNoTabuleiro;
    }

    public static Rei getReiPreto() {
        return reiPreto;
    }
    public static void setReiBranco(Rei reiBranco) {
        Tabuleiro.reiBranco = reiBranco;
    }

    public static void setReiPreto(Rei reiPreto) {
        Tabuleiro.reiPreto = reiPreto;
    }
    public static Rei getReiBranco() {
        return reiBranco;
    }
}


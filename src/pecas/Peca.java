package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;
import Tabuleiro.BoardIterator;
import Tabuleiro.Pos;
import Tabuleiro.Dir;

import java.util.ArrayList;

import static Tabuleiro.Casa.BY_BLACK;
import static Tabuleiro.Casa.BY_WHITE;
import static Tabuleiro.Tabuleiro.*;

public abstract class Peca {
    protected Pos pos;
    protected char tipo;
    protected int cor;
    protected Casa casa;
    protected ArrayList<Casa> casasLegais;
    protected boolean jaMoveu;
    protected boolean estaCravada;

    protected static final int X = 0;
    protected static final int Y = 1;

    protected static final Dir N = new Dir(0, 1);
    protected static final Dir E = new Dir(1, 0);
    protected static final Dir S = new Dir(0, -1);
    protected static final Dir W = new Dir(-1, 0);
    protected static final Dir NE = new Dir(1, 1);
    protected static final Dir SE = new Dir(1, -1);
    protected static final Dir SW = new Dir(-1, -1);
    protected static final Dir NW = new Dir(-1, 1);


    public Peca(int coluna, int fileira, int cor){
        Casa casaInicial = Tabuleiro.getCasa(coluna, fileira);

        this.pos = new Pos(coluna, fileira);
        this.cor = cor;
        this.casa = casaInicial;    //Setta a casa correspondente como a sua casa.
        casaInicial.setPeca(this);  //Setta a peça da sua casa como si própria.
        this.jaMoveu = false;
        this.estaCravada = false;

        Tabuleiro.getPecasNoTabuleiro().add(this); //Se adiciona no Array List do Tabuleiro.
    }

    public Pos getPos() {
        return pos;
    }
    public void setPos(int coluna, int fileira) {
        this.pos = new Pos(coluna, fileira);
    }

    public boolean jaMoveu(){
        return this.jaMoveu;
    }
    public void setJaMoveu(boolean move){
        this.jaMoveu = move;
    }
    public boolean estaCravada(){
        return this.estaCravada;
    }
    public void setEstaCravada(boolean esta){
        this.estaCravada = esta;
    }

    public int getColuna(){
        return pos.getColuna();
    }
    public void setColuna(int coluna){
        pos.setColuna(coluna);
    }

    public int getFileira(){
        return pos.getFileira();
    }
    public void setFileira(int fileira){
        pos.setFileira(fileira);
    }

    public char getTipo() {
        return tipo;
    }

    public int getCor() {
        return cor;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
    public Casa getCasa() {
        return casa;
    }

    public abstract void setCasasLegais();

    protected void analisarDirecao(BoardIterator iter) {
        ArrayList<Casa> arrayCorrespondente = (this.getCor() == BRANCO) ? casasLegaisPecasBrancas : casasLegaisPecasPretas;
        int byCorAtual = (getCor() == BRANCO)? BY_WHITE : BY_BLACK;

        int horizontalDir = iter.getHorizontalDir();
        int verticalDir = iter.getVerticalDir();

        int idColuna = iter.getInitialColuna() + horizontalDir;
        int idFileira = iter.getInitialFileira() + verticalDir;

        while(dentroTabuleiro(idColuna, idFileira)) {
            Casa casaNoCaminho = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão nessa direção.
            Peca pecaNoCaminho = casaNoCaminho.getPeca();  //Peças que estão (ou não) nessas casas.

            //Caminho está livre, logo é um movimento legal.
            if (pecaNoCaminho == null) {
                casasLegais.add(casaNoCaminho);
                arrayCorrespondente.add(casaNoCaminho);
                casaNoCaminho.setAtacked(byCorAtual);

                idColuna   +=  horizontalDir;
                idFileira  +=  verticalDir;
                continue;
            }

            //Se tem uma peça no caminho, pegue a cor dela.
            int corPecaNoCaminho = pecaNoCaminho.getCor();

            //Se a peça for da mesma cor, o caminho está bloqueado
            //Apenas marque essa casa como 'atacada' para impedir
            //que o rei inimigo consiga capturar essa peça aliada.
            if (corPecaNoCaminho == getCor()) {
                casaNoCaminho.setAtacked(byCorAtual);
                return;
            }

            //Como a peça é de outra cor, podemos capturar
            casasLegais.add(casaNoCaminho);
            arrayCorrespondente.add(casaNoCaminho);
            casaNoCaminho.setAtacked(byCorAtual);

            //Se a peça não for o rei adversário, mais nada a ser feito.
            if( !(pecaNoCaminho instanceof Rei)  ) {
                return;
            }

            //Processo de busca por casas de bloqueio
            ((Rei) pecaNoCaminho).setIsInCheck(true);
            ((Rei) pecaNoCaminho).incPecasAtacantes();

            int nextColuna = idColuna + horizontalDir;
            int nextFileira = idFileira + verticalDir;

            //Adiciona a casa imediatamente a frente como atacked.
            //Evita que o rei 'bloqueie' a si mesmo kkkk.
            if(dentroTabuleiro(nextColuna, nextFileira)){
                Tabuleiro.getCasa(nextColuna, nextFileira).setAtacked(byCorAtual);
            }

            idColuna = pecaNoCaminho.getColuna() - horizontalDir;
            idFileira = pecaNoCaminho.getFileira() - verticalDir;

            while (dentroTabuleiro(idColuna, idFileira)){ // Aqui fazemos um loop voltando para pegar as casas de bloqueio.
                Casa casaNoCaminhoVolta = Tabuleiro.getCasa(idColuna, idFileira); //Casas que estão na mesma fileira.
                if(corPecaNoCaminho == BRANCO){
                    Tabuleiro.casasDeBloqueioBrancas.add(casaNoCaminhoVolta);
                }
                else{
                    Tabuleiro.casasDeBloqueioPretas.add(casaNoCaminhoVolta);
                }
                idColuna  -= horizontalDir;
                idFileira -= verticalDir;
            }
            return; //Caminho está bloqueado.
        }
    }

    public void filtrarCasasLegais(){

        //Checagem de cheque duplo
        int pecasAtacantesDoMeuRei = (this.getCor() == BRANCO)? getReiBranco().getPecasAtacantes() : getReiPreto().getPecasAtacantes();
        //ArrayList<Casa> casasLegaisCorrespondente = (this.getCor() == BRANCO)? casasLegaisPecasBrancas : casasLegaisPecasPretas;

        if(pecasAtacantesDoMeuRei == 2){
            this.casasLegais.clear();
            return;
        }

        //Checagem de cheque único e interseção com casas de bloqueio.
        ArrayList<Casa> casasBloqueioCorrespondente = (this.getCor() == BRANCO)? casasDeBloqueioBrancas : casasDeBloqueioPretas;

        if(pecasAtacantesDoMeuRei == 1) {

            ArrayList<Casa> temp = new ArrayList<>();
            for (Casa casa : this.casasLegais) {
                if (casasBloqueioCorrespondente.contains(casa)) {
                    temp.add(casa);  //Busca apenas a interseção das duas listas.
                }
            }
            this.casasLegais.clear(); //Esvazia as casas legais,
            this.casasLegais = temp;  //e troca pela interseção encontrada.
        }
    }

    public ArrayList<Casa> getCasasLegais(){
        return this.casasLegais;
    }
}
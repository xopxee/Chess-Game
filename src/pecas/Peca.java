package pecas;

import Tabuleiro.Casa;
import Tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static Tabuleiro.Tabuleiro.*;

public abstract class Peca {
    protected int[] pos = new int[2];
    protected char tipo;
    protected int cor;
    protected Casa casa;
    protected ArrayList<Casa> casasLegais;
    protected boolean jaMoveu;

    protected static final int X = 0;
    protected static final int Y = 1;

    public Peca(int coluna, int fileira, int cor){
        Casa casaInicial = Tabuleiro.getCasa(coluna, fileira);

        this.pos[X] = coluna;
        this.pos[Y] = fileira;
        this.cor = cor;
        this.casa = casaInicial;    //Setta a casa correspondente como a sua casa.
        casaInicial.setPeca(this);  //Setta a peça da sua casa como si própria.
        this.jaMoveu = false;

        Tabuleiro.getPecasNoTabuleiro().add(this); //Se adiciona no Array List do Tabuleiro.
    }

    public int[] getPos() {
        return pos;
    }
    public void setPos(int coluna, int fileira) {
        this.pos[X] = coluna;
        this.pos[Y] = fileira;
    }

    public boolean jaMoveu(){
        return this.jaMoveu;
    }
    public void setJaMoveu(boolean move){
        this.jaMoveu = move;
    }

    public int getColuna(){
        return pos[X];
    }
    public void setColuna(int coluna){
        this.pos[X] = coluna;
    }

    public int getFileira(){
        return pos[Y];
    }
    public void setFileira(int fileira){
        this.pos[Y] = fileira;
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

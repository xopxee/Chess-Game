package Tabuleiro;

public class BoardIterator {
    private final Pos initial_pos;
    private final Dir iter_dir;

    public BoardIterator(Pos initial_pos, Dir iter_dir) {
        this.initial_pos = initial_pos;
        this.iter_dir = iter_dir;
    }

    public Dir getDir() {
        return iter_dir;
    }
    public int getHorizontalDir() {
        return iter_dir.getHorizontalDir();
    }
    public int getVerticalDir() {
        return iter_dir.getVerticalDir();
    }

    public Pos getPos() {
        return initial_pos;
    }
    public int getInitialColuna() {
        return initial_pos.getColuna();
    }
    public int getInitialFileira() {
        return initial_pos.getFileira();
    }
}

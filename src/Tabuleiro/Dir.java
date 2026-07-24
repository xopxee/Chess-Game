package Tabuleiro;

public class Dir {
    private final int horizontalDir;
    private final int verticalDir;

    public Dir(int horizontalDir, int verticalDir){
        this.horizontalDir = horizontalDir;
        this.verticalDir = verticalDir;
    }

    public int getHorizontalDir() {
        return horizontalDir;
    }
    public int getVerticalDir() {
        return verticalDir;
    }

    public Dir rev() {
        return new Dir(-horizontalDir, -verticalDir);
    }
}

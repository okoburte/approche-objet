package TPClasse;

public class Point {
    final int INIT_X = 25;
    final int INIT_Y = 25;

    private int x;
    private int y;

    Point(){
        this.x = INIT_X;
        this.y = INIT_Y;
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ";" + y + "]";
    }
}

package TPClasse;

public class Rond {
    private Point point;
    private int r;

    Rond(Point point, int r){
        this.point = point;
        this.r = r;
    }

    @Override
    public String toString() {
        return "[ROND " + point.toString() + ", " + r + "]";
    }

    public void affiche(){
        System.out.println(toString());
    }
}

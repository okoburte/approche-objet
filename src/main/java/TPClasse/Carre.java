package TPClasse;

public class Carre extends Rectangle {
    Point point;
    int x;

    Carre(Point point, int x){
        super(point, x, x);
    }

    @Override
    protected String getType() {
        return "CARRE";
    }
}

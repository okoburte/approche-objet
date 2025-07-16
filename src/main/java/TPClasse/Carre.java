package TPClasse;

public class Carre extends Rectangle {

    Carre(Point point, int x){
        super(point, x, x);
    }

    @Override
    protected String getType() {
        return "CARRE";
    }
}

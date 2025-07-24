package TPClasse;

public class Carre extends Rectangle {

    Carre(Point point, int x) throws DessinHorsLimiteException {
        super(point, x, x);
    }

    Carre(Point point, int x, Couleur couleur) throws DessinHorsLimiteException {
        super(point, x, x, couleur);
    }

    @Override
    protected String getType() {
        return "CARRE";
    }

    @Override
    public String sauvegarde() {
        return "" + super.getX();
    }
}

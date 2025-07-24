package TPClasse;

import java.util.ArrayList;
import java.util.List;

public class Rond extends Figure implements Surfacable{
    private int r;

    Rond(Point point, int r){
        super.startingPoint = point;
        this.r = r;
        super.couleur = Couleur.getCouleurDefault();
    }

    Rond(Point point, int r, Couleur couleur){
        this(point, r);
        super.couleur = couleur;
    }

    @Override
    public String toString() {
        return "[" + getType() + " " + couleur.toString() + " " + startingPoint.toString() + ", " + r + "]";
    }

    @Override
    public boolean couvre(Point point) {
        return Point.getDistance(startingPoint, point) == r;
    }

    @Override
    public double distanceOrigine() {
        return r;
    }

    @Override
    public String sauvegarde() {
        return "" + r;
    }

    public Point getPoint(){
        return startingPoint;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()))) return false;

        Rond compareRond = (Rond) obj;
        return getPoint().equals(compareRond.getPoint()) && r == compareRond.r && getCouleur().equals(compareRond.getCouleur());
    }

    protected String getType() {
        return "ROND";
    }

    @Override
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(startingPoint);
        return points;
    }

    @Override
    public double surface() {
        return Math.PI * r * r;
    }
}

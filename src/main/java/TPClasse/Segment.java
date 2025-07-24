package TPClasse;

import java.util.ArrayList;
import java.util.List;

public class Segment extends Figure{
    int lenght;
    boolean horizontal;

    Segment (Point point, int lenght, boolean horizontal){
        super.startingPoint = point;
        this.lenght = lenght;
        this.horizontal = horizontal;
        super.couleur = Couleur.getCouleurDefault();
    }

    Segment (Point point, int lenght, boolean horizontal, Couleur couleur){
        this(point, lenght, horizontal);
        super.couleur = couleur;
    }

    @Override
    public String toString() {
        int x = startingPoint.getX();
        int y = startingPoint.getY();
        if(horizontal) x += lenght;
        else y += lenght;
        Point endPoint = null;
        try {
            endPoint = new Point(x, y);
        } catch (DessinHorsLimiteException e) {
            throw new RuntimeException(e);
        }
        return "[" + getType() + " " + couleur.toString() + " " + startingPoint.toString() + " à " + endPoint.toString();
    }

    @Override
    public boolean couvre(Point point) {
        if(horizontal){
            return point.getX() >= startingPoint.getX() && point.getX() <= startingPoint.getX() + lenght;
        }
        else {
            return point.getY() >= startingPoint.getY() && point.getY() <= startingPoint.getY() + lenght;
        }
    }

    @Override
    public double distanceOrigine() {
        return lenght;
    }

    @Override
    public String sauvegarde() {
        return lenght + "," + horizontal;
    }

    @Override
    public Point getPoint() {
        return startingPoint;
    }

    public Point getEndPoint() throws DessinHorsLimiteException {
        int x = startingPoint.getX();
        int y = startingPoint.getY();
        if(horizontal) x += lenght;
        else y += lenght;
        return new Point(x, y);
    }

    @Override
    protected String getType() {
        return "SEGMENT";
    }

    @Override
    public List<Point> getPoints() throws DessinHorsLimiteException {
        List<Point> points = new ArrayList<>();
        points.add(startingPoint);
        points.add(getEndPoint());
        return points;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()))) {
            return false;
        }

        Segment compareSegment = (Segment) obj;
        return startingPoint.equals(compareSegment.startingPoint) &&  lenght == compareSegment.lenght &&  horizontal == compareSegment.horizontal && getCouleur().equals(compareSegment.getCouleur());
    }
}

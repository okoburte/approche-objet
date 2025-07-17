package TPClasse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rond extends Figure implements Surfacable{
    private Point point;
    private int r;

    Rond(Point point, int r){
        this.point = point;
        this.r = r;
    }

    @Override
    public String toString() {
        return "[" + getType() + " " + point.toString() + ", " + r + "]";
    }

    @Override
    public boolean couvre(Point point) {
        return Point.getDistance(this.point, point) == r;
    }

    public Point getPoint(){
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()))) return false;

        Rond compareRond = (Rond) obj;
        return getPoint().equals(compareRond.getPoint()) && r == compareRond.r;
    }

    protected String getType() {
        return "ROND";
    }

    @Override
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(point);
        return points;
    }

    @Override
    public double surface() {
        return Math.PI * r * r;
    }
}

package TPClasse;

import java.util.Arrays;
import java.util.List;

public class Rectangle extends Figure implements Surfacable{
    private Point point;
    private Point[] points = new Point[4];
    private int x;
    private int y;

    Rectangle(Point point, int x, int y){
        this.point = point;
        this.x = x;
        this.y = y;
        setPoints();
    }

    void setPoints(){
        for (int i = 0; i < points.length; i++) {
            int x = point.getX();
            int y = point.getY();
            if(i%2 != 0) x += this.x;
            if(i >= 2) y += this.y;
            points[i] = new Point(x, y);
        }
    }

    public List<Point> getPoints(){
        return List.of(points);
    }

    @Override
    public String toString() {
        return "[" + getType() + " "
                + points[0].toString()
                + points[1].toString()
                + points[2].toString()
                + points[3].toString()
                + "]";
    }

    @Override
    public boolean couvre(Point point) {
        if(points[0].getX() <= point.getX() && points[0].getX() + x >= point.getX() && points[0].getY() == point.getY()) return true;
        if(points[0].getY() <= point.getY() && points[0].getY() + y >= point.getY() && points[0].getY() == point.getY()) return true;
        if(points[3].getX() <= point.getX() && points[3].getX() + x >= point.getX() && points[0].getX() == point.getX()) return true;
        if(points[3].getY() <= point.getY() && points[3].getY() + y >= point.getY() && points[0].getX() == point.getX()) return true;
        return false;
    }

    public Point getPoint() {
        return point;
    }

    protected String getType(){
        return "RECTANGLE";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()))) {
            return false;
        }
        return getPoints().containsAll(((Rectangle)obj).getPoints());
    }

    @Override
    public double surface() {
        return x*y;
    }

    public double getDiagonal(){
        return Point.getDistance(points[0], points[3]);
    }
}

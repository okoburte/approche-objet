package TPClasse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle extends Figure implements Surfacable {
    Point[] points;

    Triangle(Point[] points) {
        this.points = points;
    }

    @Override
    public Point getPoint() {
        return points[0];
    }

    @Override
    protected String getType() {
        return "TRIANGLE";
    }

    @Override
    public List<Point> getPoints() {
        return Arrays.asList(points);
    }

    @Override
    public String toString() {
        return "[" + getType() + ", " + points[0] + ", " + points[1] + ", " + points[2] + "]";
    }

    @Override
    public boolean couvre(Point point) {
        boolean result = false;
        for(Point p : points) {
            if(p.equals(point)) return true;
        }
        for (int i = 0; i < points.length; i++) {
            if(i < points.length - 1) {
                result = (point.getX() - points[i].getX())*(points[i].getY() - points[i+1].getY()) == (points[i].getY() - point.getY())*(points[i].getX() - points[i+1].getX());
                if(!result) continue;
                result = Math.min(points[i].getX(), points[i+1].getX()) <= point.getX() && Math.max(points[i].getX(), points[i+1].getX()) >= point.getX();
                if(!result) continue;
                result = Math.min(points[i].getY(), points[i+1].getY()) <= point.getY() && Math.max(points[i].getY(), points[i+1].getY()) >= point.getY();
                if(result) return result;
            }
        }
        return false;
    }

    @Override
    public double surface() {
        double  surface = 0;
        for (int i = 0; i < points.length; i++) {
            if(i == points.length - 1) {
                surface += Point.getDistance(points[i], points[0]);
            }
            else {
                surface += Point.getDistance(points[i], points[i + 1]);
            }
        }
        return surface;
    }
}

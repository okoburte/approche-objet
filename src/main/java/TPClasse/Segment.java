package TPClasse;

import java.util.ArrayList;
import java.util.List;

public class Segment extends Figure{
    Point startingPoint;
    int lenght;
    boolean horizontal;

    Segment (Point point, int lenght, boolean horizontal){
        this.startingPoint = point;
        this.lenght = lenght;
        this.horizontal = horizontal;
    }

    @Override
    public String toString() {
        int x = startingPoint.getX();
        int y = startingPoint.getY();
        if(horizontal) x += lenght;
        else y += lenght;
        Point endPoint = new Point(x, y);
        return "[" + getType() + " " + startingPoint.toString() + " à " + endPoint.toString();
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
    public Point getPoint() {
        return startingPoint;
    }

    public Point getEndPoint() {
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
    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        points.add(startingPoint);
        points.add(getEndPoint());
        return points;
    }

    @Override
    public boolean equals(Object obj) {
        Segment compareSegment = (Segment) obj;
        return startingPoint.equals(compareSegment.startingPoint) &&  lenght == compareSegment.lenght &&  horizontal == compareSegment.horizontal;
    }
}

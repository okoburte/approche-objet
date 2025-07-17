package TPClasse;

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
    public Point[] getPoints() {
        return new Point[]{startingPoint, getEndPoint()};
    }

    @Override
    public boolean equals(Object obj) {
        Segment compareSegment = (Segment) obj;
        return startingPoint.equals(compareSegment.startingPoint) &&  lenght == compareSegment.lenght &&  horizontal == compareSegment.horizontal;
    }
}

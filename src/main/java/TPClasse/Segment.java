package TPClasse;

public class Segment extends Figure implements Surfacable{
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

    @Override
    protected String getType() {
        return "SEGMENT";
    }

    @Override
    public double surface() {
        return lenght;
    }
}

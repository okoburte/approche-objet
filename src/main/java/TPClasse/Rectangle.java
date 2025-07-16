package TPClasse;

public class Rectangle {
    private Point point;
    private int x;
    private int y;

    Rectangle(Point point, int x, int y){
        this.point = point;
        this.x = x;
        this.y = y;
    }

    Point getPointBasGauche(){
        return point;
    }

    Point getPointBasDroite(){
        return new Point(point.getX() + x, point.getY());
    }

    Point getPointHautGauche(){
        return new Point(point.getX(), point.getY() + y);
    }

    Point getPointHautDroite(){
        return new Point(point.getX() + x, point.getY() + y);
    }

    @Override
    public String toString() {
        return "[" + getType() + " "
                + getPointBasGauche().toString()
                + getPointBasDroite().toString()
                + getPointHautGauche().toString()
                + getPointHautDroite().toString()
                + "]";
    }

    public void affiche(){
        System.out.println(this);
    }

    protected String getType(){
        return "RECTANGLE";
    }
}

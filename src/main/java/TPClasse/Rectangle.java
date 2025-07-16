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

    @Override
    public boolean equals(Object obj) {
        if(!this.getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(this.getClass())) {
            System.out.println("not same class");
            return false;
        }
        Rectangle compareRect = (Rectangle) obj;
        return getPointBasGauche().equals(compareRect.getPointBasGauche())
                && getPointBasDroite().equals(compareRect.getPointBasDroite())
                && getPointHautGauche().equals(compareRect.getPointHautGauche())
                && getPointHautDroite().equals(compareRect.getPointHautDroite()) ;
    }
}

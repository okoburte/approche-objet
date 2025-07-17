package TPClasse;

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
    public Point[] getPoints() {
        return new Point[]{point};
    }

    @Override
    public double surface() {
        return Math.PI * r * r;
    }
}

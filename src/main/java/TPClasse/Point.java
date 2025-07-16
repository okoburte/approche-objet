package TPClasse;

public class Point {
    final int INIT_X = 25;
    final int INIT_Y = 25;

    private int x;
    private int y;

    Point(){
        this.x = INIT_X;
        this.y = INIT_Y;
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x + ";" + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || !getClass().isAssignableFrom(obj.getClass())) return false;
        Point comparePoint = (Point) obj;
        return (x == comparePoint.x) && (y == comparePoint.y);
    }

    static public double getDistance(Point p1, Point p2){
        int difX = Math.abs(p1.getX() - p2.getX());
        int difY = Math.abs(p1.getY() - p2.getY());
        return Math.sqrt((difX*difX) + (difY*difY));
    }
}

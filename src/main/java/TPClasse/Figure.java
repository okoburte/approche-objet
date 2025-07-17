package TPClasse;

import java.util.List;

public abstract class Figure{
    public static final int NB_FIGURE_TYPE = 5;

    public void affiche(){
        System.out.println(this);
    }

    public abstract Point getPoint();
    protected abstract String getType();
    public abstract List<Point> getPoints();
    public abstract String toString();
    public abstract boolean couvre(Point point);
}

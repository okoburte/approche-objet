package TPClasse;

import java.util.List;

public abstract class Figure implements Comparable<Figure>{
    public static final int NB_FIGURE_TYPE = 4;

    Couleur couleur;
    Point startingPoint;

    public void affiche(){
        System.out.println(this);
    }

    public abstract Point getPoint();
    protected abstract String getType();
    public abstract List<Point> getPoints() throws DessinHorsLimiteException;
    public abstract String toString();
    public abstract boolean couvre(Point point);
    public abstract double distanceOrigine();
    public abstract String sauvegarde();

    public Couleur getCouleur(){
        return couleur;
    }

    public int compareTo(Figure o) {
        if(distanceOrigine() - o.distanceOrigine() == 0) return 0;
        else if (distanceOrigine() - o.distanceOrigine() < 0) return 1;
        else return -1;
    }
}

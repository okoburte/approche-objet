package TPClasse;

public abstract class Figure{
    public static final int NB_FIGURE_TYPE = 4;

    public void affiche(){
        System.out.println(this);
    }

    public abstract Point getPoint();
    protected abstract String getType();
    public abstract  Point[] getPoints();
}

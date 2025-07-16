package TPClasse;

public class TestFigure {
    public static void main(String[] args) {
        Point p1 = new Point(2, 5);
        Point p2 = new Point(5, 2);
        Carre carre = new Carre(p1, 5);
        Rectangle rectangle = new Rectangle(p2, 3, 4);

        carre.affiche();
        rectangle.affiche();
    }
}

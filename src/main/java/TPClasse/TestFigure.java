package TPClasse;

public class TestFigure {
    public static void main(String[] args) {
        Point p1 = new Point(2, 5);
        Carre carre1 = new Carre(p1, 5);
        Carre carre3 = new Carre(p1, 5);
        Rectangle rectangle1 = new Rectangle(p1, 5, 5);
        Rectangle rectangle3 = new Rectangle(p1, 5, 5);

        carre1.affiche();
        rectangle1.affiche();

        Carre carre2 = FigureUtil.getRandomCarre(20, 20, 10);
        Rectangle rectangle2 = FigureUtil.getRandomRectangle(20, 20, 10, 5);
        Rectangle rectangleCarre = FigureUtil.getRandomCarre(20, 20, 8);
        Rond rond1 = FigureUtil.getRandomRond(20, 20, 10);

        carre2.affiche();
        rectangle2.affiche();
        rectangleCarre.affiche();

        System.out.println(carre1.equals(rectangle1));
        System.out.println(rectangle1.equals(carre1));
        System.out.println(rectangle1.equals(rectangle3));
        System.out.println(carre2.equals(carre1));
        System.out.println(carre1.equals(carre3));
        System.out.println(carre1.equals(rond1));
    }
}

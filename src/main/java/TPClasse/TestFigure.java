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
        Figure figure1 = FigureUtil.getRandomFigure(20, 20, 10, 10);
        Segment segment1 = FigureUtil.getRandomSegment(20, 20, 10);

        carre2.affiche();
        rectangle2.affiche();
        rectangleCarre.affiche();
        rond1.affiche();
        figure1.affiche();
        segment1.affiche();

        System.out.println("La surface de carre2 = " + carre2.surface());
        System.out.println("La surface de rectangle2 = " + rectangle2.surface());
        System.out.println("La surface de rond1 = " + rond1.surface());
        System.out.println("La surface de figure1 = " + figure1.surface());
        System.out.println("La surface de segment1 = " + segment1.surface());
        System.out.println("La diagonale de carre2 = " + carre2.getDiagonal());
        System.out.println("La diagonale de rectangle2 = " + rectangle2.getDiagonal());
    }
}

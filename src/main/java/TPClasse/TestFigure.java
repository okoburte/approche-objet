package TPClasse;

import java.util.Arrays;

public class TestFigure {
    public static void main(String[] args) {
        Carre carre2 = FigureUtil.getRandomCarre(20, 20, 10);
        Rectangle rectangle2 = FigureUtil.getRandomRectangle(20, 20, 10, 5);
        Rectangle rectangleCarre = FigureUtil.getRandomCarre(20, 20, 8);
        Rond rond1 = FigureUtil.getRandomRond(20, 20, 10);
        Figure figure1 = FigureUtil.getRandomFigure(20, 20, 10, 10);
        Segment segment1 = FigureUtil.getRandomSegment(20, 20, 10);
        Surfacable surfacable1 = FigureUtil.getRandomSurfacable(20, 20, 10, 10);

        System.out.println("Random carre :");
        carre2.affiche();
        System.out.println("Random rectangle :");
        rectangle2.affiche();
        System.out.println("Random rond :");
        rond1.affiche();
        System.out.println("Random segment :");
        segment1.affiche();
        System.out.println("Random figure :");
        figure1.affiche();
        System.out.println("Random surface :");
        surfacable1.affiche();

        System.out.println("La surface de carre2 = " + carre2.surface());
        System.out.println("La surface de rectangle2 = " + rectangle2.surface());
        System.out.println("La surface de rond1 = " + rond1.surface());
        System.out.println("La diagonale de carre2 = " + carre2.getDiagonal());
        System.out.println("La diagonale de rectangle2 = " + rectangle2.getDiagonal());

        System.out.println("liste des points de carre2, rectangle2, rond1, segment1, figure1 :");
        System.out.println(Arrays.toString(FigureUtil.getPoints(carre2, rectangle2, rond1, segment1, figure1)));
    }
}

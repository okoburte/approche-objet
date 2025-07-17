package TPClasse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFigure {
    public static void main(String[] args) {

        Carre carre2 = FigureUtil.getRandomCarre(20, 20, 10);
        Rectangle rectangle2 = FigureUtil.getRandomRectangle(20, 20, 10, 5);
        Rectangle rectangleCarre = FigureUtil.getRandomCarre(20, 20, 8);
        Rond rond1 = FigureUtil.getRandomRond(20, 20, 10);
        Figure figure1 = FigureUtil.getRandomFigure(20, 20, 10, 10);
        Segment segment1 = FigureUtil.getRandomSegment(20, 20, 10);
        Surfacable surfacable1 = FigureUtil.getRandomSurfacable(20, 20, 10, 10);
        Triangle triangle1 = FigureUtil.getRandomTriangle(20, 20, 10);
        List<Figure> figures = FigureUtil.genere(5);

        Dessin dessin1 = new Dessin(figures);
        //Rectangle rectangle1 = new Rectangle(new Point(5, 5), 5, 5);
        //dessin1.addFigure(rectangle1);
        //Rond rond3 = new Rond(new Point(5, 5), 3);
        //dessin1.addFigure(rond3);
        //Segment segment2 = new Segment(new Point(5, 5), 5, true);
        //dessin1.addFigure(segment2);
        Triangle triangle2 = new Triangle(new Point[]{new Point(0, 0), new Point(5, 5), new Point(5, 0)});
        dessin1.addFigure(triangle2);
        Point p1 = new Point(2, 0);


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
        System.out.println("Random triangle :");
        triangle1.affiche();

        System.out.println("La surface de carre2 = " + carre2.surface());
        System.out.println("La surface de rectangle2 = " + rectangle2.surface());
        System.out.println("La surface de rond1 = " + rond1.surface());
        System.out.println("la surface de triangle1 = " + triangle1.surface());
        System.out.println("La diagonale de carre2 = " + carre2.getDiagonal());
        System.out.println("La diagonale de rectangle2 = " + rectangle2.getDiagonal());

        System.out.println("liste des points de carre2, rectangle2, rond1, segment1, figure1, triangle1 :");
        System.out.println(FigureUtil.getPoints(carre2, rectangle2, rond1, segment1, figure1, triangle1));

        System.out.println("Liste de 5 figures generé aleatoirement :");
        System.out.println(figures);

        System.out.println("Est ce que le dessin1 contient le point p1 :");
        System.out.println(FigureUtil.getFigureEn(p1, dessin1));
    }
}

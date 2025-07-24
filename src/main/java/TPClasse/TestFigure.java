package TPClasse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFigure {
    public static void main(String[] args) throws DessinHorsLimiteException {
        Carre carre2 = new Carre(new Point(0, 0), 0);
        Rectangle rectangle2 = new Rectangle(new Point(0, 0), 0, 0);
        Rond rond1 = new Rond(new Point(0, 0), 0);
        Figure figure1;
        Segment segment1;
        Surfacable surfacable1;
        List<Figure> figures = new ArrayList<>();

        carre2 = FigureUtil.getRandomCarre(20, 20, 10, "carre2");
        rectangle2 = FigureUtil.getRandomRectangle(20, 20, 10, 5, "rectangle2");
        rond1 = FigureUtil.getRandomRond(20, 20, 10, "rond1");
        figure1 = FigureUtil.getRandomFigure(20, 20, 10, 10, "figure1");
        segment1 = FigureUtil.getRandomSegment(20, 20, 10, "segment1");
        surfacable1 = FigureUtil.getRandomSurfacable(20, 20, 10, 10, "surfacable1");
        figures = FigureUtil.genere(5, "genereRandom1");


        Dessin dessin1 = new Dessin(figures);
        Rectangle rectangle1 = new Rectangle(new Point(5, 5), 5, 5, Couleur.Bleu);
        dessin1.addFigure(rectangle1);
        Rectangle rectangle3 = new Rectangle(new Point(5, 5), 5, 5, Couleur.Noir);
        dessin1.addFigure(rectangle3);
        Rond rond3 = new Rond(new Point(5, 5), 3);
        dessin1.addFigure(rond3);
        Segment segment2 = new Segment(new Point(5, 5), 5, true);
        dessin1.addFigure(segment2);
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

        System.out.println("La surface de carre2 = " + carre2.surface());
        System.out.println("La surface de rectangle2 = " + rectangle2.surface());
        System.out.println("La surface de rond1 = " + rond1.surface());
        System.out.println("La diagonale de carre2 = " + carre2.getDiagonal());
        System.out.println("La diagonale de rectangle2 = " + rectangle2.getDiagonal());

        System.out.println("liste des points de carre2, rectangle2, rond1, segment1, figure1,  :");
        System.out.println(FigureUtil.getPoints(carre2, rectangle2, rond1, segment1, figure1));

        System.out.println("Liste de 5 figures generé aleatoirement :");
        System.out.println(figures);

        System.out.println("Est ce que le dessin1 contient le point p1 :");
        System.out.println(FigureUtil.getFigureEn(p1, dessin1));

        System.out.println("Liste des figures de dessin1 trié par distance a l'origine :");
        System.out.println(FigureUtil.trieProcheOrigine(dessin1));

        System.out.println("Liste des figures de dessin1 trié par surface :");
        System.out.println(FigureUtil.trieDominant(dessin1));

        System.out.println("Rectangle1 et rectangle3 sont egaux ?");
        System.out.println(rectangle1.equals(rectangle3));

        Dessin savedDessin = FigureUtil.chargement("save.json");

        System.out.println("Ancienne sauvegarde :");
        System.out.println(FigureUtil.trieDominant(savedDessin));

        FigureUtil.sauvegarde(dessin1, "save.json");
    }
}

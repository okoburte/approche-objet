package TPClasse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class FigureUtil {
    public static Rond getRandomRond(int maxX, int maxY, int maxRadius) {
        return new Rond(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxRadius));
    }

    public static Rectangle getRandomRectangle(int maxX, int maxY, int maxLength, int maxHeight){
        return new Rectangle(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxLength), (int)Math.ceil(Math.random() * maxHeight));
    }

    public static Carre getRandomCarre(int maxX, int maxY, int maxLength){
        return  new Carre(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxLength));
    }

    static Point getRandomPoint(int maxX, int maxY){
        return new Point((int)Math.ceil(Math.random() * maxX), (int)Math.ceil(Math.random() * maxY));
    }

    public static Segment getRandomSegment(int maxX, int maxY, int maxLength) {
        return new Segment(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxLength), Math.random()>0.5);
    }

    public static Triangle getRandomTriangle(int maxX, int maxY, int maxLength) {
        Point p1 = getRandomPoint(maxX, maxY);
        Point p2 = getRandomPoint(maxX, maxY);
        while (p2.equals(p1) || Point.getDistance(p1, p2) > maxLength) {
            p2 = getRandomPoint(maxX, maxY);
        }
        Point p3 = getRandomPoint(maxX, maxY);
        while (p3.equals(p1) || p3.equals(p2) || Point.getDistance(p3, p1) > maxLength || Point.getDistance(p3, p2) > maxLength) {
            p3 = getRandomPoint(maxX, maxY);
        }
        return new Triangle(new Point[]{p1, p2, p3});
    }

    static Figure getRandomFigure(int maxX, int maxY, int maxLength, int maxHeight){
        switch ((int)Math.ceil(Math.random() * Figure.NB_FIGURE_TYPE)){
            case Surfacable.NB_SURFACABLE+1:
                return getRandomSegment(maxX, maxY, maxLength);
            default:
                return (Figure) getRandomSurfacable(maxX, maxY, maxLength, maxHeight);
        }
    }

    static Surfacable getRandomSurfacable(int maxX, int maxY, int maxLength, int maxHeight){
        switch ((int)Math.ceil(Math.random() * Surfacable.NB_SURFACABLE)){
            case 1:
                return getRandomRond(maxX, maxY, maxLength);
            case 2:
                return getRandomRectangle(maxX, maxY, maxLength, maxHeight);
            case 3:
                return getRandomCarre(maxX, maxY, maxLength);
            case 4:
                return getRandomTriangle(maxX, maxY, maxLength);
            default:
                return getRandomRectangle(maxX, maxY, maxLength, maxHeight);
        }
    }

    static List<Point> getPoints(Figure... figures){
        List<Point> points = new ArrayList<Point>();
        for(Figure figure : figures){
            points.addAll(figure.getPoints());
        }
        return points;
    }

    static List<Figure> genere(int nbFigure){
        List<Figure> figures = new ArrayList<>();
        for(int i = 0; i < nbFigure; i++){
            figures.add(getRandomFigure(89, 89, 10, 10));
        }
        return figures;
    }

    static Figure getFigureEn(Point point, Dessin dessin){
        Iterator<Figure> iFigures = dessin.getFigures().iterator();
        while(iFigures.hasNext()){
            Figure figure = iFigures.next();
            if(figure.couvre(point)){ return figure; }
        }
        return null;
    }
}

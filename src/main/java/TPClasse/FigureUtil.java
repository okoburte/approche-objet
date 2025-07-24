package TPClasse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;

public class FigureUtil {
    static Map<String, Figure> figureMap = new HashMap<>();

    public static Rond getRandomRond (int maxX, int maxY, int maxRadius, String name) throws DessinHorsLimiteException{
        Rond rond = new Rond(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxRadius), getRandomCouleur());
        figureMap.put(name, rond);
        return rond;
    }

    public static Rectangle getRandomRectangle(int maxX, int maxY, int maxLength, int maxHeight, String name)throws DessinHorsLimiteException{
        Rectangle rectangle = new Rectangle(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxLength), (int)Math.ceil(Math.random() * maxHeight), getRandomCouleur());
        figureMap.put(name, rectangle);
        return rectangle;
    }

    public static Carre getRandomCarre(int maxX, int maxY, int maxLength, String name)throws DessinHorsLimiteException{
        Carre carre = new Carre(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxLength), getRandomCouleur());
        figureMap.put(name, carre);
        return  carre;
    }

    static Point getRandomPoint (int maxX, int maxY) throws DessinHorsLimiteException {
        return new Point((int)Math.ceil(Math.random() * maxX), (int)Math.ceil(Math.random() * maxY));
    }

    public static Segment getRandomSegment(int maxX, int maxY, int maxLength, String name) throws DessinHorsLimiteException{
        Segment segment = new Segment(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxLength), Math.random()>0.5, getRandomCouleur());
        figureMap.put(name, segment);
        return segment;
    }

//    public static Triangle getRandomTriangle(int maxX, int maxY, int maxLength, String name) throws DessinHorsLimiteException{
//        Point p1 = getRandomPoint(maxX, maxY);
//        Point p2 = getRandomPoint(maxX, maxY);
//        while (p2.equals(p1) || Point.getDistance(p1, p2) > maxLength) {
//            p2 = getRandomPoint(maxX, maxY);
//        }
//        Point p3 = getRandomPoint(maxX, maxY);
//        while (p3.equals(p1) || p3.equals(p2) || Point.getDistance(p3, p1) > maxLength || Point.getDistance(p3, p2) > maxLength) {
//            p3 = getRandomPoint(maxX, maxY);
//        }
//        Triangle triangle = new Triangle(new Point[]{p1, p2, p3});
//        figureMap.put(name, triangle);
//        return triangle;
//    }

    static Figure getRandomFigure(int maxX, int maxY, int maxLength, int maxHeight, String name)throws DessinHorsLimiteException{
        switch ((int)Math.ceil(Math.random() * Figure.NB_FIGURE_TYPE)){
            case Surfacable.NB_SURFACABLE+1:
                return getRandomSegment(maxX, maxY, maxLength, name);
            default:
                return (Figure) getRandomSurfacable(maxX, maxY, maxLength, maxHeight, name);
        }
    }

    static Surfacable getRandomSurfacable(int maxX, int maxY, int maxLength, int maxHeight, String name)throws DessinHorsLimiteException{
        switch ((int)Math.ceil(Math.random() * Surfacable.NB_SURFACABLE)){
            case 1:
                return getRandomRond(maxX, maxY, maxLength, name);
            case 2:
                return getRandomRectangle(maxX, maxY, maxLength, maxHeight, name);
            case 3:
                return getRandomCarre(maxX, maxY, maxLength, name);
//            case 4:
//                return getRandomTriangle(maxX, maxY, maxLength, name);
            default:
                return getRandomRectangle(maxX, maxY, maxLength, maxHeight, name);
        }
    }

    static List<Point> getPoints(Figure... figures) throws DessinHorsLimiteException {
        List<Point> points = new ArrayList<Point>();
        for(Figure figure : figures){
            points.addAll(figure.getPoints());
        }
        return points;
    }

    static Couleur getRandomCouleur(){
        Couleur[] couleurs = Couleur.values();
        return couleurs[(int)Math.ceil(Math.random() * Couleur.values().length) - 1];
    }

    static List<Figure> genere(int nbFigure, String preName)throws DessinHorsLimiteException{
        List<Figure> figures = new ArrayList<>();
        for(int i = 0; i < nbFigure; i++){
            figures.add(getRandomFigure(89, 89, 10, 10, preName + i));
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

    static List<Figure> trieProcheOrigine(Dessin dessin){
        List<Figure> figures = dessin.getFigures();
        Collections.sort(figures);
        return figures;
    }

    static List<Figure> trieDominant(Dessin dessin){
        List<Figure> figures = dessin.getFigures();
        figures.removeIf(figure -> !(figure instanceof Surfacable));
        Collections.sort(figures, new Comparator<Figure>() {
            @Override
            public int compare(Figure o1, Figure o2) {
                Surfacable s1 = (Surfacable) o1;
                Surfacable s2 = (Surfacable) o2;
                if(s1.surface() == s2.surface()) return 0;
                else if (s1.surface() > s2.surface()) return -1;
                else  return 1;
            }
        });
        return figures;
    }

    static Figure getFigure(String name){
        return figureMap.get(name);
    }

    static void sauvegarde(Dessin dessin, String path) {
        try(FileOutputStream fos = new FileOutputStream(path)){
            for(Figure figure: dessin.getFigures()){
                String saveFigure = figure.getType() + ","
                        + figure.startingPoint.getX() + ","
                        + figure.startingPoint.getY() + ","
                        + figure.getCouleur().getCode() + ","
                        + figure.sauvegarde() + "/";
                fos.write(saveFigure.getBytes(StandardCharsets.UTF_8));
            }
        }
        catch (IOException e){
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    static Dessin chargement (String path) throws DessinHorsLimiteException{
        try(FileInputStream fis = new FileInputStream(path)){
            List<Figure> figureList = new ArrayList<>();

            String dataString = new String(fis.readAllBytes(), StandardCharsets.UTF_8);
            String[] figuresData = dataString.split("/");

            for(String figureData:figuresData){
                if(figureData != ""){
                    Figure loadedFigure;
                    String[] dataParts = figureData.split(",");
                    switch (dataParts[0]){
                        case "ROND":
                            loadedFigure = new Rond(new Point(Integer.parseInt(dataParts[1]),
                                    Integer.parseInt(dataParts[2])),
                                    Integer.parseInt(dataParts[4]),
                                    Couleur.getCouleurByCode(dataParts[3]));
                            figureList.add(loadedFigure);
                            break;
                        case "RECTANGLE":
                            loadedFigure = new Rectangle(new Point(Integer.parseInt(dataParts[1]),
                                    Integer.parseInt(dataParts[2])),
                                    Integer.parseInt(dataParts[4]),
                                    Integer.parseInt(dataParts[5]),
                                    Couleur.getCouleurByCode(dataParts[3]));
                            figureList.add(loadedFigure);
                            break;
                        case "CARRE":
                            loadedFigure = new Carre(new Point(Integer.parseInt(dataParts[1]),
                                    Integer.parseInt(dataParts[2])),
                                    Integer.parseInt(dataParts[4]),
                                    Couleur.getCouleurByCode(dataParts[3]));
                            figureList.add(loadedFigure);
                            break;
                        case "SEGMENT":
                            loadedFigure = new Segment(new Point(Integer.parseInt(dataParts[1]),
                                    Integer.parseInt(dataParts[2])),
                                    Integer.parseInt(dataParts[4]),
                                    Objects.equals(dataParts[5], "True"),
                                    Couleur.getCouleurByCode(dataParts[3]));
                            figureList.add(loadedFigure);
                            break;
                        default:
                            break;
                    }
                }
            }
            return new Dessin(figureList);
        }
        catch (IOException e){
            System.out.println("Erreur : " + e.getMessage());
        }
        return new Dessin();
    }
}

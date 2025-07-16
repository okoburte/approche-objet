package TPClasse;

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

    static Figure getRandomFigure(int maxX, int maxY, int maxLength, int maxHeight){
        switch ((int)Math.ceil(Math.random() * Figure.NB_FIGURE_TYPE)){
            case 1:
                return getRandomRond(maxX, maxY, maxLength);
            case 2:
                return getRandomRectangle(maxX, maxY, maxLength, maxHeight);
            case 3:
                return getRandomCarre(maxX, maxY, maxLength);
            case 4:
                return getRandomSegment(maxX, maxY, maxLength);
            default:
                return getRandomRectangle(maxX, maxY, maxLength, maxHeight);
        }
    }
}

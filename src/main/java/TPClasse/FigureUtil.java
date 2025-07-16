package TPClasse;

public class FigureUtil {
    Rond getRandomRond(int maxX, int maxY, int maxRadius) {
        return new Rond(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxRadius));
    }

    Rectangle getRandomRectangle(int maxX, int maxY, int maxLength, int maxHeight){
        return new Rectangle(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxLength), (int)Math.ceil(Math.random() * maxHeight));
    }

    Carre getRandomCarre(int maxX, int maxY, int maxLength){
        return  new Carre(getRandomPoint(maxX, maxY), (int)Math.ceil(Math.random() * maxLength));
    }

    Point getRandomPoint(int maxX, int maxY){
        return new Point((int)Math.ceil(Math.random() * maxX), (int)Math.ceil(Math.random() * maxY));
    }
}

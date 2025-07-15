package TPClasse;

public class FigureUtil {
    Rond getRandomRond(int maxX, int maxY, int maxRadius) {
        Point randomCentre = new Point((int)Math.ceil(Math.random() * maxX), (int)Math.ceil(Math.random() * maxY));
        return new Rond(randomCentre, (int)Math.ceil(Math.random() * maxRadius));
    }

    Rectangle getRandomRectangle(int maxX, int maxY, int maxLength, int maxHeight){
        Point randomPoint = new Point((int)Math.ceil(Math.random() * maxX), (int)Math.ceil(Math.random() * maxY));
        return new Rectangle(randomPoint, (int)Math.ceil(Math.random() * maxLength), (int)Math.ceil(Math.random() * maxHeight));
    }
}

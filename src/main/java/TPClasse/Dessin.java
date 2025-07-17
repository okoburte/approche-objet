package TPClasse;

import java.util.ArrayList;
import java.util.List;

public class Dessin {
    List<Figure> figures;

    Dessin(){
        figures = new ArrayList<Figure>();
    }

    Dessin(List<Figure> figures){
        this.figures = figures;
    }

    public boolean addFigure(Figure figure){
        return figures.add(figure);
    }

    public List<Figure> getFigures(){
        return figures;
    }
}

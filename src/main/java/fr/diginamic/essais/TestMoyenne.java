package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {
    public static void main(String[] args) {
        double[] valeurs = {5, 4, 10, 17, 34, -15, -5, 0};
        CalculMoyenne calculMoyenne = new CalculMoyenne(valeurs);
        System.out.println("Moyenne = " + calculMoyenne.Calcul());
        System.out.println("Ajout de la valeur 1142.");
        calculMoyenne.ajout(1142);
        System.out.println("Nouvelle moyenne = " + calculMoyenne.Calcul());
    }
}

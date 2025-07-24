package fr.diginamic.essais;

import fr.diginamic.entites.Theatre;

public class TestTheatre {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Theatre du petit bois", 25);

        theatre.inscrire(4, 20);
        theatre.inscrire(2, 30);
        System.out.println("Total clients actuellement inscrit : " + theatre.getTotalClients() + ". Total recette actuelle : "+ theatre.getRecette() + ".");

        theatre.inscrire(10, 15);
        theatre.inscrire(6, 20);
        System.out.println("Total clients actuellement inscrit : " + theatre.getTotalClients() + ". Total recette actuelle : "+ theatre.getRecette() + ".");

        theatre.inscrire(4, 25);
    }
}

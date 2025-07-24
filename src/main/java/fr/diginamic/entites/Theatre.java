package fr.diginamic.entites;

public class Theatre {
    private String nom;
    private int capaciteMax;
    private int totalClients;
    private double recette;

    public Theatre(String nom, int capaciteMax){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        totalClients = 0;
        recette = 0;
    }

    public int getTotalClients(){
        return totalClients;
    }

    public double getRecette(){
        return recette;
    }

    public void inscrire(int nbClients, double prixPlace){
        if(nbClients > placeRestante()) {
            System.out.println("Pas assez de place disponible pour " + nbClients + ". Il reste " + placeRestante() + " disponible.");
            return;
        }
        System.out.println("Inscription reussi pour " + nbClients + " au prix de " + prixPlace + ".");
        totalClients += nbClients;
        recette += nbClients*prixPlace;
    }

    private int placeRestante(){
        return capaciteMax - totalClients;
    }
}

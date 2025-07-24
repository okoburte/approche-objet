package fr.diginamic.essais;

import fr.diginamic.maison.*;

import java.util.ArrayList;
import java.util.List;

public class TestMaison {
    public static void main(String[] args) {
        Maison maison = new Maison();
        List<Piece> pieces = new ArrayList<>();

        {
            try {
                pieces.add(new Chambre(16, 1));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                pieces.add(new Chambre(19, 1));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                pieces.add(new Chambre(-19, 1));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                pieces.add(new Chambre(19, -2));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                pieces.add(new Cuisine(14, 0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                pieces.add(new Salon(28, 0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                pieces.add(new WC(7, 0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                pieces.add(new WC(8, 1));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                pieces.add(new SalleDeBain(12, 1));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            pieces.add(null);
        }

        for (Piece piece : pieces) {
            try {
                maison.ajouterPiece(piece);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Superficie total de la maison : " + maison.getSuperficie());
        System.out.println("Superficie total du premier etage : " + maison.getSuperficie(1));
        System.out.println("Superficie total des chambres : " + maison.getSuperficie(Chambre.class));
        System.out.println("Superficie total des WC du rez-de-chaussé : " + maison.getSuperficie(0, WC.class));

        System.out.println("Il y a " + maison.getNumberPieceOf(Chambre.class) + " chambres dans la maison.");
        System.out.println("Il y a " + maison.getNumberPieceOf(Cuisine.class) + " cuisines dans la maison.");
        System.out.println("Il y a " + maison.getNumberPieceOf(WC.class) + " WC dans la maison.");
    }
}

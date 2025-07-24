package fr.diginamic.chaines;

import fr.diginamic.entites.Salarie;

import java.util.Arrays;

public class ManipulationChaine {
    public static void main(String[] args) {
        String chaine = "Durand;Marcel;2 523.5";

        char premierCaractere = chaine.charAt(0);
        System.out.println("Premier caractère : " + premierCaractere);
        System.out.println("Longueur de la chaine : " + chaine.length());
        String nomDeFamille = "";
        for (int i = 0; i < chaine.length(); i++) {
            if(chaine.charAt(i) == ';') {
                nomDeFamille = chaine.substring(0, i);
                break;
            }
        }
        System.out.println("Nom de famille : " + nomDeFamille.toUpperCase());
        System.out.println("Nom de famille : " + nomDeFamille.toLowerCase());

        String[] sousChaines = chaine.split(";");
        System.out.println("Tableau de sous chaines de la chaine principale séparé par le caractère ';' :\n" + Arrays.toString(sousChaines));

        Salarie salarie = new Salarie(sousChaines[0], sousChaines[1], Double.parseDouble(sousChaines[2].replace(" ", "")));
        System.out.println(salarie.toString());
    }
}

package entites;

import entites2.Personne;

public class TestPersonne {
    public static void main(String[] args) {
        Personne johnSmith = new Personne();
        johnSmith.nom = "Smith";
        johnSmith.prenom = "John";
        johnSmith.adresse = new AdressePostale();
        johnSmith.adresse.numero = 42;
        johnSmith.adresse.libelle = "Impasse des oliviers";
        johnSmith.adresse.codePostale = 34080;
        johnSmith.adresse.ville = "Montpellier";

        Personne sophieDupont = new Personne();
        sophieDupont.nom = "Dupont";
        sophieDupont.prenom = "Sophie";
        sophieDupont.adresse = new AdressePostale();
        sophieDupont.adresse.numero = 144;
        sophieDupont.adresse.libelle = "Allée du professeur Mac";
        sophieDupont.adresse.codePostale = 69210;
        sophieDupont.adresse.ville = "Lyon";
    }
}

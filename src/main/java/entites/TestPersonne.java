package entites;

import entites2.Personne;

public class TestPersonne {
    public static void main(String[] args) {
        Personne johnSmith = new Personne("Smith", "John");
        johnSmith.adresse = new AdressePostale(42, "Impasse des oliviers",34082, "Montpellier");

        Personne sophieDupont = new Personne("Dupont", "Sophie", new AdressePostale(144, "Allée du professeur Mac",69210, "Lyon"));

        Personne adamConnor = new Personne("Connor", "Adam");
        adamConnor.setAdresse(new AdressePostale(1400, "Boulevard du petit biscuit", 34090, "Montpellier"));
    }
}

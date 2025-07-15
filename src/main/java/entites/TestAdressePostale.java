package entites;

public class TestAdressePostale {
    public static void main(String[] args) {
        AdressePostale adresse1 = new AdressePostale();
        adresse1.numero = 2;
        adresse1.libelle = "rue du four";
        adresse1.codePostale = 34090;
        adresse1.ville = "Montpellier";

        AdressePostale adresse2 = new AdressePostale();
        adresse2.numero = 75;
        adresse2.libelle = "Avenue des pissenlit";
        adresse2.codePostale = 75100;
        adresse2.ville = "Paris";
    }
}

package entites;

public class AdressePostale {
    int numero;
    String libelle;
    int codePostale;
    String ville;

    AdressePostale(int numero, String libelle, int codePostale, String ville){
        this.numero = numero;
        this.libelle = libelle;
        this.codePostale = codePostale;
        this.ville = ville;
    }
}

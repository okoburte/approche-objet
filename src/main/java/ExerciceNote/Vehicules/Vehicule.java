package ExerciceNote.Vehicules;

public abstract class Vehicule {
    String marque;
    String modele;
    String numImmat;

    Vehicule (String marque, String modele, String numImmat) {
        this.marque = marque;
        this.modele = modele;
        this.numImmat = numImmat;
    }

    public String getMarque(){
        return marque;
    }

    public String getModele(){
        return modele;
    }

    public String getNumImmat(){
        return numImmat;
    }

    public void affiche(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "N° : " + getNumImmat() + ", Modèle : " + getMarque() + " " + getModele();
    }
}

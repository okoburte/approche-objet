package ExerciceNote.Vehicules;

public class Voilier extends Maritime{
    public Voilier(String marque, String modele, String numImmat) {
        super(marque, modele, numImmat);
    }

    @Override
    public void affiche() {
        System.out.println("Voilier " + super.toString());
    }
}

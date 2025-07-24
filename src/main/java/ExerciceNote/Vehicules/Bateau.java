package ExerciceNote.Vehicules;

import ExerciceNote.Port;

public class Bateau extends Maritime implements AMoteur{
    private int reservoir;

    public Bateau(String marque, String modele, String numImmat) throws Exception {
        this(marque, modele, numImmat, 200);
    }

    public Bateau(String marque, String modele, String numImmat, int reservoir) throws Exception {
        super(marque, modele, numImmat);
        if(reservoir <= 0) throw new Exception("Un vehicule ne peut pas avoir un reservoir negatif.");
        else {
            this.reservoir = reservoir;
        }
    }

    @Override
    public void remplirReservoir(Port port) {
        try {
            port.obtenirCarburant(reservoir);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getReservoir() {
        return reservoir;
    }

    @Override
    public void affiche() {
        System.out.println("Bateau " + super.toString());
    }
}

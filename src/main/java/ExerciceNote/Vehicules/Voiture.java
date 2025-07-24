package ExerciceNote.Vehicules;

import ExerciceNote.Port;

public class Voiture extends Routier implements AMoteur {
    private int reservoir;

    public Voiture(String marque, String modele, String numImmat) throws Exception {
        this(marque, modele, numImmat, 50);
    }

    public Voiture(String marque, String modele, String numImmat, int reservoir) throws Exception {
        super(marque, modele, numImmat);
        if(reservoir <= 0) throw new Exception("Un vehicule ne peut pas avoir un reservoir negatif.");
        else {
            this.reservoir = reservoir;
        }
    }

    @Override
    public void affiche() {
        System.out.println("Voiture " + super.toString());
    }

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
}

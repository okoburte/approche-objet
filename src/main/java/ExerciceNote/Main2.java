package ExerciceNote;

import ExerciceNote.Vehicules.*;

public class Main2 {
    public static void garer(Port port, Routier vehicule) {
        try {
            port.garer(vehicule);
            System.out.println("Je gare " + vehicule);
        } catch (Exception e) {
            System.out.println("!!! Erreur pour garer " + vehicule + " : " + e.getMessage());
        }
    }

    public static void amarer(Port port, Maritime vehicule) {
        try {
            port.amarer(vehicule);
            System.out.println("J'amare " + vehicule);
        } catch (Exception e) {
            System.out.println("!!! Erreur pour amarer " + vehicule + " : " + e.getMessage());
        }
    }

    public static void sortir(Port port, Vehicule vehicule) {
        try {
            port.sortir(vehicule);
            System.out.println("Je sors " + vehicule);
        } catch (Exception e) {
            System.out.println("!!! Erreur pour sortir " + vehicule + " : " + e.getMessage());
        }
    }

    public static void remplirReservoir(Port port, AMoteur vehicule) {
        try {
            vehicule.remplirReservoir(port);
            System.out.println("Réservoir de " + vehicule.getReservoir() + " litres rempli pour " + vehicule);
        } catch (Exception e) {
            System.out.println("!!! Erreur pour remplir le réservoir de " + vehicule.getReservoir() + " litres de " + vehicule + " : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Port port = new Port();
            Voiture voiture1 = new Voiture("Tesla", "Modèle 3", "AZ-233-SD");
            garer(port, voiture1);
            Voiture voiture2 = new Voiture("Peugeot", "2008", "SD-234-RD", 60);
            garer(port, voiture2);
            Moto moto1 = new Moto("Honda", "Z543", "DD-341-RD");
            garer(port, moto1);
            sortir(port, moto1);
            System.out.println(port + "\n");

            garer(port, new Moto("Honda", "Z543", "DD-342-RD"));
            garer(port, new Moto("Honda", "Z543", "DD-343-RD"));
            garer(port, new Moto("Honda", "Z543", "DD-344-RD"));
            garer(port, new Moto("Honda", "Z543", "DD-345-RD"));
            garer(port, new Moto("Honda", "Z543", "DD-346-RD"));
            garer(port, new Moto("Honda", "Z543", "DD-347-RD"));
            garer(port, new Voiture("Renault", "Clio", "ZZ-350-RD", 30));
            System.out.println(port + "\n");

            Bateau bateau1 = new Bateau("Nausica", "Bermude", "A3433-SD");
            amarer(port, bateau1);
            Bateau bateau2 = new Bateau("Nausica", "Bermude2", "A33-SSSD");
            amarer(port, bateau2);
            Bateau bateau3 = new Bateau("Nausica", "Bermude3", "A3333-SSSD", 150);
            amarer(port, bateau3);
            Voilier voilier1 = new Voilier("Bénéteau", "Antatric", "DDSDF-23");
            amarer(port, voilier1);
            System.out.println(port + "\n");

            remplirReservoir(port, voiture1);
            remplirReservoir(port, voiture2);
            System.out.println(port + "\n");

            remplirReservoir(port, bateau1);
            remplirReservoir(port, bateau2);
            remplirReservoir(port, bateau3);
            System.out.println(port + "\n");

            port.remplirReservoir();
            remplirReservoir(port, bateau2);
            System.out.println(port + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

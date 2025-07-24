package ExerciceNote;

import ExerciceNote.Vehicules.*;

import java.util.HashSet;
import java.util.Set;

public class Port {
    private Set<Voiture> voitures;
    private Set<Moto> motos;
    private Set<Maritime> vehiculesMaritimes;
    private int reservoir;
    private int reservoirMax;
    private int placeVoiture;
    private int placeMoto;
    private int placeBassin;

    Port() throws Exception {
        this(10, 5, 20, 500);
    }

    Port(int placeVoiture, int placeMoto, int placeBassin, int reservoirMax) throws Exception {
        if(placeVoiture < 0) throw new Exception("Impossible d'avoir un nombre de place pour les voitures negatif.");
        if(placeMoto < 0) throw new Exception("Impossible d'avoir un nombre de place pour les motos negatif.");
        if(placeBassin < 0) throw new Exception("Impossible d'avoir un nombre de place dans le bassin du port negatif.");
        if(reservoirMax <= 0) throw new Exception("Impossible d'avoir une capacité de reservoir du port negatif.");
        voitures = new HashSet<>(placeVoiture);
        motos = new HashSet<>(placeMoto);
        vehiculesMaritimes = new HashSet<>(placeBassin);
        this.reservoirMax = reservoirMax;
        reservoir = reservoirMax;
        this.placeVoiture = placeVoiture;
        this.placeMoto = placeMoto;
        this.placeBassin = placeBassin;
    }

    public void garer(Routier vehicule) throws Exception {
        if(vehicule == null) throw new Exception("Le paramètre vehicule est null.");
        if(vehicule.getClass().isAssignableFrom(Voiture.class)) {
            if(voitures.size() >= placeVoiture) throw new Exception("Plus de place pour les voitures dans le parking.");
            else voitures.add((Voiture) vehicule);
        }
        else if(vehicule.getClass().isAssignableFrom(Moto.class)) {
            if(motos.size() >= placeMoto) throw new Exception("Plus de place pour les motos dans le parking.");
            else motos.add((Moto) vehicule);
        }
        else throw new Exception("Seul les vehicules routier Voiture et Moto sont geré.");
    }

    public void amarer(Maritime vehicule) throws Exception {
        if(vehicule == null) throw new Exception("Le paramètre vehicule est null.");
        else if (vehiculesMaritimes.size() >= placeBassin) throw new Exception("Plus de place dans le bassin du port pour s'amarer.");
        else vehiculesMaritimes.add(vehicule);
    }

    public void sortir(Vehicule vehicule) throws Exception {
        if(vehicule.getClass().isAssignableFrom(Maritime.class)){
            if(!vehiculesMaritimes.remove(vehicule)) throw new Exception("Le vehicule maritime n'etait pas garer dans ce port");
        }
        else if(vehicule.getClass().isAssignableFrom(Voiture.class)){
            if(!voitures.remove(vehicule)) throw new Exception("Le vehicule routier (Voiture) n'etait pas garer dans ce port");
        }
        else if(vehicule.getClass().isAssignableFrom(Moto.class)){
            if(!motos.remove(vehicule)) throw new Exception("Le vehicule routier (Moto) n'etait pas garer dans ce port");
        }
        else throw new Exception("Ce type de vehicule n'est pas geré par le port.");
    }

    public void obtenirCarburant(int quantite) throws Exception {
        if(getReservoir() < quantite) throw new Exception("Il n'y a plus assez de carburant dans le reservoir du port.");
        else reservoir -= quantite;
    }

    public void remplirReservoir(){
        reservoir = getReservoirMax();
    }

    public int getReservoirMax(){
        return reservoirMax;
    }

    public int getReservoir(){
        return reservoir;
    }

    public void state(){
        System.out.println("Il y a actuellement " + reservoir + "L de fuel dans le reservoir du port.");
        System.out.println("Il y a actuellement " + (voitures.size() + motos.size()) + " vehicules routiers garés sur le parking du port.");
        System.out.println("Liste des Voitures : " + voitures.toString());
        System.out.println("Liste des motos : " + motos.toString());
        System.out.println("Il y a actuellement " + vehiculesMaritimes.size() + " vehicules maritimes amarés dans le port.");
        System.out.println("Liste des vehicules maritimes : " + vehiculesMaritimes.toString());
    }
}

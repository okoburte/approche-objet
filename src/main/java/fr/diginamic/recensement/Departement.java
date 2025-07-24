package fr.diginamic.recensement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Departement implements Comparable<Departement> {
    private String codeDepartement;
    private Map<String, Ville> villeMap;

    public Departement(String codeDepartement){
        this.codeDepartement = codeDepartement;
        villeMap = new HashMap<>();
    }

    public Map<String, Ville> getVilleMap(){
        return villeMap;
    }

    public String getCodeDepartement(){
        return codeDepartement;
    }

    @Override
    public String toString() {
        return "Departement " + codeDepartement + " (Population : " + getPopulation() + ")";
    }

    public long getPopulation(){
        long populationTotal = 0;
        for(Ville ville:villeMap.values()){
            populationTotal += ville.getPopulation();
        }
        return populationTotal;
    }

    @Override
    public int compareTo(Departement o) {
        return Double.compare(o.getPopulation(), getPopulation());
    }
}

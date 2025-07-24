package fr.diginamic.recensement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Region implements Comparable<Region> {
    private String codeRegion;
    private String nomRegion;
    private Map<String, Departement> departementMap;

    public Region(String codeRegion, String nomRegion){
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        departementMap = new HashMap<>();
    }

    public String getCodeRegion(){
        return codeRegion;
    }

    public String getNomRegion(){
        return nomRegion;
    }

    public Map<String, Departement> getDepartementMap(){
        return departementMap;
    }

    @Override
    public String toString() {
        return codeRegion + " " + nomRegion + " (Population : " + getPopulation() + ")";
    }

    public long getPopulation(){
        long populationTotal = 0;
        for(Departement departement: departementMap.values()){
            populationTotal += departement.getPopulation();
        }
        return populationTotal;
    }

    @Override
    public int compareTo(Region o) {
        return Double.compare(o.getPopulation(), getPopulation());
    }
}

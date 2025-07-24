package fr.diginamic.recensement;

public class Ville implements Comparable<Ville>{
    private String nomCommune;
    private String codeCommune;
    private int population;

    public Ville(String nomCommune, String codeCommune, int population){
        this.nomCommune = nomCommune;
        this.codeCommune = codeCommune;
        this.population = population;
    }

    public String getCodeCommune(){
        return codeCommune;
    }

    @Override
    public String toString() {
        return codeCommune + " " + nomCommune + "(" + population + ")";
    }

    public int getPopulation(){
        return population;
    }

    public String getNomCommune(){
        return nomCommune;
    }

    @Override
    public int compareTo(Ville o) {
        return Integer.compare(o.getPopulation(), getPopulation());
    }
}

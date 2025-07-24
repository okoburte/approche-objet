package fr.diginamic.operations;

public class CalculMoyenne {
    private double[] valeurs;

    public CalculMoyenne(){
        valeurs = new double[0];
    }

    public CalculMoyenne(double[] valeurs){
        this.valeurs = valeurs;
    }

    public void ajout(double valeur){
        double[] newValeurs = new double[valeurs.length + 1];
        for (int i = 0; i < valeurs.length; i++) {
            newValeurs[i] = valeurs[i];
        }
        newValeurs[newValeurs.length-1] = valeur;
        valeurs = newValeurs;
    }

    public double Calcul(){
        if(valeurs.length == 0) return 0;
        return Sommes()/ valeurs.length;
    }

    public double Sommes(){
        double sommes = 0;
        for(double valeur:valeurs) sommes += valeur;
        return sommes;
    }
}

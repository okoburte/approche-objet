package fr.diginamic.maison;

public abstract class Piece {
    private double superficie;
    private int etage;

    public Piece(double superficie, int etage) throws Exception{
        if(superficie < 0 || etage < 0) throw new Exception("Impossible de creer une piece avec une superficie ou un etage negatif.");
        this.superficie = superficie;
        this.etage = etage;
    }

    public double getSuperficie(){
        return superficie;
    }

    public int getEtage(){
        return etage;
    }
}

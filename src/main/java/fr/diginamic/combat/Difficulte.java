package fr.diginamic.combat;

public enum Difficulte {
    Facile(100, 100), Moyen(50, 50), Difficile(25, 25), Extreme(0, 0);

    private int lootRate;
    private int fleeChance;

    Difficulte(int lootRate, int fleeChance){
        this.lootRate = lootRate;
        this.fleeChance = fleeChance;
    }

    int getLootRate(){
        return lootRate;
    }

    int getFleeChance(){
        return fleeChance;
    }
}

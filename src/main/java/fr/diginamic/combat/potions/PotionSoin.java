package fr.diginamic.combat.potions;

import fr.diginamic.combat.Personnage;

import java.util.concurrent.ThreadLocalRandom;

public class PotionSoin extends Potion{
    private int minRegen;
    private int maxRegen;

    public PotionSoin(int minRegen, int maxRegen){
        this.minRegen = minRegen;
        this.maxRegen = maxRegen;
    }

    @Override
    public void use(Personnage personnage) {
        int regen = ThreadLocalRandom.current().nextInt(minRegen, maxRegen);
        System.out.println("Vous etes soigné de " + regen + " hp !");
        personnage.soigner(regen);
    }

    @Override
    public String toString() {
        return "Potion de soin (soigne" + minRegen + " à " + maxRegen + " hp)";
    }
}

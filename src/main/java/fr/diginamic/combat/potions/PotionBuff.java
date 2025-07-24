package fr.diginamic.combat.potions;

import fr.diginamic.combat.Personnage;
import fr.diginamic.combat.Stat;

public class PotionBuff extends Potion{
    private Stat stat;
    private int value;
    private int duration;

    public PotionBuff(Stat stat, int value, int duration){
        this.stat = stat;
        this.value = value;
        this.duration = duration;
    }

    @Override
    public void use(Personnage personnage) {
        System.out.println("Votre " + stat.toString() + " est augmenté de +" + value + " pendant " + duration + " combats !");
        personnage.addBuff(stat, value, duration);
    }

    @Override
    public String toString() {
        return "Potion de buff (+" + value + " " + stat.toString() + " pendant "+ duration + " combats)";
    }
}

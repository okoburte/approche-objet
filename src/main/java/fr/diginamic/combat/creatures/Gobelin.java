package fr.diginamic.combat.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Gobelin extends Creature{
    private static final int SCORE_GIVEN = 2;
    private static final CreatureType creatureType = CreatureType.Gobelin;

    public Gobelin(){
        this(ThreadLocalRandom.current().nextInt(5, 10), ThreadLocalRandom.current().nextInt(10, 15));
    }

    public Gobelin(int force, int hpMax) {
        super(force, hpMax);
    }

    @Override
    public void attaque() {
        System.out.println("Le gobelin prend l'avantage lors de cette echange et en profite pour vous donner un coups d'épée bien placé !");
    }

    @Override
    public int getScoreGiven() {
        return SCORE_GIVEN;
    }

    @Override
    public CreatureType getCreatureType() {
        return creatureType;
    }

    @Override
    public void intro() {
        System.out.println("Un gobelin solitaire vous apercoit et vous attaque !");
    }

    @Override
    public void creatureWon() {
        System.out.println("Le gobelin vous submerge de coup au moment ou vous perdez l'equilibre de fatigue ! Vous etes mort !");
    }

    @Override
    public void creatureLost() {
        System.out.println("Le gobelin perd l'equilibre sous vos assault incessant et vous parvenez a prendre l'avantage pour en finir !");
    }
}

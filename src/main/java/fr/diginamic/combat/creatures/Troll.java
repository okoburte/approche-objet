package fr.diginamic.combat.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Troll extends Creature{
    private static final int SCORE_GIVEN = 5;
    private static final CreatureType creatureType = CreatureType.Troll;

    public Troll(){
        this(ThreadLocalRandom.current().nextInt(10, 15), ThreadLocalRandom.current().nextInt(20, 30));
    }

    public Troll(int force, int hpMax) {
        super(force, hpMax);
    }

    @Override
    public void attaque() {
        System.out.println("Le troll prend l'avantage lors de cette echange et vous assène un grand coup avec son tronc d'arbre !");
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
        System.out.println("Pas de chance de tomber sur un troll... en plus il vous a vu et il vous charge !");
    }

    @Override
    public void creatureWon() {
        System.out.println("Le troll vous ecrabouille sous son tronc d'arbre ! Vous etes mort !");
    }

    @Override
    public void creatureLost() {
        System.out.println("Vous arrivez à porter le coup de grace au troll apres un combat acharné !");
    }
}

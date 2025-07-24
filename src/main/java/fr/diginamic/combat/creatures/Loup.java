package fr.diginamic.combat.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Loup extends Creature{
    private static final int SCORE_GIVEN = 1;
    private static final CreatureType creatureType = CreatureType.Loup;

    public Loup(){
        this(ThreadLocalRandom.current().nextInt(3, 8), ThreadLocalRandom.current().nextInt(5, 10));
    }

    public Loup(int force, int hpMax){
        super(force, hpMax);
    }

    @Override
    public void attaque() {
        System.out.println("Le loup prend l'avantage lors de cette echange et plante ses crocs dans votre chair !");
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
        System.out.println("Un loup apparait et vous attaque !");
    }

    @Override
    public void creatureWon() {
        System.out.println("Vous finissez lacéré sous les coups de griffes et les morsures du loup ! Vous etes mort !");
    }

    @Override
    public void creatureLost() {
        System.out.println("Vos coups bien placé finissent par avoir raison du loup qui s'ecroule a vos pieds !");
    }
}

package fr.diginamic.combat.creatures;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Creature {
    private int force;
    private int hpMax;
    private int degatSubit;

    public Creature(int force, int hpMax){
        this.force = force;
        this.hpMax = hpMax;
        degatSubit = 0;
    }

    public abstract void attaque();
    public abstract int getScoreGiven();
    public abstract CreatureType getCreatureType();
    public abstract void intro();
    public abstract void creatureWon();
    public abstract void creatureLost();

    public int getForce(){
        return force;
    }

    public int getAttackValue(){
        return force + ThreadLocalRandom.current().nextInt(1, 10);
    }

    public boolean isDead(){
        return degatSubit >= hpMax;
    }

    public void takeDamage(int damage){
        if(damage < 0) return;
        degatSubit += damage;
    }

    @Override
    public String toString() {
        return getCreatureType().toString() + " : " + (hpMax-degatSubit) + "/" + hpMax + " (Force : " + force + ")";
    }
}

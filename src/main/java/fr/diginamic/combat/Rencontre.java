package fr.diginamic.combat;

import fr.diginamic.combat.creatures.Creature;
import fr.diginamic.combat.creatures.CreatureType;
import fr.diginamic.combat.creatures.*;
import fr.diginamic.combat.potions.PotionBuff;
import fr.diginamic.combat.potions.PotionSoin;

import java.util.concurrent.ThreadLocalRandom;

public class Rencontre {
    private Personnage personnage;
    private Creature creature;
    private int nbTour;
    private Difficulte difficulte;

    public Rencontre(Personnage personnage, Creature creature){
        this(personnage, creature, Difficulte.Moyen);
    }

    public Rencontre(Personnage personnage, CreatureType creatureType){
        this(personnage, getCreatureByType(creatureType), Difficulte.Moyen);
    }

    public Rencontre(Personnage personnage, Creature creature, Difficulte difficulte){
        this.personnage = personnage;
        this.creature = creature;
        this.difficulte = difficulte;
        nbTour = 1;
        creature.intro();
    }

    public void nextTurn(){
        System.out.println("Tour n°" + nbTour);
        int damageDeal = personnage.getAttackValue() - creature.getAttackValue();
        switch(Integer.compare(damageDeal, 0)){
            case -1:
                creaturePlay(Math.abs(damageDeal));
                break;
            case 1:
                personnagePlay(damageDeal);
                break;
            default:
                System.out.println("Votre force et celle du " + creature.getCreatureType().toString() + " s'annule");
        }
        nbTour ++;
    }

    public boolean fuite(){
        if(ThreadLocalRandom.current().nextFloat(0f, 100f) > difficulte.getFleeChance()) {
            System.out.println("Vous n'avez pas reussi a fuir le combat ! Le " + creature.getCreatureType().toString() + " en profite pour vous attaquer !");
            personnage.takeDamage(creature.getForce());
            return false;
        }

        System.out.println("Vous avez reussi a fuir !");
        return true;
    }

    public boolean checkFinRencontre(){
        if(personnage.isDead()){
            creature.creatureWon();
            System.out.println("Votre score final avec ce personnage est de " + personnage.getScore());
            return true;
        }
        else if (creature.isDead()) {
            creature.creatureLost();
            personnage.addScore(creature.getScoreGiven());
            personnage.reduceBuffDuration();
            getLoot();
            return true;
        }
        return false;
    }

    public void status(){
        System.out.println(personnage.toString());
        System.out.println(creature.toString());
    }

    private void creaturePlay(int damageDeal){
        creature.attaque();
        personnage.takeDamage(damageDeal);
    }

    private void personnagePlay(int damageDeal){
        personnage.attaque();
        creature.takeDamage(damageDeal);
    }

    private void getLoot(){
        if(ThreadLocalRandom.current().nextFloat(0f, 100f) > difficulte.getLootRate()) return;
        switch (ThreadLocalRandom.current().nextInt(1, 4)){
            case 1:
                System.out.println("Vous avez trouvé une potion de soin (5 à 10 hp rendu) !");
                personnage.addPotion(new PotionSoin(5, 10));
                break;
            case 2:
                System.out.println("Vous avez trouvé une potion d'attaque mineure (+3 force pendant 1 combat) !");
                personnage.addPotion(new PotionBuff(Stat.Force, 3, 1));
                break;
            case 3:
                System.out.println("Vous avez trouvé une potion d'attaque majeure (+5 force pendant 2 combats) !");
                personnage.addPotion(new PotionBuff(Stat.Force, 5, 2));
                break;
            case 4:
                System.out.println("Les dieux sont témoin de votre exploit (+5 scores) !");
                personnage.addScore(5);
                break;
        }
    }

    private static Creature getCreatureByType(CreatureType creatureType){
        switch (creatureType){
            case Loup:
                return new Loup();
            case Gobelin:
                return new Gobelin();
            case Troll:
                return new Troll();
            default:
                return new Loup();
        }
    }
}

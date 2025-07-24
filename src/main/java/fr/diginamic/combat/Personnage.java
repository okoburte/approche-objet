package fr.diginamic.combat;

import fr.diginamic.combat.potions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Personnage {
    private int hpMax;
    private int degatSubit;
    private int force;
    private int score;
    private List<Potion> potionList;
    private Map<Stat, Map<Integer, Integer>> buff;

    public Personnage(){
        this((int) Math.ceil((Math.random() * 31) + 19), (int) Math.ceil((Math.random() * 7) + 11));
        potionList.add(new PotionSoin(5, 10));
        potionList.add(new PotionBuff(Stat.Force, 3, 1));
        potionList.add(new PotionBuff(Stat.Force, 5, 2));
    }

    public Personnage(int hpMax, int force){
        this.hpMax = hpMax;
        this.force = force;
        score = 0;
        degatSubit = 0;
        potionList = new ArrayList<>(10);
        buff = new HashMap<>();
    }

    public void attaque(){
        System.out.println("Vous prenez l'avantage lors de cette echange et en profitez pour porter un coup direct a votre adversaire !");
    }

    public int getAttackValue(){
        return force + getStatBuff(Stat.Force) + ThreadLocalRandom.current().nextInt(1, 10);
    }

    public void soigner(int soin){
        degatSubit = Math.max(0, degatSubit-soin);
    }

    public void takeDamage(int damage){
        if(damage < 0) return;
        degatSubit += damage;
    }

    public void addBuff(Stat stat, int value, int duration){
        buff.computeIfAbsent(stat, k -> new HashMap<>()).put(value, duration);
    }

    public void reduceBuffDuration(){
        for(Map<Integer, Integer> buffMap: buff.values()){
            buffMap.replaceAll((key, value) -> value-1);
            buffMap.entrySet().removeIf(buff -> buff.getValue() <= 0);
        }
    }

    public void addScore(int scoreGained){
        score += scoreGained;
    }

    public int getScore(){
        return score;
    }

    public List<Potion> getPotionList(){
        return potionList;
    }

    public void addPotion(Potion potion){
        if(potion == null) return;
        potionList.add(potion);
    }

    public void usePotion(int potionIndex){
        if(potionIndex < 0 || potionIndex >= potionList.size()) {
            System.out.println("Index potion invalide !");
            return;
        }
        potionList.get(potionIndex).use(this);
        potionList.remove(potionIndex);
    }

    @Override
    public String toString() {
        return "Personnage : " + (hpMax-degatSubit) + "/" + hpMax + " (Force : " + force + ")";
    }

    public boolean isDead(){
        return degatSubit >= hpMax;
    }

    private int getStatBuff(Stat stat){
        if(!buff.keySet().contains(stat)) return 0;
        int sommes = 0;
        for(Integer buff: buff.get(stat).keySet()){
            sommes += buff;
        }
        return sommes;
    }
}

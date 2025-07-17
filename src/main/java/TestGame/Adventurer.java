package TestGame;

import java.util.List;

public class Adventurer {
    final static int[] EXP_RECQUIRED = {10, 25, 60, 110};

    String name;
    Job.job job;
    int maxHp;
    int hpLost;
    int strength;
    int intelligence;
    int dexterity;
    int wisdom;
    int level;
    int experience;
    // List<Talent> talentList;

    Adventurer(String name, int level, Job.job job) {
        this.name = name;
        this.job = job;
        this.level = Math.max(1, Math.min(level, EXP_RECQUIRED.length));
        init();
    }

    private void init() {
        maxHp = Job.getMaxHp(job);
        hpLost = 0;
        strength = getRandomBaseStat() + Job.getStrengthMod(job);
        intelligence = getRandomBaseStat() + Job.getIntelligenceMod(job);
        dexterity = getRandomBaseStat() + Job.getDexterityMod(job);
        wisdom = getRandomBaseStat() + Job.getWisdomMod(job);
        experience = EXP_RECQUIRED[level];
    }

    private int getRandomBaseStat() {
        return (int) (Math.random() * 5) + 1;
    }

    public boolean takeDamage(int damage) {
        hpLost += damage;
        return !isDead();
    }

    private boolean isDead() {
        return hpLost >= maxHp;
    }

    public boolean gainExperience(int experience) {
        this.experience += experience;
        return hasLevelUp();
    }

    private boolean hasLevelUp() {
        if(level < EXP_RECQUIRED.length && experience >= EXP_RECQUIRED[level]) {
            level++;
            return true;
        }
        return false;
    }

    public int getStrength() {
        return strength;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public int getDexterity() {
        return dexterity;
    }
    public int getWisdom() {
        return wisdom;
    }
    public int getLevel() {
        return level;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public int getCurrentHp (){
        return maxHp - hpLost;
    }
}

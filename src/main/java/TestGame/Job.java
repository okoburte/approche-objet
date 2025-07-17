package TestGame;

abstract public class Job {
    public enum job{
        Warrior, Mage, Archer, Cleric, Paladin, Battlemage, Necromancer, Monk, Shaman, Priest
    }

    public static int getMaxHp(job job){
        return switch (job){
            case Warrior, Battlemage, Monk -> 60;
            case Paladin -> 80;
            case Archer, Shaman, Cleric -> 50;
            case Mage, Necromancer, Priest -> 40;
        };
    }

    public static int getStrengthMod(job job){
        return switch (job) {
            case Warrior -> 4;
            case Paladin, Battlemage, Monk -> 2;
            default -> 0;
        };
    }

    public static int getIntelligenceMod(job job){
        return switch (job) {
            case Mage -> 4;
            case Battlemage, Necromancer, Shaman -> 2;
            default -> 0;
        };
    }

    public static int getDexterityMod(job job){
        return switch (job) {
            case Archer -> 4;
            case Monk, Shaman, Priest -> 2;
            default -> 0;
        };
    }

    public static int getWisdomMod(job job){
        return switch (job) {
            case Cleric -> 4;
            case Necromancer, Priest, Paladin -> 2;
            default -> 0;
        };
    }
}

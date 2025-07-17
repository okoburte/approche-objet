package TestGame;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    final static int[] FAME_TRESHOLD = {10, 25, 60, 110};

    List<Adventurer> adventurerList;
    List<Quest> questList;
    int gold;
    int fameLevel;
    int fameXp;

    Guild() {
        init();
    }

    private void init() {
        adventurerList = new ArrayList<Adventurer>();
        questList = new ArrayList<Quest>();
        gold = 100;
        fameLevel = 1;
        fameXp = 0;
    }

    public List<Adventurer> getAdventurerList() {
        return adventurerList;
    }

    public void addAdventurer(Adventurer adventurer) {
        adventurerList.add(adventurer);
    }

    public List<Quest> getQuestList() {
        return questList;
    }

    public void addQuest(Quest quest) {
        questList.add(quest);
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public int getFameLevel() {
        return fameLevel;
    }

    public boolean addFameXp(int fameXp) {
        this.fameXp += fameXp;
        if (fameLevel < FAME_TRESHOLD.length) {
            if (this.fameXp >= FAME_TRESHOLD[fameLevel]) {
                this.fameLevel = fameLevel + 1;
                return true;
            }
        }
        return false;
    }
}

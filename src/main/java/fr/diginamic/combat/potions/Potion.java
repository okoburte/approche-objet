package fr.diginamic.combat.potions;

import fr.diginamic.combat.Personnage;

public abstract class Potion {
    public abstract void use(Personnage personnage);
    public abstract String toString();
}

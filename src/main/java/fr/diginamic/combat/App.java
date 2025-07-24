package fr.diginamic.combat;

import fr.diginamic.combat.creatures.CreatureType;
import fr.diginamic.combat.potions.Potion;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Bienvenu sur Hero Fight !");
        Scanner scanner = new Scanner(System.in);
        MenuChoice menuChoice = MenuChoice.None;
        Personnage personnage = null;

        while (menuChoice != MenuChoice.Leave) {
            System.out.println("1 - Creer un nouveau personnage");
            System.out.println("2 - Combattre une creature");
            System.out.println("3 - Utiliser une potion");
            System.out.println("4 - Afficher le score");
            System.out.println("5 - Quitter le jeu");
            try {
                int response = scanner.nextInt();
                menuChoice = getMenuChoiceByInt(response);
                switch (menuChoice){
                    case Create:
                        if(personnage == null || personnage.isDead()) personnage = creationPersonnage();
                        else {
                            String validation = "";
                            while (validation.toUpperCase() != "Y" && validation.toUpperCase() != "N"){
                                System.out.println("Un personnage existe deja. etes vous sur de vouloir le remplacer par un nouveau personnage ? (Y/N)");
                                validation = scanner.next();
                            }
                            if(validation.toUpperCase() == "Y") personnage = creationPersonnage();
                        }
                        break;
                    case Fight:
                        if(personnage == null || personnage.isDead()) System.out.println("Vous ne pouvez pas combatre sans personnage ! Veuillez creer un personnage avant de combattre.");
                        else {
                            CreatureType choixCreature = null;
                            while (choixCreature != CreatureType.Loup && choixCreature != CreatureType.Gobelin && choixCreature != CreatureType.Troll){
                                System.out.println("Quelle creature souhaitez vous combattre ?");
                                System.out.println("1 - Combattre un loup");
                                System.out.println("2 - Combattre un gobelin");
                                System.out.println("3 - Combattre un troll");
                                System.out.println("4 - Retour");
                                try {
                                    int choix = scanner.nextInt();
                                    if(choix == 4) break;
                                    choixCreature = getCreatureTypeByInt(choix);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            if(choixCreature == null) break;
                            Rencontre rencontre = new Rencontre(personnage, choixCreature);
                            boolean fuite = false;
                            while(!fuite && !rencontre.checkFinRencontre()){
                                rencontre.status();
                                try{
                                    int choix = 0;
                                    while (choix != 1 && choix != 2){
                                        System.out.println("Que souhaitez vous faire :");
                                        System.out.println("1 - Continuer le combat");
                                        System.out.println("2 - Tenter de fuir");
                                        choix = scanner.nextInt();
                                    }
                                    if(choix == 1) rencontre.nextTurn();
                                    else fuite = rencontre.fuite();
                                }
                                catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                        break;
                    case Potion:
                        if(personnage == null || personnage.isDead()) System.out.println("Vous devez dabords creer un personnage avant d'acceder aux potions !");
                        else {
                            try{
                                int choix = 0;
                                List<Potion> potionList = personnage.getPotionList();
                                affichePotionMenu(potionList);
                                while (choix < 1 || choix > potionList.size()+1){
                                    choix = scanner.nextInt();
                                }
                                if(choix == potionList.size()+1) break;
                                personnage.usePotion(choix-1);
                            }
                            catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case Score:
                        if(personnage == null || personnage.isDead()) System.out.println("Vous n'avez pas de personnage actuellement");
                        else System.out.println("Votre score actuel pour ce personnage est de " + personnage.getScore());
                        break;
                    case Leave:
                        System.out.println("Merci d'avoir jouer a Hero Fight !");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static MenuChoice getMenuChoiceByInt(int index){
        switch (index){
            case 1:
                return MenuChoice.Create;
            case 2:
                return MenuChoice.Fight;
            case 3:
                return MenuChoice.Potion;
            case 4:
                return MenuChoice.Score;
            case 5:
                return MenuChoice.Leave;
            default:
                return MenuChoice.None;
        }
    }

    private static CreatureType getCreatureTypeByInt(int index){
        switch (index){
            case 1:
                return CreatureType.Loup;
            case 2:
                return CreatureType.Gobelin;
            case 3:
                return CreatureType.Troll;
            default:
                return null;
        }
    }

    private static Personnage creationPersonnage(){
        System.out.println("Creation d'un nouveau personnage :");
        Personnage personnage = new Personnage();
        System.out.println(personnage.toString());
        return personnage;
    }

    private static void affichePotionMenu(List<Potion> potionList){
        System.out.println("Quelle potion souhaitez vous utiliser :");
        for (int i = 0; i < potionList.size(); i++) {
            System.out.println((i+1) + " - " + potionList.get(i).toString());
        }
        System.out.println((potionList.size()+1) + " - Retour");
    }

    private enum MenuChoice {
        None, Create, Fight, Potion, Score, Leave
    }
}

package fr.diginamic.recensement;

import java.util.Map;
import java.util.Scanner;

public class RecherchePopulationDepartement extends MenuService{
    @Override
    public void traiter(Map<String, Region> regionMap, Scanner scanner) {
        System.out.println("Veuillez entrer le code departement :");
        String reponse = scanner.next();
        boolean trouve = false;
        for (Region region : regionMap.values()) {
            Map<String, Departement> departementMap = region.getDepartementMap();
            if(departementMap.containsKey(reponse)) {
                System.out.println(departementMap.get(reponse).toString());
                trouve = true;
                break;
            }
        }
        if(!trouve) System.out.println("Departement non trouvé");
    }
}

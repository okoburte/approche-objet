package fr.diginamic.recensement;

import java.util.Map;
import java.util.Scanner;

public class RecherchePopulationRegion extends MenuService{
    @Override
    public void traiter(Map<String, Region> regionMap, Scanner scanner) {
        System.out.println("Veuillez entrer le code region ou le nom de la region (avec accent si present) :");
        String reponse = scanner.next();
        if(regionMap.containsKey(reponse)) System.out.println(regionMap.get(reponse).toString());
        else {
            for(Region region: regionMap.values()){
                if(region.getNomRegion().equalsIgnoreCase(reponse)) {
                    System.out.println(region);
                    return;
                }
            }
            System.out.println("Region non trouvé.");
        }
    }
}

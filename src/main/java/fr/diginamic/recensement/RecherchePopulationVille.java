package fr.diginamic.recensement;

import java.util.Map;
import java.util.Scanner;

public class RecherchePopulationVille extends MenuService {
    @Override
    public void traiter(Map<String, Region> regionMap, Scanner scanner) {
        System.out.println("Veuillez entrez le nom de la Commune :");
        String reponse = scanner.next();
        boolean trouve = false;
        for (Region region : regionMap.values()) {
            for (Departement departement : region.getDepartementMap().values()) {
                Map<String, Ville> villeMap = departement.getVilleMap();
                for (Ville ville : villeMap.values()) {
                    if (ville.getNomCommune().equalsIgnoreCase(reponse)) {
                        System.out.println(ville);
                        trouve = true;
                        break;
                    }
                }
            }
            if (trouve) break;
        }
        if(!trouve) System.out.println("Ville non trouvé.");
    }
}

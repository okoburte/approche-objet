package fr.diginamic.recensement;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RechercheVillePlusPeupleDepartement extends MenuService{
    @Override
    public void traiter(Map<String, Region> regionMap, Scanner scanner) {
        System.out.println("Veuillez entrer le code departement :");
        String reponse = scanner.next();
        boolean trouve = false;
        for (Region region: regionMap.values()){
            for (Departement departement: region.getDepartementMap().values()){
                if(departement.getCodeDepartement().equalsIgnoreCase(reponse)){
                    Map<String, Ville> villeMap = departement.getVilleMap();
                    List<Ville> top10VilleDepartement = villeMap.values().stream().sorted().limit(10).toList();
                    for (int i = 0; i < top10VilleDepartement.size(); i++) {
                        System.out.println((i+1) + " - " + top10VilleDepartement.get(i));
                    }
                    break;
                }
            }
            if(trouve) break;
        }
    }
}

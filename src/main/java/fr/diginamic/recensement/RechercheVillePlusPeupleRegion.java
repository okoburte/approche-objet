package fr.diginamic.recensement;

import java.util.*;
import java.util.stream.Collectors;

public class RechercheVillePlusPeupleRegion extends MenuService{
    @Override
    public void traiter(Map<String, Region> regionMap, Scanner scanner) {
        System.out.println("Veuillez entrer le code region ou le nom de la region (avec accent si present) :");
        String reponse = scanner.next();
        Region regionDemande = null;
        if(regionMap.containsKey(reponse)) regionDemande = regionMap.get(reponse);
        else {
            for(Region region: regionMap.values()){
                if(region.getNomRegion().equalsIgnoreCase(reponse)) {
                    regionDemande = region;
                }
            }
        }
        if(regionDemande == null) System.out.println("Region non trouvé.");
        else {
            List<Ville> villeList = new ArrayList<>();
            for(Departement departement: regionDemande.getDepartementMap().values()){
                villeList.addAll(departement.getVilleMap().values());
            }
            List<Ville> top10VilleRegion = villeList.stream().sorted().limit(10).toList();
            for (int i = 0; i < top10VilleRegion.size(); i++) {
                System.out.println((i+1) + " - " + top10VilleRegion.get(i));
            }
        }
    }
}

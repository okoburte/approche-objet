package fr.diginamic.recensement;

import java.util.*;
import java.util.stream.Collectors;

public class RechercheVillePlusPeuple extends MenuService{
    @Override
    public void traiter(Map<String, Region> regionMap, Scanner scanner) {
        List<Ville> villeList = new ArrayList<>();
        for(Region region: regionMap.values()){
            for(Departement departement: region.getDepartementMap().values()){
                villeList.addAll(departement.getVilleMap().values());
            }
        }
        List<Ville> top10Ville = villeList.stream().sorted().limit(10).toList();
        for (int i = 0; i < top10Ville.size(); i++) {
            System.out.println((i+1) + " - " + top10Ville.get(i));
        }
    }
}

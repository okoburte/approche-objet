package fr.diginamic.recensement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RechercheDepartementPlusPeuple extends MenuService{
    @Override
    public void traiter(Map<String, Region> regionMap, Scanner scanner) {
        Map<String, Departement> departementMap = new HashMap<>();
        for(Region region: regionMap.values()){
            departementMap.putAll(region.getDepartementMap());
        }
        List<Departement> top10Departements = departementMap.values().stream().sorted().limit(10).toList();
        for (int i = 0; i < top10Departements.size(); i++) {
            System.out.println((i+1) + " - " + top10Departements.get(i));
        }
    }
}

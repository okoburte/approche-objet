package fr.diginamic.recensement;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RechercheRegionPlusPeuple extends MenuService{
    @Override
    public void traiter(Map<String, Region> regionMap, Scanner scanner) {
        List<Region> top10Regions = regionMap.values().stream().sorted().limit(10).toList();
        for (int i = 0; i < top10Regions.size(); i++) {
            System.out.println((i+1) + " - " + top10Regions.get(i));
        }
    }
}

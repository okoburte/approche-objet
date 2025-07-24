package fr.diginamic.recensement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class LectureFichier {
    private static Map<String, Region> regionMap = new HashMap<>();

    public static void main(String[] args) {
        final String FILE_PATH = "recensement.csv";

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH)));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                addLine(reader.readLine().split(";"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int choix = 0;
        Scanner scanner = new Scanner(System.in);
        while (choix != 9){
            choix = 0;
            System.out.println("1. Population d'une ville donnée");
            System.out.println("2. Population d'un departement donnée");
            System.out.println("3. Population d'une region donnée");
            System.out.println("4. Afficher les 10 regions les plus peuplées");
            System.out.println("5. Afficher les 10 departement les plus peuplés");
            System.out.println("6. Afficher les 10 villes les plus peuplées d'un departement");
            System.out.println("7. Afficher les 10 villes les plus peuplées d'une region");
            System.out.println("8. Afficher les 10 villes les plus peuplées de France");
            System.out.println("9. Sortir");
            while (choix < 1 || choix > 9) {
                try {
                    choix = scanner.nextInt();
                    switch (choix){
                        case 1:
                            RecherchePopulationVille recherche1 = new RecherchePopulationVille();
                            recherche1.traiter(regionMap, scanner);
                            break;
                        case 2:
                            RecherchePopulationDepartement recherche2 = new RecherchePopulationDepartement();
                            recherche2.traiter(regionMap, scanner);
                            break;
                        case 3:
                            RecherchePopulationRegion recherche3 = new RecherchePopulationRegion();
                            recherche3.traiter(regionMap, scanner);
                            break;
                        case 4:
                            RechercheRegionPlusPeuple recherche4 = new RechercheRegionPlusPeuple();
                            recherche4.traiter(regionMap, scanner);
                            break;
                        case 5:
                            RechercheDepartementPlusPeuple recherche5 = new RechercheDepartementPlusPeuple();
                            recherche5.traiter(regionMap, scanner);
                            break;
                        case 6:
                            RechercheVillePlusPeupleDepartement recherche6 = new RechercheVillePlusPeupleDepartement();
                            recherche6.traiter(regionMap, scanner);
                            break;
                        case 7:
                            RechercheVillePlusPeupleRegion recherche7 = new RechercheVillePlusPeupleRegion();
                            recherche7.traiter(regionMap, scanner);
                            break;
                        case 8:
                            RechercheVillePlusPeuple recherche8 = new RechercheVillePlusPeuple();
                            recherche8.traiter(regionMap, scanner);
                            break;
                        case 9:
                            System.out.println("Sortie en cours");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }

    public static void addLine(String[] dataParts) {
        if (dataParts.length < 1) return;

        Ville ville = new Ville(dataParts[DataIndex.NomCommune.getDataIndex()], dataParts[DataIndex.CodeCommune.getDataIndex()], Integer.parseInt(dataParts[DataIndex.PopTotal.getDataIndex()].replace(" ", "")));
        if (regionMap.containsKey(dataParts[DataIndex.CodeRegion.getDataIndex()])) {
            Map<String, Departement> departementMap = regionMap.get(dataParts[DataIndex.CodeRegion.getDataIndex()]).getDepartementMap();
            if (departementMap.containsKey(dataParts[DataIndex.CodeDepartement.getDataIndex()])) {
                Map<String, Ville> villeMap = departementMap.get(dataParts[DataIndex.CodeDepartement.getDataIndex()]).getVilleMap();
                villeMap.put(ville.getCodeCommune(), ville);
            } else {
                Departement departement = new Departement(dataParts[DataIndex.CodeDepartement.getDataIndex()]);
                departementMap.put(departement.getCodeDepartement(), departement);
                departement.getVilleMap().put(ville.getCodeCommune(), ville);
            }
        } else {
            Region region = new Region(dataParts[DataIndex.CodeRegion.getDataIndex()], dataParts[DataIndex.NomRegion.getDataIndex()]);
            regionMap.put(region.getCodeRegion(), region);
            Departement departement = new Departement(dataParts[DataIndex.CodeDepartement.getDataIndex()]);
            region.getDepartementMap().put(departement.getCodeDepartement(), departement);
            departement.getVilleMap().put(ville.getCodeCommune(), ville);
        }
    }
}

package fr.diginamic.recensement;

import java.util.Map;
import java.util.Scanner;

public abstract class MenuService {
    public abstract void traiter(Map<String, Region> regionMap, Scanner scanner);
}

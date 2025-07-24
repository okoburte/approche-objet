package fr.diginamic.essais;

import fr.diginamic.operations.Operations;

public class TestOperations {
    public static void main(String[] args) {
        System.out.println("5 + 3 = " + Operations.Calcul(5, 3, '+'));
        System.out.println("1 - 3 = " + Operations.Calcul(1, 3, '-'));
        System.out.println("9 * 3 = " + Operations.Calcul(9, 3, '*'));
        System.out.println("9 / 3 = " + Operations.Calcul(9, 3, '/'));
        System.out.println("9 / 0 = " + Operations.Calcul(9, 0, '/'));
        System.out.println("9 j 3 = " + Operations.Calcul(9, 3, 'j'));
    }
}

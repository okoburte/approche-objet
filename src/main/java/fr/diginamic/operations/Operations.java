package fr.diginamic.operations;

public class Operations {
    public static double Calcul(double a, double b, char op){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if (b != 0) return a/b;
            default:
                System.out.println("Erreur lors de l'operation. assurer vous d'utiliser les caractere +, -, * ou / (b != 0 dans le cas de /).");
                return 0;
        }
    }
}

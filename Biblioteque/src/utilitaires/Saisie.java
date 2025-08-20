package utilitaires;

import java.util.Scanner;

public class Saisie {
    private static Scanner sc = new Scanner(System.in);

    public static int lireEntier() {
        return sc.nextInt();
    }

    public static String lireChaine() {
        sc.nextLine();
        return sc.nextLine();
    }
}

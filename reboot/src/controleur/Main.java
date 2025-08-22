package controleur;

import utilitaires.Saisie;
import vue.Vue;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 10; i++) {
//            System.out.println("tape dans tes mains" + (i));
//        }
//        int numberOfTrees = 0;
//        while (numberOfTrees < 10) {
//            numberOfTrees++;
//            System.out.println("j ai planté " + numberOfTrees + " arbres ");
//        }
//        System.out.println("Vive la nature");

//        int pushUpGoal = 10;
//        do {
//            System.out.println("Push up !"+pushUpGoal);
//            pushUpGoal -= 1;
//        }
//        while (pushUpGoal > 0);
//        System.out.println("Bonne Année");
        boolean fin = false;

        while (!fin) {
            Vue.vueMenu();
            System.out.println("> Votre Choix [1-6] ou [0] pour quitter :");
            int selection = Saisie.lireEntier();
            switch (selection)
            {
                case 0:
                    fin = true;
                    System.out.println("Merci et à bientôt");
                break;

                case 1:
                    Vue.vueCreation();
                    break;
                case 2:
                    System.out.println("case2");
                    break;
                case 3:
                    System.out.println("case3");
                    break;
                case 4:
                    System.out.println("case4");
                    break;
                case 5:
                    System.out.println("case5");
                    break;
                default:
                    // choix en erreur
                    System.err.println("! Choix incorrect ! [0-6] !");
                    break;
            }
        }
    }
}








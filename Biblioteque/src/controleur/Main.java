package controleur;

import modele.Abonnes;
import modele.Employe;
import modele.Livre;
import modele.Livreprete;
import utilitaires.Saisie;
import vue.Vue;

import java.util.Scanner;

//import static vue.Vue.captureutilisateur;


public class Main {
    public static void main(String[] args) {

        String nom, prenom, email;
        String REGEX = "^\\p{L}+$";
        String REGEXMAIL = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

        Abonnes Abonnes00 = new Abonnes("Temiro", "Chantal", "Temiro.Chantal@yahoo.fr");
        Abonnes.getAbonnes().add(Abonnes00);
        Abonnes Abonnes01 = new Abonnes("Kull", "Jean", "Jean.Kull@lesmouches.fr");
        Abonnes.getAbonnes().add(Abonnes01);
        Employe Simone = new Employe("Vielle", "Simone", "1245421");
        Employe Gilbert = new Employe("Montagné", "Gilbert", "1010101");
        Livre livre0 = new Livre(9999999999999l, "Le Seigneur des Anneaux : la communauté de l'Anneau", "J.R.R Tolkien", 5);
        Livre.getLivres().add(livre0);
        Livre livre1 = new Livre(9999999999998l, "Le Seigneur des Anneaux : les deux tours", "J.R.R Tolkien", 5);
        Livre.getLivres().add(livre1);
        Scanner sc = new Scanner(System.in);
        Boolean fin = false;

        while (!fin) {
        Vue.vueMenu();
        System.out.println("Votre Choix [1 -6] ou [0] pour quitter : ");
        int selection = Saisie.lireEntier();
        switch (selection)
        {
            case 0:
                fin = true;
                System.out.println("au revoir");
                break;
            case 1:
                Vue.vueCreation();
                break;
            case 2:
                System.out.println("Enregistrer un nouveau livre");
                break;
            case 3:
                System.out.println("Enregistrer un nouveau pret");
                break;
            case 4:
                System.out.println("-----Afficher la liste des abonnés-----\n");
                for (Abonnes abonne : Abonnes.getAbonnes()) {
                    System.out.println(abonne);
                }
                break;
            case 5:
                System.out.println("afficher la liste des livres");
                for (Livre livre : Livre.getLivres()) {
                    System.out.println(livre);
                }
                break;
            case 6:
                System.out.println("afficher la liste des prets");
                for (Livreprete livrepretes : Livreprete.getLivrepretes()) {
                    System.out.println(livrepretes);
                }
                break;
            default:
                System.err.println("! Choix incorrect ! [0-6] !");
                break;
                }

            }
        }
}

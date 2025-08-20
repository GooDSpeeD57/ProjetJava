package controleur;

import modele.Abonnes;
import modele.Employe;
import modele.Livre;
import modele.Livreprete;
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

        Vue.vueMenu();
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()) {
            case 0:
                System.out.println("au revoir");
                break;
            case 1:
                boolean erreur = true;
                sc.nextLine();
                do {
                    System.out.println("Le nom ?");
                    nom = sc.nextLine().trim();
                    if (!nom.matches(REGEX)) {
                        System.err.println("Le nom est incorrect ! merci de resaisir");
                    } else {
                        erreur = false;
                    }
                } while (erreur);

                erreur = true;
                do {
                    System.out.println("le prenom ?");
                    prenom = sc.nextLine().trim();
                    if (!prenom.matches(REGEX)) {
                        System.err.println("Le prénom est incorrecte ! merci de resaisir");
                    } else {
                        erreur = false;
                    }
                } while (erreur);

                erreur = true;
                do {
                    System.out.println("le mail ?");
                    email = sc.nextLine().trim();
                    if (!email.matches(REGEXMAIL)) {
                        System.err.println("Le mail comporte une erreurs ! merci de resaisir");
                    } else {
                        erreur = false;
                    }
                } while (erreur);
                Abonnes abonnes = new Abonnes(nom, prenom, email);
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
        }
    }
}

package vue;
import modele.Abonnes;
import modele.Livre;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Vue {
    private static Scanner sc = new Scanner(System.in);

    private static String nom, prenom, email, isbn, titre, auteur;
    private static int quantitedisponible;


    public static String getNom() {
        return nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static String getEmail() {
        return email;
    }

    public static void vueMenu() {

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║                                        ║");
        System.out.println("║                Bienvenue               ║");
        System.out.println("║                                        ║");
        System.out.println("║          Application Biblioteque       ║");
        System.out.println("║                                        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║       _.--._  _.--._                   ║");
        System.out.println("║  ,-=.-\":;:;:;\\':;:;:;\"-._              ║");
        System.out.println("║  \\\\\\:;:;:;:;:;\\:;:;:;:;:;\\             ║");
        System.out.println("║   \\\\\\:;:;:;:;:;\\:;:;:;:;:;\\            ║");
        System.out.println("║    \\\\\\:;:;:;:;:;\\:;:;:;:;:;\\           ║");
        System.out.println("║     \\\\\\:;:;:;:;:;\\:;:;:;:;:;\\          ║");
        System.out.println("║      \\\\\\;:;::;:;:;\\:;:;:;::;:\\         ║");
        System.out.println("║       \\\\\\;;:;:_:--:\\:_:--:_;:;\\        ║");
        System.out.println("║        \\\\\\_.-\"      :      \"-._\\       ║");
        System.out.println("║         \\`_..--\"\"--.;.--\"\"--.._=>      ║");
        System.out.println("╠════════════════════════════════════════╣");
    }
    public static void vueMenuglobal(){
        System.out.println("║         Que voulez vous faire ?        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1 : Enregistrer un nouvel abonné       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 2 : Enregistrer un nouveau livre       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 3 : Enregistrer un nouveau prêt        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 4 : Afficher la liste des abonnées     ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 5 : Afficher la liste des livres       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 6 : Afficher la liste des prêts        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 0 : quitter                            ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    public static void vueMenuLivre() {

        System.out.println("║         Que voulez vous faire ?        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1 : Recherche Livre                    ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 2 : Recherche Abonnées                 ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 3 : Identifiant                        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 4 : Cree un pret                       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 5 : Afficher la liste des prêts        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 0 : Quitter                            ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    public static void vueMenuRechLivre() {

        System.out.println("║         Recherche de Livre             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1 : Par ISBM  10 ou 13 n°              ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 2 : Par Titre                          ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 3 : Par Auteur                         ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 0 : Quitter                            ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    public static void vueMenuAbonne() {


        System.out.println("║            Recherche Abonnées          ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1 : Par Nom                            ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 2 : Par Email                          ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 0 : Quitter                            ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    public static void vueCreation() {

        System.out.println("Création d'un abonné");
        nom = saisieUtilisateur("Le nom ?", "Le nom est incorrect ! merci de resaisir");
        prenom = saisieUtilisateur("Le prenom ?", "Le prenom est incorrect ! merci de resaisir");
        email = saisieMailUtilisateur("Le mail ?", "Le mail est incorrect ! merci de resaisir");
        Abonnes Abonnes00 = new Abonnes(nom, prenom, email);
        Abonnes.getAbonnes().add(Abonnes00);
    }

    public static void vueCreaLivre() {

        System.out.println("Création d'un livre");
        isbn = saisieISBN("ISBN 10 ou 13 chiffre", "ISBN est incorrect ! merci de resaisir");
        titre = saisieAuteur("Le Titre ?", "Le Titre est incorrect ! merci de resaisir");
        auteur = saisieAuteur("Auteur ?", "L'auteur est incorrect ! merci de resaisir");
        quantitedisponible = saisiequantite("Quantité", "la valeur ne peut pas etre négative");
        Livre Livre00 = new Livre(isbn, titre, auteur, quantitedisponible);
        Livre.getLivres().add(Livre00);

    }

    private static String saisieUtilisateur(String message, String messageException) {

        String saisie = "";
        String REGEX = "^\\p{L}+$";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim().toUpperCase();
            if (!saisie.matches(REGEX)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private static String saisieMailUtilisateur(String message, String messageException) {

        String saisie = "";
        String REGEX = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim().toUpperCase();
            if (!saisie.matches(REGEX)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    private static int saisiequantite(String message, String messageException) {

        int saisie;
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextInt();
            if (saisie < 0) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    public static String saisieISBN(String message, String messageException) {

        String saisie = "";
        String REGEX = "^(?:\\d{10}|\\d{13})$";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!saisie.matches(REGEX)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);

        return saisie;
    }

    public static String saisieAuteur(String message, String messageException) {

        String saisie = "";
        String REGEX = "^(?! )[A-Za-zÀ-ÖØ-öø-ÿ0-9'’\"():;!?.,\\- ]+(?<! )$";
        boolean erreur = true;

        do {
            System.out.println(message);
            saisie = sc.nextLine().trim();
            if (!saisie.matches(REGEX)) {
                System.err.println(messageException);
            } else {
                erreur = false;
            }
        } while (erreur);
        return saisie;
    }
}




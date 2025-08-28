package vue;
import exception.SaisieException;
import modele.Abonnes;
import modele.Livre;
import utilitaires.Saisie;
import java.util.Scanner;

public class Vue {
    private static Scanner sc = new Scanner(System.in);

    private static String nom, prenom, email, isbn, titre, auteur;
    private static int quantitedisponible;

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
        System.out.println("║ 0 : Quitter                            ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    public static void vueMenuLivre() {

        System.out.println("║         Que voulez vous faire ?        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1 : Recherche Livre                    ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 2 : Recherche Abonnées                 ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 3 : Créer un pret                       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 4 : Afficher la liste des prêts        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour Menu Principal              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    public static void vueMenuRechLivre() {

        System.out.println("║         Recherche de Livre             ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1 : Par ISBN  10 ou 13 n°              ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 2 : Par Titre                          ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 3 : Par Auteur                         ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour Menu Précedent              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    public static void vueMenuAbonne() {


        System.out.println("║            Recherche Abonnées          ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1 : Par Nom                            ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 2 : Par Email                          ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 0 : Retour Menu Précedent              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
    public static void vueCreation() {

        System.out.println("Création d'un abonné");
        nom = saisieUtilisateur("Le nom ?", "Le nom est incorrect ! merci de resaisir");
        prenom = saisieUtilisateur("Le prenom ?", "Le prenom est incorrect ! merci de resaisir");
        email = saisieMailUtilisateur("Le mail ?", "Le mail est incorrect ! merci de resaisir");
        Abonnes nouvelAbonne = new Abonnes(nom, prenom, email);

    }

    public static void vueCreaLivre() throws SaisieException {

        System.out.println("Création d'un livre");
        isbn = saisieISBN("ISBN 10 ou 13 chiffre", "ISBN est incorrect ! merci de resaisir");
        titre = saisieAuteur("Le Titre ?", "Le Titre est incorrect ! merci de resaisir");
        auteur = saisieAuteur("Auteur ?", "L'auteur est incorrect ! merci de resaisir");
        quantitedisponible = Saisie.lireEntier("Quantité", "la valeur ne peut pas etre négative");
        Livre nouveauLivre = new Livre(isbn, titre, auteur, quantitedisponible);


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

    public static String saisieMailUtilisateur(String message, String messageException) {

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




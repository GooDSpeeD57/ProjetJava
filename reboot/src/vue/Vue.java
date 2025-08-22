package vue;
import java.time.LocalDate;
import java.util.Scanner;



public class Vue {
    private static Scanner sc = new Scanner(System.in);
    private static String nom;
    private static String prenom;
    private static String email;

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
        System.out.println("║         Que voulez vous faire ?        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1 : enregistrer un nouvel abonné       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 2 : enregistrer un nouveau livre       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 3 : enregistrer un nouveau prêt        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 4 : afficher la liste des abonnées     ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 5 : afficher la liste des livres       ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 6 : afficher la liste des prêts        ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 0 : quitter                            ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    public static void vueCreation() {

        System.out.println("Création d'un abonné");


        nom = saisieUtilisateur("Le nom ?", "Le nom est incorrect ! merci de resaisir");
        prenom = saisieUtilisateur("Le prenom ?", "Le prenom est incorrect ! merci de resaisir");
        email = saisieMailUtilisateur("Le mail ?", "Le mail est incorrect ! merci de resaisir");
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
}
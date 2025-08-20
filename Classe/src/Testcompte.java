import java.util.Scanner;

public class Testcompte {
    public static void main(String[] args) {
                Testcompte testcompte = new Testcompte();
        testcompte.run();
    }
     public static void run (){
        double newsadd=0;
        double newsremove=0;
        Scanner sc = new Scanner(System.in);
        Compte compte = new Compte();
        System.out.println("Verssemnt : ");
        newsadd = sc.nextInt();
       compte.deposer(newsadd);
       compte.nouveausolde();
       System.out.println("Sommes a retirer : ");
       newsremove = sc.nextInt();
       compte.retirer(newsremove);
       compte.nouveausolde();
     }
}

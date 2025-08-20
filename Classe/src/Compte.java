public class Compte {
    public double solde=0;
    public void deposer(double valeur){
        this.solde+=valeur;
    };
    public void retirer(double valeur) {
        this.solde -= valeur;
    };
    public void nouveausolde(){
        System.out.println("nouveaux solde :"+solde);
        }
 }





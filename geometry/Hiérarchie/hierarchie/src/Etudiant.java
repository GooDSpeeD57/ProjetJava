public class Etudiant extends Personne {
    private String programme;
    private int annee;
    private double fraisscolaires;
Etudiant(String name, String adresse,String programme, int annee, double fraisscolaires) {
    super(name, adresse);
        this.programme = programme;
        this.annee = annee;
        this.fraisscolaires = fraisscolaires;

}
@Override
    public String toString() {return"nom"+getNom()+"adresse"+getAdresse()+"programme"+programme+"annee"+annee;}
}

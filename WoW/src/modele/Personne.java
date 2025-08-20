package modele;
import java.util.ArrayList;
import java.util.List;

public class Personne {

    private String nom;
    private String race;
    private String classe;
    private int niveau=1;
    private int pointdevie=100;

    public Personne(String nom, String race, String classe, int niveau, int pointdevie) {
        this.setNom(nom);
        this.setRace(race);
        this.setClasse(classe);
        this.setNiveau(niveau);
        this.setPointdevie(pointdevie);

    }
    public Personne(String nom, String race, String classe) {
        this.setNom(nom);
        this.setRace(race);
        this.setClasse(classe);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getPointdevie() {
        return pointdevie;
    }

    public void setPointdevie(int pointdevie) {
        this.pointdevie = pointdevie;
    }
    @Override
    public String toString() {
        return "\n"+this.getNom() + "\nJe suis un  " + this.getRace() + "\nJe suis un(e)  " + this.getClasse() + "\nPoint de vie " + this.getPointdevie();
    }
}

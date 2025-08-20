package modele;
import java.util.ArrayList;
import java.util.List;

public class Voleur extends Personne {

    private int agilite;

    private static List<Voleur> voleurs = new ArrayList<>();

    public Voleur(String nom, String race, String classe, int niveau, int pointdevie, int agilite)  {
        super(nom,race,classe,niveau,pointdevie);
        this.setAgilite(agilite);
    }
    public Voleur(String nom, String race, String classe)  {
        super(nom,race,classe,1,100);
        this.setAgilite(100);
    }
    public static List<Voleur> getVoleurs() {
        return voleurs;

    }
    public int getAgilite() {
        return agilite;
    }
    public void setAgilite(int agilite) {
        this.agilite  = agilite;
    }
    @Override
    public String toString() {
        return super.toString() + "\nagilité = " + this.getAgilite();
    }
}




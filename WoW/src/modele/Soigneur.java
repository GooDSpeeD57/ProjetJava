package modele;
import java.util.ArrayList;
import java.util.List;

public class Soigneur extends Personne {

    private int pointdemana;

    private static List<Soigneur> soigneurs = new ArrayList<>();

    public Soigneur(String nom, String race, String classe, int niveau, int pointdevie, int pointdemana)  {
        super(nom,race,classe,niveau,pointdevie);
        this.setPointdemana(pointdemana);
    }
    public Soigneur(String nom, String race, String classe)  {
        super(nom,race,classe,1,100);
        this.setPointdemana(10);
    }
    public static List<Soigneur> getSoigneurs() {
        return soigneurs;
    }
    public int getPointdemana() {
        return pointdemana;
    }
    public void setPointdemana(int pointdemana) {
        this.pointdemana  = pointdemana;
    }
    @Override
    public String toString() {
        return super.toString() + "\nPoint de force = " + this.getPointdemana();
    }
}




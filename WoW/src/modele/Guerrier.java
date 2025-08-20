package modele;
import java.util.ArrayList;
import java.util.List;

public class Guerrier extends Personne {

    private int force;

    private static List<Guerrier> guerriers = new ArrayList<>();

    public Guerrier(String nom, String race, String classe, int niveau, int pointdevie,int force)  {
        super(nom,race,classe,niveau,pointdevie);
        this.setForce(force);
    }
    public Guerrier(String nom, String race, String classe)  {
        super(nom,race,classe,1,100);
        this.setForce(10);
    }
    public static List<Guerrier> getGuerriers() {
        return guerriers;
    }
    public int getForce() {
        return force;
    }
    public void setForce(int force) {
        this.force = force;
    }
    @Override
    public String toString() {
    return super.toString() + "\nPoint de force = " + this.getForce();
    }
}




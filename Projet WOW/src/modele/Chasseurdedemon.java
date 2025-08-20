package modele;

import java.util.ArrayList;
import java.util.List;

public class Chasseurdedemon extends Personnage {
    private static List<Chasseurdedemon> chasseurdedemons = new ArrayList();
    private int pointdagilite;

    public Chasseurdedemon(String faction, String race,String classe,String nom, int niveau, int pointdevie, int pointdagilite) {
        super(faction,race,classe,nom,niveau,pointdevie);
        this.setPointdagilite(pointdagilite);
    }
    public static List<Chasseurdedemon> getChasseurdedemons() {
        return chasseurdedemons;
    };
    public int getPointdagilite() {
        return this.pointdagilite;
    }

    public void setPointdagilite(int pointdagilite) {
        this.pointdagilite = pointdagilite;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPoint d' agilité " + pointdagilite;
    }
}

package modele;
import java.util.ArrayList;

public class Druide extends Personnage {
    private static ArrayList <Druide>listDruides = new ArrayList<>();
    private int pointdemana;

    public Druide(String faction, String race,String classe,String nom, int niveau, int pointdevie, int pointdemana)
    {
       super(faction,race,classe,nom,niveau,pointdevie);
       this.pointdemana = pointdemana;
    }
    public int getPointdemana() {
        return pointdemana;
    }
    public void setPointdemana(int pointdemana) {
        this.pointdemana = pointdemana;
    }
    @Override
    public String toString() {
        return super.toString()+" Point de mana "+pointdemana;
    }
}

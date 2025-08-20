package modele;
import java.util.ArrayList;
import java.util.List;

public class Guerrier extends Personnage {
    private static List<Guerrier> Guerriers = new ArrayList();
            private int pointdeforce;
        public Guerrier(String faction, String race,String classe,String nom, int niveau, int pointdevie,int pointdeforce)
        {
            super(faction,race,classe,nom,niveau,pointdevie);
            this.setPointdeforce(pointdeforce);
        }
        public static List<Guerrier>getGuerriers(){
            return Guerriers;
        }
        public int getPointdeforce() {
            return this.pointdeforce;
        }
        public void setPointdeforce(int pointdeforce) {
            this.pointdeforce = pointdeforce;
        }
        @Override
        public String toString() {
            return super.toString()+" Point de force "+pointdeforce;
        }
}

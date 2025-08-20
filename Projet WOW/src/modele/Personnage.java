package modele;

public class Personnage {
    private String faction;
    private String race;
    private String classe;
    private String nom;
    private int niveau;
    private int pointdevie;
    ;

    public Personnage(String faction, String race,String classe,String nom, int niveau, int pointdevie) {
        this.setFaction(faction);
        this.setRace(race);
        this.setClasse(classe);
        this.setNom(nom);
        this.setNiveau(niveau);
        this.setPointdevie(pointdevie);
    }
    public Personnage(String faction,String race,String classe,String nom) {
        this.setFaction(faction);
        this.setRace(race);
        this.setClasse(classe);
        this.setNom(nom);
        this.setNiveau(1);
        this.setPointdevie(100);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return ("mon pseudo est : " + this.getNom() + "\nje suis dans la faction : " + this.getFaction() + "\nje suis un : " + this.getRace() + "\nje suis un "+this.getClasse()+"\nje suis de niveau "+ this.getNiveau()+"\nPoint de vie "+this.getPointdevie());
    }
}



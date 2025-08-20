public class Personnel extends Personne {
    private String etablissement;
    private String salaire;
    public Personnel(String nom,String adresse,String etablissement, String salaire) {
        super (nom, adresse);
        this.etablissement = etablissement;
        this.salaire = salaire;
    }
    public String getEtablissement() {
        return etablissement;
    }
    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }
    public String getSalaire() {
        return salaire;
    }
    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }
    @Override
    public String toString() {return"nom"+getNom()+"adresse"+getAdresse()+"etablissement"+etablissement+"salaire : "+salaire;}
}

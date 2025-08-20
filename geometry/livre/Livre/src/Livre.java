public class Livre {
    private String titre, auteur;
    private int nbpage;
    private double prix;
public Livre(String titre, String auteur, int nbpage, double prix) {
    this.titre = titre;
    this.auteur = auteur;
    this.nbpage = nbpage;
    this.prix = prix;
    }
public Livre(String titre, String auteur, int nbpage) {
    this.titre = titre;
    this.auteur = auteur;
    setNbpage(nbpage);
}
    public Livre () {};

    public Livre (String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = this.auteur;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public int getNbpage() {
        return nbpage;
    }
    public void setNbpage(int nbpage) {
                if (nbpage <=0 ) {
            System.err.println("le nombre de pages ne peut etre négatif");

        }else{this.nbpage = nbpage;}
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        if (prixfixe() == false){
//            if (!prixfixe()){  simplification
        this.prix = prix;
    }
        else{System.err.println("prix deja fixe");
        }
    }
    public boolean prixfixe (){
        if (prix==0) {return false;}
   else {return true;}
    }
    public String affichetoi (){return "Auteur : " +getAuteur()+"\n"+"Titre : "+getTitre()+"\n"+"Nombre de pages : "+getNbpage()+"\n"+"Prix : "+getPrix() ;}
}



package modele;

import java.util.ArrayList;
import java.util.List;

public class Livre {
    private String isbn,titre,auteur;
    private int quantitedisponible;

    private static List<Livre> livres = new ArrayList<>();

    public Livre(String isbn,String titre,String auteur,int quantitedisponible){
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.quantitedisponible = quantitedisponible;
    }
    public static List<Livre> getLivres() {
        return livres;
    }
    public static void setLivres(List<Livre> livres) {
        Livre.livres = livres;
    }
    public void setLivre(Livre livre){
        this.livres.add(livre);
    }
    public static Livre rechercherParISBN(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equalsIgnoreCase(isbn)) {
                return livre;
            }
        }
        return null;
    }
    public static Livre rechercherParTitre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().toLowerCase().contains(titre.toLowerCase())) {
                return livre;
            }
        }
        return null;
    }
    public static Livre rechercherParAuteur(String auteur) {
        for (Livre livre : livres) {
            if (livre.getAuteur().toLowerCase().contains(auteur.toLowerCase())) {
                    return livre;  }
        }
        return null;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = this.titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public int getQuantitedisponible() {
        return quantitedisponible;
    }
    public void setQuantitedisponible(int quantitedisponible) {
        this.quantitedisponible = quantitedisponible;
    }
    @Override
    public String toString() {
        return this.isbn+"\n"+this.titre+"\n"+this.auteur+"\n"+this.quantitedisponible;
    }
}




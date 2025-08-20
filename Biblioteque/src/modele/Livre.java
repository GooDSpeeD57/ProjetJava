package modele;

import java.util.ArrayList;
import java.util.List;

public class Livre {
    private long isbn;
    private String nom;
    private String auteur;
    private int quantitedisponible;

    private static List<Livre> livres = new ArrayList<>();

    public Livre(long isbn,String nom,String auteur,int quantitedisponible){
        this.isbn = isbn;
        this.nom = nom;
        this.auteur = auteur;
        this.quantitedisponible = quantitedisponible;
    }
    public static List<Livre> getLivres() {
        return livres;
    }
    public static void setLivres(List<Livre> livres) {
        Livre.livres = livres;
    }
    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
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
        return this.isbn+"\n"+this.nom+"\n"+this.auteur+"\n"+this.quantitedisponible;
    }
}




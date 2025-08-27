package modele;

import java.util.ArrayList;
import java.util.List;

public class Livre {
    private String isbn,titre,auteur;
    private int quantitedisponible;

    private static List<Livre> livres = new ArrayList<>();

    public Livre(String isbn,String titre,String auteur,int quantitedisponible){
        this.setIsbn(isbn);
        this.setTitre(titre);
        this.setAuteur(auteur);
        this.setQuantitedisponible(quantitedisponible);
        livres.add(this);
    }

    public static Livre rechercherParISBN(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equalsIgnoreCase(isbn)) {
                return livre;
            }
        }
        return null;
    }
    public static List<Livre> rechercherParTitre(String auteur) {
        List<Livre> resultats = new ArrayList<>();
            for (Livre livre : livres) {
                if (livre.getTitre().toLowerCase().contains(auteur.toLowerCase())) {
                resultats.add(livre);
            }
        }
        return resultats;
    }
    public static List<Livre> rechercherParAuteur(String auteur) {
        List<Livre> resultats = new ArrayList<>();
            for (Livre livre : livres) {
                if (livre.getAuteur().toLowerCase().contains(auteur.toLowerCase())) {
                resultats.add(livre);
            }
        }
        return resultats;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        if (isbn == null || !isbn.matches("^(?:\\d{10}|\\d{13})$")) {
            throw new IllegalArgumentException("L'ISBN doit contenir exactement 10 ou 13 chiffres.");
        }
        this.isbn = isbn;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        if (titre == null || titre.trim().isEmpty() || !titre.matches("^(?! )[A-Za-zÀ-ÖØ-öø-ÿ0-9'’\"():;!?.,\\- ]+(?<! )$")) {
            throw new IllegalArgumentException("Pas d espace avant ou apres.");
        }
        this.titre = this.titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        if (auteur == null || auteur.trim().isEmpty() || !auteur.matches("^(?! )[A-Za-zÀ-ÖØ-öø-ÿ0-9'’\"():;!?.,\\- ]+(?<! )$")) {
            throw new IllegalArgumentException("Pas d espace avant ou apres.");
        }
        this.auteur = auteur;
    }
    public int getQuantitedisponible() {
               return quantitedisponible;
    }
    public void setQuantitedisponible(int quantitedisponible) {
        if (quantitedisponible < 0 ) {
            throw new IllegalArgumentException("la quantiré ne peut etre inferieure a 0");
        }
        this.quantitedisponible = quantitedisponible;
    }
    public static List<Livre> getLivres() {
        return livres;
    }
    @Override
    public String toString() {
        return this.isbn+"\n"+this.titre+"\n"+this.auteur+"\n"+this.quantitedisponible;
    }
}




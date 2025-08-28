package modele;
import exception.SaisieException;

import java.io.Serializable;

public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nom;
    private String prenom;

    public Personne(String nom,String prenom){
        this.setNom(nom);
        this.setPrenom(prenom);
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public void setNom(String nom) {
        if (nom == null ||nom.trim().length() < 3 || !nom.matches("^\\p{L}+$")) {
            throw new IllegalArgumentException("Erreur dans le nom ! Merci de corriger");
        } else {
            this.nom = nom;
        }
    }
    public void setPrenom(String prenom) {
        if (prenom == null ||prenom.trim().length() < 3 || !prenom.matches("^\\p{L}+$")) {
            throw new IllegalArgumentException("Erreur dans le prenom ! Merci de corriger");
        } else {
            this.prenom = prenom;
        }
    }
public String toString(){
        return "Nom : "+this.nom+"\nPrénom : "+this.prenom;
        }
}


package modele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Groupe {
    private String nom;
    private Guerrier guerrier;
    private Voleur voleur;
    private Soigneur soigneur;
    private LocalDate dateCreation;
    private static List<Groupe> groupes=new ArrayList<>();

    public Groupe(String nom, Guerrier guerrier, Voleur voleur ,Soigneur soigneur) {
        this.setNom(nom);
        this.setGuerrier(guerrier);
        this.setSoigneur(soigneur);
        this.setVoleur(voleur);
    }
    public Groupe(String nom, Guerrier guerrier, Voleur voleur , Soigneur soigneur, LocalDate datecreation) {
        this.setNom(nom);
        this.setGuerrier(guerrier);
        this.setSoigneur(soigneur);
        this.setVoleur(voleur);
        this.setDateCreation(datecreation);

    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Guerrier getGuerrier() {
        return guerrier;
    }
    public void setGuerrier(Guerrier guerrier) {
        this.guerrier = guerrier;
    }
    public Voleur getVoleur() {
        return voleur;
    }
    public void setVoleur(Voleur voleur) {
        this.voleur = voleur;
    }
    public Soigneur getSoigneur() {
        return soigneur;
    }
    public void setSoigneur(Soigneur soigneur) {
        this.soigneur = soigneur;
    }
    public LocalDate getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }
    public static List<Groupe> getGroupes() {
        return groupes;
    }
    public static void setGroupes(List<Groupe> groupes) {
        Groupe.groupes = groupes;
    }

    @Override
    public String toString() {

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        String dateCreationString = "";
//        if (this.dateCreation == null) {
//            dateCreationString = "pas de date";
//        } else {
//            dateCreationString = this.dateCreation.format(dtf);
//        }
            return "\n"+this.getNom()+"\n"+this.getGuerrier()+"\n"+this.getVoleur()+"\n"+this.getSoigneur()
                    +"\n"+this.getDateCreation();
    }

}





package modele;

import exception.SaisieException;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Livreprete implements Serializable {
    private static final long serialVersionUID = 1L;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static List<Livreprete>livrepretes = new ArrayList<>();

    private Abonnes abonnes;
    private Livre livre;
    private Employe employe;
    private LocalDate datePret;
    private LocalDate dateRetour;

    public Livreprete(Livre livre,Abonnes abonnes,Employe employe ) throws SaisieException {
        if (livre == null || abonnes == null || employe == null) {
            throw new IllegalArgumentException("Aucun parametre ne peut etre vide");
        }
        if (livre.getQuantitedisponible() <= 0) {
            throw new IllegalArgumentException("Livre indisponnible au pret");
        }
            this.livre = livre;
            this.abonnes = abonnes;
            this.employe = employe;
            this.datePret = LocalDate.now();
            this.dateRetour = datePret.plusDays(7);
            livre.setQuantitedisponible(livre.getQuantitedisponible() - 1);
            livrepretes.add(this);
        }

   public Abonnes getAbonnes()
   {
        return abonnes;
   }
   public Livre getLivre()
   {
        return livre;
   }
   public Employe getEmploye()
   {
        return employe;
   }
   public String getDatePret()
   {
        return datePret.format(formatter);
   }
    public String getDateRetour()
    {
        return dateRetour.format(formatter);
    }

    public static List<Livreprete> getLivrepretes()
    {
        return  new ArrayList<>(livrepretes);
    }

    public static void setLivrepretes(List<Livreprete> livrepretes)
    {
        Livreprete.livrepretes = livrepretes;
    }

    public String toString() {
        return "Livre : "+livre.getIsbn()+" Titre : "+livre.getTitre()
                +"\nAbonnes Nom : "+abonnes.getNom()+"prénom"+abonnes.getPrenom()
                +"\nEmploye Identifiant :"+employe.getIndentifiant()
                +"\nDate d empreint : "+getDatePret()+" Date de Retour :"+getDateRetour();
    }
}


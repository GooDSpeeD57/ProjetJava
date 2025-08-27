package modele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Abonnes extends Personne {
    private LocalDate dateNow;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String mail;
    private static List<Abonnes> abonnes=new ArrayList<>();
    private static final String REGEXemail = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

    public Abonnes(String nom, String prenom, String mail){
        super(nom,prenom);
        this.setMail(mail);
        this.dateNow = LocalDate.now();
        abonnes.add(this);
    }
    public static List<Abonnes> rechercherNom(String nom) {
        List<Abonnes> resultats = new ArrayList<>();
        for (Abonnes abonne : abonnes) {
            if (abonne.getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(abonne);
            }
        }
        return resultats;
    }
    public static List<Abonnes> rechercherEmail(String email) {
        List<Abonnes> resultats = new ArrayList<>();
        for (Abonnes abonne : abonnes) {
            if (abonne.getMail().toLowerCase().contains(email.toLowerCase())) {
                resultats.add(abonne);
            }
        }
        return resultats;
    }
public static List<Abonnes> getAbonnes()
{
        return abonnes;
}
public void setAbonnes(List<Abonnes> abonnes)
{
        this.abonnes=abonnes;

}
public String getMail()
{
        return this.mail;
}
public void setMail(String mail) {
        if(mail==null||mail.trim().isEmpty()||!mail.matches(REGEXemail)){
            throw  new IllegalArgumentException("L'email non valide");
        }
        this.mail = mail.trim().toLowerCase();
}
public String getDateNow()
{
        return this.dateNow.format(formatter);
}
@Override
    public String toString(){
        return super.toString()+
                "\nEmail : "+ this.mail+
                "\nDate d'inscription : "+this.getDateNow()+"\n";
}
}



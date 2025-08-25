package modele;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Abonnes extends Personne {
    LocalDate dateNow = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String mail;
    private static List<Abonnes> abonnes=new ArrayList<>();

    public Abonnes(String nom, String prenom, String mail){
        super(nom,prenom);
        this.mail=mail;
        this.dateNow = dateNow;
    }
public static List<Abonnes> getAbonnes(){
        return abonnes;
}
public void setAbonnes(List<Abonnes> abonnes){
        this.abonnes=abonnes;
}
public String getMail() {
        return this.mail;
}
public void setMail(String mail) {
        this.mail = mail;
}
public String getDateNow() {
        return this.dateNow.format(formatter);
}
public void setDateNow(LocalDate dateNow) {
        this.dateNow = dateNow;
}
@Override
    public String toString(){
        return super.toString()+"\nEmail : "+ this.mail+"\nDate d'inscription : "+this.dateNow+"\n";
}
}



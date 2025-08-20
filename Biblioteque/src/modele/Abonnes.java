package modele;

import java.util.ArrayList;
import java.util.List;

public class Abonnes extends Personne {
    private String mail;
    private String dateinscription;
    private static List<Abonnes> abonnes=new ArrayList<>();

    public Abonnes(String nom, String prenom, String mail, String dateinscription){
        super(nom,prenom);
        this.mail=mail;
        this.dateinscription=dateinscription;
    }
public static List<Abonnes> getAbonnes(){
        return abonnes;
}
public String getMail() {
        return this.mail;
}
public void setMail(String mail) {
        this.mail = mail;
}
public String getDateinscription() {
        return this.dateinscription;
}
public void setDateinscription(String dateinscription) {
        this.dateinscription = dateinscription;
}
@Override
    public String toString(){
        return super.toString()+"\nEmail : "+ this.mail+"\nDate d'inscription : "+this.dateinscription+"\n";
}
}



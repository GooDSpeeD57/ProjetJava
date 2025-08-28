package modele;

import java.util.ArrayList;
import java.util.List;

public class Employe extends Personne{
    private String identifiant;
    private static List<Employe> employees = new ArrayList<>();
    public Employe(String nom, String prenom, String identifiant) {
        super(nom, prenom);
        this.setIdentifiant(identifiant);
        employees.add(this);
    }
public static List<Employe> getEmployees(){
        return employees;
}
public static void setEmployees(List<Employe> employees) {
        Employe.employees = employees;
}
public String getIdentifiant() {
        return identifiant;
}
public void setIdentifiant(String identifiant){
        if (identifiant==null || identifiant.trim().isEmpty()){
            throw new IllegalArgumentException("identifiant ne peux pas etre vide ");
        }
        this.identifiant = identifiant;
}
@Override
public String toString(){
        return super.toString()+"\nIdentifiant : "+this.identifiant;
}
}


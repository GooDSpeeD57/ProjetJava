package modele;

import java.util.ArrayList;
import java.util.List;

public class Employe extends Personne{
    private String indentifiant;
    private static List<Employe> employees = new ArrayList<>();
    public Employe(String nom, String prenom, String indentifiant) {
        super(nom, prenom);
        this.indentifiant=indentifiant;
    }
public static List<Employe> getEmployees(){
        return employees;
}
public String getIndentifiant() {
        return indentifiant;
}
public void setIndentifiant(String indentifiant) {
        this.indentifiant = indentifiant;
}
@Override
public String toString(){
        return super.toString()+"\nIndentifiant : "+this.indentifiant;
}
}


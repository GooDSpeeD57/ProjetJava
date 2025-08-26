package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livreprete extends Livre {
    private int quantiteprete;
    private LocalDate dateSortie;
    private static List<Livreprete> livrepretes=new ArrayList<>();
    public Livreprete(String isbn,String nom,String auteur,int quantitedisponible) {
        super(isbn,nom,auteur,quantitedisponible);
        this.quantiteprete=quantiteprete;
        this.dateSortie=LocalDate.now();
    }
    public static List<Livreprete> getLivrepretes() {
        return livrepretes;
    }
    public int getQuantiteprete() {
        return quantiteprete;
    }
    public void setQuantiteprete(int quantiteprete) {
        this.quantiteprete = quantiteprete;
    }
    public LocalDate getDateSortie() {
        return dateSortie;
    }
    @Override
    public String toString() {
        return super.toString()+"livreprete"+this.quantiteprete;
    }
}

public class Ville {
    private String nom;
    protected int nombrehabitant;
    public Ville(String leNom){
        setNom(leNom);
        this.nombrehabitant = -1;
    };

public Ville(String nom, int nombrehabitant) {
    this.nom = nom;
    this.nombrehabitant = nombrehabitant;
}
public String getNom() {
    return nom;
}
public int getNombrehabitant() {
    return nombrehabitant;
}
public void setNombrehabitant(int nombrehabitant) {
    if (nombrehabitant <0 ) {System.out.println("le nombre d habitant doit etre positif");
    }
    else{this.nombrehabitant = nombrehabitant;}
    }
    @Override
    public String toString() {
    return ("Non de la vile" +getNom() + " nombre habitant " + getNombrehabitant());
    }
}

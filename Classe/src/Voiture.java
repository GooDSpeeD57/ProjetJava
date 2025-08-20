public class Voiture {
    String marque;
    double prix;
    public Voiture () {
    }
    public void setMarque(String marque)
    {
        this.marque = marque;
    }
    public String getMarque() {
        return this.marque;
    }
    public void setPrix(double prix) {
        this.prix = prix;
}
    public double getPrix() {
    return this.prix;
    }
    public void displayVoiture(){
        System.out.println("Voiture "+getMarque() + "Prix " + getPrix());
    }
}



public class Rectangle {
    double largeur,longueur,surface;
    public Rectangle(double largeur,double longueur){
        this.largeur=largeur;
        this.longueur=longueur;

    }public void setLongueur(double longueur){
        this.longueur=longueur;
    }
    public double getLargeur() {
        return largeur;
    }
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public double getLongueur() {
        return longueur;
    }
        public void airetotal(){
        System.out.println("L'air du rectangle est de "+(largeur*longueur)+" m²");
    }
        public void perimeter(){
        System.out.println("Le périmètre du rectangle est de "+((largeur+longueur)*2)+" m");

    }
}


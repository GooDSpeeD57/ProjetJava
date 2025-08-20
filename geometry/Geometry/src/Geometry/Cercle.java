package Geometry;
public class Cercle {
    public Point centre;
    public double radius;
    public Cercle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }
    public double perimetre(){
        double pi=Math.PI;
        return pi*2*radius;
    }
    public double surface(){
        double pi=Math.PI;
        return pi*radius*radius;
    }
    public void testinthecircle(Point q) {
        double dx = q.abscisse - this.centre.abscisse;
        double dy = q.ordonne - this.centre.ordonne;
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance <= this.radius) {
            System.out.println("Le point est dans le cercle ou sur le perimetre du cercle ");
        } else {
            System.out.println("le point est hors cercle");
        }
    }
     public void afficherresultat()
        {
            System.out.println("Le rayon du cercle est de : "+this.radius);
            System.out.println("Le centre du cercle a pour abscisse : "+ this.centre.abscisse +" et ordonné : "+this.centre.ordonne);
        }
}



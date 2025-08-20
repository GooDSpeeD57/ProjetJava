package Geometry;
public class Main {
    public static void main(String[] args) {
    Point centre=new Point(0.0,0.0);
    Cercle cercle1=new Cercle(centre,3.0);
    Point m1=new Point(3.0,0.0);
    cercle1.afficherresultat();
    cercle1.testinthecircle(m1);
    }
}

package controleur;

import modele.Chasseurdedemon;
import modele.Guerrier;



public class Main {
    public static void main(String[] args) {
        Chasseurdedemon chasseurdedemon1= new Chasseurdedemon("Neutre","Elf","Chasseur de demon","Illidan",1,100,100);
        Chasseurdedemon.getChasseurdedemons(chasseurdedemon1);

        Guerrier guerrier1 = new Guerrier("Alliance","Humain","guerrier","Retania",1,150,100);
        Guerrier.Guerriers.add(guerrier1);

        for(Chasseurdedemon c : chasseurdedemons){
            System.out.println(c.toString());
        }
        }
    }

package controleur;

import modele.Groupe;
import modele.Guerrier;
import modele.Soigneur;
import modele.Voleur;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static modele.Groupe.getGroupes;
import static modele.Guerrier.getGuerriers;
import static modele.Soigneur.getSoigneurs;
import static modele.Voleur.getVoleurs;

public class Main {
    public static void main(String[] args) {
        LocalDate Datedujour = LocalDate.now();

Voleur voleur0 = new Voleur("Nainpossible","nain","voleur");
getVoleurs().add(voleur0);
Soigneur pretre0 = new Soigneur("Yatrosia","elf","soigneur");
getSoigneurs().add(pretre0);
Guerrier guerrier0 = new Guerrier("Bigberta","humain","guerrier");
getGuerriers().add(guerrier0);
Voleur voleur1 = new Voleur("Nainconfortable","nain","voleur");
getVoleurs().add(voleur1);
Soigneur pretre1 = new Soigneur("OOmana","elf","soigneur");
getSoigneurs().add(pretre1);
Guerrier guerrier1 = new Guerrier("Truckitank","humain","guerrier");
getGuerriers().add(guerrier1);
Groupe groupe0 =new Groupe("Les cassos",guerrier0,voleur0,pretre0,LocalDate.now());
getGroupes().add(groupe0);
Groupe groupe1 =new Groupe("Casse Crane",guerrier1,voleur1,pretre1,LocalDate.now());
getGroupes().add(groupe1);
//for (Voleur vo : getVoleurs()) {
//    System.out.println(vo);
//}
//for (Guerrier gu :getGuerriers()){
//    System.out.println(gu);
//}
//for (Soigneur so:getSoigneurs()){
//    System.out.println(so);
//}
//for (Groupe gr:getGroupes()){
//System.out.println(gr);}
//System.out.println(voleur0);
//System.out.println(pretre0);
//System.out.println(guerrier0);
//System.out.println(groupe0);
//System.out.println(voleur1);
//System.out.println(pretre1);
//System.out.println(guerrier1);
//boolean e1=(voleur0==voleur1);
//System.out.println(e1);
System.out.println("comparaison : nom "+ voleur0.getNom().equals(voleur1.getNom()));
System.out.println("comparaison : niveau "+ (voleur0.getNiveau()== voleur1.getNiveau()));
//System.out.println("comparaison : habilité" + voleur0.getAgilite().equals(voleur1.getAgilite()));
System.out.println("comparaison : Race "+ voleur0.getRace().equals(voleur1.getRace()));

        LocalDate datedujour= LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = datedujour.format(myFormatObj);
        System.out.println("test apres formatage :" + formattedDate);

    }


}


public class Main {
    public static void main(String[] args) {
Livre livre1= new Livre("Le Seigneur des Anneaux : la communauté de l'anneau ","Tolkien ",500,50);
Livre livre2= new Livre("Le Seigneur des Anneaux : les deux tours ","Tolkien ",540,70);
Livre livre3= new Livre();
Livre livre4= new Livre("titre","auteur");
System.out.println("\n"+"Titre : "+livre1.getTitre()+"\n"+"Auteur :"+livre1.getAuteur()+"\n"+"Nombre de pages : "+livre1.getNbpage()+"\n"+"Prix : "+livre1.getPrix()+" €");
System.out.println("\n"+"Titre : "+livre2.getTitre()+"\n"+"Auteur :"+livre2.getAuteur()+"\n"+"Nombre de pages : "+livre2.getNbpage()+"\n"+"Prix : "+livre2.getPrix()+" €"+"\n");
System.out.println("nombre total de pages "+(livre1.getNbpage()+livre2.getNbpage()+"\n"));
System.out.println(livre1.affichetoi()+"\n");
System.out.println(livre2.affichetoi());
System.out.println(livre1.prixfixe());
System.out.println(livre2.prixfixe());
livre1.setPrix(10);
    }
}

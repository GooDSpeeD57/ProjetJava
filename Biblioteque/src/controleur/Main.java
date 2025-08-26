package controleur;

import modele.Abonnes;
import modele.Employe;
import modele.Livre;
import modele.Livreprete;
import utilitaires.Saisie;
import vue.Vue;

import java.util.List;
import java.util.Scanner;

//import static vue.Vue.captureutilisateur;


public class Main {
    public static void main(String[] args) {


        Abonnes Abonnes00 = new Abonnes("Temiro", "Chantal", "Temiro.Chantal@yahoo.fr");
        Abonnes.getAbonnes().add(Abonnes00);
        Abonnes Abonnes01 = new Abonnes("Kull", "Jean", "Jean.Kull@lesmouches.fr");
        Abonnes.getAbonnes().add(Abonnes01);
        Employe Simone = new Employe("Vielle", "Simone", "1245421");
        Employe Gilbert = new Employe("Montagné", "Gilbert", "1010101");
        Livre livre0 = new Livre("9782267046885", "Le Seigneur des Anneaux : La Communauté de l'Anneau", "J.R.R Tolkien", 5);
        Livre.getLivres().add(livre0);
        Livre livre1 = new Livre("9782267046892", "Le Seigneur des Anneaux : Les Deux Tours", "J.R.R Tolkien", 5);
        Livre.getLivres().add(livre1);
        Livre livre2 = new Livre("9782267046908","Le Seigneur des Anneaux : Le Retour du Roi","J.R.R Tolkien", 5);
        Livre.getLivres().add(livre2);
        Scanner sc = new Scanner(System.in);
        Boolean fin = false;

        while (!fin) {
        Vue.vueMenu();
        Vue.vueMenuglobal();
        System.out.println("Votre Choix [1 -6] ou [0] pour quitter : ");
        int selection = Saisie.lireEntier();
        switch (selection)
        {
            case 0:
                fin = true;
                System.out.println("au revoir");
                break;
            case 1:
                Vue.vueCreation();
                break;
            case 2:
                Vue.vueCreaLivre();
                break;
            case 3:
                Boolean fin1 = false;
                while (!fin1) {
                    Vue.vueMenu();
                    Vue.vueMenuLivre();
                    System.out.println("Votre Choix [1 -5] ou [0] pour retourner au menu principal : ");
                    int selection1 = Saisie.lireEntier();
                    switch (selection1){
                        case 0:
                            fin1 = true;
                            break;
                        case 1:
                            Boolean fin2 = false;
                            while (!fin2) {
                                Vue.vueMenu();
                                Vue.vueMenuRechLivre();
                                System.out.println("Votre Choix [1 -3] ou [0] pour quitter : ");
                                int selection2 = Saisie.lireEntier();
                                switch (selection2) {
                                    case 0:
                                        fin2 = true;
                                        break;
                                    case 1:
                                        System.out.println("Recherche par ISBN");
                                        String isbnRecherche = Vue.saisieISBN("ISBN :", "10 ou 13 chiffres");
                                        Livre livreTrouve = Livre.rechercherParISBN(isbnRecherche);

                                        if (livreTrouve != null) {
                                            System.out.println("Livre trouvé :\n" + livreTrouve);
                                        } else {
                                            System.out.println("Aucun livre trouvé avec cet ISBN.");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Recherche par Titre");
                                        String  titrerecherche= Vue.saisieAuteur("Titres ? :", "Pas despace avant et apres");
                                        Livre livreTrouve1 = Livre.rechercherParTitre(titrerecherche);

                                        if (livreTrouve1 != null) {
                                            System.out.println("Livre trouvé :\n" + livreTrouve1);
                                        } else {
                                            System.out.println("Aucun livre trouvé avec ce titre.");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Entrez le nom de l'auteur : ");
                                        String nomAuteur = Saisie.lireChaine();
                                        List<Livre> livresTrouves = Livre.rechercherParAuteur(nomAuteur);

                                        if (livresTrouves.isEmpty()) {
                                            System.out.println("Aucun livre trouvé pour cet auteur.");
                                        } else {
                                            System.out.println("Livres trouvés pour l'auteur \"" + nomAuteur + "\" :");
                                            for (Livre l : livresTrouves) {
                                                System.out.println("-------------------------");
                                                System.out.println(l);
                                            }
                                        }
                                        break;
//                                        System.out.println("Recherche par Auteur");
//                                        String auteurRecherche = Vue.saisieAuteur("Auteur:", "10 ou 13 chiffres");
//                                        Livre livreTrouve2 = Livre.rechercherParAuteur(auteurRecherche);
//
//                                        if (livreTrouve2 != null) {
//                                            System.out.println("Livre trouvé :\n" + livreTrouve2);
//                                        } else {
//                                            System.out.println("Aucun livre trouvé avec cet auteur.");
//                                        }
//                                        break;
                                    default:
                                        System.err.println("choix entre 1.3");
                                }
                            }
                            break;
                        case 2:
                            Boolean fin3 = false;
                            while (!fin3) {
                                Vue.vueMenu();
                                Vue.vueMenuAbonne();
                                System.out.println("Votre Choix [1 -2] ou [0] pour quitter : ");
                                int selection3 = Saisie.lireEntier();
                                switch (selection3) {
                                    case 0:
                                        fin3 = true;
                                        break;
                                    case 1:
                                        System.out.println("Nom");
                                        break;
                                    case 2:
                                        System.out.println("Mail");
                                        break;
                                    default:
                                        System.err.println("choix entre 1.5");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("test3");
                            break;
                        case 4:
                            System.out.println("test4");
                            break;
                        case 5:
                            System.out.println("test5");
                            break;
                        default:
                            System.err.println("choix entre 1.5");
                    }
                }
                break;
            case 4:
                System.out.println("-----Afficher la liste des abonnés-----\n");
                for (Abonnes abonne : Abonnes.getAbonnes()) {
                    System.out.println(abonne);
                }
                break;
            case 5:
                System.out.println("afficher la liste des livres");
                for (Livre livre : Livre.getLivres()) {
                    System.out.println(livre);
                }
                break;
            case 6:
                System.out.println("afficher la liste des prets");
                for (Livreprete livrepretes : Livreprete.getLivrepretes()) {
                    System.out.println(livrepretes);
                }
                break;
            default:
                System.err.println("! Choix incorrect ! [0-6] !");
                break;
                }

            }
        }
}

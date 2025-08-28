package controleur;

import exception.SaisieException;
import modele.Abonnes;
import modele.Employe;
import modele.Livre;
import modele.Livreprete;
import utilitaires.PersitSerializable;
import utilitaires.Saisie;
import vue.Vue;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String FICHIER_PERSISTANCE = "donnees.bin";
    private static Map<String, Object> donnees;
    public static void main(String[] args) throws SaisieException {
        donnees = PersitSerializable.charger(FICHIER_PERSISTANCE);
        List<Abonnes> abonnes = (List<Abonnes>) donnees.getOrDefault("abonnes", new java.util.ArrayList<>());
        List<Employe> employes = (List<Employe>) donnees.getOrDefault("employes", new java.util.ArrayList<>());
        List<Livre> livres = (List<Livre>) donnees.getOrDefault("livres", new java.util.ArrayList<>());
        List<Livreprete> livrepretes = (List<Livreprete>) donnees.getOrDefault("prets", new java.util.ArrayList<>());

        Abonnes.setAbonnes(abonnes);
        Employe.setEmployees(employes);
        Livre.setLivres(livres);
        Livreprete.setLivrepretes(livrepretes);

//        Abonnes abonnes00 = new Abonnes("Temiro", "Chantal", "Temiro.Chantal@yahoo.fr");
//        Abonnes abonnes01 = new Abonnes("Kull", "Jean", "Jean.Kull@lesmouches.fr");
//        Employe employe00 = new Employe("Vielle", "Simone", "1245421");
//        Employe employe01 = new Employe("Montagné", "Gilbert", "1010101");
//        Livre livre00 = new Livre("9782267046885", "Le Seigneur des Anneaux : La Communauté de l'Anneau", "J.R.R Tolkien", 5);
//        Livre livre01 = new Livre("9782267046892", "Le Seigneur des Anneaux : Les Deux Tours", "J.R.R Tolkien", 5);
//        Livre livre02 = new Livre("9782267046908","Le Seigneur des Anneaux : Le Retour du Roi","J.R.R Tolkien", 5);

        Scanner sc = new Scanner(System.in);
        Boolean fin = false;

        while (!fin) {
        Vue.vueMenu();
        Vue.vueMenuglobal();
        int selection = Saisie.lireEntier("Votre Choix [1 -6] ou [0] pour quitter : ","un nombre positif");
        switch (selection)
        {
            case 0:
                fin = true;
                System.out.println("Sauvegarde en cours...");
                donnees.put("abonnes", Abonnes.getAbonnes());
                donnees.put("employes", Employe.getEmployees());
                donnees.put("livres", Livre.getLivres());
                donnees.put("prets", Livreprete.getLivrepretes());
                PersitSerializable.sauvegarder(donnees, FICHIER_PERSISTANCE);
                System.out.println("Au revoir !");
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
                    int selection1 = Saisie.lireEntier("Votre Choix [1 -5] ou [0] pour retourner au menu principal : ","Un nombre");
                    switch (selection1){
                        case 0:
                            fin1 = true;
                            break;
                        case 1:
                            Boolean fin2 = false;
                            while (!fin2) {
                                Vue.vueMenu();
                                Vue.vueMenuRechLivre();
                                int selection2 = Saisie.lireEntier("Votre Choix [1 -3] ou [0] pour quitter : ","un NOMBRE!!!!");
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
                                        System.out.println("Recherche par Titre : ");
                                        String nomTitre = Vue.saisieAuteur("Titre ?","Pas d'espace avant et apres ");
                                        List<Livre> livresTrouves = Livre.rechercherParTitre(nomTitre);

                                        if (livresTrouves.isEmpty()) {
                                            System.out.println("Aucun livre trouvé pour ce Titre.");
                                        } else {
                                            System.out.println("Livres trouvés pour le titre \"" + nomTitre + "\"");
                                            for (Livre l : livresTrouves) {
                                                System.out.println("-------------------------");
                                                System.out.println(l);
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Recherche par Auteur : ");
                                        String nomAuteur = Vue.saisieAuteur("Auteur ?","Pas d'espace avant et apres ");
                                        List<Livre> livresTrouves1 = Livre.rechercherParAuteur(nomAuteur);

                                        if (livresTrouves1.isEmpty()) {
                                            System.out.println("Aucun livre trouvé pour cet auteur.");
                                        } else {
                                            System.out.println("Livres trouvés pour l'auteur \"" + nomAuteur + "\" :");
                                            for (Livre l : livresTrouves1) {
                                                System.out.println("-------------------------");
                                                System.out.println(l);
                                            }
                                        }
                                        break;
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
                                int selection3 = Saisie.lireEntier("Votre Choix [1 -2] ou [0] pour quitter : ","un nombre entre 0 et 3");
                                switch (selection3) {
                                    case 0:
                                        fin3 = true;
                                        break;
                                    case 1:
                                        String nom = Vue.saisieAuteur("Recherche par Nom ?","Pas d'espace avant et apres ");
                                        List<Abonnes> nomTrouve = Abonnes.rechercherNom(nom);

                                        if (nomTrouve.isEmpty()) {
                                            System.out.println("Aucun Nom trouvé pour : "+nom+ " Veuillez l'inscrire.");
                                        } else {
                                            System.out.println("Nom  \"" + nom + "\" :");
                                            for (Abonnes l : nomTrouve ) {
                                                System.out.println("-------------------------");
                                                System.out.println(l);
                                            }
                                        }
                                        break;
                                    case 2:
                                        String mail = Vue.saisieMailUtilisateur("Recherche par Email ?","Pas d'espace avant et apres ");
                                        List<Abonnes> rechercheMail = Abonnes.rechercherEmail(mail);

                                        if (rechercheMail.isEmpty()) {
                                            System.out.println("Aucun Email trouvé pour : "+mail+ " Veuillez l'inscire.");
                                        } else {
                                            System.out.println("Email ?  \"" + mail + "\" :");
                                            for (Abonnes l : rechercheMail ) {
                                                System.out.println("-------------------------");
                                                System.out.println(l);
                                            }
                                        }
                                        break;
                                    default:
                                        System.err.println("choix entre 1.2");
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
                    System.out.println("-------------------------");
                    System.out.println(abonne);
                }
                break;
            case 5:
                System.out.println("afficher la liste des livres");
                for (Livre livre : Livre.getLivres()) {
                    System.out.println("-------------------------");
                    System.out.println(livre);
                }
                break;
            case 6:
                System.out.println("afficher la liste des prets");
//                Livreprete pret1 = new Livreprete(livre00,abonnes00,employe00);
//
//                for (Livreprete pret : Livreprete.getLivrepretes()) {
//                    System.out.println("-------------------------");
//                    System.out.println(pret);
//                    }
                break;
            default:
                System.err.println("! Choix incorrect ! [0-6] !");
                break;
                }

            }
        }
}

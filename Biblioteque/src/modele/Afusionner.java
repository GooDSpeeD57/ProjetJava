//package modele;
//
//public class Afusionner {
//    // MODIFICATION DU CASE 3 dans Main.java - Créer un prêt interactif
//case 3:
//    Boolean fin1 = false;
//    while (!fin1) {
//        Vue.vueMenu();
//        Vue.vueMenuLivre();
//        int selection1 = Saisie.lireEntier("Votre Choix [1-5] ou [0] pour retourner au menu principal : ", "Un nombre");
//        switch (selection1) {
//            case 0:
//                fin1 = true;
//                break;
//            case 1:
//                // Recherche de livre (existant)
//                gererRechercheLivre();
//                break;
//            case 2:
//                // Recherche d'abonné (existant)
//                gererRechercheAbonnes();
//                break;
//            case 3:
//                // NOUVEAU : Créer un prêt interactif
//                creerPretInteractif();
//                break;
//            case 4:
//                // Afficher les prêts
//                afficherPrets();
//                break;
//            case 5:
//                System.out.println("Fonctionnalité future");
//                break;
//            default:
//                System.err.println("choix entre 0-5");
//        }
//    }
//    break;
//
//    // NOUVELLE MÉTHODE : Créer un prêt interactif
//    private static void creerPretInteractif() throws SaisieException {
//        System.out.println("=== CRÉATION D'UN PRÊT ===\n");
//
//        // ÉTAPE 1 : Sélectionner un livre
//        Livre livreSelectionne = selectionnerLivre();
//        if (livreSelectionne == null) {
//            System.out.println("❌ Création de prêt annulée - Aucun livre sélectionné.");
//            return;
//        }
//
//        // ÉTAPE 2 : Sélectionner un abonné
//        Abonnes abonneSelectionne = selectionnerAbonne();
//        if (abonneSelectionne == null) {
//            System.out.println("❌ Création de prêt annulée - Aucun abonné sélectionné.");
//            return;
//        }
//
//        // ÉTAPE 3 : Sélectionner un employé
//        Employe employeSelectionne = selectionnerEmploye();
//        if (employeSelectionne == null) {
//            System.out.println("❌ Création de prêt annulée - Aucun employé sélectionné.");
//            return;
//        }
//
//        // ÉTAPE 4 : Créer le prêt
//        try {
//            Livreprete nouveauPret = new Livreprete(livreSelectionne, abonneSelectionne, employeSelectionne);
//            System.out.println("\n✅ PRÊT CRÉÉ AVEC SUCCÈS !");
//            System.out.println("═══════════════════════════");
//            System.out.println(nouveauPret);
//            System.out.println("═══════════════════════════");
//        } catch (Exception e) {
//            System.err.println("❌ Erreur lors de la création du prêt : " + e.getMessage());
//        }
//    }
//
//    // MÉTHODE : Sélectionner un livre
//    private static Livre selectionnerLivre() throws SaisieException {
//        System.out.println("📚 SÉLECTION DU LIVRE");
//        System.out.println("Comment voulez-vous rechercher le livre ?");
//        System.out.println("1 - Par ISBN");
//        System.out.println("2 - Par Titre");
//        System.out.println("3 - Par Auteur");
//        System.out.println("0 - Annuler");
//
//        int choix = Saisie.lireEntier("Votre choix : ", "Un nombre entre 0 et 3");
//
//        switch (choix) {
//            case 0:
//                return null;
//
//            case 1:
//                // Recherche par ISBN
//                String isbn = Vue.saisieISBN("ISBN du livre :", "10 ou 13 chiffres");
//                Livre livre = Livre.rechercherParISBN(isbn);
//
//                if (livre == null) {
//                    System.out.println("❌ Aucun livre trouvé avec cet ISBN.");
//                    return null;
//                }
//
//                if (livre.getQuantitedisponible() <= 0) {
//                    System.out.println("❌ Ce livre n'est pas disponible (stock: " + livre.getQuantitedisponible() + ")");
//                    return null;
//                }
//
//                System.out.println("✅ Livre sélectionné : " + livre.getTitre() + " (Stock: " + livre.getQuantitedisponible() + ")");
//                return livre;
//
//            case 2:
//                // Recherche par titre
//                String titre = Vue.saisieAuteur("Titre du livre :", "Pas d'espace avant et après");
//                List<Livre> livresTitre = Livre.rechercherParTitre(titre);
//
//                if (livresTitre.isEmpty()) {
//                    System.out.println("❌ Aucun livre trouvé pour ce titre.");
//                    return null;
//                }
//
//                return choisirLivreDansListe(livresTitre, "titre \"" + titre + "\"");
//
//            case 3:
//                // Recherche par auteur
//                String auteur = Vue.saisieAuteur("Auteur du livre :", "Pas d'espace avant et après");
//                List<Livre> livresAuteur = Livre.rechercherParAuteur(auteur);
//
//                if (livresAuteur.isEmpty()) {
//                    System.out.println("❌ Aucun livre trouvé pour cet auteur.");
//                    return null;
//                }
//
//                return choisirLivreDansListe(livresAuteur, "auteur \"" + auteur + "\"");
//
//            default:
//                System.err.println("Choix invalide.");
//                return null;
//        }
//    }
//
//    // MÉTHODE : Choisir un livre dans une liste
//    private static Livre choisirLivreDansListe(List<Livre> livres, String critere) throws SaisieException {
//        System.out.println("\n📋 Livres trouvés pour " + critere + " :");
//
//        // Filtrer les livres disponibles
//        List<Livre> livresDisponibles = new ArrayList<>();
//        for (int i = 0; i < livres.size(); i++) {
//            Livre livre = livres.get(i);
//            if (livre.getQuantitedisponible() > 0) {
//                livresDisponibles.add(livre);
//                System.out.println((livresDisponibles.size()) + " - " + livre.getTitre() +
//                        " (ISBN: " + livre.getIsbn() + ", Stock: " + livre.getQuantitedisponible() + ")");
//            }
//        }
//
//        if (livresDisponibles.isEmpty()) {
//            System.out.println("❌ Aucun livre disponible dans cette sélection.");
//            return null;
//        }
//
//        System.out.println("0 - Annuler");
//        int choix = Saisie.lireEntier("Sélectionnez un livre : ", "Un nombre valide");
//
//        if (choix == 0 || choix > livresDisponibles.size()) {
//            return null;
//        }
//
//        Livre livreChoisi = livresDisponibles.get(choix - 1);
//        System.out.println("✅ Livre sélectionné : " + livreChoisi.getTitre());
//        return livreChoisi;
//    }
//
//    // MÉTHODE : Sélectionner un abonné
//    private static Abonnes selectionnerAbonne() throws SaisieException {
//        System.out.println("\n👤 SÉLECTION DE L'ABONNÉ");
//        System.out.println("Comment voulez-vous rechercher l'abonné ?");
//        System.out.println("1 - Par Nom");
//        System.out.println("2 - Par Email");
//        System.out.println("0 - Annuler");
//
//        int choix = Saisie.lireEntier("Votre choix : ", "Un nombre entre 0 et 2");
//
//        switch (choix) {
//            case 0:
//                return null;
//
//            case 1:
//                // Recherche par nom
//                String nom = Vue.saisieAuteur("Nom de l'abonné :", "Pas d'espace avant et après");
//                List<Abonnes> abonnesNom = Abonnes.rechercherNom(nom);
//
//                if (abonnesNom.isEmpty()) {
//                    System.out.println("❌ Aucun abonné trouvé pour ce nom.");
//                    return null;
//                }
//
//                return choisirAbonneDansListe(abonnesNom, "nom \"" + nom + "\"");
//
//            case 2:
//                // Recherche par email
//                String email = Vue.saisieMailUtilisateur("Email de l'abonné :", "Email invalide");
//                List<Abonnes> abonnesEmail = Abonnes.rechercherEmail(email);
//
//                if (abonnesEmail.isEmpty()) {
//                    System.out.println("❌ Aucun abonné trouvé pour cet email.");
//                    return null;
//                }
//
//                return choisirAbonneDansListe(abonnesEmail, "email \"" + email + "\"");
//
//            default:
//                System.err.println("Choix invalide.");
//                return null;
//        }
//    }
//
//    // MÉTHODE : Choisir un abonné dans une liste
//    private static Abonnes choisirAbonneDansListe(List<Abonnes> abonnes, String critere) throws SaisieException {
//        System.out.println("\n📋 Abonnés trouvés pour " + critere + " :");
//
//        for (int i = 0; i < abonnes.size(); i++) {
//            Abonnes abonne = abonnes.get(i);
//            System.out.println((i + 1) + " - " + abonne.getNom() + " " + abonne.getPrenom() +
//                    " (" + abonne.getMail() + ")");
//        }
//
//        System.out.println("0 - Annuler");
//        int choix = Saisie.lireEntier("Sélectionnez un abonné : ", "Un nombre valide");
//
//        if (choix == 0 || choix > abonnes.size()) {
//            return null;
//        }
//
//        Abonnes abonneChoisi = abonnes.get(choix - 1);
//        System.out.println("✅ Abonné sélectionné : " + abonneChoisi.getNom() + " " + abonneChoisi.getPrenom());
//        return abonneChoisi;
//    }
//
//    // MÉTHODE : Sélectionner un employé
//    private static Employe selectionnerEmploye() throws SaisieException {
//        System.out.println("\n👨‍💼 SÉLECTION DE L'EMPLOYÉ");
//
//        List<Employe> employes = Employe.getEmployees();
//
//        if (employes.isEmpty()) {
//            System.out.println("❌ Aucun employé enregistré dans le système.");
//            return null;
//        }
//
//        System.out.println("Employés disponibles :");
//        for (int i = 0; i < employes.size(); i++) {
//            Employe employe = employes.get(i);
//            System.out.println((i + 1) + " - " + employe.getNom() + " " + employe.getPrenom() +
//                    " (ID: " + employe.getIdentifiant() + ")");
//        }
//
//        System.out.println("0 - Annuler");
//        int choix = Saisie.lireEntier("Sélectionnez un employé : ", "Un nombre valide");
//
//        if (choix == 0 || choix > employes.size()) {
//            return null;
//        }
//
//        Employe employeChoisi = employes.get(choix - 1);
//        System.out.println("✅ Employé sélectionné : " + employeChoisi.getNom() + " " + employeChoisi.getPrenom());
//        return employeChoisi;
//    }
//
//// NOUVEAU CASE 6 : Afficher les prêts sans duplication
//case 6:
//        System.out.println("-----Afficher la liste des prêts-----\n");
//
//    List<Livreprete> prets = Livreprete.getLivrepretes();
//
//    if (prets.isEmpty()) {
//        System.out.println("📋 Aucun prêt enregistré dans le système.");
//        System.out.println("💡 Utilisez l'option 3 pour créer des prêts.");
//    } else {
//        System.out.println("📊 Nombre total de prêts : " + prets.size());
//        System.out.println("═══════════════════════════════════════");
//        for (int i = 0; i < prets.size(); i++) {
//            System.out.println("PRÊT #" + (i + 1));
//            System.out.println(prets.get(i));
//            System.out.println("═══════════════════════════════════════");
//        }
//    }
//    break;
//}

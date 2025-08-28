package controleur;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;

import modele.*;
import exception.SaisieException;
import utilitaires.PersitSerializable;

public class MainSwing extends JFrame {

    private static final String FICHIER_PERSISTANCE = "donnees.bin";
    private static Map<String, Object> donnees;

    // Composants principaux
    private JTabbedPane tabbedPane;
    private JPanel panelAccueil, panelAbonnes, panelLivres, panelPrets, panelRapports;

    // Tables pour affichage des données
    private JTable tableAbonnes, tableLivres, tablePrets;
    private DefaultTableModel modelAbonnes, modelLivres, modelPrets;

    // Composants de saisie
    private JTextField txtNom, txtPrenom, txtEmail;
    private JTextField txtISBN, txtTitre, txtAuteur, txtQuantite;
    private JTextField txtRechercheISBN, txtRechercheTitre, txtRechercheAuteur;
    private JTextField txtRechercheNom, txtRechercheEmail;

    public MainSwing() {
        chargerDonnees();
        initComponents();
        chargerDonneesDansGUI();
    }

    private void chargerDonnees() {
        donnees = PersitSerializable.charger(FICHIER_PERSISTANCE);
        List<Abonnes> abonnes = (List<Abonnes>) donnees.getOrDefault("abonnes", new java.util.ArrayList<>());
        List<Employe> employes = (List<Employe>) donnees.getOrDefault("employes", new java.util.ArrayList<>());
        List<Livre> livres = (List<Livre>) donnees.getOrDefault("livres", new java.util.ArrayList<>());
        List<Livreprete> livrepretes = (List<Livreprete>) donnees.getOrDefault("prets", new java.util.ArrayList<>());

        Abonnes.setAbonnes(abonnes);
        Employe.setEmployees(employes);
        Livre.setLivres(livres);
        Livreprete.setLivrepretes(livrepretes);
    }

    private void initComponents() {
        setTitle("📚 Système de Gestion de Bibliothèque");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        // Gestionnaire de fermeture avec sauvegarde
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sauvegarderEtQuitter();
            }
        });

        // Création du menu
        creerMenu();

        // Création des onglets
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 12));

        creerPanelAccueil();
        creerPanelAbonnes();
        creerPanelLivres();
        creerPanelPrets();
        creerPanelRapports();

        tabbedPane.addTab("🏠 Accueil", panelAccueil);
        tabbedPane.addTab("👥 Abonnés", panelAbonnes);
        tabbedPane.addTab("📚 Livres", panelLivres);
        tabbedPane.addTab("📋 Prêts", panelPrets);
        tabbedPane.addTab("📊 Rapports", panelRapports);

        add(tabbedPane);

        // Style général
    }


    private void creerMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem itemSauvegarder = new JMenuItem("💾 Sauvegarder");
        JMenuItem itemQuitter = new JMenuItem("❌ Quitter");

        itemSauvegarder.addActionListener(e -> sauvegarder());
        itemQuitter.addActionListener(e -> sauvegarderEtQuitter());

        menuFichier.add(itemSauvegarder);
        menuFichier.addSeparator();
        menuFichier.add(itemQuitter);

        JMenu menuAide = new JMenu("Aide");
        JMenuItem itemAPropos = new JMenuItem("ℹ️ À propos");
        itemAPropos.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Système de Gestion de Bibliothèque\nVersion 1.0\n\nDéveloppé avec Java Swing",
                        "À propos",
                        JOptionPane.INFORMATION_MESSAGE)
        );
        menuAide.add(itemAPropos);

        menuBar.add(menuFichier);
        menuBar.add(menuAide);
        setJMenuBar(menuBar);
    }

    private void creerPanelAccueil() {
        panelAccueil = new JPanel(new BorderLayout());
        panelAccueil.setBackground(new Color(240, 248, 255));

        // Panel de bienvenue
        JPanel panelBienvenue = new JPanel();
        panelBienvenue.setBackground(new Color(240, 248, 255));
        panelBienvenue.setLayout(new BoxLayout(panelBienvenue, BoxLayout.Y_AXIS));

        JLabel lblTitre = new JLabel("📚 Bienvenue dans le Système de Bibliothèque");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitre.setForeground(new Color(25, 25, 112));

        JLabel lblSousTitre = new JLabel("Gestion complète de votre bibliothèque");
        lblSousTitre.setFont(new Font("Arial", Font.ITALIC, 16));
        lblSousTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSousTitre.setForeground(new Color(70, 130, 180));

        panelBienvenue.add(Box.createVerticalGlue());
        panelBienvenue.add(lblTitre);
        panelBienvenue.add(Box.createRigidArea(new Dimension(0, 10)));
        panelBienvenue.add(lblSousTitre);
        panelBienvenue.add(Box.createVerticalGlue());

        // Panel des statistiques
        JPanel panelStats = new JPanel(new GridLayout(2, 2, 10, 10));
        panelStats.setBorder(new TitledBorder("📊 Statistiques"));
        panelStats.setBackground(new Color(240, 248, 255));

        JLabel lblNbAbonnes = new JLabel("👥 Abonnés: " + Abonnes.getAbonnes().size(), SwingConstants.CENTER);
        JLabel lblNbLivres = new JLabel("📚 Livres: " + Livre.getLivres().size(), SwingConstants.CENTER);
        JLabel lblNbPrets = new JLabel("📋 Prêts: " + Livreprete.getLivrepretes().size(), SwingConstants.CENTER);
        JLabel lblNbEmployes = new JLabel("👨‍💼 Employés: " + Employe.getEmployees().size(), SwingConstants.CENTER);

        Font fontStats = new Font("Arial", Font.BOLD, 14);
        lblNbAbonnes.setFont(fontStats);
        lblNbLivres.setFont(fontStats);
        lblNbPrets.setFont(fontStats);
        lblNbEmployes.setFont(fontStats);

        panelStats.add(lblNbAbonnes);
        panelStats.add(lblNbLivres);
        panelStats.add(lblNbPrets);
        panelStats.add(lblNbEmployes);

        panelAccueil.add(panelBienvenue, BorderLayout.CENTER);
        panelAccueil.add(panelStats, BorderLayout.SOUTH);
    }

    private void creerPanelAbonnes() {
        panelAbonnes = new JPanel(new BorderLayout());

        // Panel de saisie
        JPanel panelSaisieAbonne = new JPanel(new GridBagLayout());
        panelSaisieAbonne.setBorder(new TitledBorder("➕ Nouvel Abonné"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Champs de saisie
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieAbonne.add(new JLabel("Nom:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtNom = new JTextField(15);
        panelSaisieAbonne.add(txtNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panelSaisieAbonne.add(new JLabel("Prénom:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtPrenom = new JTextField(15);
        panelSaisieAbonne.add(txtPrenom, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        panelSaisieAbonne.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtEmail = new JTextField(15);
        panelSaisieAbonne.add(txtEmail, gbc);

        // Boutons
        JPanel panelBoutons = new JPanel(new FlowLayout());
        JButton btnAjouter = new JButton("➕ Ajouter");
        JButton btnVider = new JButton("🗑️ Vider");

        btnAjouter.addActionListener(e -> ajouterAbonne());
        btnVider.addActionListener(e -> viderChampsAbonne());

        panelBoutons.add(btnAjouter);
        panelBoutons.add(btnVider);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panelSaisieAbonne.add(panelBoutons, gbc);

        // Panel de recherche
        JPanel panelRechercheAbonne = new JPanel(new GridBagLayout());
        panelRechercheAbonne.setBorder(new TitledBorder("🔍 Recherche"));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        panelRechercheAbonne.add(new JLabel("Par nom:"), gbc);
        gbc.gridx = 1;
        txtRechercheNom = new JTextField(15);
        panelRechercheAbonne.add(txtRechercheNom, gbc);
        gbc.gridx = 2;
        JButton btnRechercheNom = new JButton("🔍");
        btnRechercheNom.addActionListener(e -> rechercherAbonneParNom());
        panelRechercheAbonne.add(btnRechercheNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelRechercheAbonne.add(new JLabel("Par email:"), gbc);
        gbc.gridx = 1;
        txtRechercheEmail = new JTextField(15);
        panelRechercheAbonne.add(txtRechercheEmail, gbc);
        gbc.gridx = 2;
        JButton btnRechercheEmail = new JButton("🔍");
        btnRechercheEmail.addActionListener(e -> rechercherAbonneParEmail());
        panelRechercheAbonne.add(btnRechercheEmail, gbc);

        JButton btnAfficherTous = new JButton("📋 Afficher tous");
        btnAfficherTous.addActionListener(e -> chargerAbonnes());
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3;
        panelRechercheAbonne.add(btnAfficherTous, gbc);

        // Panel supérieur
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2));
        panelSuperior.add(panelSaisieAbonne);
        panelSuperior.add(panelRechercheAbonne);

        // Table des abonnés
        String[] colonnesAbonnes = {"Nom", "Prénom", "Email", "Date inscription"};
        modelAbonnes = new DefaultTableModel(colonnesAbonnes, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableAbonnes = new JTable(modelAbonnes);
        tableAbonnes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollAbonnes = new JScrollPane(tableAbonnes);
        scrollAbonnes.setBorder(new TitledBorder("👥 Liste des Abonnés"));

        panelAbonnes.add(panelSuperior, BorderLayout.NORTH);
        panelAbonnes.add(scrollAbonnes, BorderLayout.CENTER);
    }

    private void creerPanelLivres() {
        panelLivres = new JPanel(new BorderLayout());

        // Panel de saisie livre
        JPanel panelSaisieLivre = new JPanel(new GridBagLayout());
        panelSaisieLivre.setBorder(new TitledBorder("➕ Nouveau Livre"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelSaisieLivre.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtISBN = new JTextField(15);
        panelSaisieLivre.add(txtISBN, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        panelSaisieLivre.add(new JLabel("Titre:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtTitre = new JTextField(15);
        panelSaisieLivre.add(txtTitre, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        panelSaisieLivre.add(new JLabel("Auteur:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtAuteur = new JTextField(15);
        panelSaisieLivre.add(txtAuteur, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = GridBagConstraints.NONE;
        panelSaisieLivre.add(new JLabel("Quantité:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtQuantite = new JTextField(15);
        panelSaisieLivre.add(txtQuantite, gbc);

        JPanel panelBoutonsLivre = new JPanel(new FlowLayout());
        JButton btnAjouterLivre = new JButton("➕ Ajouter");
        JButton btnViderLivre = new JButton("🗑️ Vider");

        btnAjouterLivre.addActionListener(e -> ajouterLivre());
        btnViderLivre.addActionListener(e -> viderChampsLivre());

        panelBoutonsLivre.add(btnAjouterLivre);
        panelBoutonsLivre.add(btnViderLivre);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panelSaisieLivre.add(panelBoutonsLivre, gbc);

        // Panel de recherche livre
        JPanel panelRechercheLivre = new JPanel(new GridBagLayout());
        panelRechercheLivre.setBorder(new TitledBorder("🔍 Recherche"));

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        panelRechercheLivre.add(new JLabel("Par ISBN:"), gbc);
        gbc.gridx = 1;
        txtRechercheISBN = new JTextField(15);
        panelRechercheLivre.add(txtRechercheISBN, gbc);
        gbc.gridx = 2;
        JButton btnRechercheISBN = new JButton("🔍");
        btnRechercheISBN.addActionListener(e -> rechercherLivreParISBN());
        panelRechercheLivre.add(btnRechercheISBN, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelRechercheLivre.add(new JLabel("Par titre:"), gbc);
        gbc.gridx = 1;
        txtRechercheTitre = new JTextField(15);
        panelRechercheLivre.add(txtRechercheTitre, gbc);
        gbc.gridx = 2;
        JButton btnRechercheTitre = new JButton("🔍");
        btnRechercheTitre.addActionListener(e -> rechercherLivreParTitre());
        panelRechercheLivre.add(btnRechercheTitre, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelRechercheLivre.add(new JLabel("Par auteur:"), gbc);
        gbc.gridx = 1;
        txtRechercheAuteur = new JTextField(15);
        panelRechercheLivre.add(txtRechercheAuteur, gbc);
        gbc.gridx = 2;
        JButton btnRechercheAuteur = new JButton("🔍");
        btnRechercheAuteur.addActionListener(e -> rechercherLivreParAuteur());
        panelRechercheLivre.add(btnRechercheAuteur, gbc);

        JButton btnAfficherTousLivres = new JButton("📋 Afficher tous");
        btnAfficherTousLivres.addActionListener(e -> chargerLivres());
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3;
        panelRechercheLivre.add(btnAfficherTousLivres, gbc);

        JPanel panelSuperiorLivre = new JPanel(new GridLayout(1, 2));
        panelSuperiorLivre.add(panelSaisieLivre);
        panelSuperiorLivre.add(panelRechercheLivre);

        // Table des livres
        String[] colonnesLivres = {"ISBN", "Titre", "Auteur", "Quantité"};
        modelLivres = new DefaultTableModel(colonnesLivres, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableLivres = new JTable(modelLivres);
        tableLivres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollLivres = new JScrollPane(tableLivres);
        scrollLivres.setBorder(new TitledBorder("📚 Liste des Livres"));

        panelLivres.add(panelSuperiorLivre, BorderLayout.NORTH);
        panelLivres.add(scrollLivres, BorderLayout.CENTER);
    }

    private void creerPanelPrets() {
        panelPrets = new JPanel(new BorderLayout());

        // Panel de création de prêt
        JPanel panelCreationPret = new JPanel(new FlowLayout());
        panelCreationPret.setBorder(new TitledBorder("➕ Nouveau Prêt"));

        JButton btnNouveauPret = new JButton("📋 Créer un prêt");
        btnNouveauPret.setFont(new Font("Arial", Font.BOLD, 14));
        btnNouveauPret.addActionListener(e -> ouvrirDialogueCreationPret());

        JButton btnActualiserPrets = new JButton("🔄 Actualiser");
        btnActualiserPrets.addActionListener(e -> chargerPrets());

        panelCreationPret.add(btnNouveauPret);
        panelCreationPret.add(btnActualiserPrets);

        // Table des prêts
        String[] colonnesPrets = {"Livre", "Abonné", "Employé", "Date prêt", "Date retour"};
        modelPrets = new DefaultTableModel(colonnesPrets, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablePrets = new JTable(modelPrets);
        tablePrets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPrets = new JScrollPane(tablePrets);
        scrollPrets.setBorder(new TitledBorder("📋 Liste des Prêts"));

        panelPrets.add(panelCreationPret, BorderLayout.NORTH);
        panelPrets.add(scrollPrets, BorderLayout.CENTER);
    }

    private void creerPanelRapports() {
        panelRapports = new JPanel(new BorderLayout());

        JPanel panelBoutons = new JPanel(new FlowLayout());
        JButton btnRapportAbonnes = new JButton("👥 Rapport Abonnés");
        JButton btnRapportLivres = new JButton("📚 Rapport Livres");
        JButton btnRapportPrets = new JButton("📋 Rapport Prêts");

        btnRapportAbonnes.addActionListener(e -> genererRapportAbonnes());
        btnRapportLivres.addActionListener(e -> genererRapportLivres());
        btnRapportPrets.addActionListener(e -> genererRapportPrets());

        panelBoutons.add(btnRapportAbonnes);
        panelBoutons.add(btnRapportLivres);
        panelBoutons.add(btnRapportPrets);

        JTextArea textAreaRapport = new JTextArea();
        textAreaRapport.setEditable(false);
        textAreaRapport.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollRapport = new JScrollPane(textAreaRapport);
        scrollRapport.setBorder(new TitledBorder("📊 Rapport"));

        panelRapports.add(panelBoutons, BorderLayout.NORTH);
        panelRapports.add(scrollRapport, BorderLayout.CENTER);
    }

    // Méthodes de chargement des données
    private void chargerDonneesDansGUI() {
        chargerAbonnes();
        chargerLivres();
        chargerPrets();
    }

    private void chargerAbonnes() {
        modelAbonnes.setRowCount(0);
        for (Abonnes abonne : Abonnes.getAbonnes()) {
            modelAbonnes.addRow(new Object[]{
                    abonne.getNom(),
                    abonne.getPrenom(),
                    abonne.getMail(),
                    abonne.getDateNow()
            });
        }
    }

    private void chargerLivres() {
        modelLivres.setRowCount(0);
        for (Livre livre : Livre.getLivres()) {
            modelLivres.addRow(new Object[]{
                    livre.getIsbn(),
                    livre.getTitre(),
                    livre.getAuteur(),
                    livre.getQuantitedisponible()
            });
        }
    }

    private void chargerPrets() {
        modelPrets.setRowCount(0);
        for (Livreprete pret : Livreprete.getLivrepretes()) {
            modelPrets.addRow(new Object[]{
                    pret.getLivre().getTitre(),
                    pret.getAbonnes().getNom() + " " + pret.getAbonnes().getPrenom(),
                    pret.getEmploye().getNom() + " " + pret.getEmploye().getPrenom(),
                    pret.getDatePret(),
                    pret.getDateRetour()
            });
        }
    }

    // Méthodes d'action
    private void ajouterAbonne() {
        try {
            String nom = txtNom.getText().trim();
            String prenom = txtPrenom.getText().trim();
            String email = txtEmail.getText().trim();

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires!", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new Abonnes(nom, prenom, email);
            chargerAbonnes();
            viderChampsAbonne();
            JOptionPane.showMessageDialog(this, "Abonné ajouté avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ajouterLivre() {
        try {
            String isbn = txtISBN.getText().trim();
            String titre = txtTitre.getText().trim();
            String auteur = txtAuteur.getText().trim();
            String quantiteStr = txtQuantite.getText().trim();

            if (isbn.isEmpty() || titre.isEmpty() || auteur.isEmpty() || quantiteStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs sont obligatoires!", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantite = Integer.parseInt(quantiteStr);
            new Livre(isbn, titre, auteur, quantite);
            chargerLivres();
            viderChampsLivre();
            JOptionPane.showMessageDialog(this, "Livre ajouté avec succès!", "Succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La quantité doit être un nombre!", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viderChampsAbonne() {
        txtNom.setText("");
        txtPrenom.setText("");
        txtEmail.setText("");
    }

    private void viderChampsLivre() {
        txtISBN.setText("");
        txtTitre.setText("");
        txtAuteur.setText("");
        txtQuantite.setText("");
    }

    // Méthodes de recherche
    private void rechercherAbonneParNom() {
        String nom = txtRechercheNom.getText().trim();
        if (nom.isEmpty()) {
            chargerAbonnes();
            return;
        }

        modelAbonnes.setRowCount(0);
        List<Abonnes> resultats = Abonnes.rechercherNom(nom);
        for (Abonnes abonne : resultats) {
            modelAbonnes.addRow(new Object[]{
                    abonne.getNom(),
                    abonne.getPrenom(),
                    abonne.getMail(),
                    abonne.getDateNow()
            });
        }
    }

    private void rechercherAbonneParEmail() {
        String email = txtRechercheEmail.getText().trim();
        if (email.isEmpty()) {
            chargerAbonnes();
            return;
        }

        modelAbonnes.setRowCount(0);
        List<Abonnes> resultats = Abonnes.rechercherEmail(email);
        for (Abonnes abonne : resultats) {
            modelAbonnes.addRow(new Object[]{
                    abonne.getNom(),
                    abonne.getPrenom(),
                    abonne.getMail(),
                    abonne.getDateNow()
            });
        }
    }

    private void rechercherLivreParISBN() {
        String isbn = txtRechercheISBN.getText().trim();
        if (isbn.isEmpty()) {
            chargerLivres();
            return;
        }

        modelLivres.setRowCount(0);
        Livre livre = Livre.rechercherParISBN(isbn);
        if (livre != null) {
            modelLivres.addRow(new Object[]{
                    livre.getIsbn(),
                    livre.getTitre(),
                    livre.getAuteur(),
                    livre.getQuantitedisponible()
            });
        }
    }

    private void rechercherLivreParTitre() {
        String titre = txtRechercheTitre.getText().trim();
        if (titre.isEmpty()) {
            chargerLivres();
            return;
        }

        try {
            modelLivres.setRowCount(0);
            List<Livre> resultats = Livre.rechercherParTitre(titre);
            for (Livre livre : resultats) {
                modelLivres.addRow(new Object[]{
                        livre.getIsbn(),
                        livre.getTitre(),
                        livre.getAuteur(),
                        livre.getQuantitedisponible()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la recherche: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rechercherLivreParAuteur() {
        String auteur = txtRechercheAuteur.getText().trim();
        if (auteur.isEmpty()) {
            chargerLivres();
            return;
        }

        modelLivres.setRowCount(0);
        List<Livre> resultats = Livre.rechercherParAuteur(auteur);
        for (Livre livre : resultats) {
            modelLivres.addRow(new Object[]{
                    livre.getIsbn(),
                    livre.getTitre(),
                    livre.getAuteur(),
                    livre.getQuantitedisponible()
            });
        }
    }

    // Dialogue de création de prêt
    private void ouvrirDialogueCreationPret() {
        JDialog dialogPret = new JDialog(this, "📋 Créer un Prêt", true);
        dialogPret.setSize(600, 500);
        dialogPret.setLocationRelativeTo(this);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Variables pour stocker les sélections
        final Livre[] livreSelectionne = {null};
        final Abonnes[] abonneSelectionne = {null};
        final Employe[] employeSelectionne = {null};

        // Panel de sélection du livre
        JPanel panelLivre = new JPanel(new BorderLayout());
        panelLivre.setBorder(new TitledBorder("📚 Sélection du Livre"));

        String[] colonnesLivresPret = {"ISBN", "Titre", "Auteur", "Stock"};
        DefaultTableModel modelLivresPret = new DefaultTableModel(colonnesLivresPret, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableLivresPret = new JTable(modelLivresPret);
        tableLivresPret.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Charger uniquement les livres disponibles
        for (Livre livre : Livre.getLivres()) {
            if (livre.getQuantitedisponible() > 0) {
                modelLivresPret.addRow(new Object[]{
                        livre.getIsbn(),
                        livre.getTitre(),
                        livre.getAuteur(),
                        livre.getQuantitedisponible()
                });
            }
        }

        JScrollPane scrollLivresPret = new JScrollPane(tableLivresPret);
        scrollLivresPret.setPreferredSize(new Dimension(550, 100));
        panelLivre.add(scrollLivresPret, BorderLayout.CENTER);

        // Panel de sélection de l'abonné
        JPanel panelAbonne = new JPanel(new BorderLayout());
        panelAbonne.setBorder(new TitledBorder("👥 Sélection de l'Abonné"));

        String[] colonnesAbonnesPret = {"Nom", "Prénom", "Email"};
        DefaultTableModel modelAbonnesPret = new DefaultTableModel(colonnesAbonnesPret, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableAbonnesPret = new JTable(modelAbonnesPret);
        tableAbonnesPret.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (Abonnes abonne : Abonnes.getAbonnes()) {
            modelAbonnesPret.addRow(new Object[]{
                    abonne.getNom(),
                    abonne.getPrenom(),
                    abonne.getMail()
            });
        }

        JScrollPane scrollAbonnesPret = new JScrollPane(tableAbonnesPret);
        scrollAbonnesPret.setPreferredSize(new Dimension(550, 100));
        panelAbonne.add(scrollAbonnesPret, BorderLayout.CENTER);

        // Panel de sélection de l'employé
        JPanel panelEmploye = new JPanel(new BorderLayout());
        panelEmploye.setBorder(new TitledBorder("👨‍💼 Sélection de l'Employé"));

        String[] colonnesEmployesPret = {"Nom", "Prénom", "Identifiant"};
        DefaultTableModel modelEmployesPret = new DefaultTableModel(colonnesEmployesPret, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tableEmployesPret = new JTable(modelEmployesPret);
        tableEmployesPret.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (Employe employe : Employe.getEmployees()) {
            modelEmployesPret.addRow(new Object[]{
                    employe.getNom(),
                    employe.getPrenom(),
                    employe.getIdentifiant()
            });
        }

        JScrollPane scrollEmployesPret = new JScrollPane(tableEmployesPret);
        scrollEmployesPret.setPreferredSize(new Dimension(550, 100));
        panelEmploye.add(scrollEmployesPret, BorderLayout.CENTER);

        // Panel des tables
        JPanel panelTables = new JPanel();
        panelTables.setLayout(new BoxLayout(panelTables, BoxLayout.Y_AXIS));
        panelTables.add(panelLivre);
        panelTables.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTables.add(panelAbonne);
        panelTables.add(Box.createRigidArea(new Dimension(0, 5)));
        panelTables.add(panelEmploye);

        // Panel des boutons
        JPanel panelBoutonsPret = new JPanel(new FlowLayout());
        JButton btnCreer = new JButton("✅ Créer le Prêt");
        JButton btnAnnuler = new JButton("❌ Annuler");

        btnCreer.addActionListener(e -> {
            int ligneSelectionnee;

            // Vérifier sélection du livre
            ligneSelectionnee = tableLivresPret.getSelectedRow();
            if (ligneSelectionnee == -1) {
                JOptionPane.showMessageDialog(dialogPret, "Veuillez sélectionner un livre!", "Erreur", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String isbnSelectionne = (String) modelLivresPret.getValueAt(ligneSelectionnee, 0);
            livreSelectionne[0] = Livre.rechercherParISBN(isbnSelectionne);

            // Vérifier sélection de l'abonné
            ligneSelectionnee = tableAbonnesPret.getSelectedRow();
            if (ligneSelectionnee == -1) {
                JOptionPane.showMessageDialog(dialogPret, "Veuillez sélectionner un abonné!", "Erreur", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String emailSelectionne = (String) modelAbonnesPret.getValueAt(ligneSelectionnee, 2);
            for (Abonnes abonne : Abonnes.getAbonnes()) {
                if (abonne.getMail().equals(emailSelectionne)) {
                    abonneSelectionne[0] = abonne;
                    break;
                }
            }

            // Vérifier sélection de l'employé
            ligneSelectionnee = tableEmployesPret.getSelectedRow();
            if (ligneSelectionnee == -1) {
                JOptionPane.showMessageDialog(dialogPret, "Veuillez sélectionner un employé!", "Erreur", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String identifiantSelectionne = (String) modelEmployesPret.getValueAt(ligneSelectionnee, 2);
            for (Employe employe : Employe.getEmployees()) {
                if (employe.getIdentifiant().equals(identifiantSelectionne)) {
                    employeSelectionne[0] = employe;
                    break;
                }
            }

            // Créer le prêt
            try {
                new Livreprete(livreSelectionne[0], abonneSelectionne[0], employeSelectionne[0]);
                chargerPrets();
                chargerLivres(); // Mettre à jour les stocks
                dialogPret.dispose();
                JOptionPane.showMessageDialog(this,
                        "Prêt créé avec succès!\n\n" +
                                "Livre: " + livreSelectionne[0].getTitre() + "\n" +
                                "Abonné: " + abonneSelectionne[0].getNom() + " " + abonneSelectionne[0].getPrenom() + "\n" +
                                "Employé: " + employeSelectionne[0].getNom() + " " + employeSelectionne[0].getPrenom(),
                        "Succès", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialogPret, "Erreur lors de la création du prêt: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnAnnuler.addActionListener(e -> dialogPret.dispose());

        panelBoutonsPret.add(btnCreer);
        panelBoutonsPret.add(btnAnnuler);

        panelPrincipal.add(panelTables, BorderLayout.CENTER);
        panelPrincipal.add(panelBoutonsPret, BorderLayout.SOUTH);

        dialogPret.add(panelPrincipal);
        dialogPret.setVisible(true);
    }

    // Méthodes de rapport
    private void genererRapportAbonnes() {
        StringBuilder rapport = new StringBuilder();
        rapport.append("=== RAPPORT DES ABONNÉS ===\n\n");
        rapport.append("Nombre total d'abonnés: ").append(Abonnes.getAbonnes().size()).append("\n\n");

        for (Abonnes abonne : Abonnes.getAbonnes()) {
            rapport.append("Nom: ").append(abonne.getNom()).append(" ").append(abonne.getPrenom()).append("\n");
            rapport.append("Email: ").append(abonne.getMail()).append("\n");
            rapport.append("Date d'inscription: ").append(abonne.getDateNow()).append("\n");
            rapport.append("─────────────────────────────────────\n");
        }

        afficherRapport(rapport.toString());
    }

    private void genererRapportLivres() {
        StringBuilder rapport = new StringBuilder();
        rapport.append("=== RAPPORT DES LIVRES ===\n\n");
        rapport.append("Nombre total de livres: ").append(Livre.getLivres().size()).append("\n");

        int stockTotal = 0;
        int livresDisponibles = 0;

        for (Livre livre : Livre.getLivres()) {
            stockTotal += livre.getQuantitedisponible();
            if (livre.getQuantitedisponible() > 0) {
                livresDisponibles++;
            }
        }

        rapport.append("Stock total: ").append(stockTotal).append(" exemplaires\n");
        rapport.append("Livres disponibles: ").append(livresDisponibles).append("\n");
        rapport.append("Livres en rupture: ").append(Livre.getLivres().size() - livresDisponibles).append("\n\n");

        rapport.append("DÉTAIL PAR LIVRE:\n");
        rapport.append("─────────────────────────────────────\n");

        for (Livre livre : Livre.getLivres()) {
            rapport.append("ISBN: ").append(livre.getIsbn()).append("\n");
            rapport.append("Titre: ").append(livre.getTitre()).append("\n");
            rapport.append("Auteur: ").append(livre.getAuteur()).append("\n");
            rapport.append("Stock: ").append(livre.getQuantitedisponible());
            if (livre.getQuantitedisponible() == 0) {
                rapport.append(" ⚠️ RUPTURE");
            }
            rapport.append("\n─────────────────────────────────────\n");
        }

        afficherRapport(rapport.toString());
    }

    private void genererRapportPrets() {
        StringBuilder rapport = new StringBuilder();
        rapport.append("=== RAPPORT DES PRÊTS ===\n\n");
        rapport.append("Nombre total de prêts: ").append(Livreprete.getLivrepretes().size()).append("\n\n");

        if (Livreprete.getLivrepretes().isEmpty()) {
            rapport.append("Aucun prêt enregistré dans le système.\n");
        } else {
            rapport.append("DÉTAIL DES PRÊTS:\n");
            rapport.append("─────────────────────────────────────\n");

            int numPret = 1;
            for (Livreprete pret : Livreprete.getLivrepretes()) {
                rapport.append("PRÊT #").append(numPret++).append("\n");
                rapport.append("Livre: ").append(pret.getLivre().getTitre()).append("\n");
                rapport.append("ISBN: ").append(pret.getLivre().getIsbn()).append("\n");
                rapport.append("Abonné: ").append(pret.getAbonnes().getNom()).append(" ").append(pret.getAbonnes().getPrenom()).append("\n");
                rapport.append("Email: ").append(pret.getAbonnes().getMail()).append("\n");
                rapport.append("Employé: ").append(pret.getEmploye().getNom()).append(" ").append(pret.getEmploye().getPrenom()).append("\n");
                rapport.append("Date de prêt: ").append(pret.getDatePret()).append("\n");
                rapport.append("Date de retour prévue: ").append(pret.getDateRetour()).append("\n");
                rapport.append("─────────────────────────────────────\n");
            }
        }

        afficherRapport(rapport.toString());
    }

    private void afficherRapport(String rapport) {
        JDialog dialogRapport = new JDialog(this, "📊 Rapport", true);
        dialogRapport.setSize(600, 500);
        dialogRapport.setLocationRelativeTo(this);

        JTextArea textArea = new JTextArea(rapport);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setCaretPosition(0);

        JScrollPane scroll = new JScrollPane(textArea);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scroll, BorderLayout.CENTER);

        JPanel panelBoutons = new JPanel(new FlowLayout());
        JButton btnFermer = new JButton("❌ Fermer");
        btnFermer.addActionListener(e -> dialogRapport.dispose());
        panelBoutons.add(btnFermer);

        panel.add(panelBoutons, BorderLayout.SOUTH);

        dialogRapport.add(panel);
        dialogRapport.setVisible(true);
    }

    // Méthodes de sauvegarde
    private void sauvegarder() {
        donnees.put("abonnes", Abonnes.getAbonnes());
        donnees.put("employes", Employe.getEmployees());
        donnees.put("livres", Livre.getLivres());
        donnees.put("prets", Livreprete.getLivrepretes());
        PersitSerializable.sauvegarder(donnees, FICHIER_PERSISTANCE);
        JOptionPane.showMessageDialog(this, "Données sauvegardées avec succès!", "Sauvegarde", JOptionPane.INFORMATION_MESSAGE);
    }

    private void sauvegarderEtQuitter() {
        int choix = JOptionPane.showConfirmDialog(this,
                "Voulez-vous sauvegarder avant de quitter?",
                "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION);

        if (choix == JOptionPane.YES_OPTION) {
            sauvegarder();
            System.exit(0);
        } else if (choix == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        // Si CANCEL, on ne fait rien
    }

    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        // Créer quelques données de test si nécessaire
        initialiserDonneesTest();

        SwingUtilities.invokeLater(() -> {
            new MainSwing().setVisible(true);
        });
    }

    private static void initialiserDonneesTest() {
        // Créer quelques employés de test s'il n'y en a pas
        if (Employe.getEmployees().isEmpty()) {
            new Employe("Martin", "Sophie", "EMP001");
            new Employe("Dubois", "Pierre", "EMP002");
        }
    }
}
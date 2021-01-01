package onitama;

/*
 * Mini-Projet - Onitama
 * Nicolas TROUILLET - Mallory GOMBAULT
 * Class - Interface Graphique
 */
/**
 *
 * Nous sommes partis sur principe que les deux joueurs savent jouer, et que
 * donc, ils respecteront les cases sur lesquelles ils peuvent jouer leurs pions
 * en fonction des cartes.
 *
 *
 */
public class fenetredejeu extends javax.swing.JFrame {

    //private static Partie jeu;
    private Joueur joueur1, joueur2;

    private Grille grille;

    //private static int NombreJoueur = 2;
    private Coordonnee bouton1;

    private Carte carteajouer = null;

    /**
     * Creates new form fenetredejeu
     */
    public fenetredejeu() {

        initComponents();

        //Affichage d'ambiance 
        panneau_message.setVisible(false);
        carte1_jr.setVisible(false);
        carte2_jr.setVisible(false);
        carte1_jb.setVisible(false);
        carte2_jb.setVisible(false);
        plateau.setVisible(false);
        carte_milieu.setVisible(false);
        labeljb1.setVisible(false);
        labeljb2.setVisible(false);
        labelcm.setVisible(false);
        labeljr1.setVisible(false);
        labeljr2.setVisible(false);

        //Préparation du jeu ********************************************************************
        Carte.init();
        Deck.init();
        Deck.Melanger();
        //jeu = new Partie();
        Carte carte[] = Deck.Distribuer(); //On distribue les cartes
        joueur1 = new Joueur(new Carte[]{carte[0], carte[3]}, Grille.rouge); //On crée les deux joueurs et on leur attribue leur carte
        joueur2 = new Joueur(new Carte[]{carte[1], carte[4]}, Grille.bleu);

        grille = null;

        if (carte[2].prendreCouleur() == Grille.rouge) //On mets les joueurs dans le bon ordre
        {
            grille = new Grille(carte[2], joueur1, joueur2);
        } else {
            grille = new Grille(carte[2], joueur2, joueur1);
        }

        joueur1.InitialiserGrille(grille); //On crée les grilles des joueurs
        joueur2.InitialiserGrille(grille);

        // AFFICHAGE CARTES **********************************************************************
        //Création des cartes graphiques
        Cellule_Graphique CellGraphj1c1 = new Cellule_Graphique(joueur1.ReferenceCarteDuJoueur()[0]);
        Cellule_Graphique CellGraphj1c2 = new Cellule_Graphique(joueur1.ReferenceCarteDuJoueur()[1]);
        Cellule_Graphique CellGraphj2c1 = new Cellule_Graphique(joueur2.ReferenceCarteDuJoueur()[0]);
        Cellule_Graphique CellGraphj2c2 = new Cellule_Graphique(joueur2.ReferenceCarteDuJoueur()[1]);
        Cellule_Graphique CellGraphcm = new Cellule_Graphique(grille.RecupererCarteMilieu());

        //Action pour les quatre cartes
        /*CellGraphj1c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                CarteChoisie(joueur1.ReferenceCarteDuJoueur()[0]); //On garde en référence la carte que le joueur va jouer
                message.setText("le joueur bleu à choisi de jouer la carte " + joueur1.ReferenceCarteDuJoueur()[0].prendreNom());
            }
        });

        CellGraphj1c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                CarteChoisie(joueur1.ReferenceCarteDuJoueur()[1]);
                message.setText("le joueur bleu à choisi de jouer la carte " + joueur1.ReferenceCarteDuJoueur()[1].prendreNom());
            }
        });

        CellGraphj2c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                CarteChoisie(joueur2.ReferenceCarteDuJoueur()[0]);
                message.setText("le joueur rouge à choisi de jouer la carte " + joueur1.ReferenceCarteDuJoueur()[0].prendreNom());
            }
        });

        CellGraphj2c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                CarteChoisie(joueur2.ReferenceCarteDuJoueur()[1]);
                message.setText("le joueur rouge à choisi de jouer la carte " + joueur1.ReferenceCarteDuJoueur()[1].prendreNom());
            }
        });*/
        carte1_jb.add(CellGraphj1c1);
        carte2_jb.add(CellGraphj1c2);
        carte1_jr.add(CellGraphj2c1);
        carte2_jr.add(CellGraphj2c2);
        carte_milieu.add(CellGraphcm);

        // AFFICHAGE Plateau ********************************************************
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j < 5; j++) { //On parcours le plateau

                int ii = i; //Problème de inner class
                int jj = j;

                Cellule_Graphique CellGraph = new Cellule_Graphique(grille.ReferencePions()[i][j]);
                plateau.add(CellGraph);
                
                
                // Si le joueur appuie sur une carte ************************************************

                CellGraphj1c1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        CarteChoisie(joueur1.ReferenceCarteDuJoueur()[0]); //On garde en référence la carte que le joueur va jouer
                        message.setText("le joueur bleu à choisi de jouer la carte " + joueur1.ReferenceCarteDuJoueur()[0].prendreNom());
                    }
                });

                CellGraphj1c2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        CarteChoisie(joueur1.ReferenceCarteDuJoueur()[1]);
                        message.setText("le joueur bleu à choisi de jouer la carte " + joueur1.ReferenceCarteDuJoueur()[1].prendreNom());
                    }
                });

                CellGraphj2c1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        CarteChoisie(joueur2.ReferenceCarteDuJoueur()[0]);
                        message.setText("le joueur rouge à choisi de jouer la carte " + joueur1.ReferenceCarteDuJoueur()[0].prendreNom());
                    }
                });

                CellGraphj2c2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        CarteChoisie(joueur2.ReferenceCarteDuJoueur()[1]);
                        message.setText("le joueur rouge à choisi de jouer la carte " + joueur1.ReferenceCarteDuJoueur()[1].prendreNom());
                    }
                });

                //Action des boutons sur le plateau******************************************************
                
                CellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                        

                        boolean tour = JouerFenetre(ii, jj);
                        if (tour == false) {
                            return; //Le joueur n'a pas fini son tour
                        } else {
                            //Le tour s'est bien passé
                            //On passe au prochain tour, on affiche les nouvelles modifications

                            grille.JoueurSuivant();
                            if (grille.JoueurCourant() == joueur1) {
                                message.setText("c'est au tour du joueur bleu");
                            } else {
                                message.setText("c'est au tour du joueur rouge");
                            }

                        }

                    }

                });
            }

        }

    }

    //METHODE POUR L'INTEFRACE *********************************************************************************************************************************

    //METHODE RECUPERATION CARTE A JOUER ***********************************************
    public void CarteChoisie(Carte cartejoueur) { //joueur1.ReferenceCarteDuJoueur()[0];

        carteajouer = cartejoueur;

    }

    //METHODE - VERIFIER DE/VERS ********************************************************************************************************************************************
    public boolean VerifierDeVers(int ligne, int colonne) { //On cherche à savoir si le joueur choisit son pion à déplacer où la case sur laquelle il veut déplacer son pion

        Joueur jc = grille.JoueurCourant();
        int couleurjoueur = jc.ReferenceCouleurDuJoueur(); //On récupère la couleur du joueur courant

        if (grille.ReferencePions(ligne, colonne).ReferenceCouleurPion() == couleurjoueur) { //S'il clique sur son pion,

            bouton1.MettreEnCommun(ligne, colonne); //On lui attribut ses coordonnées

            if (couleurjoueur == 1) {
                message.setText("le joueur rouge à choisi son pion à bouger");
            } else {
                message.setText("le joueur bleu à choisi son pion à bouger");
            }

            return true;

        } else { //Sinon, rien ne se passe

            return false;

        }

    }

    //METHODE - JOUER ********************************************************************************************************************************************
    public boolean JouerFenetre(int ligne, int colonne) { //On joue un tour

        carte1_jb.repaint();
        carte2_jb.repaint();
        carte1_jr.repaint();
        carte2_jr.repaint();
        carte_milieu.repaint();

//Vérifier que le joueur n'a pas perdu tous ses pions **********************
        Joueur jc = grille.JoueurCourant();
        int couleurjoueur = jc.ReferenceCouleurDuJoueur(); //On récupère la couleur du joueur courant

        if (grille.NombrePionsCouleur(couleurjoueur) == 0) { //On compte son nombre de pions restant

            Joueur Jgagnant = grille.JoueurEnAttente();

            if (Jgagnant.ReferenceCouleurDuJoueur() == 1) { //On annonce le gagnant
                message.setText("Victoire du joueur Rouge ! Merci d'avoir joué"); //Pour le moment, ce sont des strings, mais nous modifierons cela lorsque nos images fonctionneront
            } else {
                message.setText("Victoire du joueur Bleu ! Merci d'avoir joué");
            }

        }

        //Si cette étape est passée, on continue
        if (VerifierDeVers(ligne, colonne) == true) { //On vérifie que le bouton choisi est celui de départ ou d'arrivée, c'est-à-dire, s'il correspond au pion que le joueur souhaite déplacer ou 
            //S'il correspond à la case où il souhaite avancer.

            return false; //Si c'est le pion, les valeurs de bouton1 ont été changées et prêtes à être utilisées au prochain bouton

        } else if (VerifierDeVers(ligne, colonne) == false) { //Sinon, on stock la nouvelle coordonnee afin de déplacer le pion

            Coordonnee Vers = new Coordonnee(ligne, colonne);
            grille.jouer(bouton1, Vers); //On joue le pion

            // On vérifie si le joueur est gagnant
            if (grille.VerifierGagnant() == true) { //Si oui, on récupère son nom

                Joueur Jgagnant = grille.etreGagnant();

                if (Jgagnant.ReferenceCouleurDuJoueur() == 1) { //On annonce le vainqueur

                    message.setText("Victoire du joueur Rouge ! Merci d'avoir joué");
                } else {
                    message.setText("Victoire du joueur Bleu ! Merci d'avoir joué");
                }

            }

            //Sinon, on passe au tour suivant, et on actualise le plateau
            Carte carteechanger = grille.echangerCarte(carteajouer); //On échange les références des cartes au milieu
            grille.echangerCarteMilieu(carteechanger); //On donne la nouvelle carte à la liste du joueur

            plateau.repaint();
            carte1_jb.repaint();
            carte2_jb.repaint();
            carte1_jr.repaint();
            carte2_jr.repaint();
            carte_milieu.repaint();

        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plateau = new javax.swing.JPanel();
        carte_milieu = new javax.swing.JPanel();
        carte2_jb = new javax.swing.JPanel();
        carte1_jb = new javax.swing.JPanel();
        carte1_jr = new javax.swing.JPanel();
        carte2_jr = new javax.swing.JPanel();
        demarrer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bouton_demarrer = new javax.swing.JButton();
        panneau_message = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        labeljb2 = new javax.swing.JLabel();
        labeljr2 = new javax.swing.JLabel();
        labeljb1 = new javax.swing.JLabel();
        labelcm = new javax.swing.JLabel();
        labeljr1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1800, 1800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        plateau.setBackground(new java.awt.Color(255, 255, 255));
        plateau.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 960, 960));

        carte_milieu.setBackground(new java.awt.Color(255, 255, 255));
        carte_milieu.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(carte_milieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 300, 185));

        carte2_jb.setBackground(new java.awt.Color(255, 255, 255));
        carte2_jb.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(carte2_jb, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 300, 185));

        carte1_jb.setBackground(new java.awt.Color(255, 255, 255));
        carte1_jb.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(carte1_jb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 185));

        carte1_jr.setBackground(new java.awt.Color(255, 255, 255));
        carte1_jr.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(carte1_jr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 750, 300, 185));

        carte2_jr.setBackground(new java.awt.Color(255, 255, 255));
        carte2_jr.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(carte2_jr, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 750, 300, 185));

        demarrer.setBackground(new java.awt.Color(0, 0, 0));
        demarrer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lorsque vous êtes prêts, cliquer sur démarrer partie");
        demarrer.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 500, 80));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("~Vous allez jouer à Onitama~ ");
        demarrer.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 490, 80));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vous pouvez choisir votre couleur");
        demarrer.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 530, 80));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Le joueur bleu commence");
        demarrer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 500, 80));

        bouton_demarrer.setFont(new java.awt.Font("Tempus Sans ITC", 0, 48)); // NOI18N
        bouton_demarrer.setText("Démarrer Partie");
        bouton_demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton_demarrerActionPerformed(evt);
            }
        });
        demarrer.add(bouton_demarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, -1));

        getContentPane().add(demarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 600, 600));

        panneau_message.setBackground(new java.awt.Color(255, 204, 153));
        panneau_message.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setToolTipText("");

        message.setColumns(20);
        message.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        message.setRows(5);
        message.setPreferredSize(new java.awt.Dimension(360, 60));
        jScrollPane2.setViewportView(message);

        panneau_message.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 370, 60));

        getContentPane().add(panneau_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 400, 100));

        labeljb2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        labeljb2.setText("Carte 2 - joueur bleu");
        getContentPane().add(labeljb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        labeljr2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        labeljr2.setText("Carte 2 - joueur rouge");
        getContentPane().add(labeljr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 960, -1, -1));

        labeljb1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        labeljb1.setText("Carte 1 - joueur bleu");
        getContentPane().add(labeljb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        labelcm.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        labelcm.setText("Carte du milieu");
        getContentPane().add(labelcm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, -1, -1));

        labeljr1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        labeljr1.setText("Carte 1 - joueur rouge");
        getContentPane().add(labeljr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 960, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bouton_demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton_demarrerActionPerformed

        //Affichage d'ambiance
        carte1_jr.setVisible(true);
        panneau_message.setVisible(true);
        carte2_jr.setVisible(true);
        carte1_jb.setVisible(true);
        carte2_jb.setVisible(true);
        carte_milieu.setVisible(true);
        plateau.setVisible(true);
        demarrer.setVisible(false);
        bouton_demarrer.setEnabled(false);

        labeljb1.setVisible(true);
        labeljb2.setVisible(true);
        labelcm.setVisible(true);
        labeljr1.setVisible(true);
        labeljr2.setVisible(true);

        message.setText("Le joueur bleu commence ! Bonne chance");
    }//GEN-LAST:event_bouton_demarrerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fenetredejeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fenetredejeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fenetredejeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fenetredejeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fenetredejeu().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bouton_demarrer;
    private javax.swing.JPanel carte1_jb;
    private javax.swing.JPanel carte1_jr;
    private javax.swing.JPanel carte2_jb;
    private javax.swing.JPanel carte2_jr;
    private javax.swing.JPanel carte_milieu;
    private javax.swing.JPanel demarrer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelcm;
    private javax.swing.JLabel labeljb1;
    private javax.swing.JLabel labeljb2;
    private javax.swing.JLabel labeljr1;
    private javax.swing.JLabel labeljr2;
    private javax.swing.JTextArea message;
    private javax.swing.JPanel panneau_message;
    private javax.swing.JPanel plateau;
    // End of variables declaration//GEN-END:variables
}

package onitama;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilisateur
 */
public class fenetredejeu extends javax.swing.JFrame {


    private static Partie jeu;
    
    private Joueur joueur1, joueur2;

    private Grille grille;

    private static int NombreJoueur = 2;
    
    private Coordonnee bouton1;
    
    
    /**
     * Creates new form fenetredejeu
     */
    public fenetredejeu() {
        initComponents();
        
        //Affichage d'ambiance 
        
        
        carte1_jb.setVisible(false);
        carte2_jb.setVisible(false);
        carte1_jr.setVisible(false);
        carte2_jr.setVisible(false);
        plateau.setVisible(false);
        carte_milieu.setVisible(false);
        
        //Préparation du jeu 
        
        Carte.init();
	Deck.init();
        Deck.Melanger();
	//jeu = new Partie();
        Carte carte[] = Deck.Distribuer(); //On distribue les cartes
		joueur1 = new Joueur(new Carte[] {carte[0],carte[3]}, Grille.rouge); //On crée les deux joueurs
		joueur2 = new Joueur(new Carte[] {carte[1],carte[4]}, Grille.bleu);

		//grille = null;

		if(carte[2].prendreCouleur() == Grille.rouge) //On attribue les cartes aux joueurs
			grille = new Grille(carte[2], joueur1, joueur2);
		else
			grille = new Grille(carte[2], joueur2, joueur1);


		joueur1.InitialiserGrille(grille); //On crée les grilles des joueurs
		joueur2.InitialiserGrille(grille);
                
         
        AfficherPlateau(); //On commence par afficher la grille de base
        
        
        
    }
    
//Affichage du plateau 
        
        public void AfficherPlateau() { //Méthode d'affichade de la grille
            
        
        for (int i = 4; i>=0; i--) { 
            for (int j = 0; j<5; j++) { //On parcours le plateau
                
                
                Cellule_Graphique CellGraph = new Cellule_Graphique(grille.ReferencePions()[i][j]);
                plateau.add(CellGraph);
                
                
            }
        }
        
        }
        
        //Pour un bouton -----------------------------------------------------------------------------------
        
        
        public boolean VerifierDeVers(int ligne, int colonne) { //On cherche à savoir si le joueur choisit son pion à déplacer où la case sur laquelle il veut déplacer son pion
            
            
            Joueur jc = grille.JoueurCourant();
            int couleurjoueur = jc.ReferenceCouleurDuJoueur(); //On récupère la couleur du joueur courant
            
            if (grille.ReferencePions(ligne,colonne).ReferenceCouleurPion() == couleurjoueur) { //S'il clique sur son pion,
                
                bouton1.initialiserLigne(ligne); //On récupère la référence de coordonnée de cette case
                bouton1.initialiserColonne(colonne);
                
                return true;
                
                
            } else { //Sinon, rien ne se passe
                
                
                return false;
                
            }
            
        }
          
            public boolean Jouer(int ligne, int colonne) { //On joue un tour
            
                
            //Vérifier que le joueur n'a pas perdu tous ses pions ------------
                
            Joueur jc = grille.JoueurCourant();
            int couleurjoueur = jc.ReferenceCouleurDuJoueur(); //On récupère la couleur du joueur courant
            
            if (grille.NombrePionsCouleur(couleurjoueur)== 0) { //On compte son nombre de pions restant
                
                Joueur Jgagnant = grille.JoueurEnAttente();
                
                if (Jgagnant.ReferenceCouleurDuJoueur() == 1) { //On annonce le gagnant
                   System.out.println("Victoire du joueur Rouge ! ");
               } else {
                   System.out.println("Victoire du joueur Bleu ! ");
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
                
            if(grille.VerifierGagnant() == true) { //Si oui, on récupère son nom
                    
               Joueur Jgagnant = grille.etreGagnant();
               
               if (Jgagnant.ReferenceCouleurDuJoueur() == 1) { //On annonce le vainqueur
                   
                   System.out.println("Victoire du joueur Rouge ! ");
               } else {
                   System.out.println("Victoire du joueur Bleu ! ");
               }
               
           }
                
            //Sinon, on passe au tour suivant, et on actualise le plateau
            
            
            //A compléter, changement de carte du milieu avec celle du joueur
            
            grille.JoueurSuivant();
            AfficherPlateau();
            
            
            
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
        carte2_jr = new javax.swing.JPanel();
        carte1_jr = new javax.swing.JPanel();
        carte1_jb = new javax.swing.JPanel();
        carte2_jb = new javax.swing.JPanel();
        demarrer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bouton_demarrer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1800, 1800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        plateau.setBackground(new java.awt.Color(255, 255, 255));
        plateau.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(plateau, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 960, 960));

        carte_milieu.setBackground(new java.awt.Color(255, 255, 255));
        carte_milieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte_milieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 300, 185));

        carte2_jr.setBackground(new java.awt.Color(255, 255, 255));
        carte2_jr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte2_jr, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 300, 185));

        carte1_jr.setBackground(new java.awt.Color(255, 255, 255));
        carte1_jr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte1_jr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 185));

        carte1_jb.setBackground(new java.awt.Color(255, 255, 255));
        carte1_jb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte1_jb, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 750, 300, 185));

        carte2_jb.setBackground(new java.awt.Color(255, 255, 255));
        carte2_jb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(carte2_jb, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 750, 300, 185));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bouton_demarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton_demarrerActionPerformed
        
        //Affichage d'ambiance
        
        carte1_jb.setVisible(true);
        carte2_jb.setVisible(true);
        carte1_jr.setVisible(true);
        carte2_jr.setVisible(true);
        carte_milieu.setVisible(true);
        plateau.setVisible(true);
        demarrer.setVisible(false);
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
    private javax.swing.JPanel plateau;
    // End of variables declaration//GEN-END:variables
}

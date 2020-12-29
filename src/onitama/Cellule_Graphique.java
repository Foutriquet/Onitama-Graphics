package onitama;


import java.awt.Graphics;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Mini-Projet - Onitama
 * Nicolas TROUILLET - Mallory GOMBAULT
 * Class - Cellule Graphique
 */

/**
 *
 * @author Utilisateur
 */
public class Cellule_Graphique extends JButton {
    
    Pions CelluleAssociee;
    
    //Image du plateau *************************************************************
    
    
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/casevide.png"));
    ImageIcon img_pb = new javax.swing.ImageIcon(getClass().getResource("/images/casepionbleu.png"));
    ImageIcon img_pr = new javax.swing.ImageIcon(getClass().getResource("/images/casepionrouge.png"));
    ImageIcon img_rb = new javax.swing.ImageIcon(getClass().getResource("/images/caseroibleu.png"));
    ImageIcon img_rr = new javax.swing.ImageIcon(getClass().getResource("/images/caseroirouge.png"));
    ImageIcon img_temple = new javax.swing.ImageIcon(getClass().getResource("/images/casetemple.png"));
    ImageIcon img_pbt = new javax.swing.ImageIcon(getClass().getResource("/images/pionbleusurtemple.png"));
    ImageIcon img_prt = new javax.swing.ImageIcon(getClass().getResource("/images/pionrougesurtemple.png"));
    ImageIcon img_rbt = new javax.swing.ImageIcon(getClass().getResource("/images/roibleusurtemple.png"));
    ImageIcon img_rrt = new javax.swing.ImageIcon(getClass().getResource("/images/roirougesurtemple.png"));
    
    
    // Image des cartes *************************************************************
    
    ImageIcon img_cobra = new javax.swing.ImageIcon(getClass().getResource("/images/cobra.png"));
    ImageIcon img_sanglier = new javax.swing.ImageIcon(getClass().getResource("/images/boar.png"));
    ImageIcon img_crabe = new javax.swing.ImageIcon(getClass().getResource("/images/crab.png"));
    ImageIcon img_grue = new javax.swing.ImageIcon(getClass().getResource("/images/crane.png"));
    ImageIcon img_dragon = new javax.swing.ImageIcon(getClass().getResource("/images/dragon.png"));
    ImageIcon img_anguille = new javax.swing.ImageIcon(getClass().getResource("/images/eel.png"));
    ImageIcon img_elephant = new javax.swing.ImageIcon(getClass().getResource("/images/elephant.png"));
    ImageIcon img_grenouille = new javax.swing.ImageIcon(getClass().getResource("/images/frog.png"));
    ImageIcon img_oie = new javax.swing.ImageIcon(getClass().getResource("/images/goose.png"));
    ImageIcon img_cheval = new javax.swing.ImageIcon(getClass().getResource("/images/horse.png"));
    ImageIcon img_singe = new javax.swing.ImageIcon(getClass().getResource("/images/monkey.png"));
    ImageIcon img_mante = new javax.swing.ImageIcon(getClass().getResource("/images/mantis.png"));
    ImageIcon img_boeuf = new javax.swing.ImageIcon(getClass().getResource("/images/ox.png"));
    ImageIcon img_lapin = new javax.swing.ImageIcon(getClass().getResource("/images/rabit.png"));
    ImageIcon img_coq = new javax.swing.ImageIcon(getClass().getResource("/images/rooster.png"));
    ImageIcon img_tigre = new javax.swing.ImageIcon(getClass().getResource("/images/tiger.png"));

    
    
    
    
   
    Cellule_Graphique (Pions coordAssoc) {
        CelluleAssociee = coordAssoc;
    }
    
    
    @Override
    public void paintComponent (Graphics G) {
        super.paintComponent(G);
        
        if (CelluleAssociee.etreRoi() == true) {
            
        
            switch (CelluleAssociee.ReferenceCouleurPion()) {
                    
                    case 1:
                        
                        if (( CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
                           setIcon(img_rrt); 
                           break;
                        } else {
                            setIcon(img_rr); 
                            break;
                        }
                       
                        
                        
                    case -1 :
                        if (( CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
                           setIcon(img_rbt); 
                           break;
                        } else {
                            setIcon(img_rb); 
                            break;
                        }
                        
            }
        } else if (CelluleAssociee.ReferenceCouleurPion() == 1 && CelluleAssociee.etreRoi() == false) {
                
            if ((CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
                
                        setIcon(img_prt);
                       
            } else {
                        
                        setIcon(img_pr);
                        
                }
        
    } else if (CelluleAssociee.ReferenceCouleurPion() == -1 && CelluleAssociee.etreRoi() == false) {
                
            if ((CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
                
                        setIcon(img_pbt);
                       
            } else {
                        
                        setIcon(img_pb);
                        
                }
    
    
    } else if ((CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
        
        setIcon(img_temple);

    } else {
        
        setIcon(img_vide);
    }
        
        
        
    }
}
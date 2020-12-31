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
    Carte CarteAssociee;
    
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
    ImageIcon img_lapin = new javax.swing.ImageIcon(getClass().getResource("/images/rabbit.png"));
    ImageIcon img_coq = new javax.swing.ImageIcon(getClass().getResource("/images/rooster.png"));
    ImageIcon img_tigre = new javax.swing.ImageIcon(getClass().getResource("/images/tiger.png"));

    
    
    
    //Constructeur
   
    Cellule_Graphique (Pions coordAssoc) {
        CelluleAssociee = coordAssoc;
    }
    
    Cellule_Graphique (Carte carteAssoc) {
        CarteAssociee = carteAssoc;
    }
    
    
    @Override
    public void paintComponent (Graphics G) {
        super.paintComponent(G);
        
        //Si la case possède un roi 
        
        /*if ((CelluleAssociee == null && CelluleAssociee.ReferenceCoordonnee() == Coordonnee.TempleBleu) || (CelluleAssociee == null && CelluleAssociee.ReferenceCoordonnee() == Coordonnee.TempleRouge)) {
        //Si ce n'est qu'un temple vide
            setIcon(img_temple);

        } else*/ if (CelluleAssociee == null) { //Si ce n'est qu'une case vide
        
            setIcon(img_vide); 
        
        } else if (CelluleAssociee.etreRoi() == true) {
            
        //Dépendant de la couleur du roi
            switch (CelluleAssociee.ReferenceCouleurPion()) {
                    
                    case 1: //S'il est rouge
                        
                        
                        if (( CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
                           setIcon(img_rrt);  //S'il est sur un temple
                           break;
                        } else {
                            setIcon(img_rr); //Sinon
                            break;
                        }
                       
                        
                        
                    case -1 : //S'il est bleu
                        if (( CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
                           setIcon(img_rbt); //S'il est sur un temple
                           break;
                        } else {
                            setIcon(img_rb); //Sinon
                            break;
                        }
                        
            }
            //Si c'est un simple pion rouge
        } else if (CelluleAssociee.ReferenceCouleurPion() == 1 && CelluleAssociee.etreRoi() == false) {
                
            if ((CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
                
                        setIcon(img_prt); //Sur un temple
                       
            } else { 
                        
                        setIcon(img_pr); //Sinon
                        
                }
        
    } else if (CelluleAssociee.ReferenceCouleurPion() == -1 && CelluleAssociee.etreRoi() == false) { //Si c'est un simple pion bleu
                
            if ((CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 4) || (CelluleAssociee.ReferenceCoordonnee().ReferenceLigne() == 2 && CelluleAssociee.ReferenceCoordonnee().ReferenceColonne() == 0)) {
                
                        setIcon(img_pbt); //Sur un temple
                       
            } else {
                        
                        setIcon(img_pb); //Sinon
                        
                }
    
    
    }   
       
        
        //***********************************************************************************************************
        
        
    //Attribution des icons des cartes aux labels
        
    for (int i = 0; i<16 ; i++) {   
        
        if (CarteAssociee == null) return;
        
        if(CarteAssociee.prendreNom() == "tigre") {
            setIcon(img_tigre); 
        }
        
        if(CarteAssociee.prendreNom() == "cobra") {
            setIcon(img_cobra);
        }
        
        if(CarteAssociee.prendreNom() == "sanglier") {
            setIcon(img_sanglier);
        }
        
        if(CarteAssociee.prendreNom() == "crabe") {
            setIcon(img_crabe);   
        } 
        
        if(CarteAssociee.prendreNom() == "anguille") {
            setIcon(img_anguille);  
        } 
        
        if(CarteAssociee.prendreNom() == "elephant") {
            setIcon(img_elephant);
        }
        
        if(CarteAssociee.prendreNom() == "cheval") {
            setIcon(img_cheval);
        }
        
        if(CarteAssociee.prendreNom() == "boeuf") {
            setIcon(img_boeuf);
        }
        
        if(CarteAssociee.prendreNom() == "lapin") {
            setIcon(img_lapin);   
        } 
        
        if(CarteAssociee.prendreNom() == "oie") {
            setIcon(img_oie);
        }
        
        if(CarteAssociee.prendreNom() == "grue") {
            setIcon(img_grue);
        }
        
        if(CarteAssociee.prendreNom() == "dragon") {
            setIcon(img_dragon);
        }
        
        if(CarteAssociee.prendreNom() == "coq") {
            setIcon(img_coq);
        }
        
        if(CarteAssociee.prendreNom() == "mante") {
            setIcon(img_mante); 
        } 
        
        if(CarteAssociee.prendreNom() == "singe") {
            setIcon(img_singe);
        }
            
        if(CarteAssociee.prendreNom() == "grenouille") {
            setIcon(img_grenouille);
        }
        
        } 
        }
        
        
        
        
        
        
    }
        
        


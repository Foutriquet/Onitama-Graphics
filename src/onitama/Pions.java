/*
 * Mini-Projet - Onitama
 * Nicolas TROUILLET - Mallory GOMBAULT
 * Class - Pions
 */
package onitama;

/**
 *
 * @author Utilisateur
 */
public class Pions {
    
    //Attribut
    
        private Coordonnee position;
	private int couleurPion;
	private boolean etreRoi;

        
        //METHODE 1 ------------------------------------------------------------------------------------------------------
        
        
	public Pions(Coordonnee positionpion, int couleur, boolean Roi) { //Constructeur du pion
		this.etreRoi = Roi;
		position = new Coordonnee(positionpion);
		couleurPion = couleur;
	}

        
        //METHODE 2 ------------------------------------------------------------------------------------------------------
        
        
	public Pions(Pions pioncourant) { //Référence du pion
		etreRoi = pioncourant.etreRoi();
		couleurPion = pioncourant.ReferenceCouleurPion();
		position = new Coordonnee(pioncourant.ReferenceCoordonnee());
	}

        
        //METHODE 3 ------------------------------------------------------------------------------------------------------
        
        
	public Coordonnee ReferenceCoordonnee() { //Reference coordonnee
		return position;
	}

        
        //METHODE 4 ------------------------------------------------------------------------------------------------------
        
        
	public void InitialiserCoordonnee(Coordonnee c) { //Initialise ses coordonnées
		position = new Coordonnee(c);
	}

        
        //METHODE 5 ------------------------------------------------------------------------------------------------------
        
        
	public int ReferenceCouleurPion() { //Référence de sa couleur
		return couleurPion;
	}

        
        //METHODE 6 ------------------------------------------------------------------------------------------------------
        
        
	public boolean etreRoi() { //Référence du roi
		return etreRoi;
	}

        
      

}


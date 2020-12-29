
package onitama;

import java.util.Arrays;

/*
 * Mini-Projet - Onitama
 * Nicolas TROUILLET - Mallory GOMBAULT
 * Class - Joueur
 */

/**
 *
 * @author Utilisateur
 */
public class Joueur {
    
    //Attributs

	private Carte[] cartesDuJoueur;
	private Grille grilledujoueur;
	private int couleur;
	

	
        
        //METHODE 1 ------------------------------------------------------------------------------------------------------
        
        

	public Joueur(Carte[] capacitedemouvement, int couleurJoueur) { //Constructeur
		cartesDuJoueur = capacitedemouvement;
		couleur = couleurJoueur;
		
	}

        
        //METHODE 2 ------------------------------------------------------------------------------------------------------
        
        
	public Joueur(Joueur joueur) { //Référence du joueur
            
		cartesDuJoueur = Arrays.copyOf(joueur.ReferenceCarteDuJoueur(),2); //On récupère les deux premières cartes du joueur
		grilledujoueur = joueur.ReferenceGrille();
		couleur = joueur.ReferenceCouleurDuJoueur();
		
	}

	

        
        //METHODE 3 ------------------------------------------------------------------------------------------------------
        
        

	public void InitialiserGrille(Grille grille) { //On crée la grille
		if(grilledujoueur == null)
			grilledujoueur = grille;
		else
			grilledujoueur = new Grille(grille);
	}

        
        //METHODE 4 ------------------------------------------------------------------------------------------------------
        
        
	public Grille ReferenceGrille() { //Référence de la grille
		return grilledujoueur;
	}

        
        //METHODE 5 ------------------------------------------------------------------------------------------------------
        
        
	public void InitialiserCarte(int numeroCarte, Carte cartejoueur) { //Attribution de la carte au tableau de carte du joueur
		cartesDuJoueur[numeroCarte] = new Carte(cartejoueur);
	}

        
        //METHODE 6 ------------------------------------------------------------------------------------------------------
        
        
	public Carte[] ReferenceCarteDuJoueur() { //Référence des cartes du joueur
		return cartesDuJoueur;
	}

        
        //METHODE 7 ------------------------------------------------------------------------------------------------------
        
        
	public int ReferenceCouleurDuJoueur() { //Référence couleur joueur
		return couleur;
	}

        

}

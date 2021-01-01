/*
 * Mini-Projet - Onitama
 * Nicolas TROUILLET - Mallory GOMBAULT
 * Class - Partie
 */
package onitama;

/**
 *
 * 
 * @author Utilisateur
 */
public class Partie {
    
    // Attributs
    
        private static Partie jeu;


	private Joueur joueur1, joueur2;

	private Grille grille;

	private static int NombreJoueur = 2;

        
        //METHODE 1 ------------------------------------------------------------------------------------------------------
        
        
	public static void main(String [] args) { //Intialisation de la partie
            
		Carte.init();
		Deck.init();
                Deck.Melanger();
		jeu = new Partie();
		
	}

        
        //METHODE 2 ------------------------------------------------------------------------------------------------------
        
        

	public Partie() { //Commencer la partie
            
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
	}

	
}

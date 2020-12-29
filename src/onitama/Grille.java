/*
 * Mini-Projet - Onitama
 * Nicolas TROUILLET - Mallory GOMBAULT
 * Class - Deck
 */
package onitama;

/**
 *
 * @author Utilisateur
 */
public class Grille {
    
        
    //Attributs

	public static final int rouge  = 1; //Attribution des nombres essentiels aux calculs
	public static final int bleu = -1;

	private Pions pionsEnJeu [][] = new Pions[5][5]; //On crée les pions
        

	private boolean PresenceRoiBleu = true; 
	private boolean PresenceRoiRouge  = true;

	private boolean VictoireBleu = false;
	private boolean VictoireRouge = false;

	private Carte CarteDuMilieu;

	private Joueur JoueurCourant;
	private Joueur JoueurEnAttente;


        
        //METHODE 1 ------------------------------------------------------------------------------------------------------
        
        
	public Grille(Grille grilleJeu) { //Création de la grille
            
		CarteDuMilieu = new Carte(grilleJeu.RecupererCarteMilieu()); //Référence de la carte du milieu

		for(int i = 0; i < 25; i++) //Il attribue les pions à la liste pionsEnJeu qui contient tous les pions
			if(grilleJeu.ReferencePions(i%5,i/5) != null) //Comme il y a cinq pions, le modulo nous permet de les mettre à une certaine distance les uns des autres 
				pionsEnJeu[i/5][i%5] = new Pions(grilleJeu.ReferencePions(i%5,i/5));

		JoueurCourant = new Joueur(grilleJeu.JoueurCourant()); //On crée les joueurs
		JoueurEnAttente = new Joueur(grilleJeu.JoueurEnAttente());
	}

        
        //METHODE 2 ------------------------------------------------------------------------------------------------------
        
        
	public Grille(Carte cartemilieu, Joueur joueurquicommence, Joueur joueurquiattend) { //Constructeur
            
		JoueurCourant = joueurquicommence;
		JoueurEnAttente = joueurquiattend;
		CarteDuMilieu = cartemilieu;

		for(int i = 0; i < 5; i++) { //On applique les coordonnées des pions par joueur
			pionsEnJeu[0][i] = new Pions(new Coordonnee(i,0),  rouge, i == 2);
			pionsEnJeu[4][i] = new Pions(new Coordonnee(i,4), bleu, i == 2);
		}

	}

        
        //METHODE 3 ------------------------------------------------------------------------------------------------------
        
        
	public Carte RecupererCarteMilieu() { //Référence carte du milieu
		return CarteDuMilieu;
	}

        
        //METHODE 4 ------------------------------------------------------------------------------------------------------
        
        
	public Joueur JoueurCourant() { //Référence joueur courant
		return JoueurCourant;
	}

        
        //METHODE 5 ------------------------------------------------------------------------------------------------------
        
        
	public Joueur JoueurEnAttente() { //Référence joueur en attente
		return JoueurEnAttente;
	}

        
        //METHODE 6 ------------------------------------------------------------------------------------------------------
        
        
	public void JoueurSuivant() { //Méthode pour changer le tour des joueurs
            
		Joueur courant = JoueurCourant;
		JoueurCourant = new Joueur(JoueurEnAttente);
		JoueurEnAttente = new Joueur(courant);
	}


        
        //METHODE 7 ------------------------------------------------------------------------------------------------------
        
        
	public Pions CoordonneeRoi(int couleur) {
            
		for(Pions pionscourant: ReferencePionsCouleur(couleur)) //On récupère les coordonnée du roi en fonction de la couleur donné
			if(pionscourant != null && pionscourant.etreRoi()) //On cherche la présence du roi
				return pionscourant;
		return null;
	}

        
        //METHODE 8 ------------------------------------------------------------------------------------------------------
        
        
	public int NombrePionsCouleur(int couleur) { //On cherche le nombre de pion restant par joueur
		int count = 0;
		for(Pions pionscourant: ReferencePionsCouleur(couleur))
			if(pionscourant != null)
				++count;
		return count;
	}

	
        
        //METHODE 9 ------------------------------------------------------------------------------------------------------
        
        
	public Pions[][] ReferencePions() { //Référence des pions restant sur la grille
		return pionsEnJeu;
	}

        
        //METHODE 10 ------------------------------------------------------------------------------------------------------
        
        
	public Carte[] CarteDuJoueur(int couleur) { //Référence des cartes d'un joueur en fonction de sa couleur
		return CouleurJoueur(couleur).ReferenceCarteDuJoueur();
	}

        
        //METHODE 11 ------------------------------------------------------------------------------------------------------
        
        
	public Pions ReferencePions(int ligne, int colonne) { //Référence du pions par rapport à sa position
		return pionsEnJeu[colonne][ligne];
	}


        
        //METHODE 12 ------------------------------------------------------------------------------------------------------
        
        
	public Pions [] ReferencePionsCouleur(int couleur) { //On cherche la référence des pions par rapport à leur couleur
            
		int index = 0;
		Pions [] pions = new Pions[5];

		for(int i = 0; i < 25; i++) //même façon que pour la référence de la grille
			if(ReferencePions(i%5,i/5) != null && ReferencePions(i%5,i/5).ReferenceCouleurPion() == couleur)
				pions[index++] = new Pions(ReferencePions(i%5,i/5));

		return pions;
	}

        
        //METHODE 13 ------------------------------------------------------------------------------------------------------
        
        
	public Pions ReferencePions2(Coordonnee position) { //On récupère la position du pion
		return ReferencePions(position.ReferenceLigne(),position.ReferenceColonne());
	}

        
        //METHODE 14 ------------------------------------------------------------------------------------------------------
        
        
	public Carte echangerCarte(Carte carteaechanger) { //Changer la carte du milieu avec celle du joueur une fois qu'il a joué
		Carte variable = CarteDuMilieu;
		CarteDuMilieu = carteaechanger;
		return variable;
	}

        
        //METHODE 15 ------------------------------------------------------------------------------------------------------
        
        
	public Joueur etreGagnant() { //On prend la couleur du gagnant
		if(VictoireBleu || !PresenceRoiRouge)
			return CouleurJoueur(bleu);
		if(VictoireRouge || !PresenceRoiBleu)
			return CouleurJoueur(rouge);
		return null;
	}

        
        //METHODE 16 ------------------------------------------------------------------------------------------------------
        
        
	public boolean VerifierGagnant() { //On vérifie qui gagne

		Pions pion = ReferencePions2(Coordonnee.TempleRouge);

		if(pion != null && pion.etreRoi() && pion.ReferenceCouleurPion() == bleu) //Position du roi 
			return (VictoireBleu = true);

		pion = ReferencePions2(Coordonnee.TempleBleu);
                
		if(pion != null && pion.etreRoi() && pion.ReferenceCouleurPion() == rouge)
			return (VictoireRouge = true);

		PresenceRoiBleu = (CoordonneeRoi(bleu)  != null);
		PresenceRoiRouge  = (CoordonneeRoi(rouge)   != null);

		return !(PresenceRoiBleu && PresenceRoiRouge);
	}

        
        //METHODE 17 ------------------------------------------------------------------------------------------------------
        
        
	public void jouer(Coordonnee de, Coordonnee vers) { //Jouer un pion
            
            //Si on mange le roi
		if(ReferencePions2(vers) != null && ReferencePions2(vers).etreRoi() && ReferencePions2(vers).ReferenceCouleurPion() != ReferencePions2(de).ReferenceCouleurPion()) //On vérifie que le mouvement est faisable
			if(ReferencePions2(vers).ReferenceCouleurPion() == bleu) //On vérifie que le roi n'est pas à l'emplacement
				PresenceRoiBleu = false;
			else
				PresenceRoiRouge = false; 
// ------------------------------------------------------------------------------------------------------------------------

		pionsEnJeu[vers.ReferenceColonne()][vers.ReferenceLigne()] = new Pions(ReferencePions2(de)); //On déplace le pion à ses nouvelles coordonnées
                
		ReferencePions(vers.ReferenceLigne(),vers.ReferenceColonne()).InitialiserCoordonnee(vers); //On lui attribut ses nouvelles coordonnées
                
		pionsEnJeu[de.ReferenceColonne()][de.ReferenceLigne()] = null; //L'ancienne position devient null
	}

       
        //METHODE 18 ------------------------------------------------------------------------------------------------------
        
        
	public Joueur CouleurJoueur(int couleur) { //On cherche a savoir si le joueur d'une certaine couleur joue ou est en attente
		if(JoueurCourant.ReferenceCouleurDuJoueur() == couleur)
			return JoueurCourant;
		return JoueurEnAttente;
	}

        
        //METHODE 19 ------------------------------------------------------------------------------------------------------
        
        
	public void echangerCarteMilieu(Carte carteajouer) { //On échange la carte du joueur avec celle du milieu dans sa liste
            
		for(int i = 0; i < 2; i++) {
			if(JoueurCourant.ReferenceCarteDuJoueur()[i] == carteajouer) { //S'il joue telle carte, alors on l'échange
				JoueurCourant.InitialiserCarte(i, CarteDuMilieu);
				CarteDuMilieu = new Carte(carteajouer);
				break;
			}

			if(JoueurEnAttente.ReferenceCarteDuJoueur()[i] == carteajouer) {
				JoueurEnAttente.InitialiserCarte(i, CarteDuMilieu);
				CarteDuMilieu = new Carte(carteajouer);
				break;
			}
		}
	}
        
        
       

        
}

        
       

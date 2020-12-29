/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama;

/**
 *
 * @author Utilisateur
 */
public class Coordonnee {
    
        //On place les rois sur leur position
	public static final Coordonnee TempleBleu = new Coordonnee(2,4);
	public static final Coordonnee TempleRouge = new Coordonnee(2,0);

	private int ligne,colonne; //Une coordonnée est définie par sa ligne et sa colonne

        
        //METHODE 1 ------------------------------------------------------------------------------------------------------
        
        
	public Coordonnee(int ligne, int colonne) { //Constructeur 
		this(new int[] {ligne,colonne});
	}

        
        //METHODE 2 ------------------------------------------------------------------------------------------------------
        
        
	public Coordonnee(int[] element) { //Methode qui sert à rassembler deux élements en un seul objet
		MettreEnCommun(element);
	}

        
        //METHODE 3 ------------------------------------------------------------------------------------------------------
        
        
	public Coordonnee(Coordonnee position) { //Référence de la position d'un élément
		this(position.ReferencePaire());
	}

        
        //METHODE 4 ------------------------------------------------------------------------------------------------------
        
        
	public void MettreEnCommun(int[] element) { //Methode qui sert à rassembler deux élements(tableau) en un seul
		MettreEnCommun(element[0],element[1]);
	}

        
        //METHODE 5 ------------------------------------------------------------------------------------------------------
        
        
	public boolean DeplacerPion(int[] deplacement, int couleur) { //Déplacement de la position d'un pion
            
		return DeplacerCoordonnee(deplacement[0], deplacement[1], couleur);
	}

        
        //METHODE 6 ------------------------------------------------------------------------------------------------------
        
        
	public boolean DeplacerCoordonnee(int Lnouvelle, int Cnouvelle, int couleur) { //Deplacement des coordonnées d'un pion
            
            //On initialise nos variables
		int NouvelleLigne = ligne;
		int NouvelleColonne = colonne;

		NouvelleLigne += Lnouvelle*-1*couleur; //Comme les couleurs sont égales à 1 et -1 et que les grilles sont en 
                //orientation opposée, on utilise ce calcul pour déplacer parfaitement les coordonnées en fonction de la carte à jouer
                
		NouvelleColonne += Cnouvelle*couleur;

		if((NouvelleLigne >= 0 && NouvelleLigne < 5) && (NouvelleColonne >= 0 && NouvelleColonne < 5)) { //On vérifie que le déplacement est faisable dans les limites de la grille
                    
			MettreEnCommun(NouvelleLigne, NouvelleColonne); //Rassembler les coordonnees 
			return true; //Le changement s'est bien passé
		}
                
		return false; //Le changement s'est mal passé
	}

        
        //METHODE 7 ------------------------------------------------------------------------------------------------------
        
        
        
	public void MettreEnCommun(int Ligne, int Colonne) {  //On initialise nos coordonnées
            
	
	initialiserLigne(Ligne);
	initialiserColonne(Colonne);
		
	}

        
        //METHODE 8 ------------------------------------------------------------------------------------------------------
        
        
	public void initialiserLigne(int n) { //On intialise la ligne
		if(n < 0 || n >= 5) {
                    System.out.println("La ligne est hors du tableau");
                }
		ligne = n;
	}

        
        //METHODE 9 ------------------------------------------------------------------------------------------------------
        
        
	public void initialiserColonne(int n){ //On initialise la colonne
		if(n < 0 || n >= 5) {
                    System.out.println("La colonne est hors du tableau");
                }
		colonne = n;
	}

        
        //METHODE 10------------------------------------------------------------------------------------------------------
        
        
	public int ReferenceLigne() { //On récupère la référence de la ligne
		return ligne;
	}

        
        //METHODE 11 ------------------------------------------------------------------------------------------------------
        
        
	public int ReferenceColonne() { //On récupère la référence de la colonne
		return colonne;
	}

        
        //METHODE 12 ------------------------------------------------------------------------------------------------------
        
        
	public int[] ReferencePaire() { //On récupère la référence de la paire colonne/ligne
		return new int[] {ligne,colonne};
	}


}

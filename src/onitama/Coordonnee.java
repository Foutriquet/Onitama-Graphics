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
        
        
        
	public void MettreEnCommun(int Ligne, int Colonne) {  //On initialise nos coordonnées
            
	
	initialiserLigne(Ligne);
	initialiserColonne(Colonne);
		
	}

        
        //METHODE 6 ------------------------------------------------------------------------------------------------------
        
        
	public void initialiserLigne(int n) { //On intialise la ligne
		
		ligne = n;
	}

        
        //METHODE 7 ------------------------------------------------------------------------------------------------------
        
        
	public void initialiserColonne(int c){ //On initialise la colonne
		
		colonne = c;
	}

        
        //METHODE 8------------------------------------------------------------------------------------------------------
        
        
	public int ReferenceLigne() { //On récupère la référence de la ligne
		return ligne;
	}

        
        //METHODE 9 ------------------------------------------------------------------------------------------------------
        
        
	public int ReferenceColonne() { //On récupère la référence de la colonne
		return colonne;
	}

        
        //METHODE 10 ------------------------------------------------------------------------------------------------------
        
        
	public int[] ReferencePaire() { //On récupère la référence de la paire colonne/ligne
		return new int[] {ligne,colonne};
	}


}

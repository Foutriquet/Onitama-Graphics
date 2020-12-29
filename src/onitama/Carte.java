/*
 * Mini-Projet - Onitama
 * Nicolas TROUILLET - Mallory GOMBAULT
 * Class - Carte
 */
package onitama;

import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class Carte {
    
    //Atributs
    
    private String nom;
    private int[][] CapaciteDeMouvement;
    private int couleurCarte;
    
        public static ArrayList<Carte> TouteslesCartes = new ArrayList<Carte>(); //Les éléments d'un array liste peuvent être ajouter ou enlever à n'importe quel moment.
        //Nous en avons donc besoin car nos attributs sont privées. ArrayList permet de créer un objet de ce type
    
        //Toutes les cartes du jeu 
        
        public static Carte tigre;
	public static Carte dragon;
	public static Carte grenouille;
	public static Carte lapin;
	public static Carte crabe;
	public static Carte elephant;
	public static Carte oie;
	public static Carte coq;
	public static Carte singe;
	public static Carte mante;
	public static Carte cheval;
	public static Carte boeuf;
	public static Carte grue;
	public static Carte sanglier;
	public static Carte anguille;
	public static Carte cobra;
        
        
        
        //METHODE 1 ------------------------------------------------------------------------------------------------------
        
        
    public String prendreNomCarte() {
		return nom;
	}

        
        //METHODE 2 ------------------------------------------------------------------------------------------------------
        
        
//Informations récupérée sur internet. Elles représentent les déplacements possible depuis la position du joueur. 
	public static void init() { //Les grille.couleur permettent l'attribution de la carte à une orientation de grille d'un joueur
            
		tigre = new Carte(new int[][] {{0,2},{0,-1}},"tigre", Grille.bleu); //Exemple, ici, le tigre peut aller deux cases en avant, et une case en arrière (0,2) et (0,-1)
		dragon = new Carte(new int[][] {{-2,1}, {-1,-1}, {1,-1},{2,1}} ,"Dragon", Grille.rouge); //Ici, il peut aller deux cases en diagonale vers la gauche (-2,1)
		grenouille = new Carte(new int[][] {{-2,0}, {-1,1},  {1,-1}},"grenouille", Grille.rouge);
		lapin = new Carte(new int[][] {{1,1},{-1,-1}, {2,0}},"lapin", Grille.bleu);
		crabe = new Carte(new int[][] {{2,0},{-2,0},  {0,1}} ,"crabe", Grille.bleu);
		elephant = new Carte(new int[][] {{1,0},{-1,0},{1,1},{-1,1}},"Elephant", Grille.rouge);
		oie = new Carte(new int[][] {{-1,1}, {1,-1},{-1,0},{1,0}},"oie", Grille.bleu);
		coq = new Carte(new int[][] {{-1,-1},{1,1},{-1,0},{1,0}},"coq", Grille.rouge);
		singe = new Carte(new int[][] {{1,1}, {-1,-1}, {1,-1}, {-1,1}},"singe", Grille.bleu);
		mante = new Carte(new int[][] {{0,-1},{-1,1},{1,1}} ,"mante", Grille.rouge);
		cheval = new Carte(new int[][] {{-1,0},{0,1},{0,-1}},"cheval", Grille.rouge);
		boeuf = new Carte(new int[][] {{1,0},{0,1},{0,-1}},"boeuf", Grille.bleu);
		grue = new Carte(new int[][] {{-1,-1},{1,-1},{0,1}} ,"grue", Grille.bleu);
		sanglier = new Carte(new int[][] {{-1,0},{1,0},{0,1}},"sanglier", Grille.rouge);
		anguille = new Carte(new int[][] {{-1,1},{-1,-1},{1,0}},"anguille", Grille.bleu);
		cobra = new Carte(new int[][] {{1,1},{1,-1},{-1,0}} ,"Cobra", Grille.rouge);
	}

        
        //METHODE 3 ------------------------------------------------------------------------------------------------------
        
        
	Carte(int [][] CapaciteDeMouvementCarte, String nomCarte, int couleur) { //Constructeur de la carte
            
		this.CapaciteDeMouvement = CapaciteDeMouvementCarte; //This représente la carte
		this.nom  = nomCarte;
		this.couleurCarte = couleur;

		TouteslesCartes.add(this);
	}

        
        //METHODE 4 ------------------------------------------------------------------------------------------------------
        
        
	public Carte(Carte cartecourante) { //Récupérer la référence de la carte
            
		CapaciteDeMouvement = cartecourante.prendreCapacitedeMouv(); 
		nom  = cartecourante.prendreNom();
		couleurCarte = cartecourante.prendreCouleur();
	}

        
        //METHODE 5 ------------------------------------------------------------------------------------------------------
        
        
	public int [][] prendreCapacitedeMouv() { //Référence des mouvements
		return CapaciteDeMouvement;
	}

        
        //METHODE 6 ------------------------------------------------------------------------------------------------------
        
        
	public String prendreNom() { //Référence nom
		return nom;
	}

        
        //METHODE 7 ------------------------------------------------------------------------------------------------------
        
        
	public int prendreCouleur() { //Référence couleur
		return couleurCarte;
	}

        
        //METHODE 8 ------------------------------------------------------------------------------------------------------
        
        
	public String prendreCouleurString() { //Renvoie la couleur en string de la carte
		String couleur = "bleu";
		if(couleurCarte == Grille.rouge) couleur = "rouge";
		return couleur;
	}

        
        //METHODE 9 ------------------------------------------------------------------------------------------------------
        
        
	public static Carte CarteParNom(String nomCarte) { //Vérifie que la carte en train d'être joué est la bonne
            
		for(Carte cartecourante : TouteslesCartes)
			if(cartecourante.nom == nomCarte) //Si le nom est bien le même que celui de la carte, c'est ok
                            
				return cartecourante;
		return null;
	}

        
    
}

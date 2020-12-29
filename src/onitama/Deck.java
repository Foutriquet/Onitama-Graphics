/*
 * Mini-Projet - Onitama
 * Nicolas TROUILLET - Mallory GOMBAULT
 * Class - Deck
 */
package onitama;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Utilisateur
 */
public class Deck {
    
    private static Carte TouteslesCartes[]; //Attribut regroupant toutes les cartes
   
        
        //METHODE 1 ------------------------------------------------------------------------------------------------------
        
        
 public static void init() { //Initialise le deck des cartes
     
		TouteslesCartes = new Carte[Carte.TouteslesCartes.size()]; //On crée une liste qui regroupe toutes les cartes du jeu en parcourant la taille

		Melanger();
                
	}

        
        //METHODE 2 ------------------------------------------------------------------------------------------------------
        
        
	public static Carte[] Distribuer() {  //Méthode qui distribue les cartes
            
		return Arrays.copyOfRange(TouteslesCartes,0,5); //Cette méthode copie les cinq premières cartes de la liste et les range dans une nouvelle liste
	}

        
        //METHODE 3 ------------------------------------------------------------------------------------------------------
        
        
	public static void Melanger() {//Méthode pour mélanger les cartes ------
            
		Collections.shuffle(Carte.TouteslesCartes); //Après renseignement sur internet, on a importé la fonction "shuffle" pour mélanger le deck
		
                for (int i = 0; i < 5; i++) //On leur donne une nouvelle position
			TouteslesCartes[i] = Carte.TouteslesCartes.get(i); //La méthode get est utilisé pour récupérer l'élément d'une position spécifique dans une liste
	}
}


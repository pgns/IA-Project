package ia;


import java.lang.reflect.Array;
import java.util.ArrayList;

import puissance4.Plateau;
import utils.Coordonnees;

public class MinMax {

/**
 * L'algo min max suivi v1
 */
/*	Algorithme DecisionMinMax (e,J) 
	{ D�cide du meilleur coup � jouer par le joueur J dans la situation e }
	D�but
	  Pour chaque coup de CoupJouables(e,J) faire
	    valeur[coup] = ValeurMinMax(Applique(coup,e),J,false)
	  Fin pour
	  retourner (coup tel que valeur[coup] est maximale)
	Fin

	Algorithme ValeurMinMax (e,J,EstUnEtatMax) 
	{ Calcule la valeur de e pour le joueur J selon que e EstUnEtatMax ou pas }
	D�but
	  Si PartieGagnante(e,J) Alors retourner(+1)
	  Sinon Si PartiePerdante(e,J) Alors retourner(-1)
	        Sinon Si PartieNulle(e,J) Alors retourner(0)
	              Sinon 
	                 vals = vide
	                 Pour s parmi les successeurs de e faire
	                    ajouter ValeurMinMax(s,J,not(EstUnEtatMax))) � vals
	                 Fin pour
	                 Si EstUnEtatMax
	                 Alors retourner(maximum de vals)
	                 Sinon retourner(minimum de vals)
	              Fin si
	        Fin si
	  Fin si
	Fin*/
	
	ListeCoupPossible listeCoupPossible;
	
	/*public int valeurMinMax(Plateau p, byte joueur, boolean niveauMax){
		byte joueurVictoir = p.victoire();
		byte joueurNext;
		int i;
		if (joueurVictoir == joueur)
			return Integer.MAX_VALUE;
		else if(joueurVictoir == 0)
			if (p.plateauPlein())
				return 0;
			else{
				if (joueur == 1)
					joueurNext = 2;
				else
					joueurNext = 1;
				ArrayList<Integer> listeValeur=new ArrayList<Integer>();
				ListeCoupPossible lcp = new ListeCoupPossible(p,joueurNext);
				
				for (i = 0 ; i < lcp.size(); i++){
					listeValeur.add(valeurMinMax(lcp.get(i),joueurNext,!niveauMax));
				}
				if(niveauMax){ //retour du minimum
					int min = Integer.MAX_VALUE;
					for(i = 0 ; i < listeValeur.size() ; i++)
						if (listeValeur.get(i) < min)
							min = listeValeur.get(i);
					return min;
				}
				else{ //retour du maximum 
					int max = Integer.MIN_VALUE;
					for(i = 0 ; i < listeValeur.size() ; i++)
						if (listeValeur.get(i) > max)
							max = listeValeur.get(i);
					return max;
				}
			}
		else
			return Integer.MIN_VALUE;
	}*/
	
	public MinMax(){
	}
	
	/**
	 * La fonction min-max
	 * @param joueur
	 * @param plateau
	 * @return le plateau qui a la meilleur proba de gagner
	 */
	public Plateau minMax(byte joueur, Plateau plateau){
		this.listeCoupPossible = new ListeCoupPossible(plateau,joueur);
		int valeur_max = Integer.MIN_VALUE;
		int indice_max=0;
		int valeur;
		//System.out.println("Joueur : "+joueur);
		for (int i=0 ; i < this.listeCoupPossible.size(); i++){
			valeur = valeurMinMaxLimite(this.listeCoupPossible.get(i),joueur,false,6);
			/*System.out.println();
			System.out.println(valeur+" "+i);
			System.out.println();
			System.out.println();*/
			if (valeur > valeur_max){
				valeur_max = valeur;
				indice_max = i;
			}
		}
		return this.listeCoupPossible.get(indice_max);	
	}
	
	/**
	 * La fonction valeau min-max limit� a une profondeur
	 * @param p
	 * @param joueur
	 * @param niveauMax
	 * @param profondeur
	 * @return
	 */
	public int valeurMinMaxLimite(Plateau p, byte joueur, boolean niveauMax, int profondeur){
		//System.out.println("E1 - Joueur "+joueur+" - Profondeur : "+profondeur);
		byte joueurVictoir = p.victoire();
		byte joueurNext;
		int i;
		
		if (joueurVictoir == joueur)
			return Integer.MAX_VALUE;
		else if((joueurVictoir != joueur)&&(joueurVictoir != 0))
			return Integer.MIN_VALUE;
		else
			if (p.plateauPlein())
				return 0;
			else{	
				if (profondeur == 0)//<== profondeur
					return 0;
				
				if (joueur == 1)
					joueurNext = 2;
				else
					joueurNext = 1;
				
				ArrayList<Integer> listeValeur=new ArrayList<Integer>();
				ListeCoupPossible lcp = new ListeCoupPossible(p,joueurNext);
				
				for (i = 0 ; i < lcp.size(); i++){
					listeValeur.add(valeurMinMaxLimite(lcp.get(i),joueurNext,!niveauMax,profondeur-1));
				}
				
				/*System.out.println("E2 - Joueur "+joueurNext);
				for (i = 0 ; i < lcp.size(); i++){
					System.out.print(listeValeur.get(i)+" - "+i+" | ");
				}*/

				
				
				if(niveauMax){ //retour du minimum
					int min = Integer.MAX_VALUE;
					for(i = 0 ; i < listeValeur.size() ; i++)
						if (listeValeur.get(i) < min)
							min = listeValeur.get(i);
					return min * -1;
				}
				else{ //retour du maximum 
					int max = Integer.MIN_VALUE;
					for(i = 0 ; i < listeValeur.size() ; i++)
						if (listeValeur.get(i) > max)
							max = listeValeur.get(i);
					return -max;
				}
			}
		/*else{
			System.out.println("je vais perdre");
			return Integer.MIN_VALUE;
		}*/
		//return 1;
	}
	
	/**
	 * La fonction valeau min-max limit� a une profondeur
	 * @param p
	 * @param joueur
	 * @param niveauMax
	 * @param profondeur
	 * @return
	 */
	/*public int valeurMinMaxLimite(Plateau p, byte joueur, boolean niveauMax, int profondeur){
		System.out.println("E1 - Joueur "+joueur+" ");
		byte joueurVictoir = p.victoire();
		byte joueurNext;
		int i;
		
		if (joueurVictoir == joueur)
			return Integer.MAX_VALUE;
		else if((joueurVictoir != joueur)&&(joueurVictoir != 0)){
			return Integer.MIN_VALUE;
		}
		else if(joueurVictoir == 0)
			if (p.plateauPlein())
				return 0;
			else{	
				if (joueur == 1)
					joueurNext = 2;
				else
					joueurNext = 1;
				ArrayList<Integer> listeValeur=new ArrayList<Integer>();
				ListeCoupPossible lcp = new ListeCoupPossible(p,joueurNext);
				if (profondeur == 0)//<== profondeur
					return 0;
				for (i = 0 ; i < lcp.size(); i++){
					listeValeur.add(valeurMinMaxLimite(lcp.get(i),joueurNext,!niveauMax,profondeur-1));
				}
				if(niveauMax){ //retour du minimum
					int min = Integer.MAX_VALUE;
					for(i = 0 ; i < listeValeur.size() ; i++)
						if (listeValeur.get(i) < min)
							min = listeValeur.get(i);
					System.out.print(listeValeur);
					return min;
				}
				else{ //retour du maximum 
					int max = Integer.MIN_VALUE;
					for(i = 0 ; i < listeValeur.size() ; i++)
						if (listeValeur.get(i) > max)
							max = listeValeur.get(i);
					return max;
				}
			}
		else{
			System.out.println("je vais perdre");
			return Integer.MIN_VALUE;
		}
	}*/
	
}

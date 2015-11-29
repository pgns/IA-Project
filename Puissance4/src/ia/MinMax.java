package ia;
import java.lang.reflect.Array;
import java.util.ArrayList;

import puissance4.Plateau;
import utils.Coordonnees;

// == tout les commentaires ont été déplacé dans MinMax.save

public class MinMax {
	
	ListeCoupPossible listeCoupPossible;
	int profondeurArbre = 4;
	
	
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
		for (int i=0 ; i < this.listeCoupPossible.size(); i++){
			valeur = valeurMinMaxLimite(this.listeCoupPossible.get(i),joueur,false,profondeurArbre,joueur);
			
			//System.out.println("i:"+i+" Val : "+valeur);
			if (valeur > valeur_max){
				valeur_max = valeur;
				indice_max = i;
			}
		}
		return this.listeCoupPossible.get(indice_max);
	}
	
	
	
	/**
	 * La fonction valeau min-max limitï¿½ a une profondeur
	 * @param p
	 * @param joueur
	 * @param niveauMax
	 * @param profondeur
	 * @return
	 */
	public int valeurMinMaxLimite(Plateau p, byte joueur, boolean niveauMax, int profondeur, byte player){
		byte joueurVictoir = p.victoire();
		byte joueurNext;
		int i;
		
		if (joueurVictoir == joueur)
			return Integer.MAX_VALUE - (profondeurArbre - profondeur);
		else if((joueurVictoir != joueur)&&(joueurVictoir != 0))
			return Integer.MIN_VALUE + (profondeurArbre - profondeur);
		else
			if (p.plateauPlein())
				return 0;
			else{	
				if (profondeur == 0)//<== profondeur
					if(joueur == player)
						return p.evalHeuristique(player);
					else
						return -p.evalHeuristique(player);
				if (joueur == 1)
					joueurNext = 2;
				else
					joueurNext = 1;
				
				ArrayList<Integer> listeValeur=new ArrayList<Integer>();
				ListeCoupPossible lcp = new ListeCoupPossible(p,joueurNext);
				
				for (i = 0 ; i < lcp.size(); i++){
					listeValeur.add(valeurMinMaxLimite(lcp.get(i),joueurNext,!niveauMax,profondeur-1, player));
				}				
				
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
					return max * -1;
				}
			}
	}
	
}

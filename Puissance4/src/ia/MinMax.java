package ia;

import java.util.ArrayList;

import puissance4.Plateau;

// == tout les commentaires ont �t� d�plac� dans MinMax.save

public class MinMax {
	
	ListeCoupPossible listeCoupPossible;
	int profondeurArbre;
	
	
	public MinMax(){
	}
	
	/**
	 * La fonction min-max
	 * @param joueur joueur
	 * @param plateau plateau
	 * @return le plateau qui a la meilleur proba de gagner
	 */
	
	public Plateau minMax(byte joueur, Plateau plateau){
		this.profondeurArbre = 4;
		this.listeCoupPossible = new ListeCoupPossible(plateau,joueur);
		//System.out.println("hello");
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
	 * La fonction valeau min-max limit� a une profondeur
	 * @param p plateau
	 * @param joueur joueur
	 * @param niveauMax niveauMax
	 * @param profondeur profondeur
	 * @param player le player
	 * @return renvoie la valeur minmax
	 */
	public int valeurMinMaxLimite(Plateau p, byte joueur, boolean niveauMax, int profondeur, byte player){
		byte joueurVictoir = p.victoire();
		byte joueurNext;
		int note;
		int i;
		
		if (joueurVictoir == player){
			return Integer.MAX_VALUE - (profondeurArbre - profondeur);}
		//else if((joueurVictoir != joueur)&&(joueurVictoir != 0)){
		else if(joueurVictoir != 0){
			return Integer.MIN_VALUE + (profondeurArbre - profondeur);}
		else
			if (p.plateauPlein())
				return 0;
			else{	
				if (profondeur == 0){//<== profondeur
					note = p.evalHeuristique(joueur);
					if(joueur != player)
						note = note*-1;
					return note;
				}
				if (joueur == 1)
					joueurNext = 2;
				else
					joueurNext = 1;
				
				ArrayList<Integer> listeValeur=new ArrayList<Integer>();
				ListeCoupPossible lcp = new ListeCoupPossible(p,joueurNext);
				
				for (i = 0 ; i < lcp.size(); i++){
					listeValeur.add(valeurMinMaxLimite(lcp.get(i),joueurNext,!niveauMax,profondeur-1, player));
				}				
				
				if(!niveauMax){ //retour du minimum
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
	}
	
	public Plateau minMax(byte joueur, Plateau plateau,int prof){
		this.profondeurArbre = prof;
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
	
	
}

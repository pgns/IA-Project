package ia;

import puissance4.Plateau;

public class AlphaBeta {
	ListeCoupPossible listeCoupPossible;
	
	int profondeurArbre =7;
	public AlphaBeta(){
		
	}
	
	public Plateau alphaBeta(byte joueur, Plateau plateau){
		//System.out.println("Debut de l'algo ALPHA-BETA");
		this.listeCoupPossible = new ListeCoupPossible(plateau,joueur);
		int indice_max=0;
		int valeur;
		
		int alpha = Integer.MIN_VALUE;;
		int beta = Integer.MAX_VALUE;;
		
		// *<== ici on concidere que l'on entre sur le premier noeud max
		// chaqu'un des fils seront donc des noeud min => false
		for (int i=0 ; i < this.listeCoupPossible.size(); i++){
			valeur = ValeurAlphaBeta(this.listeCoupPossible.get(i),joueur,false,profondeurArbre,alpha,beta,joueur);
			if(valeur > alpha){			//On est sur un noeud MAX
				alpha = valeur;			// MAJ de Alpha
				indice_max = i;			// on enregistre l'indice
			}
		}
		return this.listeCoupPossible.get(indice_max);	
	}
	
	public int ValeurAlphaBeta(Plateau p, byte joueur, boolean niveauMax, int profondeur, int alpha, int beta,byte player){
	
		byte joueurVictoir = p.victoire();
		byte joueurNext;
		int i;
		int val;
		// test si p est une feuille
		if (joueurVictoir == joueur)
			if(!niveauMax)
				return Integer.MAX_VALUE - (profondeurArbre - profondeur);
			else
				return Integer.MIN_VALUE + (profondeurArbre - profondeur);
		else
			if (p.plateauPlein())
				return 0;
			else{	
				if (profondeur == 0)
					return p.eval(player);
				
				if (joueur == 1)
					joueurNext = 2;
				else
					joueurNext = 1;
				// a partir d'ici, on concidere que l'on est pas dans une feuille.
				// on creer une liste de coup possible, mais on ne la parourt pas forcément (alphabeta) 
				// ps : y'a peut etre moyen de simplifier coup possible
				// ---------------------------------------------------------
				//						ALPHA-BETA
				//
				ListeCoupPossible lcp = new ListeCoupPossible(p,joueurNext);
				if(niveauMax){ //On est sur un noeud MAX, on retourne le MAXIMUM
					//on parcourt la liste des coups possibles
					for (i = 0 ; i < lcp.size(); i++){
						val = ValeurAlphaBeta(lcp.get(i),joueurNext,!niveauMax,profondeur-1,alpha,beta,player);
						if(beta <= val)
							return val;			// coupure beta
						if(val > alpha)
							alpha = val;		// maj de alpha (qui contient la valeur MAX)
					}
					return alpha;
					
				}else{//On est sur un noeud MIN, on retourne le MINIMUM
					for (i = 0 ; i < lcp.size(); i++){
						val = ValeurAlphaBeta(lcp.get(i),joueurNext,!niveauMax,profondeur-1,alpha,beta,player);
						if(alpha >= val)
							return val;			// on est sur une coupure alpha
						if(val <= beta)
							beta = val;			// pas de coupure alpha, on met à jour Beta pour les prochains fils	(qui contient la valeur MIN)		
					}
					return beta;
				}
			}
				//----------------------- FIN ---------------------------
	}	
}

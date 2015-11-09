package ia;

import java.util.ArrayList;
import java.util.Random;

import puissance4.Plateau;

public class BestFirst {
	ListeCoupPossible listeCoupPossible;
	
	/* retourne le coup possible rapprochant le plus de la victoire */
	/* parcourt en largeur */
	public Plateau BestFirst(byte joueur, Plateau plateau){
		this.listeCoupPossible = new ListeCoupPossible(plateau,joueur);
		int profondeur = 2;
		System.out.println("1");
		for (int j=0 ; j<=profondeur; j++){
			for (int i=0 ; i<this.listeCoupPossible.size(); i++){
				if(BestFirstAlgo(this.listeCoupPossible.get(i), j, joueur))
					return this.listeCoupPossible.get(i);
			}
		}
		System.out.println("4");
		Random r = new Random();
		return this.listeCoupPossible.get(r.nextInt(6));
	}
	/* Retourne le joueur suivant */
	public byte joueurSuivant(byte joueur){
		if(joueur == 1)
			return 2;
		else
			return 1;
	}
	
	public boolean BestFirstAlgo(Plateau plateau, int profondeur, byte joueur){
		ListeCoupPossible listeCoupPossibleEnnemie;
		ListeCoupPossible listeCoupPossibleIA;
		System.out.println("3");
		if(profondeur == 0){
			if(plateau.victoire() == joueur)
				return true;
			else
				return false;
		}
		else{
			System.out.println("2");
			profondeur--;
			//l'ennemie joue, puis à nous
			listeCoupPossibleEnnemie = new ListeCoupPossible(plateau,joueurSuivant(joueur));
			for(int i=0; listeCoupPossibleEnnemie.size()>i; i++){
				listeCoupPossibleIA = new ListeCoupPossible(listeCoupPossibleEnnemie.get(i),joueur);
				if(BestFirstAlgo(listeCoupPossibleIA.get(i),profondeur,joueur))
					return true;
			}
		}
		return false;
	}
	
}

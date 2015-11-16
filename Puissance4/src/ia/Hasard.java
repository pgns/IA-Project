package ia;

import java.util.Random;

import puissance4.Plateau;

/**
 * L'IA prend un coup au hasard dan sla liste des coups possibles
 * @author Barna
 *
 */
public class Hasard {

	Random rand;
	ListeCoupPossible listeCoupPossible;
	public Hasard(){
		rand = new Random();
	}
	
	public Plateau hasrad(byte joueur, Plateau plateau){
		this.listeCoupPossible = new ListeCoupPossible(plateau,joueur);
		int indice = rand.nextInt(this.listeCoupPossible.size());
		return this.listeCoupPossible.get(indice);
	}
}

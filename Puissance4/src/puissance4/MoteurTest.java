package puissance4;

import ia.MinMax;
import ia.Hasard;

import java.util.Scanner;

import ia.AlphaBeta;

/**
 * Classe permetant d'efectuer un nombre de test donn� pour les IA
 */
public class MoteurTest{

	/**
	 * Le jeu
	 */
	private Jeu jeu;

	/**
	 * IA minmax
	 */
	private MinMax iaMinMax;
	
	/**
	 * IA hasard
	 */
	private Hasard iaFacile;
	
	/**
	 * IA alphabeta
	 */
	private AlphaBeta iaAlphaBeta;
	
	/**
	 * Le temps total du joueur1
	 */
	public float tempsTotalJoueur1;
	
	/**
	 * Le temps total du joueur 2
	 */
	public float tempsTotalJoueur2;
	
	/**
	 * Temps du joueur 1 pour une partie
	 */
	private float tempsJoueur1;
	
	/**
	 * Temps du joueur 2 pour une partie 
	 */
	private float tempsJoueur2;
	
	/**
	 * Le nombre total de coup du joueur1
	 */
	private int nbTotalCoupJoueur1;
	
	/**
	 * Nombre total de coup du joueur2
	 */
	private int nbTotalCoupJoueur2;
	
	/**
	 * Le type du joueur1
	 */
	private TypeJoueur joueur1;
	
	/**
	 * Le type du joueur2
	 */
	private TypeJoueur joueur2;
	
	/**
	 * Le nombre de fois qu'on test nos ia entre eux
	 */
	private int nbTest;
	
	/**
	 * Heuristique 1 joueur 1
	 */
	private boolean h1j1;
	
	/**
	 * Heuristique 2 joueur 1
	 */
	private boolean h2j1;
	
	/**
	 * Heuristique 3 joueur 1
	 */
	private boolean h3j1;
	
	/**
	 * Heuristique 1 joueur 
	 */
	private boolean h1j2;
	
	/**
	 * Heuristique 2 joueur 2
	 */
	private boolean h2j2;
	
	/**
	 * Heuristique 3 joueur 2
	 */
	private boolean h3j2;
	
	/**
	 * Le nombre de victoires du joueur 1
	 */
	private int nbVictoireJoueur1;
	
	/**
	 * Profondeur du joueur 1
	 */
	private int profondeur1;
	
	/**
	 * Profondeur du joueur 2
	 */
	private int profondeur2;
	/**
	 * Le nombre de Victoires du joueur 2
	 */
	private int nbVictoireJoueur2;
	
	/**
	 * Le nombre de parties null
	 */
	private int nbPartieNull;
	
	/**
	 * Initialise le moteur de test
	 */
	public MoteurTest(){
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez le nombre de test: ");
		do {
			nbTest = input.nextInt();
		} while (nbTest < 0 || nbTest > 1000000);
		System.out.println("Entrez le type du prmier IA :");
		int j1;
		do {
			System.out.println("(IA facile => 1 IA MinMax => 2 IA Alphabeta => 3)");
			j1 = input.nextInt();
		} while ( j1 < 1 || j1 > 3 );
		System.out.println("Entrez le type du deui�me IA :");
		int j2;
		do {
			System.out.println("(IA facile => 1 IA MinMax => 2 IA Alphabeta => 3)");
			j2 = input.nextInt();
		} while ( j2 < 1 || j2 > 3 );
		switch(j1){
			case 1: joueur1 = TypeJoueur.IA_FACILE;
			break;
			case 2: joueur1 = TypeJoueur.IA_MOYEN;
			break;
			default: joueur1 = TypeJoueur.IA_EXTREME;
		}
		switch(j2){
			case 1: joueur2 = TypeJoueur.IA_FACILE;
			break;
			case 2: joueur2 = TypeJoueur.IA_MOYEN;
			break;
			default: joueur2 = TypeJoueur.IA_EXTREME;
		}
		String c;
		if (j1 == 2 || j1 == 3){
			System.out.println("Choix des heuristiques pour le joueur 1: ");
			System.out.println("Heuristique1 (Y/N):");
			do {
				c = input.nextLine();
			} while (!c.contentEquals("Y") && !c.contentEquals("N"));
			if (c.contentEquals("Y"))
				h1j1 = true;
			else
				h1j1 = false;
			System.out.println("Heuristique2: ");
			do {
				c = input.nextLine();
			} while (!c.contentEquals("Y") && !c.contentEquals("N"));
			if (c.contentEquals("Y"))
				h2j1 = true;
			else
				h2j1 = false;
			System.out.println("Heuristique3: ");
			do {
				c = input.nextLine();
			} while (!c.contentEquals("Y") && !c.contentEquals("N"));
			if (c.contentEquals("Y"))
				h3j1 = true;
			else
				h3j1 = false;
			System.out.println("Entrez la profondeur du joueur1: ");
			do {
				profondeur1 = input.nextInt();
			} while (profondeur1 < 0 || profondeur1 > 1000000);
		}
		if (j2 == 2 || j2 == 3){
			System.out.println("Choix des heuristiques pour le joueur 2: ");
			System.out.println("Heuristique1 (Y/N):");
			do {
				c = input.nextLine();
			} while (!c.contentEquals("Y") && !c.contentEquals("N"));
			if (c.contentEquals("Y"))
				h1j2 = true;
			else
				h1j2 = false;
			System.out.println("Heuristique2: ");
			do {
				c = input.nextLine();
			} while (!c.contentEquals("Y") && !c.contentEquals("N"));
			if (c.contentEquals("Y"))
				h2j2 = true;
			else
				h2j2 = false;
			System.out.println("Heuristique3: ");
			do {
				c = input.nextLine();
			} while (!c.contentEquals("Y") && !c.contentEquals("N"));
			if (c.contentEquals("Y"))
				h3j2 = true;
			else
				h3j2 = false;
			System.out.println("Entrez la profondeur du joueur2: ");
			do {
				profondeur2 = input.nextInt();
			} while (profondeur2 < 0 || profondeur2 > 1000000);
		}
		this.iaFacile = new Hasard();
		this.iaMinMax = new MinMax();
		this.iaAlphaBeta = new AlphaBeta();
		this.tempsTotalJoueur1 = 0F;
		this.tempsTotalJoueur2 = 0F;
		this.nbTotalCoupJoueur1 = 0;
		this.nbTotalCoupJoueur2 = 0;
		this.nbVictoireJoueur1 = 0;
		this.nbVictoireJoueur2 = 0;
		this.nbPartieNull = 0;
		input.close();
		//on lance les tests
		lancerLesTests();
	}
	
	/**
	 * Si c'estle tour de l'ordi on fait jouer l'ordi
	 */
	public void lancerLesTests(){
		this.jeu = new Jeu(joueur1,joueur2);
		for(int i = 0; i < nbTest ; i++){
			this.tempsJoueur1 = 0F;
			this.tempsJoueur2 = 0F;
			this.jeu.nouvellePartie(joueur1, joueur2, h1j1, h2j1, h3j1, h1j2, h2j2, h3j2);
			System.out.println("==============================");
			System.out.println("Lancement du test numero "+ (i+1));
			lancerPartie();
			switch (this.jeu.getPlateau().victoire()){
				case 1: //System.out.println("Victoire du joueur 1");
						this.nbVictoireJoueur1++;
						break;
				case 2: //System.out.println("Victoire du joueur 2");
						this.nbVictoireJoueur2++;
						break;
				default: System.out.println("Partie null");
						this.nbPartieNull++;
			}
			this.tempsTotalJoueur1 += this.tempsJoueur1;
			this.tempsTotalJoueur2 += this.tempsJoueur2;
			System.out.println("Temps Joueur 1: "+ this.tempsJoueur1);
			System.out.println("Temps Joueur 2: "+ this.tempsJoueur2);
		}
		System.out.println("==============================");
		System.out.println("Temps total joueur 1: "+this.tempsTotalJoueur1+" sur "+this.nbTotalCoupJoueur1+" coups");
		System.out.println("Moyenne des coups du joueur1: " + this.tempsTotalJoueur1/this.nbTotalCoupJoueur1);
		System.out.println("Temps total joueur 2: "+this.tempsTotalJoueur2+" sur "+this.nbTotalCoupJoueur2+" coups");
		System.out.println("Moyenne des coups du joueur2: " + this.tempsTotalJoueur2/this.nbTotalCoupJoueur2);
		System.out.println("Nombre de victoire du Joueur 1: "+this.nbVictoireJoueur1);
		System.out.println("Nombre de victoire du Joueur 2: "+this.nbVictoireJoueur2);
		System.out.println("Nombre de parties null: "+this.nbPartieNull);
	}
	
	/**
	 * Lance la partie
	 */
	public void lancerPartie(){
		long start;
		float temps;
		//on commence par le joueur 1
		this.jeu.changerLaMain();
		// tant que la partie n'est pas finie
		while (! this.jeu.partieFini() && ! this.jeu.getPlateau().plateauPlein()) {
			// si c'est le tour du joueur 1 on regarde quel IA faire jouer
			this.jeu.changerLaMain();
			if (this.jeu.tourJoueur() == 1){
				start = System.currentTimeMillis();
				if (this.jeu.typeJoueur1() == TypeJoueur.IA_FACILE){
					jeu.plateau = iaFacile.hasrad(jeu.tourJoueur(), jeu.getPlateau());
				}
				if (this.jeu.typeJoueur1() == TypeJoueur.IA_MOYEN){
					jeu.plateau = iaMinMax.minMax(jeu.tourJoueur(), jeu.getPlateau(),profondeur1);
				}
				if (this.jeu.typeJoueur1() == TypeJoueur.IA_EXTREME){
					jeu.plateau = iaAlphaBeta.alphaBeta(jeu.tourJoueur(), jeu.getPlateau(),profondeur1);
				}
				temps = (System.currentTimeMillis() - start) / 1000F;
				this.tempsJoueur1 += temps;
				this.nbTotalCoupJoueur1++;
				System.out.println("Joueur1 : "+temps +"secondes");
			}
			// si c'est le tour du joueur 2 on regarde quel IA faire jouer
			if (this.jeu.tourJoueur() == 2){
				start = System.currentTimeMillis();
				if (this.jeu.typeJoueur2() == TypeJoueur.IA_FACILE){
					jeu.plateau = iaFacile.hasrad(jeu.tourJoueur(), jeu.getPlateau());
				}
				if (this.jeu.typeJoueur2() == TypeJoueur.IA_MOYEN){
					jeu.plateau = iaMinMax.minMax(jeu.tourJoueur(), jeu.getPlateau(),profondeur2);
				}
				if (this.jeu.typeJoueur2() == TypeJoueur.IA_EXTREME){
					jeu.plateau = iaAlphaBeta.alphaBeta(jeu.tourJoueur(), jeu.getPlateau(),profondeur2);
				}
				temps = (System.currentTimeMillis() - start) / 1000F;
				this.tempsJoueur2 += temps;
				this.nbTotalCoupJoueur2++;
				System.out.println("Joueur2 : "+temps +"secondes");
			}
		}
		// on sort du while: la partie est finie, il y a une victoire ou le plateau est plein
	}
}

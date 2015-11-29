package puissance4;

import java.util.Scanner;

import ia.AlphaBeta;
import ia.Hasard;
import ia.MinMax;

public class MoteurTestProfondeur {
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
	private float tempsPrecedent;
	
	/**
	 * Temps du joueur 1 pour une partie
	 */
	private float tempsJoueur1;
	
	/**
	 * Nombre de coup du joueur1
	 */
	private int nbCoupJoueur1;
	
	/**
	 * Le type du joueur1
	 */
	private TypeJoueur joueur1;
	
	/**
	 * Le type du joueur2
	 */
	private TypeJoueur joueur2;
	
	/**
	 * La profondeur à tester
	 */
	private int testProfondeur;
	
	/**
	 * Heuristique 1
	 */
	private boolean h1j1;
	
	/**
	 * Heuristique 2
	 */
	private boolean h2j1;
	
	/**
	 * heuristique 3
	 */
	private boolean h3j1;
	
	/**
	 * Initialise le moteur de test
	 */
	public MoteurTestProfondeur(){
		int j1;
		String c;
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez la profondeur jusqu'à laquel descendre: ");
		do {
			testProfondeur = input.nextInt();
		} while (testProfondeur < 0 || testProfondeur > 1000000);
		System.out.println("Entrez le type de l'IA :");
		do {
			System.out.println("(IA MinMax => 1 IA Alphabeta => 2)");
			j1 = input.nextInt();
		} while ( j1 < 1 || j1 > 3 );
		System.out.println("Listes des heuristiques pour le joueur 1, Entrez Y/N:\nHeuristique1: ");
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
		switch(j1){
			case 1: joueur1 = TypeJoueur.IA_MOYEN;
			break;
			default: joueur1 = TypeJoueur.IA_EXTREME;
		}	
		joueur2 = TypeJoueur.IA_FACILE;			
		this.iaFacile = new Hasard();
		this.iaMinMax = new MinMax();
		this.iaAlphaBeta = new AlphaBeta();
		//on lance les tests
		lancerLesTests();
	}
	
	/**
	 * On lance les test
	 */
	public void lancerLesTests(){
		this.jeu = new Jeu(joueur1,joueur2);
		this.tempsPrecedent = 0;
		for(int i = 1; i <= testProfondeur ; i++){
			this.tempsJoueur1 = 0F;
			this.nbCoupJoueur1 = 0;
			this.jeu.nouvellePartie(joueur1,joueur2,h1j1,h2j1,h3j1,false,false,false);
			System.out.println("==============================");
			System.out.println("Lancement du test de profondeur "+ i);
			lancerPartie(i);
			System.out.println("Temps moyen de l'IA avec une profondeur "+i+" : "+ tempsJoueur1/this.nbCoupJoueur1);
			System.out.println((this.tempsJoueur1/this.nbCoupJoueur1-this.tempsPrecedent) + " secondes de plus que la profondeur d'avant");
			this.tempsPrecedent = this.tempsJoueur1/this.nbCoupJoueur1;
		
			System.out.println("Temps Joueur : "+ this.tempsJoueur1);
		}
	}
	
	/**
	 * Lance la partie
	 */
	public void lancerPartie(int profondeur){
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
				if (this.jeu.typeJoueur1() == TypeJoueur.IA_MOYEN){
					jeu.plateau = iaMinMax.minMax(jeu.tourJoueur(), jeu.getPlateau(),profondeur);
				}
				if (this.jeu.typeJoueur1() == TypeJoueur.IA_EXTREME){
					jeu.plateau = iaAlphaBeta.alphaBeta(jeu.tourJoueur(), jeu.getPlateau(),profondeur);
				}
				temps = (System.currentTimeMillis() - start) / 1000F;
				this.tempsJoueur1 += temps;
				this.nbCoupJoueur1++;
				System.out.println("Joueur1 : "+temps +"secondes");
			}
			// si c'est le tour du joueur 2 on regarde quel IA faire jouer
			if (this.jeu.tourJoueur() == 2){
					jeu.plateau = iaFacile.hasrad(jeu.tourJoueur(), jeu.getPlateau());
			}
		}
		// on sort du while: la partie est finie, il y a une victoire ou le plateau est plein
	}
	
}

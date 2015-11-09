package puissance4;

import ia.MinMax;
import ihm.jeu.FenetreJeu;

/**
 * 
 * @author Barna
 *
 */
public class MoteurJeu {

	/**
	 * Le jeu
	 */
	private Jeu jeu;
	
	/**
	 * La fenetre de jeu
	 */
	private FenetreJeu fenetreJeu;
	
	/**
	 * Le Verrou
	 */
	private boolean verrou;
	
	/**
	 * Le Verrou fin de partie
	 */
	private boolean verrouFinPartie;

	private MinMax test;
	
	
	/**
	 * Initialise le moteur
	 * @param j le jeu
	 * @param fj La fenetre de jeu
	 */

	public MoteurJeu(Jeu j, FenetreJeu fj){
		this.fenetreJeu = fj;
		this.jeu = j;
		this.setVerrou(false);
		this.setVerrouFinPartie(false);
		test = new MinMax();
	}
	
	/**
	 * Si c'estle tour de l'ordi on fait jouer l'ordi
	 * C'est beug� pour l'instant:)
	 */
	public void jouer(){
		System.out.println(this.jeu.typeJoueur1().toString());
		System.out.println(this.jeu.typeJoueur2().toString());
		if (this.jeu.typeJoueur1() == TypeJoueur.IA_FACILE)
			System.out.println("Baboum");
		if (this.jeu.tourJoueur() == 1 && TypeJoueur.estOrdi(this.jeu.typeJoueur1())){
			this.setVerrou(true);
			// ordi joue
			test.minMax(jeu.tourJoueur(),jeu.getPlateau());
			System.out.println("Entre dans 1");

			jeu.changerLaMain();
			this.setVerrou(false);
			if(jeu.getPlateau().plateauPlein() || jeu.getPlateau().victoire() != 0)
				this.verrouFinPartie = true;
		}
		else if(this.jeu.tourJoueur() == 2){// && TypeJoueur.estOrdi(this.jeu.typeJoueur2())){
			this.setVerrou(true);
			// ordi joue
			jeu.plateau = test.minMax(jeu.tourJoueur(),jeu.getPlateau());
			
			jeu.changerLaMain();
			this.setVerrou(false);
			if(jeu.getPlateau().plateauPlein() || jeu.getPlateau().victoire() != 0)
				this.verrouFinPartie = true;
		}
			
	}

	/**
	 * Renvoie le jeu
	 * @return le jeu
	 */
	public Jeu getJeu(){
		return this.jeu;
	}
	
	/**
	 * Retourne le v�rrou
	 * @return vrai si on a un v�rrou
	 */
	public boolean isVerrou() {
		return verrou;
	}

	/**
	 * Le setteur du v�rrou
	 * @param verrou 
	 */
	public void setVerrou(boolean verrou) {
		this.verrou = verrou;
	}

	/**
	 * Renvoie vrai si fin de partie
	 * @return vrai si fin de partie
	 */
	public boolean isVerrouFinPartie() {
		return verrouFinPartie;
	}

	/**
	 * Le setteur de fin de partie
	 * @param verrouFinPartie mettre vrai pour v�rouiller en fin de partie
	 */
	public void setVerrouFinPartie(boolean verrouFinPartie) {
		this.verrouFinPartie = verrouFinPartie;
	}
	
	
}

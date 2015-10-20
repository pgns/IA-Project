package puissance4;

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
	}

	/**
	 * Renvoie le jeu
	 * @return le jeu
	 */
	public Jeu getJeu(){
		return this.jeu;
	}
	
	/**
	 * Retourne le vérrou
	 * @return vrai si on a un vérrou
	 */
	public boolean isVerrou() {
		return verrou;
	}

	/**
	 * Le setteur du vérrou
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
	 * @param verrouFinPartie mettre vrai pour vérouiller en fin de partie
	 */
	public void setVerrouFinPartie(boolean verrouFinPartie) {
		this.verrouFinPartie = verrouFinPartie;
	}
	
	
}

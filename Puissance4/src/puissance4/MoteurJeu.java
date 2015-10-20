package puissance4;

import ihm.jeu.FenetreJeu;

public class MoteurJeu {
	private Jeu jeu;
	private FenetreJeu fenetreJeu;
	/**
	 * Le Verrou
	 */
	private boolean verrou;
	/**
	 * Le Verrou fin de partie
	 */
	private boolean verrouFinPartie;
	
	public MoteurJeu(Jeu j, FenetreJeu fj){
		this.fenetreJeu = fj;
		this.jeu = j;
		this.setVerrou(false);
		this.setVerrouFinPartie(false);
	}

	public boolean isVerrou() {
		return verrou;
	}

	public void setVerrou(boolean verrou) {
		this.verrou = verrou;
	}

	public boolean isVerrouFinPartie() {
		return verrouFinPartie;
	}

	public void setVerrouFinPartie(boolean verrouFinPartie) {
		this.verrouFinPartie = verrouFinPartie;
	}
	
	
}

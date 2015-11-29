package puissance4;

import ia.MinMax;
import ia.Hasard;
import ihm.jeu.FenetreJeu;
import ia.AlphaBeta;

/**
 * Classe du moteur du jeu
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
	 * Temps Joueur1
	 */
	public float tempsJoueur1;
	
	/**
	 * Temps Joueur2
	 */
	public float tempsJoueur2;
	
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
		this.iaFacile = new Hasard();
		this.iaMinMax = new MinMax();
		this.iaAlphaBeta = new AlphaBeta();
		this.tempsJoueur1 = 0F;
		this.tempsJoueur2 = 0F;
	}
	
	/**
	 * Si c'estle tour de l'ordi on fait jouer l'ordi
	 */
	public void jouer(){
		if (this.jeu.tourJoueur() == 1 && TypeJoueur.estOrdi(this.jeu.typeJoueur1())){
			// on place le vï¿½rrou
			this.setVerrou(true);
			// On regarde quel IA faire jouer
			long start = System.currentTimeMillis();
			if (this.jeu.typeJoueur1() == TypeJoueur.IA_FACILE){
				jeu.plateau = iaFacile.hasrad(jeu.tourJoueur(), jeu.getPlateau());
			}
			if (this.jeu.typeJoueur1() == TypeJoueur.IA_MOYEN){
				jeu.plateau = iaMinMax.minMax(jeu.tourJoueur(), jeu.getPlateau());
			}
			if (this.jeu.typeJoueur1() == TypeJoueur.IA_EXTREME){
				jeu.plateau = iaAlphaBeta.alphaBeta(jeu.tourJoueur(), jeu.getPlateau());
			}
			jeu.changerLaMain();
			float temps = (System.currentTimeMillis() - start) / 1000F;
			this.tempsJoueur1 += temps;
			this.fenetreJeu.aTemps.append("Joueur 1: "+ String.valueOf(temps)+"\n");
			this.setVerrou(false);
			if((jeu.getPlateau().plateauPlein() || jeu.getPlateau().victoire() != 0) && !this.verrouFinPartie){
				this.verrouFinPartie = true;
				if (this.tempsJoueur1 > 0)
					this.fenetreJeu.aTemps.append("Temps total j1:"+ String.valueOf(this.tempsJoueur1)+"\n");
				if (this.tempsJoueur2 > 0)
					this.fenetreJeu.aTemps.append("Temps total j2:"+ String.valueOf(this.tempsJoueur2));
			}
			else
				this.jouer();
		}
		else if(this.jeu.tourJoueur() == 2 && TypeJoueur.estOrdi(this.jeu.typeJoueur2())){
			this.setVerrou(true);
			// On regarde quel IA faire jouer
			long start = System.currentTimeMillis();
			if (this.jeu.typeJoueur2() == TypeJoueur.IA_FACILE){
				jeu.plateau = iaFacile.hasrad(jeu.tourJoueur(), jeu.getPlateau());
			}
			if (this.jeu.typeJoueur2() == TypeJoueur.IA_MOYEN){
				jeu.plateau = iaMinMax.minMax(jeu.tourJoueur(), jeu.getPlateau());
			}
			if (this.jeu.typeJoueur1() == TypeJoueur.IA_EXTREME){
				jeu.plateau = iaAlphaBeta.alphaBeta(jeu.tourJoueur(), jeu.getPlateau());
			}
			jeu.changerLaMain();
			float temps = (System.currentTimeMillis() - start) / 1000F;
			this.fenetreJeu.aTemps.append("Joueur 2: "+ String.valueOf(temps)+"\n");
			this.tempsJoueur2 += temps;
			this.setVerrou(false);
			if(jeu.getPlateau().plateauPlein() || jeu.getPlateau().victoire() != 0){
				this.verrouFinPartie = true;
				if (this.tempsJoueur1 > 0)
					this.fenetreJeu.aTemps.append("Temps total j1:"+ String.valueOf(this.tempsJoueur1)+"\n");
				if (this.tempsJoueur2 > 0)
					this.fenetreJeu.aTemps.append("Temps total j2:"+ String.valueOf(this.tempsJoueur2));
			}
			else
				this.jouer();
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
	 * Retourne le vï¿½rrou
	 * @return vrai si on a un vï¿½rrou
	 */
	public boolean isVerrou() {
		return verrou;
	}

	/**
	 * Le setteur du vérrou
	 * @param verrou valeur du vérou
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
	 * @param verrouFinPartie mettre vrai pour vï¿½rouiller en fin de partie
	 */
	public void setVerrouFinPartie(boolean verrouFinPartie) {
		this.verrouFinPartie = verrouFinPartie;
	}
	
	
}

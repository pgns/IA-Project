package ihm.jeu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import ia.MinMax;
import puissance4.MoteurJeu;
import utils.Constantes;
import utils.Coordonnees;

public class EcouteurSourisJeu implements MouseListener, MouseMotionListener{

	/**
	 * Le plateau de jeu
	 */
	AirePlateau airePlateau;
	/**
	 * Le moteur du jeu
	 */
	MoteurJeu moteurJeu;
	
	FenetreJeu fJeu;

	/**
	 * Initialise l'écouteur
	 * @param airePlateau le Plateau de jeu
	 * @param moteurJeu le moteur du jeu
	 */
	EcouteurSourisJeu(AirePlateau airePlateau,MoteurJeu moteurJeu, FenetreJeu fj){
		this.airePlateau = airePlateau;
		this.moteurJeu = moteurJeu;
		this.fJeu = fj;
	}
	
	public void mouseClicked(MouseEvent me) {
		// si ce n'est pas la fin de la partie
		if (! this.moteurJeu.isVerrouFinPartie() && !this.moteurJeu.isVerrou()){
			// on calculle les cordonnées du tableau
			Coordonnees cord = this.airePlateau.coordonneesClic(me.getX(), me.getY());
			// on regarde si les cordonnées sont corects
			if (cord.getColonne() < Constantes.NOMBRE_COLONNE_JEUX && cord.getLigne() < Constantes.NOMBRE_LIGNE_JEUX) {		
				//c'est ok on a cliqué sur une case
				if (this.airePlateau.getJeu().getPlateau().ajoutPossible(cord.getLigne(), cord.getColonne())){
					// si l'ajout du pion est possible, on effectue le déplacement
					this.airePlateau.getJeu().getPlateau().ajoutePion(this.moteurJeu.getJeu().tourJoueur(),cord.getColonne());
					this.moteurJeu.getJeu().changerLaMain();
				//	MinMax test = new MinMax();
				//	test.minMax(this.moteurJeu.getJeu().tourJoueur(),this.airePlateau.getJeu().getPlateau());
				//	this.airePlateau.getJeu().getPlateau().AffichePlateau();
					if (this.airePlateau.getJeu().getPlateau().victoire() != 0 || this.airePlateau.getJeu().getPlateau().plateauPlein() ){
					// Mettre le verrou fin de partie
						if (this.moteurJeu.tempsJoueur1 > 0)
							this.fJeu.aTemps.append("Temps total j1:"+ String.valueOf(this.moteurJeu.tempsJoueur1)+"\n");
						if (this.moteurJeu.tempsJoueur2 > 0)
							this.fJeu.aTemps.append("Temps total j2:"+ String.valueOf(this.moteurJeu.tempsJoueur2));
						this.moteurJeu.setVerrouFinPartie(true);
					}
					this.airePlateau.repaint();
					this.moteurJeu.jouer();
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}

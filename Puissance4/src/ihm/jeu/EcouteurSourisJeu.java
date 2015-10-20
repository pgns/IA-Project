package ihm.jeu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

	/**
	 * Initialise l'écouteur
	 * @param airePlateau le Plateau de jeu
	 * @param moteurJeu le moteur du jeu
	 */
	EcouteurSourisJeu(AirePlateau airePlateau,MoteurJeu moteurJeu){
		this.airePlateau = airePlateau;
		this.moteurJeu = moteurJeu;
	}
	
	public void mouseClicked(MouseEvent me) {
		// on calculle les cordonnées du tableau
		Coordonnees cord = this.airePlateau.coordonneesClic(me.getX(), me.getY());
		System.out.println(cord.getColonne() + "  " +cord.getLigne());
		// on regarde si les cordonnées sont corects
		if (cord.getColonne() < Constantes.NOMBRE_COLONNE_JEUX && cord.getLigne() < Constantes.NOMBRE_LIGNE_JEUX) {		
			//c'est ok on a cliqué sur une case
			if (this.airePlateau.getJeu().getPlateau().ajoutPossible(cord.getLigne(), cord.getColonne())){
				// on l'ajout du pion est possible, on effectue le déplacement
				this.airePlateau.getJeu().getPlateau().ajoutePion(this.moteurJeu.getJeu().tourJoueur(),cord.getColonne());
				this.moteurJeu.getJeu().changerLaMain();
				this.airePlateau.repaint();
				this.airePlateau.getJeu().getPlateau().AffichePlateau();
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

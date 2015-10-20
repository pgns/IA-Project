package ihm.jeu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import utils.Constantes;
import utils.Coordonnees;

public class EcouteurSourisJeu implements MouseListener, MouseMotionListener{

	AirePlateau airePlateau;
	//moteurjeu++
	
	EcouteurSourisJeu(AirePlateau airePlateau){
		this.airePlateau = airePlateau;
	}
	
	public void mouseClicked(MouseEvent me) {
		// on calculle les cordonn�es du tableau
		Coordonnees cord = this.airePlateau.coordonneesClic(me.getX(), me.getY());
		// on regarde si les cordonn�es sont corects
		if (cord.getColonne() < Constantes.NOMBRE_COLONNE_JEUX && cord.getLigne() < Constantes.NOMBRE_LIGNE_JEUX) {		
			//c'est ok on a cliqu� sur une case
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

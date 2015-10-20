package ihm.jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import utils.Constantes;
import utils.Coordonnees;

import javax.swing.JComponent;

import puissance4.Jeu;

@SuppressWarnings("serial")
public class AirePlateau extends JComponent{

	Jeu jeu;
	int largeurCase;
	int hauteurCase;
	
	AirePlateau(Jeu j){
		super();
		this.jeu=j;
	}
	
	synchronized public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		this.dessinerGrille(g2d);
		this.dessinerPions(g2d);
	}
	
	synchronized public void dessinerGrille(Graphics2D g2d){
		int i, j;
		this.largeurCase = this.getWidth()/Constantes.NOMBRE_COLONNE_JEUX;
		this.hauteurCase = this.getHeight()/Constantes.NOMBRE_LIGNE_JEUX;
		g2d.setColor(Color.BLACK);
		for (i = 0 ; i < Constantes.NOMBRE_LIGNE_JEUX ; i++)
			for (j = 0 ; j < Constantes.NOMBRE_COLONNE_JEUX; j++){
				g2d.drawRect(j*largeurCase,i*hauteurCase, largeurCase, hauteurCase);
			}
	}
	
	synchronized public void dessinerPions(Graphics2D g2d){
		int i,j;
		for (i = 0 ; i < Constantes.NOMBRE_LIGNE_JEUX ; i++){
			for (j = 0 ; j < Constantes.NOMBRE_COLONNE_JEUX; j++) {
				if (! jeu.getPlateau().estCaseVide(i, j)){
					if (jeu.getPlateau().estCaseJoueur1(i, j)) {
						g2d.setColor(Constantes.COULEUR_JOUEUR_1);
					}
					else {
						g2d.setColor(Constantes.COULEUR_JOUEUR_2);
					}
					g2d.fillOval(j*largeurCase,i*hauteurCase,largeurCase, hauteurCase);
				}
			}	
		}
	}
	
	public Coordonnees coordonneesClic(int clickX, int clickY){
		int x = clickX / largeurCase;
		int y = clickY / hauteurCase;
		return new Coordonnees(x,y);
	}
	
}

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
	
	/**
	 * Le jeu
	 */
	Jeu jeu;
	/**
	 * La largeur de la case
	 */
	int largeurCase;
	/**
	 * La hauteur de la case
	 */
	int hauteurCase;
	
	/**
	 * Initialise l'aire de jeu
	 * @param j Le jeu
	 */
	AirePlateau(Jeu j){
		super();
		this.jeu=j;
	}
	
	/**
	 * Paint component
	 */
	synchronized public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		this.dessinerGrille(g2d);
		this.dessinerPions(g2d);
	}
	
	/**
	 * Dessine la grille
	 * @param g2d 
	 */
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
	
	/**
	 * dessine les pions de couleur sur la grille
	 * @param g2d l'objet graphique
	 */
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
	
	/**
	 * Renvoie les cordonnées de la case cliqué
	 * @param clickX 
	 * @param clickY
	 * @return les cordonnées de la case cliqué
	 */
	public Coordonnees coordonneesClic(int clickX, int clickY){
		int x = clickX / largeurCase;
		int y = clickY / hauteurCase;
		return new Coordonnees(x,y);
	}
	
	/**
	 * Renvoie le jeu
	 * @return le jeu
	 */
	public Jeu getJeu(){
		return this.jeu;
	}
	
}

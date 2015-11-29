package ihm.jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import utils.Constantes;
import utils.Coordonnees;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import puissance4.Jeu;

@SuppressWarnings("serial")

/**
 * L'aire plateau graphique
 */
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
	 * Image joueur 1
	 */
	private Image imageJoueur1;
	
	/**
	 * Image joueur 2
	 */
	private Image imageJoueur2;
	
	/**
	 * Initialise l'aire de jeu
	 * @param j Le jeu
	 */
	AirePlateau(Jeu j){
		super();
		this.jeu=j;
		try{
			this.imageJoueur1 = ImageIO.read(Constantes.URL_IMAGE_JOUEUR_1);
			this.imageJoueur2 = ImageIO.read(Constantes.URL_IMAGE_JOUEUR_2);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	 * @param g2d  Graphics2D
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
		dessinerVictoire(g2d);
		for (i = 0 ; i < Constantes.NOMBRE_LIGNE_JEUX ; i++){
			for (j = 0 ; j < Constantes.NOMBRE_COLONNE_JEUX; j++) {
				if (! jeu.getPlateau().estCaseVide(i, j)){
					if (jeu.getPlateau().estCaseJoueur1(i, j)) {
						g2d.drawImage(imageJoueur1, j*largeurCase+2, i*hauteurCase+2, largeurCase-4, hauteurCase-4, this);
					}
					else {
						g2d.drawImage(imageJoueur2, j*largeurCase+2, i*hauteurCase+2, largeurCase-4, hauteurCase-4, this);
					}
				}
			}	
		}
	}
	
	/**
	 * colorie les cases victoires
	 * @param g2d Graphics2D
	 */
	synchronized public void dessinerVictoire(Graphics g2d){
		if (jeu.getPlateau().cordVictoire()){
			g2d.setColor(Color.ORANGE);
			g2d.fillRect(jeu.getPlateau().cord1Victoire.getColonne()*largeurCase+1, jeu.getPlateau().cord1Victoire.getLigne()*hauteurCase+1, largeurCase-2, hauteurCase-2);
			g2d.fillRect(jeu.getPlateau().cord2Victoire.getColonne()*largeurCase+1, jeu.getPlateau().cord2Victoire.getLigne()*hauteurCase+1, largeurCase-2, hauteurCase-2);
			g2d.fillRect(jeu.getPlateau().cord3Victoire.getColonne()*largeurCase+1, jeu.getPlateau().cord3Victoire.getLigne()*hauteurCase+1, largeurCase-2, hauteurCase-2);
			g2d.fillRect(jeu.getPlateau().cord4Victoire.getColonne()*largeurCase+1, jeu.getPlateau().cord4Victoire.getLigne()*hauteurCase+1, largeurCase-2, hauteurCase-2);
		}
	}
	
	/**
	 * Renvoie les cordonnées de la case cliqué
	 * @param clickX cordonnées x
	 * @param clickY cordonnées y
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

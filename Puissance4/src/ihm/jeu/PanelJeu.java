package ihm.jeu;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import puissance4.Jeu;

@SuppressWarnings("serial")
/**
 * Le panel de jeu
 */
public class PanelJeu extends JPanel{
	
	/**
	 * L'aire de jeu
	 */
	AirePlateau airePlateau;
	
	/**
	 * Constructeur du panel jeu
	 * @param j jeu
	 */
	PanelJeu(Jeu j){
		super();
		this.airePlateau = new AirePlateau(j);
		this.setLayout(new BorderLayout());
		this.add(airePlateau, BorderLayout.CENTER);
	}
	
}

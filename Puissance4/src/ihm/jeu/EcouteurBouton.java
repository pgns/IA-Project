package ihm.jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurBouton implements ActionListener{

	/**
	 * La fenetre de jeu.
	 */
	private FenetreJeu fenetreJeu;
	
	/**
	 * Constructeur de l'écouteur.
	 * @param fj	La fenetre de jeu.
	 */
	public EcouteurBouton(FenetreJeu fj){
		this.fenetreJeu = fj;
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == fenetreJeu.pCommande.bnouvellePartie){
			this.fenetreJeu.moteurJeu.getJeu().nouvellePartie();
			this.fenetreJeu.pJeu.airePlateau.repaint();
		}
		
	}

}

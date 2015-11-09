package ihm.jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import puissance4.TypeJoueur;


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
			TypeJoueur tJ1 = TypeJoueur.HUMAIN;
			TypeJoueur tJ2 = TypeJoueur.HUMAIN;
			tJ1.typeJoueur((String)fenetreJeu.pCommande.choixJoueur1.getSelectedItem());
			tJ2.typeJoueur((String)fenetreJeu.pCommande.choixJoueur2.getSelectedItem());
			this.fenetreJeu.moteurJeu.getJeu().nouvellePartie(tJ1,tJ2);
			this.fenetreJeu.moteurJeu.setVerrouFinPartie(false);
			//le joueur 1 commence
			if (this.fenetreJeu.jeu.tourJoueur() == 2)
				this.fenetreJeu.jeu.changerLaMain();
			this.fenetreJeu.pJeu.airePlateau.repaint();
		}
		
	}

}

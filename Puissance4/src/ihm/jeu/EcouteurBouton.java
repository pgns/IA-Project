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
			TypeJoueur tJ1;
			TypeJoueur tJ2;
			if (fenetreJeu.pCommande.choixJoueur1.getSelectedIndex() == 0)
				tJ1 = TypeJoueur.HUMAIN;
			else if (fenetreJeu.pCommande.choixJoueur1.getSelectedIndex() == 1)
				tJ1 = TypeJoueur.IA_FACILE;
			else if (fenetreJeu.pCommande.choixJoueur1.getSelectedIndex() == 2)
				tJ1 = TypeJoueur.IA_MOYEN;
			else // (fenetreJeu.pCommande.choixJoueur1.getSelectedIndex() == 3)
				tJ1 = TypeJoueur.IA_DIFFICILE;
			if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 0)
				tJ2 = TypeJoueur.HUMAIN;
			else if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 1)
				tJ2 = TypeJoueur.IA_FACILE;
			else if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 2)
				tJ2 = TypeJoueur.IA_MOYEN;
			else // (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 3)
				tJ2 = TypeJoueur.IA_DIFFICILE;
			this.fenetreJeu.moteurJeu.getJeu().nouvellePartie(tJ1,tJ2);
			this.fenetreJeu.moteurJeu.setVerrouFinPartie(false);
			//le joueur 1 commence
			if (this.fenetreJeu.jeu.tourJoueur() == 2)
				this.fenetreJeu.jeu.changerLaMain();
			this.fenetreJeu.pJeu.airePlateau.repaint();
		}
		
	}

}

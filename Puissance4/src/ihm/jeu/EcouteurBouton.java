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
	 * Constructeur de l'�couteur.
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
			else if (fenetreJeu.pCommande.choixJoueur1.getSelectedIndex() == 3)
				tJ1 = TypeJoueur.IA_DIFFICILE;
			else 
				tJ1 = TypeJoueur.IA_EXTREME;
			if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 0)
				tJ2 = TypeJoueur.HUMAIN;
			else if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 1)
				tJ2 = TypeJoueur.IA_FACILE;
			else if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 2)
				tJ2 = TypeJoueur.IA_MOYEN;
			else if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 3)
				tJ2 = TypeJoueur.IA_DIFFICILE;
			else
				tJ2 = TypeJoueur.IA_EXTREME;
			this.fenetreJeu.moteurJeu.getJeu().nouvellePartie(tJ1,tJ2);
			this.fenetreJeu.aTemps.setText("Joueur Temps(secondes)\n");
			this.fenetreJeu.moteurJeu.setVerrouFinPartie(false);
			this.fenetreJeu.moteurJeu.tempsJoueur1 = 0F;
			this.fenetreJeu.moteurJeu.tempsJoueur2 = 0F;
			//le joueur 1 commence
			if (this.fenetreJeu.jeu.tourJoueur() == 2)
				this.fenetreJeu.jeu.changerLaMain();
			this.fenetreJeu.pJeu.airePlateau.repaint();
			this.fenetreJeu.moteurJeu.jouer();
		}
		
	}

}

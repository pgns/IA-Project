package ihm.jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import puissance4.TypeJoueur;

/**
 * L'�couteur du bouton
 */
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
	
	/**
	 * l'�couteur de boutons
	 */
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == fenetreJeu.pCommande.bnouvellePartie){
			TypeJoueur tJ1;
			TypeJoueur tJ2;
			
			boolean heuristique1J1;
			boolean heuristique2J1;
			boolean heuristique3J1;
			
			boolean heuristique1J2;
			boolean heuristique2J2;
			boolean heuristique3J2;
			
			if (fenetreJeu.pCommande.choixJoueur1.getSelectedIndex() == 0)
				tJ1 = TypeJoueur.HUMAIN;
			else if (fenetreJeu.pCommande.choixJoueur1.getSelectedIndex() == 1)
				tJ1 = TypeJoueur.IA_FACILE;
			else if (fenetreJeu.pCommande.choixJoueur1.getSelectedIndex() == 2)
				tJ1 = TypeJoueur.IA_MOYEN;
			else 
				tJ1 = TypeJoueur.IA_EXTREME;
			if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 0)
				tJ2 = TypeJoueur.HUMAIN;
			else if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 1)
				tJ2 = TypeJoueur.IA_FACILE;
			else if (fenetreJeu.pCommande.choixJoueur2.getSelectedIndex() == 2)
				tJ2 = TypeJoueur.IA_MOYEN;
			else
				tJ2 = TypeJoueur.IA_EXTREME;
			
			if (fenetreJeu.pCommande.heuristique1J1.getSelectedIndex() == 0)
				heuristique1J1 = true;
			else
				heuristique1J1 = false;
			if (fenetreJeu.pCommande.heuristique2J1.getSelectedIndex() == 0)
				heuristique2J1 = true;
			else
				heuristique2J1 = false;
			if (fenetreJeu.pCommande.heuristique3J1.getSelectedIndex() == 0)
				heuristique3J1 = true;
			else
				heuristique3J1 = false;
			if (fenetreJeu.pCommande.heuristique1J2.getSelectedIndex() == 0)
				heuristique1J2 = true;
			else
				heuristique1J2 = false;
			if (fenetreJeu.pCommande.heuristique2J2.getSelectedIndex() == 0)
				heuristique2J2 = true;
			else
				heuristique2J2 = false;
			if (fenetreJeu.pCommande.heuristique3J2.getSelectedIndex() == 0)
				heuristique3J2 = true;
			else
				heuristique3J2 = false;
			
			
			this.fenetreJeu.moteurJeu.getJeu().nouvellePartie(tJ1,tJ2,heuristique1J1,heuristique2J1,heuristique3J1,heuristique1J2,heuristique2J2,heuristique3J2);
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

package com;

import ihm.jeu.FenetreJeu;
import puissance4.Jeu;
import puissance4.MoteurTest;
import puissance4.MoteurTestProfondeur;

/**
 * Le main
 */
public class Test {

	static Jeu j;
	
	public static void main(String[] args) {
		j = new Jeu();
		FenetreJeu f = new FenetreJeu(j);

		//Pour tester les IA entre eux un certain nombre de fois en mode console
		//MoteurTest mt = new MoteurTest();
		MoteurTestProfondeur mtp = new MoteurTestProfondeur();
	}
	
}

package com;

import ihm.jeu.FenetreJeu;
import puissance4.Jeu;

public class Test {

	static Jeu j;
	
	public static void main(String[] args) {
		j = new Jeu();
		FenetreJeu f = new FenetreJeu(j);

	}

}

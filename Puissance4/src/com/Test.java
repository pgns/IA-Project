package com;

import java.util.Scanner;

import ihm.jeu.FenetreJeu;
import puissance4.Jeu;
import puissance4.MoteurTest;
import puissance4.TypeJoueur;

public class Test {

	static Jeu j;
	
	public static void main(String[] args) {
		j = new Jeu();
		FenetreJeu f = new FenetreJeu(j);

		/**
		 * Pour tester les IA entre eux un certain nombre de fois
		 */
		MoteurTest mt = new MoteurTest();
		
	}
	
}

package com;

import java.util.Scanner;

import ihm.jeu.FenetreJeu;
import puissance4.Jeu;
import puissance4.MoteurTest;
import puissance4.MoteurTestProfondeur;

/**
 * Le main
 */
public class Test {

	static Jeu j;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		j = new Jeu();
		FenetreJeu f = new FenetreJeu(j);
		
		Scanner input1 = new Scanner(System.in);
		String str;
		boolean tourner = true;
		//Pour tester les IA entre eux un certain nombre de fois en mode console
		while(tourner){
			do{
				System.out.println("Entrez p pour lancer les tests sur la profondeur\nEntrez t pour lancer lest test entre les IA\nEntrez q pour quiter");
				str=input1.nextLine();
			} while ( ! str.contentEquals("p") && ! str.contentEquals("t") && !str.contentEquals("q"));
			if (str.contentEquals("p")){
				MoteurTestProfondeur mtp = new MoteurTestProfondeur();
			}
			if (str.contentEquals("t")){
				MoteurTest mt = new MoteurTest();
			}
			if (str.contentEquals("q"))
				tourner = false;
		}
		input1.close();
	}
	
}

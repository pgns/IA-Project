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
	
	public static void main(String[] args) {
		j = new Jeu();
		FenetreJeu f = new FenetreJeu(j);
		
		Scanner input1 = new Scanner(System.in);
		String str;
		//Pour tester les IA entre eux un certain nombre de fois en mode console
		while(true){
			do{
				System.out.println("Entrez p pour lancer les tests sur la profondeur\nEntrez t pour lancer lest test entre les IA");
				str=input1.nextLine();
			} while ( ! str.contentEquals("p") && ! str.contentEquals("t"));
			if (str.contentEquals("p")){
				MoteurTestProfondeur mtp = new MoteurTestProfondeur();
			}
			if (str.contentEquals("t")){
				MoteurTest mt = new MoteurTest();
			}
		}
	}
	
}

package utils;

import java.awt.Color;
import java.net.URL;

public class Constantes {
	/**
	 * Le chargeur de ressources
	 */
	public static Ressources RESSOURCES = new Ressources();
	
	public static int NOMBRE_COLONNE_JEUX = 7;
	public static int NOMBRE_LIGNE_JEUX = 6;
	public static int NOMBRE_CASE_VICTOIRE = 4;
	public static Color COULEUR_JOUEUR_1 = Color.YELLOW;
	public static Color COULEUR_JOUEUR_2 = Color.RED;
	public static byte JOUEUR1 = 1;
	public static byte JOUEUR2 = 2;
	public static String DOSSIER_IMAGES = "Images/";
	public static URL URL_IMAGE_JOUEUR_1 = RESSOURCES.getURL(DOSSIER_IMAGES + "Jaune.png");
	public static URL URL_IMAGE_JOUEUR_2 = RESSOURCES.getURL(DOSSIER_IMAGES + "Rouge.png");
}
package utils;

import java.awt.Color;
import java.net.URL;

/**
 * Les constantes
 */
public class Constantes {
	/**
	 * Le chargeur de ressources
	 */
	public static Ressources RESSOURCES = new Ressources();
	
	/**
	 * Le nombre de colonnes
	 */
	public static int NOMBRE_COLONNE_JEUX = 7;
	
	/**
	 * Le nombre de lignes
	 */
	public static int NOMBRE_LIGNE_JEUX = 6;
	
	/**
	 * Le nombre de case pour une victoire
	 */
	public static int NOMBRE_CASE_VICTOIRE = 4;
	
	/**
	 * Couleur du joueur 1
	 */
	public static Color COULEUR_JOUEUR_1 = Color.YELLOW;
	
	/**
	 * Couleur du joueur 2
	 */
	public static Color COULEUR_JOUEUR_2 = Color.RED;
	
	/**
	 * Le joueur1
	 */
	public static byte JOUEUR1 = 1;
	
	/**
	 * Le joueur2
	 */
	public static byte JOUEUR2 = 2;
	
	/**
	 * Le dossier des images
	 */
	public static String DOSSIER_IMAGES = "Images/";
	
	/**
	 * L'image du pion jaune
	 */
	public static URL URL_IMAGE_JOUEUR_1 = RESSOURCES.getURL(DOSSIER_IMAGES + "Jaune.png");
	
	/**
	 * L'image du pion rouge
	 */
	public static URL URL_IMAGE_JOUEUR_2 = RESSOURCES.getURL(DOSSIER_IMAGES + "Rouge.png");
}
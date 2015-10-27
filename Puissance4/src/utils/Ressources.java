package utils;

import java.net.URL;

/**
 * Classe permettant de g�rer le chargement des ressources du projet (utile pour faire un .jar).
 */
public class Ressources {
	/**
	 * Constructeur par d�faut.
	 */
	public Ressources(){
	}
	
	/**
	 * R�cup�re l'image ou le fichier de nom donn�.
	 * @param nomFichier	Le nom du fichier.
	 * @return				L'URL correspondante.
	 */
	public URL getURL(String nomFichier){
		return this.getClass().getResource(nomFichier);
	}

}

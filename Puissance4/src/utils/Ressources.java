package utils;

import java.net.URL;

/**
 * Classe permettant de gérer le chargement des ressources du projet (utile pour faire un .jar).
 */
public class Ressources {
	/**
	 * Constructeur par défaut.
	 */
	public Ressources(){
	}
	
	/**
	 * Récupère l'image ou le fichier de nom donné.
	 * @param nomFichier	Le nom du fichier.
	 * @return				L'URL correspondante.
	 */
	public URL getURL(String nomFichier){
		return this.getClass().getResource(nomFichier);
	}

}

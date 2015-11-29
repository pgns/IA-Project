package utils;

/**
 * Classe pour des cordonnées lignes colonnes du plateau
 */
public class Coordonnees {
	/**
	 * La ligne
	 */
	private int ligne;
	/**
	 * La colonne
	 */
	private int colonne;
	
	/**
	 * Le constructeur 
	 * @param colonne
	 * @param ligne
	 */
	public Coordonnees(int colonne, int ligne){
		this.setLigne(ligne);
		this.setColonne(colonne);
	}

	/**
	 * Le getteur de la ligne
	 * @return la ligne
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Le seteur de la ligne
	 * @param ligne
	 */
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	/**
	 * Le getteur de la colonne
	 * @return la colonne
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * Le setteur de la colonne
	 * @param colonne
	 */
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	
	public String toString(){
		return "ligne"+String.valueOf(ligne)+"colonne"+String.valueOf(colonne);
	}
}

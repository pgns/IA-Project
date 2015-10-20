package utils;

public class Coordonnees {
	private int ligne;
	private int colonne;
	
	public Coordonnees(int colonne, int ligne){
		this.setLigne(ligne);
		this.setColonne(colonne);
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
}

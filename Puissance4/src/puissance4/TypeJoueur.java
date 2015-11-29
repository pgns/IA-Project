package puissance4;

/**
 * Représente le type d'un joueur.
 */
public enum TypeJoueur {
	HUMAIN("Humain"),
	IA_FACILE("IA facile"),
	IA_MOYEN("IA moyen"),
	IA_DIFFICILE("IA fort"), 
	IA_EXTREME("Skynet");
	
	private String stringJoeuer;
	
	TypeJoueur(String str){
		this.stringJoeuer = str;
	}
	
	public TypeJoueur typeJoueur(String str){
		this.stringJoeuer = str;
		return this;
	}
	
	/**
	 * renvoie vrai si le joueur n'est pas huamin
	 * @param tj Type joueur
	 * @return vrai si le joueur n'est pas huamin
	 */
	public static boolean estOrdi(TypeJoueur tj){
		return tj == TypeJoueur.IA_FACILE || tj == TypeJoueur.IA_MOYEN || tj == TypeJoueur.IA_DIFFICILE || tj == TypeJoueur.IA_EXTREME;
	}
	
	public String toString(){
		return this.stringJoeuer;
	}
	
}

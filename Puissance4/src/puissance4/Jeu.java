package puissance4;

public class Jeu {

		public Plateau plateau;
		private byte aQuiLeTour;
		/**
		 * Type du joueur 1.
		 */
		private TypeJoueur typeJ1;
		/**
		 * Type du joueur 2.
		 */
		private TypeJoueur typeJ2;

		
		public Jeu(){
			plateau = new Plateau();
			typeJ1 = TypeJoueur.HUMAIN;
			typeJ2 = TypeJoueur.HUMAIN;
			this.getPlateau().initialisePlateau();
			this.aQuiLeTour=1;
		}
		
		public Jeu(TypeJoueur j1,TypeJoueur j2){
			plateau = new Plateau();
			typeJ1 = j1;
			typeJ2 = j2;
			this.getPlateau().initialisePlateau();
			this.aQuiLeTour=1;
		}
		
		public void nouvellePartie(){
			this.getPlateau().initialisePlateau();
		}
		
		public void nouvellePartie(TypeJoueur j1,TypeJoueur j2){
			typeJ1 = j1;
			typeJ2 = j2;
			this.getPlateau().initialisePlateau();
		}

		public void changerLaMain(){
			if (this.aQuiLeTour == 1)
				this.aQuiLeTour = 2;
			else
				this.aQuiLeTour = 1;
		}
		
		public Plateau getPlateau() {
			return plateau;
		}
		
		/**
		 * Renvoie le joueur en cours
		 * @return le joueur en cours 
		 */
		public byte tourJoueur(){
			return aQuiLeTour;
		}
		
		/**
		 * Vraie si la partie est finie
		 * @return Vrai si la partie est finie
		 */
		public boolean partieFini(){
			return this.plateau.finDePartie();
		}
		
		public TypeJoueur typeJoueur1(){
			return this.typeJ1;
		}
		
		public TypeJoueur typeJoueur2(){
			return this.typeJ2;
		}
		
		
	//	public void jouerCoup()
		
}

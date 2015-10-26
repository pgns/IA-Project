package puissance4;

public class Jeu {

		public Plateau plateau;
		private byte aQuiLeTour;
		
		public Jeu(){
			plateau = new Plateau();
			this.getPlateau().initialisePlateau();
			this.aQuiLeTour=1;
		}
		
		public void nouvellePartie(){
			this.getPlateau().initialisePlateau();
		}

		public void changerLaMain(){
			if (this.aQuiLeTour == 1)
				this.aQuiLeTour = 2;
			else
				this.aQuiLeTour = 1;
			partieFini();
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
}

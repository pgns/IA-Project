package puissance4;

public class Jeu {

		public Plateau plateau;
		private int aQuiLeTour;
		/**
		 * Si c'est au tour du joueur 1.
		 */
		private boolean tourJ1;
		
		public Jeu(){
			plateau = new Plateau();
			this.getPlateau().initialisePlateau();
			this.aQuiLeTour=0;
		}
		
		public void nouvellePartie(){
			this.getPlateau().initialisePlateau();
		}

		public void changerLaMain(){
			this.aQuiLeTour=(this.aQuiLeTour+1)%2;
		}
		
		public Plateau getPlateau() {
			return plateau;
		}
		
		/**
		 * Vraie si la partie est finie
		 * @return Vrai si la partie est finie
		 */
		public boolean partieFini(){
			return this.plateau.finDePartie();
		}
}

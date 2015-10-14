package puissance4;

public class Jeu {

		private Plateau plateau;
		private int aQuiLeTour;
		
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
}

package puissance4;

/**
 * La classe jeu
 */
public class Jeu {
		
		/**
		 * Le plateau
		 */
		public Plateau plateau;
		
		/**
		 * Le tour du joueur
		 */
		private byte aQuiLeTour;
		
		/**
		 * Type du joueur 1.
		 */
		private TypeJoueur typeJ1;
		
		/**
		 * Type du joueur 2.
		 */
		private TypeJoueur typeJ2;

		/**
		 * Construit un jeu humain vs humain
		 */
		public Jeu(){
			plateau = new Plateau();
			typeJ1 = TypeJoueur.HUMAIN;
			typeJ2 = TypeJoueur.HUMAIN;
			this.getPlateau().initialisePlateau();
			this.aQuiLeTour=1;
		}
		
		/**
		 * Construit un jeu
		 * @param j1 type du joueur 1
		 * @param j2 type du joueur 2
		 */
		public Jeu(TypeJoueur j1,TypeJoueur j2){
			plateau = new Plateau();
			typeJ1 = j1;
			typeJ2 = j2;
			this.getPlateau().initialisePlateau();
			this.aQuiLeTour=1;
		}
		
		/**
		 * Réninitialise le plateau
		 */
		public void nouvellePartie(){
			this.getPlateau().initialisePlateau();
		}
		
		/**
		 * Initialise une nouvelle partie
		 * @param j1 joueur 1
		 * @param j2 joueur 2
		 * @param H1J1 heuristique 1 joueur 1
		 * @param H2J1 heuristique 2 joueur 1
		 * @param H3J1 heuristique 3 joueur 1
		 * @param H1J2 heuristique 1 joueur 2
		 * @param H2J2 heuristique 2 joueur 2
		 * @param H3J2 heuristique 3 joueur 2
		 */
		public void nouvellePartie(TypeJoueur j1,TypeJoueur j2, boolean H1J1, boolean H2J1, boolean H3J1, boolean H1J2, boolean H2J2, boolean H3J2){
			typeJ1 = j1;
			typeJ2 = j2;
			this.getPlateau().initialisePlateau();
			this.getPlateau().initialiseHeuristique(H1J1, H2J1, H3J1, H1J2, H2J2, H3J2);
		}

		/**
		 * Change le tour du joueur
		 */
		public void changerLaMain(){
			if (this.aQuiLeTour == 1)
				this.aQuiLeTour = 2;
			else
				this.aQuiLeTour = 1;
		}
		
		/**
		 * Le getteur du plateau
		 * @return le plateau
		 */
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
		
		/**
		 * Renvoie le type du joueur 1
		 * @return le type du joueur 1
		 */
		public TypeJoueur typeJoueur1(){
			return this.typeJ1;
		}
		
		/**
		 * Renvoie le type du joueur 2
		 * @return le type du joueur 2
		 */
		public TypeJoueur typeJoueur2(){
			return this.typeJ2;
		}	
}
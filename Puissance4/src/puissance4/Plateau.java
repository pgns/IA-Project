package puissance4;

import utils.Constantes;

public class Plateau {
	//-- tableau :  represente la grille puissance4 
	byte tableau [][];
	//-- 			0 pour une position vide
	//--			1 pour un pion du joueur 1
	//--			2 pour un pion du joueur 2

	public Plateau(){
		tableau = new byte[6][7];
	}
	
	//-- initialise le tableau de 0 --//
	public void initialisePlateau(){
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				tableau[i][j]=0;
			}
		}
	}

	//-- Ajoute un pion pour un joueur donné dans la colonne col
	public void ajoutePion(byte joueur, int col){
		int i=0;
		while((i<Constantes.NOMBRE_LIGNE_JEUX) && (tableau[i][col]==0)){
			i++;
		}
		i--;
		if(i == -1){
		// TODO le tableau est rempli exception
		}
		else{
			tableau[i][col] = joueur;
		}
	}
	
	//-- Parcout le tableau horizontla/vertical pour savoir si un joueur J a gagné --//
	//-- retourne le joueur gagnant, ou 0 sinon --//
	public byte VictoireHV(){
		int a = 0;
		byte joueur;
		//parcourt Horizontale
		for(int i=0;i<6;i++){
			a = 0;
			joueur = tableau[i][0];
			for(int j=0;j<7;j++){
				if((tableau[i][j] == joueur)&&(joueur != 0)){
					a++;
					if(a==4){
						return joueur;
					}
				}else{
					a = 1;
					joueur = tableau[i][j];
				}
			}
		}
		//parcourt Verticale
		a = 0;
		for(int i=0;i<7;i++){
			a = 0;
			joueur = tableau[0][i];
			for(int j=0;j<6;j++){
				if((tableau[j][i] == joueur)&&(joueur != 0)){
					a++;
					if(a==4){
						return joueur;
					}
				}else{
					a = 1;
					joueur = tableau[j][i];
					}
				}
			}
		return 0;
	}
	
	
	public boolean estCaseVide(int i,int j){
		return this.tableau[i][j] == 0;
	}
	
	public boolean estCaseJoueur1(int i,int j){
		return this.tableau[i][j] == 1;
	}
	
	public byte getContenu(int i, int j) {
		return this.tableau[i][j];
	}
	
	//-- Parcout le tableau en diagonale pour savoir si un joueur J a gagné --//
	//-- retourne le joueur gagnant, ou 0 sinon --//
		public byte VictoireDiagonale(){
			int i, j, k;
			int a;
			byte joueur;
			//-- parcourt haut=>bas // gauche=>droite --//
			for(i=0;i<6;i++){
				j = i;
				k = 0;
				a = 0;
				joueur = tableau[j][k];
				while(j<6){
					if((tableau[j][k] == joueur)&&(joueur != 0)){
						a++;
						if(a == 4){return joueur;}
					}else{
						a=1;
						joueur = tableau[j][k];
					}
					j++;
					k++;
				}
			}
			for(i=1;i<7;i++){
				j = i;
				k = 0;
				a = 0;
				joueur = tableau[k][j];
				while(j<7){
					if((tableau[k][j] == joueur)&&(joueur != 0)){
						a++;
						if(a == 4){return joueur;}
					}else{
						a = 1;
						joueur = tableau[k][j];
					}
					j++;
					k++;
				}
			}
			//-- parcourt bas=>haut // gauche=>droite --//
			for(i=0;i<6;i++){
				j = 0;
				k = i;
				a = 0;
				joueur = tableau[k][j];
				while(j<=i){
					if((tableau[k][j] == joueur)&&(joueur != 0)){
						a++;
						if(a == 4){return joueur;}
					}else{
						a = 1;
						joueur = tableau[k][j];
					}
					j++;
					k--;
				}
			}
			for(i=1;i<7;i++){
				j = 5;
				k = i;
				a = 0;
				joueur = tableau[j][k];
				while(j >= (i - 1)){
					if((tableau[j][k] == joueur)&&(joueur != 0)){
						a++;
						if(a == 4){return joueur;}
					}else{
						a = 1;
						joueur = tableau[j][k];
					}
					j--;
					k++;
				}
			}
			return 0;
		}
	
		
	//-- affiche le plateau pour debug --//
	public void AffichePlateau(){
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				System.out.print(tableau[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * renvoie vrai si l'ajout d'un pion est possible à la position i,j
	 * @param i ligne
	 * @param j colonne
	 * @return Renvoie vrai si l'ajout est possible à la position (i,j)
	 */
	public boolean ajoutPossible(int i,int j){
		if (this.tableau[i][j] == 0) {
			if (i<Constantes.NOMBRE_LIGNE_JEUX-1)
				return this.tableau[i+1][j] != 0;
			else
				return true;
		}
		return false;
	}
	
	
	/**
	 * 	Vraie si la partie est finie
	 * @return Vraie si la partie est finie
	 */
	public boolean finDePartie(){
		byte joueurGagnant;
		joueurGagnant = VictoireHV();
		if(joueurGagnant != 0){
			System.out.println("Victoire du joueur "+joueurGagnant);
			return true;
		}
		joueurGagnant = VictoireDiagonale();
		if(joueurGagnant != 0){
			System.out.println("Victoire du joueur "+joueurGagnant);
			return true;
		}
		else{return false;}
	}
}

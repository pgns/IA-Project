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
	public boolean VictoireHV(int joueur){
		boolean victoire = false;
		int a=0;
		//parcourt Horizontale
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				if(tableau[i][j] == joueur){
					a++;
					if(a==4){
						return true;
					}
				}else{
					a=0;
				}
			}
		}
		//parcourt Verticale
				for(int i=0;i<7;i++){
					for(int j=0;j<i;j++){
						if(tableau[j][i] == joueur){
							a++;
							if(a==4){
								return true;
							}
						}else{
							a=0;
						}
					}
				}
		return false;
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
		public boolean VictoireDiagonale(int joueur){
			int i, j, k;
			int a;
			//--parcourt Gauche=>Droite--//
			for(i=0;i<6;i++){
				j=0;
				k=i;
				a=0;
				while(j<=i){
					j++;
					k--;
					if(tableau[k][j] == joueur){
						a++;
						if(a == 4){return true;}
					}else{
						a=0;
					}
				}
			}
			a=0;
			j=1;
			while(j<7){
				for(k=j;k<7;k++){
					if(tableau[6-j][j] == joueur){
						a++;
						if(a == 4){return true;}
					}else{
						a=0;
					}
				}
				j++;
			}
			//--parcourt Droite=>Gauche--//
			while(i<6){
				for(j=0;j<6;j++){
					if(tableau[i][j] == joueur){
						a++;
						if(a == 4){return true;}
					}else{
						a=0;
					}
				}
			}
			
				
				// EN COUR //
				
				
			
			
			
			return false;
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
		// TODO A faire
		return false;
	}
}

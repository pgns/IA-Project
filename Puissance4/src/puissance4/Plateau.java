package puissance4;

import utils.Constantes;
import utils.Coordonnees;

public class Plateau {
	//-- tableau :  represente la grille puissance4 
	byte tableau [][];
	//-- 			0 pour une position vide
	//--			1 pour un pion du joueur 1
	//--			2 pour un pion du joueur 2

	
	// les coordonn�es des case victoires
	public Coordonnees cord1Victoire;
	public Coordonnees cord2Victoire;
	public Coordonnees cord3Victoire;
	public Coordonnees cord4Victoire;
	
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
		cord1Victoire = new Coordonnees (-1,-1);
		cord2Victoire = new Coordonnees (-1,-1);
		cord3Victoire = new Coordonnees (-1,-1);
		cord4Victoire = new Coordonnees (-1,-1);
	}

	//-- Ajoute un pion pour un joueur donn� dans la colonne col
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
	
	//-- Parcout le tableau horizontla/vertical pour savoir si un joueur J a gagn� --//
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
	
	//-- Parcout le tableau en diagonale pour savoir si un joueur J a gagn� --//
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
	 * renvoie vrai si l'ajout d'un pion est possible � la position i,j
	 * @param i ligne
	 * @param j colonne
	 * @return Renvoie vrai si l'ajout est possible � la position (i,j)
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
	
	/**
	 * renvoie si il y a des cordonn�es victoire
	 * @return vrai si on a des coordonn�es de victoire
	 */
	public boolean cordVictoire(){
		return this.cord1Victoire.getLigne() != -1;
	}
	
	
	/**
	 *  Initialise les cordonn�es des cases "vaincueur"
	 * @return le joueur qui a gagn�, 0 si pas de victoire
	 */
	public byte victoire(){
		int i,j,jdep,idep;
		int nb_meme_pions;
		byte joueur;
		//parcours horizontale
		for(i=0; i < Constantes.NOMBRE_LIGNE_JEUX; i++){
			nb_meme_pions = 0;
			joueur = 0;
			for(j=0; j< Constantes.NOMBRE_COLONNE_JEUX; j++){
				if(this.tableau[i][j] == joueur && joueur != 0){
					nb_meme_pions++;
					if (nb_meme_pions == Constantes.NOMBRE_CASE_VICTOIRE-1){
						this.cord4Victoire.setColonne(j);
						this.cord4Victoire.setLigne(i);
						this.cord3Victoire.setColonne(j-1);
						this.cord3Victoire.setLigne(i);
						this.cord2Victoire.setColonne(j-2);
						this.cord2Victoire.setLigne(i);
						this.cord1Victoire.setColonne(j-3);
						this.cord1Victoire.setLigne(i);
						System.out.println(this.cord4Victoire.toString()+" "+ this.cord1Victoire.toString());
						return joueur;
					}
				}
				else{
					nb_meme_pions = 0;
					joueur = tableau[i][j];
				}
			}
		}
		//parcours vertical
		for(i=0; i < Constantes.NOMBRE_COLONNE_JEUX; i++){
			nb_meme_pions = 0;
			joueur = 0;
			for (j=0; j<Constantes.NOMBRE_LIGNE_JEUX; j++){
				if(this.tableau[j][i] == joueur && joueur != 0){
					nb_meme_pions++;
					if (nb_meme_pions == Constantes.NOMBRE_CASE_VICTOIRE-1){
						System.out.println("Victoure vertciale");
						this.cord4Victoire.setColonne(i);
						this.cord4Victoire.setLigne(j);
						this.cord3Victoire.setColonne(i);
						this.cord3Victoire.setLigne(j-1);
						this.cord2Victoire.setColonne(i);
						this.cord2Victoire.setLigne(j-2);
						this.cord1Victoire.setColonne(i);
						this.cord1Victoire.setLigne(j-3);
						return joueur;
					}
				}
				else{
					nb_meme_pions = 0;
					joueur = tableau[j][i];
				}
			}
		}
		//parcours diagonale gauche-droite
		i=0;
		j=Constantes.NOMBRE_COLONNE_JEUX-Constantes.NOMBRE_CASE_VICTOIRE;
		jdep=j;
		idep=i;
		while(idep < Constantes.NOMBRE_LIGNE_JEUX-Constantes.NOMBRE_CASE_VICTOIRE+1){
			nb_meme_pions = 0;
			joueur = 0;
			while (j < Constantes.NOMBRE_COLONNE_JEUX && i < Constantes.NOMBRE_LIGNE_JEUX){
				if(this.tableau[i][j] == joueur && joueur != 0){
					nb_meme_pions++;
					if (nb_meme_pions == Constantes.NOMBRE_CASE_VICTOIRE-1){
						System.out.println("Victoure diagoneale 1");
						this.cord4Victoire.setColonne(j);
						this.cord4Victoire.setLigne(i);
						this.cord3Victoire.setColonne(j-1);
						this.cord3Victoire.setLigne(i-1);
						this.cord2Victoire.setColonne(j-2);
						this.cord2Victoire.setLigne(i-2);
						this.cord1Victoire.setColonne(j-3);
						this.cord1Victoire.setLigne(i-3);
						return joueur;
					}
				}
				else{
					nb_meme_pions = 0;
					joueur = tableau[i][j];
				}
				i++;
				j++;
			}
			if (jdep > 0){
				jdep--;
				j=jdep;
				i=0;
			}
			else{
				j = 0;
				idep++;
				i=idep;
			}
		}
		//parcours diagonale droite-gauche
		i=0;
		j=Constantes.NOMBRE_CASE_VICTOIRE-1;
		jdep=j;
		idep=i;
		while(idep < Constantes.NOMBRE_LIGNE_JEUX-Constantes.NOMBRE_CASE_VICTOIRE+1){
			nb_meme_pions = 0;
			joueur = 0;
			while (j >= 0 && i < Constantes.NOMBRE_LIGNE_JEUX){
				if(this.tableau[i][j] == joueur && joueur != 0){
					nb_meme_pions++;
					if (nb_meme_pions == Constantes.NOMBRE_CASE_VICTOIRE-1){
						System.out.println("Victoure diagoneale 2");
						this.cord4Victoire.setColonne(j);
						this.cord4Victoire.setLigne(i);
						this.cord3Victoire.setColonne(j+1);
						this.cord3Victoire.setLigne(i-1);
						this.cord2Victoire.setColonne(j+2);
						this.cord2Victoire.setLigne(i-2);
						this.cord1Victoire.setColonne(j+3);
						this.cord1Victoire.setLigne(i-3);
						return joueur;
					}
				}
				else{
					nb_meme_pions = 0;
					joueur = tableau[i][j];
				}
				i++;
				j--;
			}
			if (jdep < Constantes.NOMBRE_COLONNE_JEUX-1){
				jdep++;
				j=jdep;
				i=0;
			}
			else{
				j =  Constantes.NOMBRE_COLONNE_JEUX-1;
				idep++;
				i=idep;
			}
		}		
		return 0;
	}
}

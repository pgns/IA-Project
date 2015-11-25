package puissance4;

import utils.Constantes;
import utils.Coordonnees;

public class Plateau implements Cloneable {
	//-- tableau :  represente la grille puissance4 
	byte tableau [][];
	//-- 			0 pour une position vide
	//--			1 pour un pion du joueur 1
	//--			2 pour un pion du joueur 2

	
	// les coordonnées des case victoires
	public Coordonnees cord1Victoire;
	public Coordonnees cord2Victoire;
	public Coordonnees cord3Victoire;
	public Coordonnees cord4Victoire;
	
	public Plateau(){
		tableau = new byte[6][7];
		cord1Victoire = new Coordonnees (-1,-1);
		cord2Victoire = new Coordonnees (-1,-1);
		cord3Victoire = new Coordonnees (-1,-1);
		cord4Victoire = new Coordonnees (-1,-1);
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
	
	/**
	 * Fonction pour construire la liste des coups possibles pour l'IA
	 * @param col la colonne
	 * @return vrai si l'ajout est possible dans la colonne
	 */
	public boolean ajoutColonnePossible(int col){
		return tableau[0][col] == 0;
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
	
	/**
	 * renvoie si il y a des cordonnées victoire
	 * @return vrai si on a des coordonnées de victoire
	 */
	public boolean cordVictoire(){
		return this.cord1Victoire.getLigne() != -1;
	}
	
	
	/**
	 *  Initialise les cordonnées des cases "vaincueur"
	 * @return le joueur qui a gagné, 0 si pas de victoire
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
	
	/**
	 * copie du tableau
	 * @param p Plateau à copier
	 */
	public void copieTableau(Plateau p){
		int i,j;
		for (i = 0 ; i < Constantes.NOMBRE_LIGNE_JEUX; i++)
			for(j = 0; j < Constantes.NOMBRE_COLONNE_JEUX; j++)
				this.tableau[i][j] = p.getContenu(i, j);
	}
	
	
	public boolean plateauPlein(){
		for(int i =0 ; i < Constantes.NOMBRE_COLONNE_JEUX; i++){
			if(this.tableau[0][i]==0){
				return false;
			}
		}
		return true;
	}
	
	
	
	
	// === Evalue une partie === //
	// note le jeu de J1 et J2
	// retourne J1-J2
	// l'algo MinMax s'occupe de gerer la note( de l'inverser( J2 - J1)) si j2 été en train de jouer son coup
	public int eval(byte joueur){
		int[] score = new int[3];
		score[0]=0;
		score[1]=0;
		score[2]=0;
		int j, a=0;
		byte pions;
		int note;
		
		
		//== parcourt en hauteur ==//
		for(int i=0;i<7;i++){
			j=5;
			pions = tableau[j][0];
			note=0;
			while((j > -1) && (tableau[j][i] != 0)){
				if(tableau[j][i] == pions){
					a++;
					if(a>1)
						note += 20;
					/*if(a==4)
						note+=20;*/
				}
				else{
					a=1;
					score[pions]+=note;
					note=0;
					pions = tableau[j][i];
				}
				j--;
			}
		}
		//== parcourt en longueur ==//	
		for(int i=0;i<6;i++){
			j=0;
			pions = tableau[i][j];
			note=0;
			a=0;
			while(j<7){
				if(tableau[i][j] == pions){
					a++;
					if(a>1)
						note += 20;
					/*if(a==4)
						note+=20;*/
				}
				else{
					a=1;
					score[pions]+=note;
					note=0;
					pions = tableau[i][j];
				}
				j++;
			}
		}
		//========== parcourt en diagonnal =========//
		int k;
		//-- parcourt bas=>haut // gauche=>droite --//
		// parcourt de la 1er moitiée
		for(int i=0;i<6;i++){
			j = 0;
			k = i;
			a = 0;
			note = 0;
			pions = tableau[k][j];
			while(j<=i){
				if(tableau[k][j] == pions){
					a++;
					if(a>1)
						note += 20;
				}else{
					a = 1;
					score[pions]+=note;
					note=0;
					pions = tableau[k][j];
				}
				j++;
				k--;
			}
		}
		// parcourt de la 2nd moitiée
		for(int i=1;i<7;i++){
			j = 5;
			k = i;
			a = 0;
			note = 0;
			pions = tableau[j][k];
			while(j >= (i - 1)){
				if(tableau[j][k] == pions){
					a++;
					if(a>1)
						note += 20;
				}else{
					a = 1;
					score[pions]+=note;
					note=0;
					pions = tableau[j][k];
				}
				j--;
				k++;
			}
		}
		//------------------ END -------------------//
		//-- parcourt haut=>bas // gauche=>droite --//
		for(int i=0;i<6;i++){
			j = i;
			k = 0;
			a = 0;
			note = 0;
			pions = tableau[j][k];
			while(j<6){
				if(tableau[j][k] == pions){
					a++;
					if(a>1)
						note += 20;
				}else{
					a = 1;
					score[pions]+=note;
					note=0;
					pions = tableau[j][k];
				}
				j++;
				k++;
			}
		}
		for(int i=1;i<7;i++){
			j = i;
			k = 0;
			a = 0;
			note = 0;
			pions = tableau[k][j];
			while(j<7){
				if(tableau[k][j] == pions){
					a++;
					if(a>1)
						note += 20;
				}else{
					a = 1;
					score[pions]+=note;
					note=0;
					pions = tableau[k][j];
				}
				j++;
				k++;
			}
		}
		//====== END  parcourt en diagonnal ========//
		// on retourne la note (on soustrait les points de j1 a j2)
		// si on evaluait j2, c'est le minmax qui inverse la note
		
		
		if(joueur == 1)
			return score[1] - score[2];
		else
			return score[2] - score[1];
	}
}

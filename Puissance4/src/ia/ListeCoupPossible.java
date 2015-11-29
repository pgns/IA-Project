package ia;

import java.util.ArrayList;

import puissance4.Plateau;
import utils.Constantes;

@SuppressWarnings("serial")
/**
 * La liste des plateaux disponibles à partir d'une configuration plateau et d'un joueur
 * @author Barna
 *
 */
public class ListeCoupPossible extends ArrayList<Plateau>{
	ListeCoupPossible(Plateau p, byte joueur){
		super();
		for (int i=0; i < Constantes.NOMBRE_COLONNE_JEUX ; i++){
			if (p.ajoutColonnePossible(i)){
				Plateau pbis = new Plateau();
				pbis.copieHeuristique(p);
				pbis.copieTableau(p);
				pbis.ajoutePion(joueur, i);
				this.add(pbis);
			}
		}
	}
}

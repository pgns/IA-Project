package ihm.jeu;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import puissance4.Jeu;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame{

	PanelJeu pJeu;
	PanelCommande pCommande;
	
	public FenetreJeu(Jeu j){
		super();
		this.setTitle("Puissance 4");
		//chargement du layout
		this.setLayout(new BorderLayout());
		//création des panels
		this.pJeu = new PanelJeu(j);
		this.pCommande = new PanelCommande();
		//ajout des panels
		
		//création de l'écouteur de la souris
		EcouteurSourisJeu ecouteurSourisJeu = new EcouteurSourisJeu(pJeu.airePlateau);//, moteurJeu, gestionnaireBarreEtat);
		pJeu.airePlateau.addMouseListener(ecouteurSourisJeu);
		pJeu.airePlateau.addMouseMotionListener(ecouteurSourisJeu); // not in use
		
		this.add(pJeu,BorderLayout.CENTER);
		this.add(pCommande,BorderLayout.EAST);
		//Un clic sur le bouton de fermeture clos l'application
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//On fixe la taille de la fenêtre
		this.setSize(900, 820);
		//On n'autorise pas le redimensionnement de la fenetre
		this.setResizable(false);
		//On centre la fenêtre
		this.setLocationRelativeTo(null);
		//On défini l'icone
		//		this.setIconImage(Avalam.ci.icone);
		//On la rend visible
		this.setVisible(true);
	}
	
}

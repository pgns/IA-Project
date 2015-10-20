package ihm.jeu;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import puissance4.Jeu;
import puissance4.MoteurJeu;

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame{

	public PanelJeu pJeu;
	public PanelCommande pCommande;
	public MoteurJeu moteurJeu;
	public Jeu jeu;
	
	public FenetreJeu(Jeu j){
		super();
		this.setTitle("Puissance 4");
		//chargement du layout
		this.setLayout(new BorderLayout());
		//création des panels
		this.pJeu = new PanelJeu(j);
		this.pCommande = new PanelCommande();
		//ajout des panels
		this.add(pJeu,BorderLayout.CENTER);
		this.add(pCommande,BorderLayout.EAST);		
		//ajout du moteur et du jeu
		this.jeu = j;
		this.moteurJeu = new MoteurJeu(this.jeu, this);
		
		//création de l'écouteur de la souris
		EcouteurSourisJeu ecouteurSourisJeu = new EcouteurSourisJeu(pJeu.airePlateau, moteurJeu);// gestionnaireBarreEtat);
		pJeu.airePlateau.addMouseListener(ecouteurSourisJeu);
		pJeu.airePlateau.addMouseMotionListener(ecouteurSourisJeu); // not in use
		//écouteur des boutons
		EcouteurBouton ecouteurBouton = new EcouteurBouton(this);
		pCommande.bnouvellePartie.addActionListener(ecouteurBouton);
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

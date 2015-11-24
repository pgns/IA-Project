package ihm.jeu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelCommande extends JPanel{

	public Button bnouvellePartie;
	public JComboBox<String> choixJoueur1;
	public JComboBox<String> choixJoueur2;
	
	
	PanelCommande(){
		super();
		this.bnouvellePartie = new Button("Nouvelle Partie");
		String[] listeChoixJoueur = {"Humain","IA facile","IA moyen","IA fort","Skynet"};
		this.choixJoueur1 = new JComboBox<String>(listeChoixJoueur);
		this.choixJoueur2 = new JComboBox<String>(listeChoixJoueur);
		this.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.darkGray);
		p1.add(bnouvellePartie);
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JLabel j2 = new JLabel("Joueur 2 ");
		JLabel j1 = new JLabel("Joueur 1 ");
		p2.add(j1);
		p2.add(choixJoueur1);
		p3.add(j2);
		p3.add(choixJoueur2);
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		this.add(p3, BorderLayout.SOUTH);
		
	}


	
}

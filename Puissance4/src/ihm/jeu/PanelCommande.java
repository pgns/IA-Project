package ihm.jeu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelCommande extends JPanel{

	public Button bnouvellePartie;
	public JComboBox<String> choixJoueur1;
	public JComboBox<String> choixJoueur2;
	public JComboBox<String> heuristique1J1;
	public JComboBox<String> heuristique2J1;
	public JComboBox<String> heuristique3J1;
	public JComboBox<String> heuristique1J2;
	public JComboBox<String> heuristique2J2;
	public JComboBox<String> heuristique3J2;
	
	
	PanelCommande(){
		super();
		this.bnouvellePartie = new Button("Nouvelle Partie");
		String[] listeChoixJoueur = {"Humain","IA facile","IA moyen","IA fort","Skynet"};
		String[] listeChoixHeuristique = {"Oui","Non"};
		this.choixJoueur1 = new JComboBox<String>(listeChoixJoueur);
		this.choixJoueur2 = new JComboBox<String>(listeChoixJoueur);
		this.heuristique1J1 = new JComboBox<String>(listeChoixHeuristique);
		this.heuristique2J1 = new JComboBox<String>(listeChoixHeuristique);
		this.heuristique3J1 = new JComboBox<String>(listeChoixHeuristique);
		this.heuristique1J2 = new JComboBox<String>(listeChoixHeuristique);
		this.heuristique2J2 = new JComboBox<String>(listeChoixHeuristique);
		this.heuristique3J2 = new JComboBox<String>(listeChoixHeuristique);
		
		this.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setBackground(Color.darkGray);
		p1.add(bnouvellePartie);
		
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JLabel j2 = new JLabel("Joueur 2 ");
		JLabel j1 = new JLabel("Joueur 1 ");
		JLabel j3 = new JLabel("Heuristique 1");
		JLabel j4 = new JLabel("Heuristique 2");
		JLabel j5 = new JLabel("Heuristique 3");
		JLabel j6 = new JLabel("Heuristique 1");
		JLabel j7 = new JLabel("Heuristique 2");
		JLabel j8 = new JLabel("Heuristique 3");
		
		p2.setLayout(new GridLayout(4, 2));
		p2.add(j1);
		p2.add(choixJoueur1);
		p2.add(j3);
		p2.add(heuristique1J1);
		p2.add(j4);
		p2.add(heuristique2J1);
		p2.add(j5);
		p2.add(heuristique3J1);
		
		p4.setLayout(new BorderLayout());
		p4.add(p1, BorderLayout.NORTH);
		p4.add(p2, BorderLayout.SOUTH);
		
		p3.setLayout(new GridLayout(4, 2));
		p3.add(j2);
		p3.add(choixJoueur2);
		p3.add(j6);
		p3.add(heuristique1J2);
		p3.add(j7);
		p3.add(heuristique2J2);
		p3.add(j8);
		p3.add(heuristique3J2);
		
		
		//p2.add(j1);
		//p4.add(j3);
		//p4.add(j4);
		//p4.add(j5);
		//p2.add(choixJoueur1);
		//p3.add(j2);
		//p3.add(choixJoueur2);
		/*p3.add(j6);
		p3.add(heuristique1J2);
		p3.add(j7);
		p3.add(heuristique2J2);*/
		//p5.add(j8);
		//p5.add(heuristique3J2);
		//this.add(p1, BorderLayout.NORTH);
		
		this.add(p4, BorderLayout.NORTH);
		//this.add(p4, BorderLayout.NORTH);
		this.add(p3, BorderLayout.SOUTH);
		//this.add(p5, BorderLayout.CENTER);
	}
}

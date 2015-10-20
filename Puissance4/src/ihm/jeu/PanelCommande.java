package ihm.jeu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelCommande extends JPanel{

	public Button bnouvellePartie;
	
	PanelCommande(){
		super();
		this.bnouvellePartie = new Button("Nouvelle Partie");
		
		this.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.darkGray);
		p1.add(bnouvellePartie);
		this.add(p1, BorderLayout.WEST);
		
	}
	
}

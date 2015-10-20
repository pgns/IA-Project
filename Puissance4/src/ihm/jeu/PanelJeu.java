package ihm.jeu;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import puissance4.Jeu;

@SuppressWarnings("serial")
public class PanelJeu extends JPanel{
	
	AirePlateau airePlateau;
	
	PanelJeu(Jeu j){
		super();
		this.airePlateau = new AirePlateau(j);
		this.setLayout(new BorderLayout());
		this.add(airePlateau, BorderLayout.CENTER);
	//	this.setBackground(Color.blue);
	}
	
}

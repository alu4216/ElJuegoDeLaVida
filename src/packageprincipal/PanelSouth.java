package packageprincipal;


import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class PanelSouth extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lvivas;
	private JLabel lmuertas;
	private Panel panelP;
	public PanelSouth(Panel panelP_) {
		panelP = panelP_;
		setPreferredSize(new Dimension(200,200));
		setLayout(new GridLayout(2,0));
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		panel = new JPanel();
		panel.setBorder(padding);
		panel.setLayout(new GridLayout(2,0));
		lvivas = new JLabel("Celulas vivas:");
		lmuertas = new JLabel("Celulas muertas:");
		panel.add(lvivas);
		panel.add(lmuertas);
		add(panel);
	}
	public void setText(String opcion, int total) {
		switch(opcion) {
		case "Cvivas": 
			lvivas.setText("Celulas vivas:"+total);
			break;
		case "Cmuertas":
			lmuertas.setText("Celulas muertas:"+(panelP.getM()*panelP.getN()-total));
			break;
		default:
			lmuertas.setText("---");
			lvivas.setText("---");
			break;
		}

	}
}

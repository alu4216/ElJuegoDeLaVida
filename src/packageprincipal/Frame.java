package packageprincipal;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class Frame extends JFrame {

	/**
	 * Contenedor principal de la interfaz gráfica
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scroll;
	private Panel panel;
	private PanelSouth panelS;
	private PanelEast panelE;
	


	public Frame() {
		//Instancias de objetos a utilizar
		panel = new Panel();
		scroll= new JScrollPane();
		panelS = new PanelSouth(panel);
		panelE = new PanelEast(panel,panelS);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(panel); //Añadimos scroll al panel
		scroll.getViewport().setView(panel);
		add(scroll, BorderLayout.CENTER);
		add(panelS,BorderLayout.SOUTH);
		add(panelE,BorderLayout.EAST);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

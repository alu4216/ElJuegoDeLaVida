package packageprincipal;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class PanelEast extends JPanel{


	private static final long serialVersionUID = 1L;
	private JButton manual;
	private JButton aleatorio;
	private Panel panel;
	private Calculo cal;

	public PanelEast(Panel panel_) {
		panel = panel_;
		cal = panel.getCal();
		manual = new JButton("Manual");
		aleatorio = new JButton("Aleatorio");
		setPreferredSize(new Dimension(200,200));
		setLayout(new FlowLayout());
		manual.addActionListener(new NewAction());
		aleatorio.addActionListener(new NewAction());
		add(manual);
		add(aleatorio);
	}

	private class NewAction implements ActionListener  {

		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource() == manual) {
				cal.actualizar();
			}
			if(arg0.getSource() == aleatorio) {
				float porcentaje= Integer.parseInt(JOptionPane.showInputDialog(null,
						"Introduzca % de celulas vivas","Datos",JOptionPane.QUESTION_MESSAGE));
				porcentaje = porcentaje / 100;
				cal.rellenarAleatorio(porcentaje);
			}

		}

	}

}



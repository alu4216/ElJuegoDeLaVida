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
	private JButton automatico;
	private JButton parar;
	private JButton reset;
	private Panel panel;
	private Calculo cal;
	private HiloIGrafica hilo;
	private HiloEstadisitca hiloE;
	private PanelSouth panelS;
	private SincroHilos sincro;

	public PanelEast(Panel panel_,PanelSouth panelS_) {
		panel = panel_;
		panelS = panelS_;
		sincro = new SincroHilos();
		cal = panel.getCal();
		hilo = new HiloIGrafica(cal,sincro);
		hiloE = new HiloEstadisitca(cal, panelS,sincro);
		manual = new JButton("Manual");
		aleatorio = new JButton("Aleatorio");
		automatico = new JButton("Automático");
		parar = new JButton("Parar");
		reset = new JButton("Reset");
		setPreferredSize(new Dimension(200,200));
		setLayout(new FlowLayout());
		manual.addActionListener(new NewAction());
		aleatorio.addActionListener(new NewAction());
		automatico.addActionListener(new NewAction());
		parar.addActionListener(new NewAction());
		reset.addActionListener(new NewAction());
		add(manual);
		add(aleatorio);
		add(automatico);
		add(parar);
		add(reset);
	}

	private class NewAction implements ActionListener  {

		@SuppressWarnings("deprecation")
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
			if(arg0.getSource() == automatico) {	
				if (hilo == null)
					hilo = new HiloIGrafica(cal,sincro);
				if(!hilo.isAlive())
					hilo.start();
				if (hiloE == null)
					hiloE = new HiloEstadisitca(cal, panelS,sincro);
				if(!hiloE.isAlive())
					hiloE.start();
			}
			if(arg0.getSource() == parar) {	
				if(hilo != null && hilo.isAlive()) {
					hilo.stop();
					hilo = null;	
				}
				if(hiloE != null && hiloE.isAlive()) {
					hiloE.stop();
					hiloE = null;	
				}
			}
			if(arg0.getSource() == reset) {	
				cal.limpiar();
			}
		}

	}

}



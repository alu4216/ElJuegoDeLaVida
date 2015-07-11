package packageprincipal;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Panel extends JPanel{

	/**
	 * Clase Panel, encargada de crear el panel de botones de celulas
	 */
	
	private static final long serialVersionUID = 1L;
	private Button botones[][];
	private Calculo cal;
	private final int N = 50;
	private final int M = 50;

	public Panel() { 
		cal = new Calculo(this);
		setPreferredSize(new Dimension(500,500));
		this.setLayout(new GridLayout(N, M, 0, 0));
		botones = new Button[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				botones[i][j] = new Button(cal,i,j);
			}
		}
		pintartablero();
	}
	private void pintartablero() {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				this.add(botones[i][j]);
			}
		}
	}
	
	public Button[][] getBotones() {
		
		return botones;
	}
	public int getN() {
		return N;
	}
	public int getM() {
		return M;
	}
	public Calculo getCal() {
		return cal;
	}
}

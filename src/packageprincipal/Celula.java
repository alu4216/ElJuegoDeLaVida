package packageprincipal;

import java.awt.Color;


public class Celula {
	protected Button botones [][];
	protected static Panel panel_;
	public Celula(Panel panel) {
		panel_ = panel;
		botones = panel.getBotones();
	}
	public boolean getestado() {
		return false;
	}
	public void pintar(int i,int j) {
		botones[i][j].setColor(Color.DARK_GRAY);

	}


}

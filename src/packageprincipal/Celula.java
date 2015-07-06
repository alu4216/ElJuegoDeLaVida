package packageprincipal;

import java.awt.Color;


public class Celula {
	protected Button botones [][];
	protected static Panel panel_;
	int tipo;
	public Celula(Panel panel) {
		panel_ = panel;
		botones = panel.getBotones();
		tipo = 0;
	}
	public boolean getestado() {
		return false;
	}
	public void pintar(int i,int j) {
		botones[i][j].setColor(Color.DARK_GRAY);

	}
	public int gettipo() { return tipo; }


}

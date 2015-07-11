package packageprincipal;

import java.awt.Color;


public class Celula {
	protected Button botones [][];
	protected static Panel panel_;
	protected static int totalcel;
	protected int tipo = 0;
	
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
	public int gettotalcel() { return totalcel; }
	public void  resettotalcel() { totalcel=0; } 
	public void uptotalcel() { totalcel++; }

}

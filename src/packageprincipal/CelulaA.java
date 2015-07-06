package packageprincipal;

import java.awt.Color;

public class CelulaA extends Celula{

	public CelulaA() {
		super(panel_);
		tipo = 1;
		
	}
	public boolean getestado() {
		return true;
	}
	public void pintar(int i,int j) {
		botones[i][j].setColor(Color.pink);
	}


}

package packageprincipal;

import java.util.Random;

public class Calculo {

	private Panel panel;
	private Celula tableroCel [][];
	public Calculo(Panel panel_) {

		panel = panel_;
		tableroCel = new Celula [panel_.getN()+2][panel.getM()+2];

		for (int i=0; i<panel.getN()+2;i++) {
			for(int j=0;j<panel.getM()+2;j++) {
				tableroCel[i][j] = new Celula(panel);
			}
		}	
	}

	public int introducirCel(int i, int j) {

		if (tableroCel[i][j].gettipo() == 0) {
			tableroCel[i][j] = new CelulaA();
			return 1;
		}
		else {
			tableroCel[i][j] = new Celula(panel);
			return 0;
		}
	}

	public void rellenarAleatorio(float porcentaje) {

		int total = panel.getN() * panel.getM();
		int rellenar = (int) (total * porcentaje);
		Random rnd = new Random(3816L);
		for(int x=0; x<rellenar;x++) {
			int i = rnd.nextInt(panel.getN());
			int j = rnd.nextInt(panel.getM());

			introducirCel(i+1, j+1);
			tableroCel[i+1][j+1].pintar(i, j);

		}

	}

	public void actualizar() {

		int matriz_aux[][] = new int [panel.getN()+2][panel.getM()+2];

		for (int i=1; i<panel.getN()+1;i++) {
			for(int j=1;j<panel.getM()+1;j++) {
				matriz_aux[i][j]= 0;
				if(vecinos(i,j) < 2 || vecinos(i,j) > 3 ) 
					matriz_aux[i][j] = -1;
				else if(vecinos(i,j) == 3) 
					matriz_aux[i][j] = 1;
			}
		}
		act_interfaz(matriz_aux);
	}

	public void limpiar() {
		for (int i=1; i<panel.getN()+1;i++) {
			for(int j=1;j<panel.getM()+1;j++) {
				tableroCel[i][j] = new Celula(panel);
				tableroCel[i][j].pintar(i-1, j-1);
			}
		}

	}

	private int vecinos(int i, int j) {
		int cont =0;
		if(tableroCel[i-1][j-1].getestado()==true) cont++;
		if(tableroCel[i-1][j].getestado()==true) cont++;
		if(tableroCel[i-1][j+1].getestado()==true) cont++;
		if(tableroCel[i][j-1].getestado()==true) cont++;
		if(tableroCel[i][j+1].getestado()==true) cont++;
		if(tableroCel[i+1][j-1].getestado()==true) cont++;
		if(tableroCel[i+1][j].getestado()==true) cont++;
		if(tableroCel[i+1][j+1].getestado()==true) cont++;
		return cont;
	}

	private void act_interfaz(int matriz_aux[][]) {
		for (int i=1; i<panel.getN()+1;i++) {
			for(int j=1;j<panel.getM()+1;j++) {
				if(matriz_aux[i][j] == 1)
				{
					tableroCel[i][j] = new CelulaA();
					tableroCel[i][j].pintar(i-1, j-1);
				}
				else if (matriz_aux[i][j] == -1)
				{
					tableroCel[i][j] = new Celula(panel);
					tableroCel[i][j].pintar(i-1, j-1);
				}
			}
		}
	}

}

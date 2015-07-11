package packageprincipal;

public class HiloEstadisitca extends Thread {
	
	private Calculo cal;
	private PanelSouth panelS;
	private SincroHilos sincro;
	HiloEstadisitca(Calculo cal_,PanelSouth panelS_,SincroHilos sincro_) {
		// TODO Auto-generated constructor stub
		cal = cal_;
		panelS = panelS_; 
		sincro = sincro_;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true)
		{
			int totalCel = cal.gettotalCel();
			panelS.setText("Cvivas", totalCel);
			panelS.setText("Cmuertas", totalCel);
			sincro.disparar();
		}
	}
}

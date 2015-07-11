package packageprincipal;

public class HiloIGrafica extends Thread {

	private Calculo cal;
	private SincroHilos sincro;
	HiloIGrafica(Calculo cal_,SincroHilos sincro_) {
		// TODO Auto-generated constructor stub
		cal = cal_;
		sincro = sincro_;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true)
		{
			cal.actualizar();
			sincro.apuntar();
			esperar();
		}
	}
	private void esperar() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

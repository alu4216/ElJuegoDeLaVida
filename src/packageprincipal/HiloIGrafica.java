package packageprincipal;

public class HiloIGrafica extends Thread {

	private Calculo cal;
	public HiloIGrafica(Calculo cal_) {
		// TODO Auto-generated constructor stub
		cal = cal_;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true)
		{
			cal.actualizar();
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

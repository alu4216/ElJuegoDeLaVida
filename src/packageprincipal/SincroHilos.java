package packageprincipal;

public class SincroHilos {

	private boolean enposicion = true;

	public synchronized void disparar() {
		while (enposicion == false) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		enposicion = false;
		notifyAll();
	}

	public synchronized void apuntar() {
		while (enposicion == true) {
			try {
				wait();
			} catch (InterruptedException e) { }
		}
		enposicion = true;
		notifyAll();
	}

}
package a3.filosofs;

public class Cobert {

	public enum estatCobert {
		LLIURE, OCUPAT
	}
	
	private  Enum<estatCobert> estat;
	
	public Cobert () {
		estat = estatCobert.LLIURE;
	}

	public synchronized Enum<estatCobert> getEstat() {
		return estat;
	}

	public synchronized void agafar() {
		try {
			
			while (estat == estatCobert.OCUPAT) wait();
			estat = estatCobert.OCUPAT;
			notifyAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void deixar() {
		estat = estatCobert.LLIURE;
		notifyAll();
	}

}

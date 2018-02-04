package a3.banymixte;

public class Bany {
	
	private short estat; //0:LLIURE 1:HI HA DONES 2:HI HA HOMES 3:PLE
	private int num;
	private int MAXP;
	
	public Bany(int maxp) {
		estat = 0;
		num = 0;
		MAXP = maxp;
	}
	
	public synchronized short getEstat() {
		return estat;
	}
	
	public synchronized void entrar(short genere) {
		try {
			while ((estat!=0 && genere!=estat) || estat==3) wait();
			//a dins
			if(estat == 0) estat = genere;
			if(++num == MAXP) estat = 3;
			System.out.println("som " + num + "-" + estat);
			notifyAll();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void sortir() {
		num--;
		System.out.println("surt " + estat);
		if(num == 0) estat = 0;
		notifyAll();
	}
	
	public static void main(String... args) {
		Bany banyMixte = new Bany(3);
		Persona dones[] = new Persona[50];
		Persona homes[] = new Persona[50];
		
		for(int i=0;i<50;i++) {
			dones[i] = new Persona(banyMixte,"dona-" + i, (short) 1);
			homes[i] = new Persona(banyMixte,"home-" + i, (short) 2);
		}
		
		for(int i=0;i<50;i++) {
			dones[i].start();
			homes[i].start();
		}
		
		
	}

}

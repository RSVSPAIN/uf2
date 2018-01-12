package a3;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Banc2 {
    
	
	private int Saldo;
	
	
	public Banc2() {		
		Saldo = 0;
	}
	
	public synchronized int getSaldo() {
		return Saldo;
	}

	private synchronized void setSaldo(int saldo) {
		Saldo = saldo;
	}

	public synchronized void ingres(int diners) {
		   int aux;
	       aux=getSaldo();
	       aux=aux+diners;
	       setSaldo(aux);
	       System.out.print("Ingresso "+ diners + '\n');
	}
	
	public synchronized void treu(int diners) {
		 	int aux;
	        aux=getSaldo();
	        aux=aux-diners;
	        setSaldo(aux);
	        System.out.print("trec "+diners+ '\n');
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		final Banc2 b = new Banc2();
		
		Runnable i = new Runnable() {
			@Override
			public void run() {
				b.ingres(100);
			}
		};
		Runnable t = new Runnable() {
			@Override
			public void run() {
				b.treu(50);
			}
		};
		
		for(int x=0;x<1000;x++) {
			executor.execute(i);
			executor.execute(t);
		}
		
		executor.shutdown();
	    executor.awaitTermination(3, TimeUnit.SECONDS);
		
		System.out.println("Saldo final: "+ b.getSaldo());
		
	}

	
}

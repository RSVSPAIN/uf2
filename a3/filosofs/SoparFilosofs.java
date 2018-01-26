package a3.filosofs;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SoparFilosofs {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		int numFilosofs=4;
		Cobert[] coberts;
		
		coberts = new Cobert[numFilosofs];
		
		for (int i=0;i<coberts.length;i++) {
			coberts[i] = new Cobert();
		}
		
		Filosof f1 = new Filosof("Abel", coberts[0], coberts[1]);
		Filosof f2 = new Filosof("Belen", coberts[1], coberts[2]);
		Filosof f3 = new Filosof("Carles", coberts[2], coberts[3]);
		Filosof f4 = new Filosof("Dani", coberts[3], coberts[0]);
		//Filosof f5 = new Filosof("Gina", (char)4, coberts[4], coberts[0]);
		
		
		
		executor.execute(f1);
		executor.execute(f2);
		executor.execute(f3);
		executor.execute(f4);
		//executor.execute(f5);
		
		executor.shutdown();
		
		
		
	}

}

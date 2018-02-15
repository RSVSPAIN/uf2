package a4;

public class Carrera {

	public static void main(String[] args) throws InterruptedException {
		
		Testimoni fcb = new Testimoni();
		Testimoni uca = new Testimoni();
		
		
		Atleta[] atFCB = new Atleta[4];
		Atleta[] atUCA = new Atleta[4];
		
		//Instàncies dells atletes al Array
		for(int i=0;i<4;i++) {
			atFCB[i] = new Atleta(fcb);
			atUCA[i] = new Atleta(uca);
		}

		//Donem nom als atletes
		for(int i=0;i<4;i++) {
			atFCB[i].setName("FCB-" + i);
			atUCA[i].setName("UCA-" + i);
		}

		//Comença la cursa
		for(int i=0;i<4;i++) {
			atFCB[i].start();
			atUCA[i].start();
		}

		//Esperem a que tots acabin
		for(int i=0;i<4;i++) {
			atFCB[i].join();
			atUCA[i].join();
		}

		//Imprimim el campió
		System.out.println("FC Barcelona: "+ fcb.getTemps());
		System.out.println("Unió Colomenca d'Atletisme: "+ uca.git a());
		String champ = ( (fcb.getTemps()) < (uca.getTemps()) )?"FC Barcelona":"Unió Colomenca";
		System.out.println("Campió: " + champ  );
		
	}

}

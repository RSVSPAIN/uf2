package a3.galetes;


public class Mare implements Runnable {
	private Familia fam;
	private String Nom;
	
	public Mare(Familia f, String Nom) {
		fam=f;
		this.Nom=Nom;
	}

	@Override
	public void run() {
		if((fam.getGaletes())==0) {
			fam.OmplePotGaletes(10);
			System.out.println("Sóc la mama "+ Nom +" i he posat 10 galetes nens!\n");
		}
		
	}
	

}

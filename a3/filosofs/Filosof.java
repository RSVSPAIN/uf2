package a3.filosofs;

import java.awt.Color;

import javax.swing.JLabel;

import static a3.filosofs.Taula.*;

public class Filosof implements Runnable {
	private Cobert cubert1;
	private Cobert cubert2;
	private String nom;
	private JLabel lblFilosof;

	public Filosof (String nom, Cobert cubert1, Cobert cubert2, JLabel lblFilosof) {
		this.cubert1 = cubert1;
		this.cubert2 = cubert2;
		this.nom=nom;
		this.lblFilosof = lblFilosof;
	}
	public Filosof (String nom, Cobert cubert1, Cobert cubert2) {
		this.cubert1 = cubert1;
		this.cubert2 = cubert2;
		this.nom=nom;
	}

	/* Codi de colors
	 * BLUE: El filòsof menja
	 * CYAN: Agafa un cubert
	 * ORANGE: El filòsof pensa
	 *
	 * lockA.lock() i lockA.unlock() és una alternativa al syncrhonized per evitar el deadlock
	 */
	
	private void menjar() {
		try {
			//Sincronització per evitar Deadlock
			//lockA.lock();
			synchronized (lock1) {
				cubert1.agafar();
				lblFilosof.setText("un cobert");
				lblFilosof.setBackground(Color.CYAN);
				System.out.println("1cobert " + nom);
				Thread.sleep((long) ((Math.random() * 50) + 50));
				cubert2.agafar();
				System.out.println("2cobert " + nom);

			}
			//lockA.unlock();

			
			System.out.println("Filosof: " + nom + " menja");
			lblFilosof.setText("menjo");
			lblFilosof.setBackground(Color.BLUE);
			Thread.sleep((long) ((Math.random()*150)+25));
						
			cubert1.deixar();
			cubert2.deixar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void pensar() {
		System.out.println("Filosof: " + nom + " pensa");
		lblFilosof.setText("penso");
		lblFilosof.setBackground(Color.ORANGE);
		try {
			Thread.sleep((long) ((Math.random()*100)+50));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}
	
	public void run() {
		for(;;) {
			menjar();
			pensar();
		}
	}	
}

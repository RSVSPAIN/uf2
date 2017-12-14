package a1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jordi on 23/11/16.
 * MP09 - Activitat 1
 * Exercici 3
 * Utilitza: CercaCaracter.java (Procés)
 */
public class MainCercarCaracter {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<CercaCaracter> llistaTasques= new ArrayList<CercaCaracter>();

        for (int i = 0; i < 15; i++) {
            char c = rndChar();
            System.out.println("car a cercar: " + c);
            CercaCaracter cerca = new CercaCaracter("Hooooolaaaa aquest mòdul és el més divertit de tots",c);
            llistaTasques.add(cerca);
        }
        List <Future<Integer>> llistaResultats;
        llistaResultats = executor.invokeAll(llistaTasques);
        executor.shutdown();

        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println("tasca " + i + ". Hi han " + resultat.get() + " entrades " + llistaTasques.get(i).getCar());
            } catch (InterruptedException | ExecutionException e) {

            }
        }

    }

    private static char rndChar () {
        int rnd = (int) (Math.random() * 52);
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);

    }
}

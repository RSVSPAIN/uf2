package a2;

import a3.Comandament;
import a3.MembreFamilia;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jordi on 04/12/16.
 * Formes de crear i cridar processos
 * aplicable també als Callables excepte l'execució amb Executors
 */
public class tipusProcessos {

    //procés com a subclasse estàtica
    static class p1 implements Runnable {

        @Override
        public void run() {
            System.out.println("sóc p1");
        }
    }

    static class p1_1 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return null;
        }
    }

    //procés coma subclasse no estàtica
    class p_classNoStatic implements Runnable {

        @Override
        public void run() {
            System.out.println(this.getClass().toString());
        }
    }

    //thread
    class pThread extends Thread {
        public pThread(String nom) {
            super(nom);
        }

        @Override
        public void run() {
            System.out.println("Sóc el thread " +  getName());
        }
    }


    public static void main(String[] args) {
        // Procés definit inline
        Runnable p2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("sóc p2");
            }
        };

        p1 p = new p1();
        tipusProcessos.p1 p3 = new tipusProcessos.p1();
        Runnable p4 = new tipusProcessos().new p_classNoStatic();
        //pThread p5 = new pThread("Nom");
        pThread p5 = new tipusProcessos().new pThread("fil");
        tipusProcessos tp = new tipusProcessos();
        MembreFamilia m = new MembreFamilia(new Comandament(),"m");

        //crides
        p2.run();
        p.run();
        p3.run();
        p4.run();

        //crida amb executor
        ExecutorService executor = Executors.newFixedThreadPool(3);

        /** execució de processos del mateuix tipus desats en una llista
         * les tasques han de ser Callable<T>. Amb Runnable no es permet

        List<p1> ltasques = new ArrayList<>();
        ltasques.add(new p1());
        ltasques.add(new p1());
        executor.invokeAll(ltasques);

        **/

        //execució individual
        executor.execute(p);
        executor.execute(p2);
        executor.execute(p3);
        executor.execute(p4);

        //Execució i espera del Thread
        p5.start();
        try {
            p5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

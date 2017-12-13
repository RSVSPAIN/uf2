package a2;

import java.util.concurrent.ForkJoinPool;

public class Dividir {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        DivTask div = new DivTask(102,7);

        pool.invoke(div);
        int res = div.join();

        System.out.println("Resultat:" + res);
    }
}

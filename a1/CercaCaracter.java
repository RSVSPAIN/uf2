package a1;

import java.util.concurrent.Callable;

/**
 * Created by jordi on 23/11/16.
 * MP09 - Activitat 1
 * Exercici 3
 */
public class CercaCaracter implements Callable<Integer> {
    private String msg;
    private char car;
    private int qtat;

    //Inicialitzem les variables excepte la qtat que s'ha de calcular, que ho farem en concurrència
    public CercaCaracter(String msg, char car) {
        this.msg = msg;
        this.car = car;
        qtat = 0;
    }

    //calculem el camp qtat
    @Override
    public Integer call() throws Exception {
        //int counter=0;
        for( int i=0; i<msg.length(); i++ ) {
            if( msg.charAt(i) == car ) {
                qtat++;
            }
        }

        return qtat;
    }

    public int getQtat() {
        return qtat;
    }

    public char getCar() {
        return car;
    }

}

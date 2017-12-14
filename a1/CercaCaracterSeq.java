package a1;

/**
 * Created by jordi on 23/11/16.
 * MP09 - Activitat 1
 * Exercici 4
 */
public class CercaCaracterSeq {
    private String msg;
    private char car;
    private int qtat;

    public CercaCaracterSeq(String msg, char car) {
        this.msg = msg;
        this.car = car;
        qtat = setQtat();

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public char getCar() {
        return car;
    }

    public void setCar(char car) {
        this.car = car;
    }

    public int getQtat() {
        return qtat;
    }


    private int setQtat() {
        int counter=0;
        for( int i=0; i<msg.length(); i++ ) {
            if( msg.charAt(i) == car ) {
                counter++;
            }
        }
        return counter;
    }
}

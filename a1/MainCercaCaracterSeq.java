package a1;

/**
 * Created by jordi on 23/11/16.
 * MP09 - Activitat 1
 * Exercici 4
 * Utilitza: CercaCaracterSeq.java
 */
public class MainCercaCaracterSeq {
    public static void main(String[] args) {
        String msg="Per fi és divendreeeees";

        CercaCaracterSeq cerca = new CercaCaracterSeq(msg, 'e');
        System.out.println("Qtat de '"+cerca.getCar()+"' a "+msg+" = "+cerca.getQtat());


    }
}

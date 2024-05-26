/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.LinkedList;

/**
 *
 * @author Fernando
 */
public class ServidorHilo extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;
    public Buffer buffer;
    LinkedList cola2 = new LinkedList();
    int id;

    public ServidorHilo(DataInputStream in, DataOutputStream out, LinkedList cola2, Buffer buffer, int id) {
        this.in = in;
        this.out = out;
        this.buffer = buffer;
        this.cola2 = cola2;
        this.id = id;
    }

    @Override
    public void run() {
        buffer.consumir();
        // Consume el valor si es posible

        if (id == 1) {
            System.out.println("Consumir el cliente caja1 " + buffer.getName() + " del buffer");
            cola2.remove(buffer.getName());
        } else if (id == 2) {
            System.out.println("Consumir el cliente caja2 " + buffer.getName() + " del buffer");

        }
         else if (id == 3) {
            System.out.println("Consumir el cliente caja3 " + buffer.getName() + " del buffer");

        }
        cola2.pop();
        System.out.println("lista:" + cola2);
        //System.out.println("pop:"+  lista.toString());

        try {
            // Esperamos entre 0 y 4 segundos

            sleep((int) (Math.random() * 5000));
           //sleep(20000);

            //  dialog.setVisible(false);
        } catch (InterruptedException e) {
            System.out.println("fsdfdsfdsfdfdsfsfsfdsfdsfsdfds");
        }

    }

}

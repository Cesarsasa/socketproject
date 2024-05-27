/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Fernando
 */
public class ServidorHilo extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;
    public Buffer buffer;
    JTextArea txt1;
    JTextArea txt2;
    JTextArea txt3;

    LinkedList cola2 = new LinkedList();
    int id;

    public ServidorHilo(DataInputStream in,DataOutputStream out, LinkedList cola2, JTextArea txt1, JTextArea txt2, JTextArea txt3, Buffer buffer, int id) {
       
        this.buffer = buffer;
        this.cola2 = cola2;
        this.id = id;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;

    }

    @Override
    public void run() {

        buffer.consumir();
        // Consume el valor si es posible

        if (id == 1) {
           //System.out.println("Consumir el cliente caja1 " + buffer.getName() + " del buffer");
            txt1.setText(buffer.getName());
        } else if (id == 2) {
           // System.out.println("Consumir el cliente caja2 " + buffer.getName() + " del buffer");
            txt2.setText(buffer.getName());
        } else if (id == 3) {
           // System.out.println("Consumir el cliente caja3 " + buffer.getName() + " del buffer");
            txt3.setText(buffer.getName());
        }
        cola2.pop();
        System.out.println("lista:" + cola2);
        //System.out.println("pop:"+  lista.toString());

        // Esperamos entre 0 y 4 segundos
        //sleep((int) (Math.random() * 40000));
        try {
            sleep((int) (Math.random() * 10000));
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

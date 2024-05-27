/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import jdk.nashorn.internal.runtime.ListAdapter;

public class Servidor extends Thread{
     int i = 0;
        Buffer b = new Buffer(5);
        
        LinkedList cola = new LinkedList();
        JTextArea txt1;
        JTextArea txt2;
        JTextArea txt3;
                

    public Servidor(LinkedList cola ,JTextArea txt1,JTextArea txt2,JTextArea txt3) {
        this.i=i;
        this.b =b;
        this.cola = cola;
        this.txt1=txt1;
        this.txt2=txt2;
        this.txt3=txt3;
        
    }


        
    @Override
    public void run(){
       
        
        
        try {
            //s.setVisible(true);
            ServerSocket server = new ServerSocket(5000);
            Socket sc;
            
            System.out.println("Servidor iniciado");
            while (true) {
                
                // Espero la conexion del cliente
                sc = server.accept();

                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());

                // Pido al cliente el nombre al cliente
               

                out.writeUTF("Toma ticket");
                out.write(i);
              
                cola.add( i);
                
                // Inicio el hilo
                System.out.println("Cola" + cola.toString());
                i++;
                System.out.println("Creada la conexion con el ticket " + i);
                
                
                ClienteHilo hiloc = new ClienteHilo(in,out,cola, b);
                hiloc.start();
                ServidorHilo hilos1 = new ServidorHilo( in,out,cola,txt1,txt2,txt3, b, 1);
                ServidorHilo hilos2 = new ServidorHilo( in,out,cola,txt1,txt2,txt3, b, 2);
                ServidorHilo hilos3 = new ServidorHilo( in,out,cola,txt1,txt2,txt3, b, 3);
                hilos1.start();
                hilos2.start();
                hilos3.start();
               
               

                

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

}

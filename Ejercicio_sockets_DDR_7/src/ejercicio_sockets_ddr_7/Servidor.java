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
import jdk.nashorn.internal.runtime.ListAdapter;

public class Servidor {

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        Buffer b = new Buffer(1);
        LinkedList cola = new LinkedList();

        try {
            ServerSocket server = new ServerSocket(5000);
            Socket sc;

            System.out.println("Servidor iniciado");
            while (true) {

                // Espero la conexion del cliente
                sc = server.accept();

                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());

                // Pido al cliente el nombre al cliente
                out.writeUTF("Indica tu nombre");
                String nombreCliente = in.readUTF();

                out.writeUTF("Toma ticket" + i);
                cola.add(nombreCliente + i);

                // Inicio el hilo
                System.out.println("Cola" + cola.toString());
                i++;
                System.out.println("Creada la conexion con el cliente " + nombreCliente);
                ClienteHilo hiloc = new ClienteHilo(in, out, nombreCliente, b);
                hiloc.start();
                
                ServidorHilo hilos = new ServidorHilo(in, out, cola, b, 1);
                ServidorHilo hilos2 = new ServidorHilo(in, out, cola, b, 2);
                ServidorHilo hilos3 = new ServidorHilo(in, out, cola, b, 3);
                hilos.start();
                hilos2.start();
                hilos3.start();

                

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

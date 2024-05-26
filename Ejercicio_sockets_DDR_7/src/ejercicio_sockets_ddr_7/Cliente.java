/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        Buffer b = new Buffer(1);
        
        try {
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");
         
             Socket sc = new Socket("127.0.0.1", 5000);

            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            // Leer mensaje del servidor
            
                  String mensaje = in.readUTF();
            System.out.println(mensaje);
           String nombre = sn.next();
            // Escribe el nombre y se lo manda al servidor
           
            
            out.writeUTF(nombre);
            
            String mensaje2 = in.readUTF();
            System.out.println(mensaje2);
            

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteHilo extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    private String nombre;
    private Buffer buffer;
    LinkedList lista = new LinkedList();
    int i = 0;

    public ClienteHilo(DataInputStream in,DataOutputStream out,LinkedList lista, Buffer buffer) {
       
        this.lista = lista;
        this.buffer = buffer;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
          try {
            sleep(2000);
            //sleep((int) (Math.random() * 4000));
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Obtenemos una letra al aza<
        //char c = letras.charAt((int) (Math.random() * letras.length()));
        if(lista.size()==5){
            
       
        while (!lista.isEmpty()) {
          
             buffer.producir(lista.getFirst().toString());
        // lista.add(nombre);
        System.out.println("Produciendo el cliente " +lista.getFirst()+ " del buffer");
        //lista.pop();
        //sleep((int) (Math.random() * 10000));

        try {
           // sleep(2000);
            sleep((int) (Math.random() * 4000));
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        }

    }
}

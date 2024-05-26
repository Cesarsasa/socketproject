package ejercicio_sockets_ddr_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ClienteHilo extends Thread {

    private DataInputStream in;
    private DataOutputStream out;
    private String nombre;
    private Buffer buffer;

    public ClienteHilo(DataInputStream in, DataOutputStream out, String nombre, Buffer buffer) {
        this.in = in;
        this.out = out;
        this.nombre = nombre;
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

        // Obtenemos una letra al aza< 
        //char c = letras.charAt((int) (Math.random() * letras.length()));
        buffer.producir(nombre);
        System.out.println("Produciendo el cliente " + nombre + " del buffer");

        try {
            // Esperamos entre 0 y 8 segundos  

           // sleep(20000);

           sleep((int) (Math.random() * 10000));
            // dialog.setVisible(false);
        } catch (InterruptedException e) {
            System.out.println("fsdfdsfdsfdfdsfsfsfdsfdsfsdfds");
        }

    }
}

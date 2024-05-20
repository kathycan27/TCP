import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
    public static void main(String[] args) {
        //Crear Socket
        int port = 5000;
        try{
            ServerSocket socket_server = new ServerSocket(port);
            System.out.println("Esperando Conexion");

            while(true){
                //Esperar y aceptar conexiones
                Socket socket_client= socket_server.accept();

                //Crear hilo para cada cliente
                hilocliente hilo = new hilocliente(socket_client);
                hilo.start();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
    

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {

        Socket socket_cliente;
        try {
            socket_cliente = new Socket("localhost", 5000);
            System.out.println("Cliente conectado");
            Scanner sc = new Scanner(System.in); // crear escaneo de teclado
            System.out.println("Juego Preguntas"); //dar opcion de recibir mensaje
            while (true) {
                            // Crear arreglo de bytes para recibir los datos del cliente    
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(socket_cliente.getOutputStream(), true);
                // escribir datos mensaje de salida
                

                // leer datos recibidois por elñ cliente , almacenador en entrada
                String datos_recibidos = entrada.readLine();
                System.out.println( datos_recibidos);
                String mensajeSalida =sc.nextLine(); // escribir mernsje en escritorio
                salida.println(mensajeSalida);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

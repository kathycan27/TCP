//hilocliente
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class hilocliente extends Thread {
    Scanner sc = new Scanner(System.in);
    Socket socket_client;
    Scanner scanner = new Scanner(System.in);
    String[] preguntas = {"¿Cuál es la capital de Italia?", "¿Cuál es el animal que maulla?", "¿Color del sol?", "¿Color de las fresas?", "¿Cuál es la capital de korea?"};
    String[] respuestas = {"roma", "gato", "amarillo", "rojo", "tokio"};
    int indexPregunta = 0;

    public hilocliente(Socket socket_client) {
        this.socket_client = socket_client;
    }

    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_client.getOutputStream(), true);
            String datos_recibidos;
            System.out.println("Bienvenido al juego de preguntas ");
            
            while (true) {
             
                salida.println(preguntas[i]);
                for(int i=0;i < 4;i++ )  
                {
                    
                    datos_recibidos = entrada.readLine();
           
                    if (datos_recibidos != null && datos_recibidos.equalsIgnoreCase(respuestas[i])) {
                        salida.println("Respuesta Correcta");
                        salida.println(preguntas[i+1]);
                        
                                           
                    } else {
                        salida.println("Respuesta Incorrecta!! La correcta es "+respuestas[i]);
                        salida.println(preguntas[i+1]);
                       
                    }                 
                    salida.println("----------------------------- ");

                }
                
                System.out.println("Fin");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
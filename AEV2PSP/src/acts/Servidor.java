package acts;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket socketEscucha = null;
		System.err.println("CONEXION FUNCIONAL");
		try {
			socketEscucha = new ServerSocket(7878);
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			return;
		}
	
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexion recibida --> Lanza hilo clase Peticion");
			Hilos  p = new Hilos(conexion);
			Thread hilo = new Thread(p);
			hilo.start();
		
	}

}

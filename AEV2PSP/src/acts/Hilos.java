package acts;

import java.net.Socket;

public class Hilos implements Runnable {
	
	Socket conexion;

	public Hilos(Socket conexion) {
		this.conexion=conexion;
	}

	@Override
	public void run() {
		
		
	}

}

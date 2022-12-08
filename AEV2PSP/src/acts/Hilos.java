package acts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Hilos implements Runnable {
	
	 Socket conexion;

	public Hilos(Socket conexion) {
		this.conexion=conexion;
	}

	public void run() {
		String[] posicionesCliente= new String[9];

		String[] posicionesServidor= new String[9];
		
		System.err.println("CLIENTE >>> Envio de datos para el calculo");
	
		try {
			
			//RECIBO DE DATOS STRING
			InputStream is = conexion.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
		    int numeroAleatorio = (int) (Math.random()*30+1);
		    System.err.println(numeroAleatorio);

			System.err.println("SERVIDOR >>> Lee datos para la operacion");
			String numero = bfr.readLine();
			
			int numeroSoporte=Integer.parseInt(numero);
			System.err.println(numero);

		    if (numeroSoporte>=numeroAleatorio) {
		    	
		    	System.err.println("Empieza el cliente");
		    	
				PrintWriter pw = new PrintWriter(conexion.getOutputStream());
				pw.print("Empieza el cliente\n");
				
				pw.flush();
				
			} else {
				System.err.println("Empieza el servidor");
				PrintWriter pw = new PrintWriter(conexion.getOutputStream());
				pw.print("Empieza la maquina\n");
				
				pw.flush();
			}


		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

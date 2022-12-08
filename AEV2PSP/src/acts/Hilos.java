package acts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;

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
				
				//RECIBO DATOS TURNO DE CLIENTE
				InputStream is1 = conexion.getInputStream();
				InputStreamReader isr1 = new InputStreamReader(is1);
				BufferedReader bfr1 = new BufferedReader(isr1);
				
				
				String turno1Cliente = bfr1.readLine();
				System.err.println("CLIENTE ATACA EN " + turno1Cliente);
				int posicion = Integer.parseInt(turno1Cliente);
				posicionesCliente[posicion]="x";
				
				
				//ENVIO DATOS TURNO DE MAQUINA
				int turno1Maquina;
				do {
				     turno1Maquina = (int) (Math.random()*9);
				     if (posicionesCliente[turno1Maquina]==null) {
							PrintWriter pw1 = new PrintWriter(conexion.getOutputStream());
							pw1.print(turno1Maquina+"\n");			
							pw1.flush();
							posicionesServidor[turno1Maquina] = "x";
					}
					
				} while (posicionesCliente[turno1Maquina]!=null);
				

				
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

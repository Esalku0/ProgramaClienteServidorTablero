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
	String[] posicionesCliente = { ".", ".", ".", ".", ".", ".", ".", ".", "." };

	String[] posicionesServidor = new String[9];

	public Hilos(Socket conexion) {
		this.conexion = conexion;
	}

	public void generarPosicionInicioCliente() throws IOException {
		InputStream is1 = conexion.getInputStream();
		InputStreamReader isr1 = new InputStreamReader(is1);
		BufferedReader bfr1 = new BufferedReader(isr1);

		String turno1Cliente = bfr1.readLine();
		System.err.println("CLIENTE ATACA EN " + turno1Cliente);
		int posicion = Integer.parseInt(turno1Cliente);
		posicionesCliente[posicion] = "O";

		// ENVIO DATOS TURNO DE MAQUINA
		boolean comprobar = false;
		int turno1Maquina;

		do {
			turno1Maquina = (int) (Math.random() * 9+1);
			System.out.println(posicionesCliente[turno1Maquina]);
			if (posicionesCliente[turno1Maquina].equals(".")) {
				PrintWriter pw1 = new PrintWriter(conexion.getOutputStream());
				pw1.print(turno1Maquina + "\n");
				pw1.flush();
				comprobar = true;
				posicionesServidor[turno1Maquina] = "x";
				System.out.println("Posicion maquina" + turno1Maquina);

			} else {
				comprobar = false;
			}
		} while (!comprobar);
	}

	public void generaPosicionInicioMaquina() throws IOException {
<<<<<<< HEAD
=======

>>>>>>> origin/Clases
		// ENVIO DATOS TURNO DE MAQUINA
		boolean comprobar = false;
		int turno1Maquina;
		do {
			turno1Maquina = (int) (Math.random() * 9);
			if (posicionesCliente[turno1Maquina].equals(".")) {
				PrintWriter pw1 = new PrintWriter(conexion.getOutputStream());
//				pw1.print(String.valueOf(turno1Maquina)+ "\n");
				pw1.print("hola \n");
				pw1.flush();
			
				comprobar = true;
				posicionesServidor[turno1Maquina] = "x";
				System.err.println("Posicion maquina " + turno1Maquina);

			} else {
				comprobar = false;
			}
		} while (!comprobar);
		System.err.println("YEEE");
	}

	public void run() {

		System.err.println("CLIENTE >>> Envio de datos para el calculo");

		try {

			// RECIBO DE DATOS STRING
			System.err.println("SERVIDOR >>> Lee datos para la operacion");
			InputStream is = conexion.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
			String numero = bfr.readLine();

			int numeroAleatorio = (int) (Math.random() * 30 + 1);
			System.err.println(numeroAleatorio);

			int numeroSoporte = Integer.parseInt(numero);

			System.err.println(numeroSoporte);

			if (numeroSoporte >= numeroAleatorio) {

				System.err.println("Empieza el cliente");
				PrintWriter pw = new PrintWriter(conexion.getOutputStream());
				pw.print("Empieza el cliente \n");
				pw.flush();

				// RECIBO DATOS TURNO DE CLIENTE
				generarPosicionInicioCliente();
				generarPosicionInicioCliente();
				generarPosicionInicioCliente();
				generarPosicionInicioCliente();
				generarPosicionInicioCliente();
				generarPosicionInicioCliente();

			} else {
				System.err.println("Empieza el servidor");
<<<<<<< HEAD
				
				PrintWriter pw = new PrintWriter(conexion.getOutputStream());
				pw.print("Empieza la maquina \n");
				pw.flush();


				
				generaPosicionInicioMaquina();
				
				
=======
				PrintWriter pw = new PrintWriter(conexion.getOutputStream());
				pw.print("Empieza la maquina \n");

				pw.flush();

				generaPosicionInicioMaquina();

>>>>>>> origin/Clases
				InputStream is1 = conexion.getInputStream();
				InputStreamReader isr1 = new InputStreamReader(is1);
				BufferedReader bfr1 = new BufferedReader(isr1);
				System.out.println("esperando...");
				
				String turno1Cliente = bfr1.readLine();
				System.err.println("CLIENTE ATACA EN " + turno1Cliente);
				int posicion = Integer.parseInt(turno1Cliente);
				posicionesCliente[posicion] = "O";

				generaPosicionInicioMaquina();
				InputStream is12 = conexion.getInputStream();
				InputStreamReader isr12 = new InputStreamReader(is12);
				BufferedReader bfr12 = new BufferedReader(isr12);

				String turno2Cliente = bfr12.readLine();
				System.err.println("CLIENTE ATACA EN " + turno2Cliente);
				int posicion2 = Integer.parseInt(turno2Cliente);
				
				posicionesCliente[posicion2] = "O";
				generaPosicionInicioMaquina();
				InputStream is123= conexion.getInputStream();
				InputStreamReader isr123 = new InputStreamReader(is123);
				BufferedReader bfr123 = new BufferedReader(isr123);

				String turno3Cliente = bfr123.readLine();
				System.err.println("CLIENTE ATACA EN " + turno3Cliente);
				int posicion3 = Integer.parseInt(turno3Cliente);
				
				posicionesCliente[posicion3] = "O";
				generaPosicionInicioMaquina();
				generaPosicionInicioMaquina();
				generaPosicionInicioMaquina();
				generaPosicionInicioMaquina();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

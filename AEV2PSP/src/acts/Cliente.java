package acts;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;

public class Cliente extends JFrame  {

	private JPanel contentPane;
	JButton btnPos1;
	JButton btnPos2;
	JButton btnPos3;
	JButton btnPos4;
	JButton btnPos5;
	JButton btnPos6;
	JButton btnPos7;
	JButton btnPos8;
	JButton btnPos9;
	
	static InetSocketAddress direccion = new InetSocketAddress("localhost", 1234);
	static Socket conexion = new Socket();
	
	String[] posicionesCliente= new String[9];

	String[] posicionesServidor= new String[9];

	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
					conexion.connect(direccion);
					//CODIGO
					System.out.println("Envio de Numero...");
					int numero= Integer.parseInt(JOptionPane.showInputDialog(null,"Elije un numero entre 1 y 30 \n"));
					PrintWriter pw = new PrintWriter(conexion.getOutputStream());
					pw.print(numero+"\n");	
					pw.flush();

					InputStream is = conexion.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader bfr = new BufferedReader(isr);
					
					String quienEmpieza = bfr.readLine();
					
					if (quienEmpieza.contains("cliente")) {
						System.out.println("Vamos a ganar ;)");
					}else {
						System.out.println("Lo vamos a intentar");
					}
					
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnPos1 = new JButton("");
		btnPos1.setBounds(101, 37, 69, 59);
		contentPane.add(btnPos1);

		btnPos2 = new JButton("");
		btnPos2.setBounds(205, 37, 69, 59);
		contentPane.add(btnPos2);

		btnPos3 = new JButton("");
		btnPos3.setBounds(301, 37, 69, 59);
		contentPane.add(btnPos3);

		btnPos4 = new JButton("");
		btnPos4.setBounds(101, 128, 69, 59);
		contentPane.add(btnPos4);

		btnPos5 = new JButton("");
		btnPos5.setBounds(205, 128, 69, 59);
		contentPane.add(btnPos5);

		btnPos6 = new JButton("");
		btnPos6.setBounds(301, 128, 69, 59);
		contentPane.add(btnPos6);

		btnPos7 = new JButton("");
		btnPos7.setBounds(101, 217, 69, 59);
		contentPane.add(btnPos7);

		btnPos8 = new JButton("");
		btnPos8.setBounds(205, 217, 69, 59);
		contentPane.add(btnPos8);

		btnPos9 = new JButton("");
		btnPos9.setBounds(301, 217, 69, 59);
		contentPane.add(btnPos9);

	}

	public JButton getBtnPos1() {
		return btnPos1;
	}

	public void setBtnPos1(JButton btnPos1) {
		this.btnPos1 = btnPos1;
	}

	public JButton getBtnPos2() {
		return btnPos2;
	}

	public void setBtnPos2(JButton btnPos2) {
		this.btnPos2 = btnPos2;
	}

	public JButton getBtnPos3() {
		return btnPos3;
	}

	public void setBtnPos3(JButton btnPos3) {
		this.btnPos3 = btnPos3;
	}

	public JButton getBtnPos4() {
		return btnPos4;
	}

	public void setBtnPos4(JButton btnPos4) {
		this.btnPos4 = btnPos4;
	}

	public JButton getBtnPos5() {
		return btnPos5;
	}

	public void setBtnPos5(JButton btnPos5) {
		this.btnPos5 = btnPos5;
	}

	public JButton getBtnPos6() {
		return btnPos6;
	}

	public void setBtnPos6(JButton btnPos6) {
		this.btnPos6 = btnPos6;
	}

	public JButton getBtnPos7() {
		return btnPos7;
	}

	public void setBtnPos7(JButton btnPos7) {
		this.btnPos7 = btnPos7;
	}

	public JButton getBtnPos8() {
		return btnPos8;
	}

	public void setBtnPos8(JButton btnPos8) {
		this.btnPos8 = btnPos8;
	}

	public JButton getBtnPos9() {
		return btnPos9;
	}

	public void setBtnPos9(JButton btnPos9) {
		this.btnPos9 = btnPos9;
	}
}

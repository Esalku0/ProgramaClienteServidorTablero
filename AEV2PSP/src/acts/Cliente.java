package acts;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame {

	private JPanel contentPane;
	static JButton btnPos1;
	static JButton btnPos2;
	static JButton btnPos3;
	static JButton btnPos4;
	static JButton btnPos5;
	static JButton btnPos6;
	static JButton btnPos7;
	static JButton btnPos8;
	static JButton btnPos9;

	static InetSocketAddress direccion = new InetSocketAddress("localhost", 1234);
	static Socket conexion = new Socket();

	String[] posicionesCliente = new String[9];

	String[] posicionesServidor = new String[9];
	static String clickString = "";
	static PrintWriter envio1;
	static PrintWriter envio2;
	static PrintWriter envio3;
	static PrintWriter envio4;
	static PrintWriter envio5;
	static PrintWriter envio6;
	static PrintWriter envio7;
	static PrintWriter envio8;
	static PrintWriter envio9;
	
	public void recibirDeServidor() {
		try {
			InputStream is1 = conexion.getInputStream();
			InputStreamReader isr1 = new InputStreamReader(is1);
			BufferedReader bfr1 = new BufferedReader(isr1);
			
			String turno2Servidor = bfr1.readLine();
			System.out.println(turno2Servidor);
			switch (Integer.parseInt(turno2Servidor)) {
			case 0:
				btnPos1.setText("O");
				break;
			case 1:
				btnPos2.setText("O");
				break;
			case 2:
				btnPos3.setText("O");
				break;
			case 3:
				btnPos4.setText("O");
				break;
			case 4:
				btnPos5.setText("O");
				break;
			case 5:
				btnPos6.setText("O");
				break;
			case 6:
				btnPos7.setText("O");
				break;
			case 7:
				btnPos8.setText("O");
				break;
			case 8:
				btnPos9.setText("O");
				break;
			}
	
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
					conexion.connect(direccion);
					// CODIGO
					System.out.println("Envio de Numero...");
					int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Elije un numero entre 1 y 30 \n"));
					PrintWriter pw = new PrintWriter(conexion.getOutputStream());
					pw.print(numero + "\n");
					pw.flush();

			
					InputStream is = conexion.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader bfr = new BufferedReader(isr);

					String quienEmpieza = bfr.readLine();

					if (quienEmpieza.contains("cliente")) {
						System.out.println("Vamos a ganar ;)");
						envio1 = new PrintWriter(conexion.getOutputStream());
						envio2 = new PrintWriter(conexion.getOutputStream());
						envio3= new PrintWriter(conexion.getOutputStream());
						envio4 = new PrintWriter(conexion.getOutputStream());
						envio5 = new PrintWriter(conexion.getOutputStream());
						envio6 = new PrintWriter(conexion.getOutputStream());
						envio7 = new PrintWriter(conexion.getOutputStream());
						envio8 = new PrintWriter(conexion.getOutputStream());
						envio9 = new PrintWriter(conexion.getOutputStream());
						
						
					} else {
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
		btnPos1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("dgdfdfg");

				if (posicionesServidor[0] == null) {
					posicionesCliente[0] = "X";
					btnPos1.setText("X");
					clickString = "0";
					envio1.print(clickString + "\n");
					envio1.flush();
				}
					recibirDeServidor();
			}
		});
		btnPos1.setBounds(101, 37, 69, 59);
		contentPane.add(btnPos1);

		btnPos2 = new JButton("");
		btnPos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (posicionesServidor[1] == null) {
					posicionesCliente[1] = "X";
					btnPos2.setText("X");
					clickString = "1";
					envio2.print(clickString + "\n");
					envio2.flush();
				}
				recibirDeServidor();
			}
		});
		btnPos2.setBounds(205, 37, 69, 59);
		contentPane.add(btnPos2);

		btnPos3 = new JButton("");
		btnPos3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (posicionesServidor[2] == null) {
					posicionesCliente[2] = "X";
					btnPos3.setText("X");
					clickString = "2";
					envio3.print(clickString + "\n");
					envio3.flush();
				}
				recibirDeServidor();
			}
		});
		btnPos3.setBounds(301, 37, 69, 59);
		contentPane.add(btnPos3);

		btnPos4 = new JButton("");
		btnPos4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (posicionesServidor[3] == null) {
					posicionesCliente[3] = "X";
					btnPos4.setText("X");
					clickString = "3";
					envio4.print(clickString + "\n");
					envio4.flush();
				}
				recibirDeServidor();
			}
		});
		btnPos4.setBounds(101, 128, 69, 59);
		contentPane.add(btnPos4);

		btnPos5 = new JButton("");
		btnPos5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicionesServidor[4] == null) {
					posicionesCliente[4] = "X";
					btnPos5.setText("X");
					clickString = "4";
					envio5.print(clickString + "\n");
					envio5.flush();
				}
				recibirDeServidor();
			}
		});
		btnPos5.setBounds(205, 128, 69, 59);
		contentPane.add(btnPos5);

		btnPos6 = new JButton("");
		btnPos6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicionesServidor[5] == null) {
					posicionesCliente[5] = "X";
					btnPos6.setText("X");
					clickString = "5";
					envio6.print(clickString + "\n");
					envio6.flush();
				}
				recibirDeServidor();
			}
		});
		btnPos6.setBounds(301, 128, 69, 59);
		contentPane.add(btnPos6);

		btnPos7 = new JButton("");
		btnPos7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicionesServidor[6] == null) {
					posicionesCliente[6] = "X";
					btnPos7.setText("X");
					clickString = "6";
					envio7.print(clickString + "\n");
					envio7.flush();
				}
				recibirDeServidor();
			}
		});
		btnPos7.setBounds(101, 217, 69, 59);
		contentPane.add(btnPos7);

		btnPos8 = new JButton("");
		btnPos8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicionesServidor[7] == null) {
					posicionesCliente[7] = "X";
					btnPos8.setText("X");
					clickString = "7";
					envio8.print(clickString + "\n");
					envio8.flush();
				}
				recibirDeServidor();
			}
		});
		btnPos8.setBounds(205, 217, 69, 59);
		contentPane.add(btnPos8);

		btnPos9 = new JButton("");
		btnPos9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posicionesServidor[8] == null) {
					posicionesCliente[8] = "X";
					btnPos9.setText("X");
					clickString = "8";
					envio9.print(clickString + "\n");
					envio9.flush();
				}
				recibirDeServidor();
			}
		});
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

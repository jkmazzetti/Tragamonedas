package Vista;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import Controladores.ControladorCaja;
import Controladores.ControladorTragamonedasTres;
import Modelo.Comprobante;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GraficaMaquinaTres extends JFrame {
	JFrame me = this;
	private JTextField txtTicket;
	private ControladorCaja caja;
	private ControladorTragamonedasTres tragamonedas;
	private Comprobante creditoDelUsuario;
	private JFrame graficaCaja;
	private JLabel lblPrimeraFruta = new JLabel("");
	JLabel lblSegundaFruta = new JLabel("");
	JLabel lblTerceraFruta = new JLabel("");

	public GraficaMaquinaTres(ControladorCaja caja, ControladorTragamonedasTres tragamonedas, JFrame graficaCaja) {
		this.caja = caja;
		this.tragamonedas = tragamonedas;
		this.graficaCaja = graficaCaja;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficaMaquinaTres.class.getResource("/imgs/casino.ico")));
		setTitle("¡Tragamonedas De Tres Casilleros!");
		this.setSize(975, 450);
		this.setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblSegundaFruta.setBounds(250, 61, 200, 200);
		lblSegundaFruta.setBackground(new Color(0, 0, 0));
		lblSegundaFruta.setIcon(new ImageIcon(GraficaMaquinaTres.class.getResource("/imgs/frutilla.jpg")));
		getContentPane().add(lblSegundaFruta);

		lblTerceraFruta.setBounds(475, 61, 200, 200);
		lblTerceraFruta.setIcon(new ImageIcon(GraficaMaquinaTres.class.getResource("/imgs/banana.jpg")));
		lblTerceraFruta.setBackground(Color.BLACK);
		getContentPane().add(lblTerceraFruta);

		lblPrimeraFruta.setBounds(25, 61, 200, 200);
		lblPrimeraFruta.setIcon(new ImageIcon(GraficaMaquinaTres.class.getResource("/imgs/guinda.jpg")));
		lblPrimeraFruta.setBackground(Color.BLACK);
		getContentPane().add(lblPrimeraFruta);

		JLabel lblLeyendaApuesta = new JLabel("Valor de Apuesta");
		lblLeyendaApuesta.setBounds(700, 98, 122, 13);
		lblLeyendaApuesta.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblLeyendaApuesta);

		JLabel lblLeyendaPozo = new JLabel("Pozo Acumulado");
		lblLeyendaPozo.setBounds(700, 61, 122, 13);
		lblLeyendaPozo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblLeyendaPozo);

		JLabel lblLeyendaSaldo = new JLabel("Créditos");
		lblLeyendaSaldo.setBounds(757, 135, 65, 13);
		lblLeyendaSaldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblLeyendaSaldo);

		JButton btnJugar = new JButton("Jugar");

		btnJugar.setBounds(235, 355, 85, 21);
		getContentPane().add(btnJugar);

		JButton btnCaja = new JButton("Ir a Caja");

		btnCaja.setBounds(380, 355, 85, 21);
		getContentPane().add(btnCaja);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(10, 46, 680, 231);
		lblBackground.setForeground(new Color(0, 0, 0));
		lblBackground.setBackground(new Color(0, 0, 0));
		lblBackground.setOpaque(true);
		getContentPane().add(lblBackground);
		
		String pozo = String.valueOf(tragamonedas.getRecaudacion());
		
		JLabel lblPozoValor = new JLabel("$" + pozo);
		lblPozoValor.setBounds(852, 61, 95, 13);
		lblPozoValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblPozoValor);

		String valorDeApuesta = String.valueOf(this.tragamonedas.getValorDeApuesta());
		JLabel lblApuestaValor = new JLabel("$" + valorDeApuesta);
		lblApuestaValor.setBounds(852, 98, 95, 13);
		lblApuestaValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblApuestaValor);

		JLabel lblCreditoDisponibleValor = new JLabel("#000000.00");
		lblCreditoDisponibleValor.setBounds(852, 135, 95, 13);
		lblCreditoDisponibleValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblCreditoDisponibleValor);

		JLabel lblTicket = new JLabel("Ingresá nro de Ticket");
		lblTicket.setBounds(235, 311, 145, 13);
		getContentPane().add(lblTicket);

		txtTicket = new JTextField();
		txtTicket.setBounds(369, 308, 96, 19);
		getContentPane().add(txtTicket);
		txtTicket.setColumns(10);
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int nroTicket = 0;
					if (!txtTicket.getText().equals("")) {
						nroTicket = Integer.valueOf(txtTicket.getText());
						creditoDelUsuario = caja.getComprobante(nroTicket);
						if (creditoDelUsuario != null && !creditoDelUsuario.fueCobrado()) {
							showMessageDialog(null, "¡Divertite!");
							btnCaja.show();
							tragamonedas.ingresarCredito(nroTicket);
							lblCreditoDisponibleValor.setText("#" + String.valueOf(creditoDelUsuario.getSaldo()));
							txtTicket.hide();
							lblTicket.hide();
							txtTicket.setText("");
							btnCaja.show();
							String resultado = tragamonedas.jugar();
							lblPozoValor.setText("$" + String.valueOf(tragamonedas.getRecaudacion()));
							lblCreditoDisponibleValor.setText("#" + String.valueOf(creditoDelUsuario.getSaldo()));
							if (resultado.equals("")) {
								txtTicket.show();

								showMessageDialog(null, "Dinero insuficiente, cobre su ticket e ingrese más credito.");
							} else {
								String mensaje = actualizarImagenes(resultado);
								if (!mensaje.equals("")) {
									showMessageDialog(null, mensaje);
								}

							}
						} else {
							showMessageDialog(null, "Ticket inválido, volvé a intentarlo o comprá más crédito.");
						}
					} else if (creditoDelUsuario != null && !txtTicket.isVisible()) {
						String resultado = tragamonedas.jugar();
						lblPozoValor.setText("$" + String.valueOf(tragamonedas.getRecaudacion()));
						lblCreditoDisponibleValor.setText("#" + String.valueOf(creditoDelUsuario.getSaldo()));
						if (resultado.equals("")) {
							txtTicket.show();
							showMessageDialog(null, "Dinero insuficiente, cobre su ticket e ingrese más credito.");
						} else {

							String mensaje = actualizarImagenes(resultado);
							if (!mensaje.equals("")) {
								showMessageDialog(null, mensaje);
							}
						}
					} else {
						showMessageDialog(null, "Dinero insuficiente, cobre su ticket e ingrese más credito.");
					}

				} catch (Exception error) {
					showMessageDialog(null, "El dato ingresado es inválido.");
				}
			}
		});
		btnCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.hide();
				lblCreditoDisponibleValor.setText("#000000.00");
				txtTicket.setVisible(true);
				lblTicket.show();
				if (creditoDelUsuario != null) {
					showMessageDialog(null, creditoDelUsuario.getInfo());
					creditoDelUsuario = null;
				}
				graficaCaja.show();
			}
		});

	}

	private String actualizarImagenes(String resultado) {

		String[] mensaje = resultado.split(",");
		String gano = "";
		String frutas[] = mensaje[0].split("-");
		if (frutas.length > 1) {
			String uno = frutas[0] + ".jpg";
			String dos = frutas[1] + ".jpg";
			String tres = frutas[2] + ".jpg";
			ImageIcon iconUno = new ImageIcon("src/imgs/" + uno);
			ImageIcon iconDos = new ImageIcon("src/imgs/" + dos);
			ImageIcon iconTres = new ImageIcon("src/imgs/" + tres);
			iconUno.getImage().flush();
			this.lblPrimeraFruta.setIcon(iconUno);
			iconDos.getImage().flush();
			lblSegundaFruta.setIcon(iconDos);
			iconTres.getImage().flush();
			lblTerceraFruta.setIcon(iconTres);
		}
		if(mensaje[1].contains("Gan")) {
			gano=mensaje[1];
		}
		return gano;
	}
}

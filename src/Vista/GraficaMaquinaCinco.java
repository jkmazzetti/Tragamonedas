package Vista;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controladores.ControladorCaja;
import Controladores.ControladorTragamonedasCinco;
import Modelo.Comprobante;

import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GraficaMaquinaCinco extends JFrame {
	JFrame me = this;
	private JTextField txtTicket;
	private ControladorCaja caja;
	private ControladorTragamonedasCinco tragamonedas;
	private Comprobante creditoDelUsuario;
	private JFrame graficaCaja;
	private JLabel lblPrimeraFruta = new JLabel("");
	private JLabel lblSegundaFruta = new JLabel("");
	private JLabel lblTerceraFruta = new JLabel("");
	private JLabel lblCuartaFruta = new JLabel("");
	private JLabel lblQuintaFruta = new JLabel("");

	public GraficaMaquinaCinco(ControladorCaja caja, ControladorTragamonedasCinco tragamonedas, JFrame graficaCaja) {
		this.caja = caja;
		this.tragamonedas = tragamonedas;
		this.graficaCaja = graficaCaja;
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GraficaMaquinaTres.class.getResource("/imgs/casino.ico")));
		setTitle("¡Tragamonedas De Cinco Casilleros!");
		this.setSize(1160, 487);
		this.setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblQuintaFruta.setIcon(new ImageIcon(GraficaMaquinaCinco.class.getResource("/imgs/uva.jpg")));
		lblQuintaFruta.setBackground(Color.BLACK);
		lblQuintaFruta.setBounds(926, 134, 200, 200);
		getContentPane().add(lblQuintaFruta);

		lblCuartaFruta.setIcon(new ImageIcon(GraficaMaquinaCinco.class.getResource("/imgs/pera.jpg")));
		lblCuartaFruta.setBackground(Color.BLACK);
		lblCuartaFruta.setBounds(701, 134, 200, 200);
		getContentPane().add(lblCuartaFruta);

		lblSegundaFruta.setBackground(new Color(0, 0, 0));
		lblSegundaFruta.setIcon(new ImageIcon(GraficaMaquinaTres.class.getResource("/imgs/frutilla.jpg")));
		lblSegundaFruta.setBounds(250, 134, 200, 200);
		getContentPane().add(lblSegundaFruta);

		lblTerceraFruta.setIcon(new ImageIcon(GraficaMaquinaTres.class.getResource("/imgs/banana.jpg")));
		lblTerceraFruta.setBackground(Color.BLACK);
		lblTerceraFruta.setBounds(475, 134, 200, 200);
		getContentPane().add(lblTerceraFruta);

		lblPrimeraFruta.setIcon(new ImageIcon(GraficaMaquinaTres.class.getResource("/imgs/guinda.jpg")));
		lblPrimeraFruta.setBackground(Color.BLACK);
		lblPrimeraFruta.setBounds(25, 134, 200, 200);
		getContentPane().add(lblPrimeraFruta);

		txtTicket = new JTextField();
		txtTicket.setBounds(590, 360, 96, 19);
		getContentPane().add(txtTicket);
		txtTicket.setColumns(10);

		JLabel lblLeyendaApuesta = new JLabel("Valor de Apuesta");
		lblLeyendaApuesta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeyendaApuesta.setBounds(10, 47, 122, 13);
		getContentPane().add(lblLeyendaApuesta);

		JLabel lblLeyendaPozo = new JLabel("Pozo Acumulado");
		lblLeyendaPozo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeyendaPozo.setBounds(10, 10, 122, 13);
		getContentPane().add(lblLeyendaPozo);

		JLabel lblCreditoDisponibleValor = new JLabel("#000000.00");
		lblCreditoDisponibleValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCreditoDisponibleValor.setBounds(162, 84, 151, 13);
		getContentPane().add(lblCreditoDisponibleValor);
		
		JLabel lblLeyendaSaldo = new JLabel("Créditos");
		lblLeyendaSaldo.setBounds(67, 84, 65, 13);
		lblLeyendaSaldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblLeyendaSaldo);

		String pozo = String.valueOf(tragamonedas.getRecaudacion());
		JLabel lblPozoValor = new JLabel("$" + pozo);
		lblPozoValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPozoValor.setBounds(162, 10, 95, 13);
		getContentPane().add(lblPozoValor);

		String valorDeApuesta = String.valueOf(this.tragamonedas.getValorDeApuesta());
		JLabel lblApuestaValor = new JLabel("$" + valorDeApuesta);
		lblApuestaValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApuestaValor.setBounds(162, 47, 95, 13);
		getContentPane().add(lblApuestaValor);

		JLabel lblTicket = new JLabel("Ingresá nro de Ticket");
		lblTicket.setBounds(461, 363, 108, 13);
		getContentPane().add(lblTicket);

		JButton btnCaja = new JButton("Ir a Caja");
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
		btnCaja.setBounds(590, 407, 85, 21);
		getContentPane().add(btnCaja);

		JButton btnJugar = new JButton("Jugar");
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
		btnJugar.setBounds(475, 407, 85, 21);
		getContentPane().add(btnJugar);

		JLabel lblBackground = new JLabel("");
		lblBackground.setForeground(new Color(0, 0, 0));
		lblBackground.setBackground(new Color(0, 0, 0));
		lblBackground.setBounds(10, 119, 1126, 231);
		lblBackground.setOpaque(true);
		getContentPane().add(lblBackground);

	}

	private String actualizarImagenes(String resultado) {

		String[] mensaje = resultado.split(",");
		String gano = "";
		String frutas[] = mensaje[0].split("-");
		if (frutas.length > 1) {
			String uno = frutas[0] + ".jpg";
			String dos = frutas[1] + ".jpg";
			String tres = frutas[2] + ".jpg";
			String cuatro = frutas[3] + ".jpg";
			String cinco = frutas[4] + ".jpg";
			ImageIcon iconUno = new ImageIcon("src/imgs/" + uno);
			ImageIcon iconDos = new ImageIcon("src/imgs/" + dos);
			ImageIcon iconTres = new ImageIcon("src/imgs/" + tres);
			ImageIcon iconCuatro = new ImageIcon("src/imgs/" + cuatro);
			ImageIcon iconCinco = new ImageIcon("src/imgs/" + cinco);
			iconUno.getImage().flush();
			this.lblPrimeraFruta.setIcon(iconUno);
			iconDos.getImage().flush();
			lblSegundaFruta.setIcon(iconDos);
			iconTres.getImage().flush();
			lblTerceraFruta.setIcon(iconTres);
			iconCuatro.getImage().flush();
			lblCuartaFruta.setIcon(iconCuatro);
			iconCinco.getImage().flush();
			lblQuintaFruta.setIcon(iconCinco);
		}
		if (mensaje[1].contains("Gan")) {
			gano = mensaje[1];
		}
		return gano;
	}
}

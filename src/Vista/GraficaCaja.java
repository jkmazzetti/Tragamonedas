
package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.showMessageDialog;
import Controladores.ControladorCaja;
import Modelo.Comprobante;
import Modelo.Usuario;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class GraficaCaja extends JFrame {
	JFrame me = this;
	JFrame inicio;
	JLabel lblTitulo;
	JButton btnAceptar;
	ButtonGroup grupoDeOpciones = new ButtonGroup();
	JFrame caja = null;
	JFrame seleccionDeMaquina = null;
	private JTextField txtDato;
	private JButton btnInicio;

	public GraficaCaja(ControladorCaja caja, Usuario user) {
		setResizable(false);
		this.setSize(500, 280);
		this.setBackground(Color.WHITE);
		setTitle("CAJA");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblTitulo = new JLabel("BIENVENIDO A LA CAJA ELEGI UNA OPCIÓN");
		lblTitulo.setBounds(122, 64, 272, 13);
		getContentPane().add(lblTitulo);

		btnAceptar = new JButton("Aceptar");

		btnAceptar.setBounds(277, 133, 87, 21);
		getContentPane().add(btnAceptar);

		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setBounds(122, 137, 85, 13);
		getContentPane().add(lblCantidad);

		txtDato = new JTextField();
		txtDato.setToolTipText("");
		txtDato.setBounds(196, 134, 71, 19);
		getContentPane().add(txtDato);
		txtDato.setColumns(10);

		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.hide();
				txtDato.setText("");
				inicio.show();
			}
		});
		btnInicio.setBounds(200, 164, 85, 21);
		getContentPane().add(btnInicio);

		JRadioButton rdbtnCredito = new JRadioButton("Comprar Crédito");
		grupoDeOpciones.add(rdbtnCredito);
		rdbtnCredito.setSelected(true);
		rdbtnCredito.setBounds(122, 95, 130, 21);
		getContentPane().add(rdbtnCredito);
		rdbtnCredito.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCantidad.setText("CANTIDAD");
				txtDato.setText("");

			}
		});
		JRadioButton rdbtnRetirarDinero = new JRadioButton("Retirar Dinero");
		rdbtnRetirarDinero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblCantidad.setText("TICKET N°");
				txtDato.setText("");

			}
		});
		grupoDeOpciones.add(rdbtnRetirarDinero);
		rdbtnRetirarDinero.setBounds(268, 94, 108, 21);
		getContentPane().add(rdbtnRetirarDinero);
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					float monto = 0;
					if (rdbtnCredito.isSelected()) {
						lblCantidad.setText("CANTIDAD");
						if (!txtDato.getText().equals("")) {
							monto = Float.valueOf(txtDato.getText());
							Comprobante comprobante = caja.venderCredito(user, monto);
							if (comprobante != null) {
								showMessageDialog(null, comprobante.getInfo());
							} else {
								showMessageDialog(null,"No tenés suficiente dinero para comprar la cantidad indicada de crédito.");
							}
						}
					} else {
						lblCantidad.setText("TICKET N°");
						int ticket = 0;
						if (!txtDato.getText().equals("")) {
							ticket = Integer.valueOf(txtDato.getText());
							monto = caja.pagar(user, ticket);
							if (monto > 0.00f) {
								showMessageDialog(null, "Recibiste $" + monto + ".");
							} else {
								showMessageDialog(null, "El ticket " + txtDato.getText() + " es inválido. ");
							}
						}
					}

				} catch (Exception error) {
					showMessageDialog(null, "El dato ingresado es inválido.");
				}
			}
		});
		iniciarComponentes();
	}

	public void iniciarComponentes() {
	}
	public void setInicio(JFrame inicio) {
		this.inicio=inicio;
	}
}

package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Principal extends JFrame {
	JFrame me = this;
	JLabel lblOpcionesPrincipal;
	JRadioButton rdbtnCaja;
	JRadioButton rdbtnJugar;
	JButton btnAceptarPrincipal;
	ButtonGroup grupoDeOpciones = new ButtonGroup();
	JFrame caja = null;
	JFrame seleccionDeMaquina = null;

	public Principal(JFrame caja, JFrame seleccionDeMaquina) {
		this.caja=caja;
		((GraficaCaja) this.caja).setInicio(this);
		this.seleccionDeMaquina = seleccionDeMaquina;
		setResizable(false);
		this.setSize(500, 280);
		this.setBackground(Color.WHITE);
		setTitle("¡BIENVENIDO AL CASINO!");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblOpcionesPrincipal = new JLabel("ELEGÍ UNA OPCIÓN PARA COMENZAR");
		lblOpcionesPrincipal.setBounds(151, 73, 335, 13);
		getContentPane().add(lblOpcionesPrincipal);

		rdbtnCaja = new JRadioButton("Ir a la Caja");
		rdbtnCaja.setSelected(true);
		grupoDeOpciones.add(rdbtnCaja);
		rdbtnCaja.setBounds(187, 101, 299, 21);
		getContentPane().add(rdbtnCaja);

		rdbtnJugar = new JRadioButton("Comenzar a Jugar");
		grupoDeOpciones.add(rdbtnJugar);
		rdbtnJugar.setBounds(187, 124, 299, 21);
		getContentPane().add(rdbtnJugar);

		btnAceptarPrincipal = new JButton("Aceptar");
		btnAceptarPrincipal.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCaja.isSelected()) {
					me.hide();
					caja.show();
				} else {
					me.hide();
					seleccionDeMaquina.show();
				}
			}
		});
		btnAceptarPrincipal.setBounds(200, 162, 85, 21);
		getContentPane().add(btnAceptarPrincipal);
		iniciarComponentes();
	}

	public void iniciarComponentes() {
	}

}

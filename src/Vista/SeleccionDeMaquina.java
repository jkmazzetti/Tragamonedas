package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class SeleccionDeMaquina extends JFrame {
	JFrame me = this;
	JLabel lblOpcionesPrincipal;
	JRadioButton rdbtnMaquinaDeTres;
	JRadioButton rdbtnMaquinaDeCinco;
	JButton btnAceptarPrincipal;
	ButtonGroup grupoDeOpciones = new ButtonGroup();
	JFrame maquinaTres;
	JFrame maquinaCinco;

	public SeleccionDeMaquina(JFrame tres, JFrame cinco) {
		this.maquinaTres = tres;
		this.maquinaCinco = cinco;
		setResizable(false);
		this.setSize(500, 279);
		this.setBackground(Color.WHITE);
		setTitle("Bienvenidos al Casino");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblOpcionesPrincipal = new JLabel("ELEGÍ UNA MÁQUINA PARA COMENZAR");
		lblOpcionesPrincipal.setBounds(151, 73, 335, 13);
		getContentPane().add(lblOpcionesPrincipal);

		rdbtnMaquinaDeTres = new JRadioButton("De 3 Casilleros");
		rdbtnMaquinaDeTres.setSelected(true);
		grupoDeOpciones.add(rdbtnMaquinaDeTres);
		rdbtnMaquinaDeTres.setBounds(187, 101, 299, 21);
		getContentPane().add(rdbtnMaquinaDeTres);

		rdbtnMaquinaDeCinco = new JRadioButton("De 5 Casilleros");
		grupoDeOpciones.add(rdbtnMaquinaDeCinco);
		rdbtnMaquinaDeCinco.setBounds(187, 124, 299, 21);
		getContentPane().add(rdbtnMaquinaDeCinco);

		btnAceptarPrincipal = new JButton("Aceptar");
		btnAceptarPrincipal.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMaquinaDeTres.isSelected()) {
					me.hide();
					maquinaTres.show();
				} else {
					me.hide();
					maquinaCinco.show();
				}
			}
		});
		btnAceptarPrincipal.setBounds(200, 162, 85, 21);
		getContentPane().add(btnAceptarPrincipal);
	}

}

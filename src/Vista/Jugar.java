package Vista;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Jugar extends JFrame {
	public JPanel panel;

	public Jugar() {
		this.setSize(500, 500); // establecer tamaño ancho y alto
		this.setBackground(Color.black);
		setTitle("Traga Monedas");
		// setLocation(400, 150);
		// setBounds(400, 150, 500, 400); //equivale a set Location y Size
		setLocationRelativeTo(null); // ventana centrada
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		colocarPaneles();
		colocarEtiquetas(124509, 100);
		cajaIngresarCredito();
		colocarBotones(5, 10);
	}

	// debe recibir como parametro lista de frutas,
	// con su tamaño sabremos la cantidad de casilleros y su diseño (ancho y alto)
	// ventana ppal hacerla mas grande y q si hay mas casilleros entren sino no los
	// muestro
	private void colocarPaneles() {
		// MiPrimeraClase objeto = new MiPrimeraClase(11, 22);
		panel = new JPanel(); // creacion de un panel
		// panel.setBackground(Color.blue);
		panel.setLayout(null); // desable defect value
		this.getContentPane().add(panel);// agregar panel a la ventana

	}

	private void colocarEtiquetas(int credit, int precioJugar) {
		JLabel etiqueta = new JLabel("Fruta1", SwingConstants.CENTER);
		panel.add(etiqueta);
		etiqueta.setBounds(10, 10, 150, 200); // ancho - alto
		etiqueta.setOpaque(true);// desable background
		etiqueta.setBackground(Color.MAGENTA);
		// etiqueta.setText("hola");
		JLabel etiqueta2 = new JLabel("Fruta2", SwingConstants.CENTER);
		panel.add(etiqueta2);
		etiqueta2.setBounds(170, 10, 150, 200); // ancho - alto
		etiqueta2.setOpaque(true);// desable background
		etiqueta2.setBackground(Color.magenta);
		// CASILLERO N°3

		ImageIcon img3 = new ImageIcon("banana.jpg");
		JLabel etiqueta3 = new JLabel(new ImageIcon("banana.jpg"), SwingConstants.CENTER);
		panel.add(etiqueta3);
		etiqueta3.setBounds(330, 10, 150, 200); // ancho - alto
		etiqueta3.setIcon(new ImageIcon(
				img3.getImage().getScaledInstance(etiqueta3.getWidth(), etiqueta3.getHeight(), Image.SCALE_SMOOTH)));
		// etiqueta3.setOpaque(true);//desable background
		// etiqueta3.setBackground(Color.MAGENTA);
		// Credito DISPONIBLE
		JLabel creditoEnMaquina = new JLabel("credito: " + credit);
		panel.add(creditoEnMaquina);
		creditoEnMaquina.setBounds(10, 220, 150, 20); // ancho - alto
		creditoEnMaquina.setOpaque(true);// desable background
		creditoEnMaquina.setBackground(Color.yellow);

		// precioJugada
		JLabel precioTiro = new JLabel("precioTiro: ");
		panel.add(precioTiro);
		precioTiro.setBounds(330, 220, 150, 20); // ancho - alto
		precioTiro.setOpaque(true);// desable background
		precioTiro.setBackground(Color.yellow);
		// MENSAJE maquina-usuario
		JLabel mensajeMaquina = new JLabel("mensaje: ");
		panel.add(mensajeMaquina);
		mensajeMaquina.setBounds(10, 360, 450, 40); // ancho - alto
		mensajeMaquina.setOpaque(true);// desable background
		mensajeMaquina.setBackground(Color.yellow);

	}

	// ingresar N° ticket para agregar credito en maquina
	// llamar funcion arrayTickets con $$ de cada uno
	private void cajaIngresarCredito() {
		JTextField nroTicketCredito = new JTextField();
		nroTicketCredito.setBounds(170, 220, 100, 20);
		nroTicketCredito.setText("ingrese N°Ticket");
		nroTicketCredito.getText();
		nroTicketCredito.setBackground(Color.cyan);
		panel.add(nroTicketCredito);
	}

	private void colocarBotones(int a, int b) {
		// BOTON N°Ticket ingresado
		JButton botonTicket = new JButton("OK");
		panel.add(botonTicket);
		botonTicket.setBounds(270, 220, 50, 20);
		// Listener N° Ticket ingresado
		ActionListener aceptarNro = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		};

		botonTicket.addActionListener(aceptarNro);

		// BOTON JUGAR
		JButton botonJugar = new JButton("JUGAR");
		panel.add(botonJugar);
		botonJugar.setBounds(120, 250, 100, 100);
		botonJugar.setBackground(Color.green);
		// boton1.setEnabled(true);//cuando no haya credito = false
		// comparar precioJugada con credito en maquina
		if (a < b) {
			botonJugar.setEnabled(true);
		} else
			botonJugar.setEnabled(false);
		// listener jugar (clase anonima)
		/*
		 * ActionListener hacerJugada = new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * 
		 * } }; botonJugar.addActionListener(hacerJugada);
		 */
		// BOTON RETIRARSE
		JButton botonRetirarse = new JButton("RETIRO");
		panel.add(botonRetirarse);
		botonRetirarse.setBounds(270, 250, 100, 100);
		botonRetirarse.setBackground(Color.red);

	}

}

package Vista;

import java.util.Scanner;

import Controladores.ControladorCaja;
import Controladores.ControladorTragamonedas;
import Controladores.ControladorTragamonedasCinco;
import Controladores.ControladorTragamonedasTres;
import Modelo.Caja;
import Modelo.Comprobante;
import Modelo.Fruta;
import Modelo.PremioCinco;
import Modelo.PremioTres;
import Modelo.TragamonedasCinco;
import Modelo.TragamonedasTres;
import Modelo.Usuario;

public class VistaConsola {
	/*
	 * Los metodos estaticos permiten que el programa puede hacer uso de ellos sin
	 * necesidad de instanciar un objeto de la clase que los contiene. Los atributos
	 * deben ser estaticos para poder almacenar datos de los metodos estáticos.
	 * 
	 * Controladores permiten encapsular los modelos, clases del programa, de la
	 * vista donde interactua el usuario.
	 */
	private static ControladorTragamonedasTres tragamonedasTresA = new ControladorTragamonedasTres(
			new TragamonedasTres(90000.00f));
	private static ControladorTragamonedasCinco tragamonedasCincoA = new ControladorTragamonedasCinco(new TragamonedasCinco(180000.00f));
	private static ControladorCaja miCaja = new ControladorCaja(new Caja());
	private static Scanner ingresoDeDatos = new Scanner(System.in);
	private static String respuesta;
	private static Usuario miUsuario = new Usuario(50000.00f);
	private static Comprobante nuevo = null;
	private static Fruta frutilla = new Fruta("FRUTILLA");
	private static Fruta banana = new Fruta("BANANA");
	private static Fruta guinda = new Fruta("GUINDA");
	private static Fruta manzana = new Fruta("MANZANA");
	private static Fruta sandia = new Fruta("SANDIA");
	private static Fruta uva = new Fruta("UVA");
	private static Fruta pera = new Fruta("PERA");
	private static PremioTres premioA = new PremioTres(frutilla, frutilla, frutilla, 500);
	private static PremioTres premioB = new PremioTres(frutilla, frutilla, pera, 100);
	private static PremioTres premioC = new PremioTres(frutilla, frutilla, uva, 250);
	private static PremioTres premioD = new PremioTres(pera, pera, uva, 50);
	private static PremioCinco premioE = new PremioCinco(frutilla, frutilla, frutilla, frutilla, frutilla, 8000);
	private static PremioCinco premioF = new PremioCinco(frutilla, frutilla, frutilla, frutilla, pera, 6500);
	private static PremioCinco premioG = new PremioCinco(frutilla, frutilla, frutilla, frutilla, uva, 2150);
	private static PremioCinco premioH = new PremioCinco(pera, pera, pera, pera, uva, 500);
	private static ControladorTragamonedas elegido;

	public static void inicio() {
		/*
		 * reemplazar con GUI que muestre tres botones: "comprar credito", "jugar" y
		 * "retirar dinero".
		 */
			try {
				System.out.println("Elija una opción\n1.comprar crédito\n2.jugar\n3.retirar dinero por caja");
				System.out.print("respuesta:");
				respuesta = ingresoDeDatos.nextLine();
				if (respuesta.equals("1")) {
					ingresarMonto();
				} else if (respuesta.equals("2")) {
					elegirMaquina();
				} else if (respuesta.equals("3")) {
					cobrar();
				} else {
					System.out.println("La opción ingresada es inválidad, vuelva a intentarlo");
					inicio();
				}
			} catch (Exception e) {
				System.out.println("La opción ingresada es inválidad, vuelva a intentarlo");
				inicio();
			}
	}

	private static void cobrar() {
		/*
		 * reemplazar con GUI que muestre un campo de texto con una etiquita "ingrese
		 * nro de comprobante" y un boton "aceptar".
		 */
		System.out.println("Indique el número de su comprobante a cobrar");
		System.out.print("respuesta:");
		respuesta = ingresoDeDatos.nextLine();
		try {
			int nro = Integer.valueOf(respuesta);
			float saldoRecibido = miCaja.pagar(miUsuario, nro);
			if (saldoRecibido > 0) {
				System.out.println("Cobró $" + saldoRecibido);
				inicio();
			} else {
				System.out.println("El número de comprobante es inválido o ya fue cobrado");
				volverAIntentar();
			}
		} catch (Exception e) {
			System.out.println("La opción ingresada es inválidad, vuelva a intentarlo");
			cobrar();
		}
	}

	private static boolean volverAIntentar() {
		/*
		 * GUI motrar mensaje "El comprobante ingresado es invalido, ¿desea volver a
		 * ingresar?" y dos botones "aceptar" y "cancelar".
		 */
		boolean validado = false;
		while (!validado) {
			System.out.println("¿Desea volver a intentar?\n1.si\n2.no");
			System.out.print("respuesta:");
			respuesta = ingresoDeDatos.nextLine();
			if (respuesta.equals("1")) {
				validado = true;
				cobrar();
			} else if (respuesta.equals("2")) {
				validado = true;
				inicio();
			} else {
				System.out.println("La opción ingresada es inválidad, vuelva a intentarlo");
				volverAIntentar();
			}
		}
		return validado;

	}

	public static void elegirMaquina() {
		/*
		 * reemplazar con GUI que muestre una lista de maquina, se puede elegir un item
		 * y que contenga un boton aceptar.
		 */
		System.out.println("Elija su tragamonedas favorito\n1.De tres casilleros\n2.De cinco casilleros");
		System.out.print("respuesta:");
		respuesta = ingresoDeDatos.nextLine();
		if (respuesta.equals("1")) {
			elegido = tragamonedasTresA;
			mostrarDetallesDeMaquinaElegida();
			ingresarNroDeComprobante();
		} else if (respuesta.equals("2")) {
			
			elegido = tragamonedasCincoA;
			mostrarDetallesDeMaquinaElegida();
			ingresarNroDeComprobante();
		} else {
			System.out.println("La opción ingresada es inválidad, vuelva a intentarlo");
			elegirMaquina();
		}
	}

	public static void ingresarMonto() {
		/*
		 * reemplazar con GUI que muestre un campo de texto, una etiqueta "ingrese la
		 * cantidad de credito a comprar", un boton aceptar y otro limpiar.
		 */
		System.out.println("Ingrese cantidad de credito a comprar");
		System.out.print("respuesta:");
		respuesta = ingresoDeDatos.nextLine();
		try {
			float cantidad = Float.valueOf(respuesta);
			nuevo = miCaja.venderCredito(miUsuario, cantidad);
			if (nuevo != null) {
				mostrarDetallesDeComprobante();
				inicio();
			} else {
				System.out.println("No tiene suficiente dinero para comprar $" + cantidad + " en crédito.");
				inicio();
			}
		} catch (Exception e) {
			System.out.println("El monto ingresado es inválido, vuelva a intentarlo");
			ingresarMonto();
		}
	}

	public static void ingresarNroDeComprobante() {
		/*
		 * reemplazar con GUI que muestre un campo de texto, una etiquieta "ingrese
		 * comprobante", un boton aceptar.
		 */
		System.out.println("Ingrese número de comprobante");
		System.out.print("respuesta:");
		respuesta = ingresoDeDatos.nextLine();
		try {
			int nro = Integer.valueOf(respuesta);
			if (elegido.ingresarCredito(nro)) {
				nuevo=miCaja.getComprobante(nro);
				String resultado = elegido.jugar();
				if (resultado == "") {
					System.out.println("Saldo insuficiente, cobre su ticket y vuelva a comprar crédito");
				} else {
					System.out.println(resultado);
				}
				
				seguirJugando();

			} else {
				System.out.println("Número de comprobante inválido o fue cobrado\n¡Compre crédito y vuelva pronto!");
				inicio();
			}
		} catch (Exception e) {
			System.out.println("Dato ingresado es inválido, vuelva a intentarlo");
			ingresarNroDeComprobante();
		}
	}

	public static void seguirJugando() {
		/*
		 * reemplazar con GUI que muestre un mensaje "¿desea continuar jugando?" y dos
		 * botones "si" y "no"
		 */
		boolean seguir = true;
		while (seguir) {
			mostrarDetallesDeComprobante();
			System.out.println("¿Quiere seguir jugando?\n1.si\n2.no");
			System.out.print("respuesta:");
			respuesta = ingresoDeDatos.nextLine();
			if (respuesta.equals("1")) {
				String resultado = elegido.jugar();
				if (resultado == "") {
					System.out.println("Saldo insuficiente, cobre su ticket y vuelva a comprar crédito");
					cobrar();
				} else {
					System.out.println(resultado);
				}
			} else if (respuesta.equals("2")) {
				inicio();
			} else {
				System.out.println("La opción ingresada es inválidad, vuelva a intentarlo");
				seguirJugando();
			}

		}
	}

	public static void mostrarDetallesDeMaquinaElegida() {
		/*
		 * reemplazar con mensaje que muestre info de la maquina elegida y un boton
		 * "aceptar"
		 */
		System.out.println("valor de apuesta: $" + elegido.getValorDeApuesta());
		System.out.println("Pozo acumulado: $"+elegido.getRecaudacion());
		System.out.println("premios:\n" + elegido.mostrarPremios());
	}
	public static void mostrarDetallesDeComprobante() {
		System.out.println(nuevo.getInfo());
	}

	public static void configurarTragamonedas() {
		tragamonedasTresA.agregarPremio(premioA);
		tragamonedasTresA.agregarPremio(premioB);
		tragamonedasTresA.agregarPremio(premioC);
		tragamonedasTresA.agregarPremio(premioD);
		tragamonedasCincoA.agregarPremio(premioE);
		tragamonedasCincoA.agregarPremio(premioF);
		tragamonedasCincoA.agregarPremio(premioG);
		tragamonedasCincoA.agregarPremio(premioH);
		tragamonedasTresA.setCaja(miCaja.getCaja());
		tragamonedasTresA.setValorDeApuesta(120);
		tragamonedasCincoA.setCaja(miCaja.getCaja());
		tragamonedasCincoA.setValorDeApuesta(150);
	}

	public static void main(String[] args) {
		configurarTragamonedas();
		inicio();		
	}

}

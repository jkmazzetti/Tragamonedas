package Modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Tragamonedas {
	/*
	 * Los atributos protegidos son privados para las clases externas, sin embargo a
	 * las clases hijas les premite poder acceder sin necesidad de generar getters o
	 * setters
	 */
	private float recaudacion = 0.00f;
	private float recaudacionMinima = 0.00f;
	protected List<Premio> premios = new ArrayList<Premio>();
	private int valorDeApuesta;
	protected int cantidadDeCasillas;
	private Comprobante saldoDelJugador = null;
	private Caja caja = null;

	public Tragamonedas(float montoInicial) {
		this.recaudacion = montoInicial;
	}

//Validamos que el comprobante exista y que no haya sido cobrado previamente para evitar jugar sin dinero.
	public boolean ingresarCredito(int nroComprobante) {
		boolean nroCorrecto = false;
		this.saldoDelJugador = this.caja.getComprobante(nroComprobante);
		if (this.saldoDelJugador != null && !this.saldoDelJugador.fueCobrado()) {
			nroCorrecto = true;
		}
		return nroCorrecto;
	}

//Settea caja recaudadora para consultar comprobantes y actualizarlos.
	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public void setValorDeApuesta(int valorDeApuesta) {
		this.valorDeApuesta = valorDeApuesta;
	}

//Verifica que la combinacion de frutas del premio coincida con la combinación aleatoria y devuelve el resultado del tiro.
	public String jugar() {
		String resultado = "";
		boolean gano = false;
		if (this.saldoDelJugador != null && this.saldoDelJugador.getSaldo() >= this.valorDeApuesta) {
			String combinacionGenerada = this.generarCombinacion();
			for (int i = 0; i < this.premios.size() && !gano; i++) {
				if (this.premios.get(i).getCombinacion().equals(combinacionGenerada)) {
					float montoAPagar = this.premios.get(i).getMonto();
					gano = true;
					resultado = combinacionGenerada + ",Ganó $" + montoAPagar;
					this.pagar(montoAPagar);
					this.recaudacion -= this.valorDeApuesta;
				}
			}
			if (!gano) {
				resultado = combinacionGenerada + ",Perdió $" + this.valorDeApuesta;
				this.saldoDelJugador.descontarSaldo(valorDeApuesta);
				this.recaudacion += this.valorDeApuesta;
			}
		}
		return resultado;
	}

//Descuenta dinero de la recaudacion de la maquina e ingresa lo ganado al comprobante para seguir jugando o retirar por caja.
	private void pagar(float monto) {
		this.recaudacion -= monto;
		this.saldoDelJugador.agregarSaldo(monto);
	}

	public void setRecaudacionMinima(float minima) {
		this.recaudacionMinima = minima;
	}

	public String alertar() {
		String alerta = "";
		if (this.recaudacion <= recaudacionMinima) {
			alerta = "No hay fondos suficientes y es posible que los próximos premios no se puedan pagar.";
		}
		return alerta;
	}

	private String generarCombinacion() {
		Fruta frutas[] = new Fruta[] { new Fruta("BANANA"), new Fruta("FRUTILLA"), new Fruta("GUINDA"),
				new Fruta("MANZANA"), new Fruta("SANDIA"), new Fruta("UVA"), new Fruta("PERA") };
		String cambinacion = "";
		int min = 0, max = frutas.length - 1, frutaAleatoria;
		for (int i = 0; i < this.cantidadDeCasillas; i++) {
			frutaAleatoria = min + (int) (Math.random() * ((max - min) + 1));
			if (i < this.cantidadDeCasillas - 1) {
				cambinacion += frutas[frutaAleatoria].getNombre() + "-";
			} else {
				cambinacion += frutas[frutaAleatoria].getNombre();
			}
		}

		return cambinacion;
	}

	public String mostrarPremios() {
		String premios = "";
		for (int i = 0; i < this.premios.size(); i++) {
			if (i < this.premios.size() - 1) {
				premios += this.premios.get(i).getCombinacion() + ": $" + this.premios.get(i).getMonto() + "\n";
			} else {
				premios += this.premios.get(i).getCombinacion() + ": $" + this.premios.get(i).getMonto();
			}
		}
		return premios;
	}

	public int getValorDeApuesta() {
		return this.valorDeApuesta;
	}

//Metodos abstractos que deben definirse en las clases concretas.
	public abstract void agregarPremio(Premio premio);

	public abstract void quitarPremio(Premio premio);

	public float getRecaudacion() {
		return this.recaudacion;
	}

}

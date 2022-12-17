package Controladores;

import Modelo.Caja;
import Modelo.Premio;
import Modelo.Tragamonedas;

/*
 * Todas las clases que derivan de Tragamonedas son del mismo tipo.
 * TragamonedasTres es tambien del tipo Tragamonedas, por ejemplo.
 */
public abstract class ControladorTragamonedas {
	protected Tragamonedas tragamonedas = null;

	// Recibe los parametros y se los pasa a la clase que controla, hace de
	// intermediario.
	public boolean ingresarCredito(int nroComprobante) {
		return this.tragamonedas.ingresarCredito(nroComprobante);
	}

	public void setCaja(Caja caja) {
		this.tragamonedas.setCaja(caja);
	}

	public void setValorDeApuesta(int valorDeApuesta) {
		this.tragamonedas.setValorDeApuesta(valorDeApuesta);
	}

	public String jugar() {
		return this.tragamonedas.jugar();
	}

	public void setRecaudacionMinima(float minima) {
		this.tragamonedas.setRecaudacionMinima(minima);
	}

	public String alertar() {
		return this.tragamonedas.alertar();
	}

	public String mostrarPremios() {
		return this.tragamonedas.mostrarPremios();
	}

	public int getValorDeApuesta() {
		return this.tragamonedas.getValorDeApuesta();
	}

	public void agregarPremio(Premio premio) {
		this.tragamonedas.agregarPremio(premio);
	}

	public void quitarPremio(Premio premio) {
		this.tragamonedas.agregarPremio(premio);
	}

	public float getRecaudacion() {
		return this.tragamonedas.getRecaudacion();
	}

}

package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Caja {
	private Map<Integer, Comprobante> comprobantesRegistrados = new TreeMap<Integer, Comprobante>(); // clave nro de comprobate y valor comprobante.
	private float saldo = 0.00f; // inicialmente tiene 0.0$
	private static int ultimoComprobanteEmitido = 1000; // "recuerda" cual fue el ultimo pero comienza por el 1000.

	public Comprobante venderCredito(Usuario usuario, float monto) {
		Comprobante nuevo = null;
		if (usuario.getDinero() >= monto) {
			this.recaudarMonto(monto);
			nuevo = this.emitirComprobante(monto);
			usuario.darDinero(monto);
		}
		return nuevo;

	}

	private void recaudarMonto(float monto) {
		this.saldo += monto;
	}

	private Comprobante emitirComprobante(float monto) {
		int numeroDeComprobante = generarCodigoAleatorio();
		Comprobante nuevoComprobante = null;
		boolean contenido = false;
		while (!contenido && this.comprobantesRegistrados.size() < 8999) {
			if (!this.comprobantesRegistrados.containsKey(numeroDeComprobante)) {
				nuevoComprobante = new Comprobante(numeroDeComprobante, monto);
				this.comprobantesRegistrados.put(numeroDeComprobante, nuevoComprobante);
				contenido = true;
			} else {
				numeroDeComprobante = generarCodigoAleatorio();
			}
		}
		return nuevoComprobante;
	}

	public Comprobante getComprobante(int nro) {

		return (Comprobante) this.comprobantesRegistrados.get(nro);
	}

	public float pagar(Usuario usuario, int nro) {
		float aPagar = 0.00f;
		Comprobante buscado = (Comprobante) this.comprobantesRegistrados.get(nro);
		if (buscado != null && !buscado.fueCobrado()) {
			aPagar = buscado.getSaldo(); // Verfica el saldo a pagar.
			buscado.cobrar(); // Settea comprobante como pagado
			usuario.recibirDinero(aPagar); // le da al usuario el dinero indicado en el comprobante.
			this.saldo -= aPagar; // resta de la caja el monto que pagó al usuarios.
		}
		return aPagar;
	}

	private int generarCodigoAleatorio() {
		int min = 1000, max = 9999;
		return (min + (int) (Math.random() * ((max - min) + 1)));
	}
}

package Controladores;

import Modelo.Caja;
import Modelo.Comprobante;
import Modelo.Usuario;

public class ControladorCaja {
	private Caja caja = null;

	public ControladorCaja(Caja caja) {
		this.caja = caja;
	}
	public Comprobante venderCredito(Usuario usuario, float monto) {
		return this.caja.venderCredito(usuario, monto);
	}

	public Comprobante getComprobante(int nro) {
		return this.caja.getComprobante(nro);
	}

	public float pagar(Usuario usuario, int nroComprobante) {
		return this.caja.pagar(usuario, nroComprobante);
	}
	public Caja getCaja() {
		return this.caja;
	}
}

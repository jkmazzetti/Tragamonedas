package Modelo;

public class Usuario {
	private float dinero;
	public Usuario(float dinero) {
		this.dinero=dinero;
	}
	public void recibirDinero(float dinero) {
		this.dinero+=dinero;
	}
	public float darDinero(float dineroADar) {
		float dinero=0.00f;
		if(dineroADar<=this.dinero) {
			dinero=dineroADar;
			this.dinero-=dineroADar;
		}
		return dinero;
	}
	public float getDinero() {
		return this.dinero;
	}
}

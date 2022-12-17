package Modelo;

public class Comprobante {
	private int nro;
	private float saldo = 0.0f;
	private boolean cobrado = false;

	public Comprobante(int nro, float monto) {
		this.nro = nro;
		this.saldo = monto;
	}

	public void agregarSaldo(float monto) {
		this.saldo += monto;
	}

	public void descontarSaldo(float apuesta) {
		this.saldo -= apuesta;
	}

	public void cobrar() {
		if (!this.cobrado) {
			this.cobrado = true;
		}
	}

	public int getNRO() {
		return this.nro;
	}

	public String getInfo() {
		String estado = "";
		if (!this.cobrado) {
			estado = "a cobrar";
		} else {
			estado = "cobrado";
		}
		return "Detalles del comprobante\nNúmero:" + this.nro + "\nSaldo: $" + this.saldo + " \nEstado: " + estado;
	}

	public boolean fueCobrado() {
		return this.cobrado;
	}

	public float getSaldo() {
		return this.saldo;
	}
	
}

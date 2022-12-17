package Modelo;
import java.util.ArrayList;
import java.util.List;

public abstract class Premio {
	protected List<Fruta> combinacionFrutas=new ArrayList<Fruta>();
	protected int monto = 0;
	protected int cantidadDeCasillas;

	public String getCombinacion() {
		String combinacion = "";
		for (int i = 0; i < this.combinacionFrutas.size(); i++) {
			if (i < this.combinacionFrutas.size() - 1) {
				combinacion += this.combinacionFrutas.get(i).getNombre() + "-";// arma un string con cadenas separada con -
			} else {
				combinacion += this.combinacionFrutas.get(i).getNombre();
			}
		}
		return combinacion;
	}

	public float getMonto() {
		return this.monto;
	}

	public int getCantidadDeCasillas() {
		return this.cantidadDeCasillas;
	}

}

package Modelo;

public class PremioTres extends Premio {
	public PremioTres(Fruta primera, Fruta segunda, Fruta tercera, int monto) {
		this.combinacionFrutas.add(primera);
		this.combinacionFrutas.add(segunda);
		this.combinacionFrutas.add(tercera);
		this.cantidadDeCasillas = 3;
		this.monto = monto;
	}
}

package Modelo;

public class PremioCinco extends Premio {
	public PremioCinco(Fruta primera, Fruta segunda, Fruta tercera, Fruta cuarta, Fruta quita, int monto) {
		this.combinacionFrutas.add(primera);
		this.combinacionFrutas.add(segunda);
		this.combinacionFrutas.add(tercera);
		this.combinacionFrutas.add(cuarta);
		this.combinacionFrutas.add(quita);
		this.cantidadDeCasillas = 5;
		this.monto = monto;
	}
}

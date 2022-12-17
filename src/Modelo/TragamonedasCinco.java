package Modelo;

public class TragamonedasCinco extends Tragamonedas {

	public TragamonedasCinco(float montoInicial) {
		super(montoInicial);
		this.cantidadDeCasillas = 5;
	}

	@Override
	/*
	 * Solo se podrán agregar premios de cinco casillas puesto que la tragamonedas
	 * es de 5 casilleros.
	 */
	public void agregarPremio(Premio premio) {
		boolean encontrado = false;
		if (premio.getCantidadDeCasillas() == 5) {
			for (int i = 0; i < this.premios.size() && !encontrado; i++) {
				if (this.premios.get(i).getCombinacion() == premio.getCombinacion()) {
					encontrado = true;
				}

			}

			// si no fue encontrado, lo agrega a la lista de premios.
			if (!encontrado) {
				this.premios.add(premio);
			}
		}

	}

	@Override
	public void quitarPremio(Premio premio) {
		boolean encontrado = false;
		if (premio.getCantidadDeCasillas() == 5) {
			for (int i = 0; i < this.premios.size() && !encontrado; i++) {
				if (this.premios.get(i).getCombinacion() == premio.getCombinacion()) {
					encontrado = true;
					this.premios.remove(i);// fue encontrado por lo que será removido y deja de iterar.
				}

			}
		}

	}

}

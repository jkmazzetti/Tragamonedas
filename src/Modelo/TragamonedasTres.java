package Modelo;
/*
 * La clase TragamonedasTres es hija de Tragamonedas.
 */
public class TragamonedasTres extends Tragamonedas {

	public TragamonedasTres(float montoInicial) {
		super(montoInicial);
		this.cantidadDeCasillas = 3;
	}

	@Override
	/*
	 * Solo se podrán agregar premios de tres casillas puesto que la tragamonedas es
	 * de 3 casilleros.
	 */
	public void agregarPremio(Premio premio) {
		boolean encontrado = false;
		if (premio.getCantidadDeCasillas() == 3) {
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
		if (premio.getCantidadDeCasillas() == 3) {
			for (int i = 0; i < this.premios.size() && !encontrado; i++) {
				if (this.premios.get(i).getCombinacion() == premio.getCombinacion()) {
					encontrado = true;
					this.premios.remove(i);// fue encontrado por lo que será removido y deja de iterar.
				}

			}
		}

	}

}

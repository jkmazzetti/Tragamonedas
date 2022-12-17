package Vista;

import Controladores.ControladorCaja;
import Controladores.ControladorTragamonedasCinco;
import Controladores.ControladorTragamonedasTres;
import Modelo.Caja;
import Modelo.Fruta;
import Modelo.PremioCinco;
import Modelo.PremioTres;
import Modelo.TragamonedasCinco;
import Modelo.TragamonedasTres;
import Modelo.Usuario;

public class GUI {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	Fruta frutilla = new Fruta("FRUTILLA");
	Fruta banana = new Fruta("BANANA");
	Fruta guinda = new Fruta("GUINDA");
	Fruta manzana = new Fruta("MANZANA");
	Fruta sandia = new Fruta("SANDIA");
	Fruta uva = new Fruta("UVA");
	Fruta pera = new Fruta("PERA");
	PremioTres premioA = new PremioTres(frutilla, frutilla, frutilla, 500);
	PremioTres premioB = new PremioTres(frutilla, frutilla, pera, 100);
	PremioTres premioC = new PremioTres(frutilla, frutilla, uva, 250);
	PremioTres premioD = new PremioTres(pera, pera, uva, 50);
	PremioCinco premioE = new PremioCinco(frutilla, frutilla, frutilla, frutilla, frutilla, 8000);
	PremioCinco premioF = new PremioCinco(frutilla, frutilla, frutilla, frutilla, pera, 6500);
	PremioCinco premioG = new PremioCinco(frutilla, frutilla, frutilla, frutilla, uva, 2150);
	PremioCinco premioH = new PremioCinco(pera, pera, pera, pera, uva, 500);
	Usuario miUsuario = new Usuario(100000.00f);
	ControladorCaja caja = new ControladorCaja(new Caja());
	ControladorTragamonedasTres tragamonedasTres=new ControladorTragamonedasTres(new TragamonedasTres(95500.00f));
	ControladorTragamonedasCinco tragamonedasCinco=new ControladorTragamonedasCinco(new TragamonedasCinco(150000.00f));
	GraficaCaja graficaCaja=new GraficaCaja(caja, miUsuario);		
	tragamonedasTres.agregarPremio(premioA);
	tragamonedasTres.agregarPremio(premioB);
	tragamonedasTres.agregarPremio(premioC);
	tragamonedasTres.agregarPremio(premioD);
	tragamonedasTres.setValorDeApuesta(225);
	tragamonedasTres.setCaja(caja.getCaja());
	tragamonedasCinco.agregarPremio(premioE);
	tragamonedasCinco.agregarPremio(premioF);
	tragamonedasCinco.agregarPremio(premioG);
	tragamonedasCinco.agregarPremio(premioH);
	tragamonedasCinco.setValorDeApuesta(500);
	tragamonedasCinco.setCaja(caja.getCaja());
	GraficaMaquinaTres maquinaTres = new GraficaMaquinaTres(caja, tragamonedasTres, graficaCaja);
	GraficaMaquinaCinco maquinaCinco = new GraficaMaquinaCinco(caja, tragamonedasCinco, graficaCaja);
	SeleccionDeMaquina graficaSeleccionDeMaquina = new SeleccionDeMaquina(maquinaTres, maquinaCinco);
	Principal juego = new Principal(graficaCaja, graficaSeleccionDeMaquina);
		juego.show();
	}
}

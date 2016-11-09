package uva.poo.entrega1;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class prueba {

	public static void main(String[] args) {
		
		TarjetaMonedero borja = new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		MaquinaVending 	sen = new MaquinaVending(5,5);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		System.out.println(sen.getCantidad());
		//sen.añadirUnProducto(polloAlLimon, 2);
		//System.out.println(sen.filaLlena(3));
	}

}
	
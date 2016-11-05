package uva.poo.entrega1;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class prueba {

	public static void main(String[] args) {
		
		TarjetaMonedero borja = new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		MaquinaVending 	sen = new MaquinaVending(5,5);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		//prueba del git para pajero y miguel se ha hecho otro
		sen.añadirVariosProductos(polloAlLimon, 0, 10);
		//System.out.println(borja.getSaldoActual());
		//sen.añadirUnProducto(polloAlLimon,0);
		//System.out.println(sen.getProducto(0).toString());
		//System.out.println(sen.getSizeMaq());
		//System.out.println(sen.getSizeFil(0));
		//sen.removeOne(0);
		//System.out.println(sen.getProducto(0).toString());
		System.out.println(sen.getSizeFil(0));
		System.out.println("Cuanto cuesta?");
		System.out.println(sen.precio(0)+" euros");
		System.out.println("Dame uno");
		sen.comprar(0, borja);
		System.out.println(sen.getSizeFil(0));
		}

}
	
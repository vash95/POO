package uva.poo.entrega1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class prueba {

	public static void main(String[] args) {
		
		TarjetaMonedero borja = new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		MaquinaVending 	sen = new MaquinaVending(5,5);
		MaquinaVending maquinola= new MaquinaVending(2,3);
		ArrayList<ArrayList<Producto>> maquina1=new ArrayList<ArrayList<Producto>>(2);
		maquina1.add(maquinola.getFila(0));
		maquina1.add(maquinola.getFila(1));
		
		System.out.println(maquinola.getMaquina());
		System.out.println(maquina1);
		System.out.println();
		System.out.println();
		
	}

}
	
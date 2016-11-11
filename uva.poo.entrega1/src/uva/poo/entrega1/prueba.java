package uva.poo.entrega1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class prueba {

	public static void main(String[] args) {
		
		TarjetaMonedero borja = new TarjetaMonedero("A156Bv09_1zXo894",5.0);
		MaquinaVending 	sen = new MaquinaVending(5,5);
		
		sen.vaciarMaquina();
		System.out.println(sen.infoMaquina());
	}

}
	
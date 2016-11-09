package uva.poo.entrega1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestMaquinaVending {

	@Test
	public void testMaquinaVendingPorDefectoValida() {
		MaquinaVending m= new MaquinaVending();
		assertEquals(m.getTamMaquina(),1);
		assertEquals(m.getCantidad(),1);
	}
	@Test
	public void testMaquinaVendingInicializadaConTamañoValido() {
		MaquinaVending m= new MaquinaVending(10,10);
		assertEquals(m.getTamMaquina(),10);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingInicializadaConTamañoIvalidoCero() {
		MaquinaVending m= new MaquinaVending(0,10);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingInicializadaConTamañoIvalidoNegativo() {
		MaquinaVending m= new MaquinaVending(-1,10);
	}
	public void testMaquinaVendingInicializadaConCantidadValida() {
		MaquinaVending m= new MaquinaVending(10,10);
		assertEquals(m.getCantidad(),10);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingInicializadaConCantidadInvalidaCero() {
		MaquinaVending m= new MaquinaVending(10,0);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingInicializadaConCantidadInvalidaNegativa() {
		MaquinaVending m= new MaquinaVending(10,-1);
	}
	//Fin prueba constructor
	public void testFilaLlenaValida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto p= new Producto ("cosa",2.0,"12345678901");
		m.reponerFila(p,1);
		assertEquals(m.filaLlena(1),true);
	}
	@Test
	public void testReponerFila() {
		fail("Not yet implemented");
	}

	@Test
	public void testVaciarFila() {
		fail("Not yet implemented");
	}

	@Test
	public void testAñadirUnProducto() {
		fail("Not yet implemented");
	}

	@Test
	public void testAñadirVariosProductos() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuitaUno() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuitaVarios() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProducto() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrecioProducto() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSizeMaq() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSizeFil() {
		fail("Not yet implemented");
	}

	@Test
	public void testInfoMaquina() {
		fail("Not yet implemented");
	}

	@Test
	public void testComprar() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaquina() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFila() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTamMaquina() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCantidad() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMaquina() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFila() {
		fail("Not yet implemented");
	}

}

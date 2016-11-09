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
	@Test
	public void testMaquinaVendingInicializadaConCantidadValida() {
		MaquinaVending m= new MaquinaVending(1,1);
		assertEquals(1,m.getCantidad());
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingInicializadaConCantidadInvalidaCero() {
		MaquinaVending m= new MaquinaVending(10,0);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingInicializadaConCantidadInvalidaNegativa() {
		MaquinaVending m= new MaquinaVending(10,-1);
	}
	//Hata aqui el contructor bien
	@Test
	public void testMaquinaVendingSReponerFilaProductoValido() {
		MaquinaVending m= new MaquinaVending(10,10);
	}
}
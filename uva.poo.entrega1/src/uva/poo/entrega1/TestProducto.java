package uva.poo.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProducto {

	@Test
	public void testProductoSinIncializarlo() {
		Producto p = new Producto ();
		assertEquals(p.getNombre(),null);
		assertEquals(p.getUpc(),null);
		assertEquals(0.0, p.getPrecio(), 0.1);
	}
	@Test
	public void testProductoInicializadoConNombreValido() {
		Producto p = new Producto ("hola",1.0,"12345678901");
		assertEquals(p.getNombre(),"hola");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInicializadoConNombreInvalido() {
		Producto p = new Producto (null,-1.0,"12345678901");
	}
	@Test
	public void testProductoInicializadoConPrecio() {
		Producto p = new Producto ("hola",30.01,"12345678901");
		assertEquals(p.getPrecio(), 30.01 , 0.1);;
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInicializadoConPrecioInvalidoNegativo() {
		Producto p = new Producto ("hola",-1.0,"12345678901");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInicializadoConPrecioInvalidoCero() {
		Producto p = new Producto ("hola",0.0,"12345678901");
	}
	@Test
	public void testProductoInicializadoConUPCCorrecto() {
		Producto p = new Producto ("hola",1.0,"12345678901");
		assertEquals(p.getUpc(),"123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInicializadoConUPCTamaño() {
		Producto p = new Producto ("hola",1.0,"1234567890");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testProductoInicializadoConUPCCaracterNoValido() {
		Producto p = new Producto ("hola",1.0,"1234567890a");
	}
}

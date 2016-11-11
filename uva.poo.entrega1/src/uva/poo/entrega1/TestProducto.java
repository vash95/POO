package uva.poo.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProducto {

	@Test
	public void testInicializarProductoSinArgumentosValido() {
		Producto p = new Producto ();
		assertEquals(p.getNombre(),null);
		assertEquals(p.getUpc(),null);
		assertEquals(0.0, p.getPrecio(), 0.1);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarConNombreVariosEspacioVacio() {
		Producto p = new Producto ("     ",1.0,"123456789012");
	}
	@Test
	public void testInicializarProductoConNombreValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		assertEquals(p.getNombre(),"hola");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarProductoConNombreInvalidoNull() {
		Producto p = new Producto (null,1.0,"123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarProductoConNombreInvalidoVacio() {
		Producto p = new Producto ("",-1.0,"123456789012");
	}
	@Test
	public void testInicializarProductoConPrecioValido() {
		Producto p = new Producto ("hola",30.01,"123456789012");
		assertEquals(p.getPrecio(), 30.01 , 0.1);;
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarProductoConPrecioInvalidoNegativo() {
		Producto p = new Producto ("hola",-1.0,"123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarProductoConPrecioInvalidoCero() {
		Producto p = new Producto ("hola",0.0,"123456789012");
	}
	@Test
	public void testInicializarProductoUPCCorrecto() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		assertEquals(p.getUpc(),"123456789012");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarProductoUPCTamañoMenorDe12Invalido() {
		Producto p = new Producto ("hola",1.0,"12345678901");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarProductoUPCTamañoMayorDe12Invalido() {
		Producto p = new Producto ("hola",1.0,"1234567890123");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarProductoConUPCCaracterNoValido() {
		Producto p = new Producto ("hola",1.0,"12345678901a");
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializaProductoUPCNullInvalido() {
		String s=null;
		Producto p = new Producto ("hola",1.0,s);
	}
	@Test
	public void testGetNombreValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		assertEquals(p.getNombre(),"hola");
	}
	@Test
	public void testGetPrecioValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		assertEquals(p.getPrecio(),1.0,0.01);
	}
	@Test
	public void testProductoGetUpcValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		assertEquals(p.getUpc(),"123456789012");
	}
	@Test 
	public void testSetNombreValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setNombre("adios");
		assertEquals(p.getNombre(),"adios");
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testSetNombreInvalidoNull() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		String s=null;
		p.setNombre(s);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testSetNombreInvalidoVacio() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setNombre("");
	}
	@Test
	public void testSetPrecioValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setPrecio(2);
		assertEquals(p.getPrecio(),2,0.01);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testSetPrecioInvalidoNegativo() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setPrecio(-1.0);
	}
	@Test
	public void testSetUPCValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setUpc("123456789012");
		assertEquals(p.getUpc(),"123456789012");
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testSetUpcInvalidoNull() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		String s=null;
		p.setUpc(s);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testSetUpcInvalidoLongitudMenorA12() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setUpc("12345678901");
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testSetUpcInvalidoLongitudMayorA12() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setUpc("1234567890123");
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testSetUpcInvalidoCaracterInvalido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		p.setUpc("12345678901a");
	}
	@Test
	public void testToStringValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		String s="Nombre del producto: hola, precio: 1.0 euros, UPC: 123456789012";
		assertTrue(s.equals(p.toString()));
	}
	@Test
	public void testEqualsValido() {
		Producto p = new Producto ("hola",1.0,"123456789012");
		Producto q = new Producto ("hola",1.0,"123456789012");
		assertNotSame(p,q);
		assertTrue(q.equals(p));
	}
}

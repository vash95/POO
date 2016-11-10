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
	//Hasta aqui el contructor bien y hacer test de todos los servicios
	@Test
	public void testMaquinaVendingFilaLlenaValidaTrue() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.añadirVariosProductos(polloAlLimon, 0, 10);
		assertEquals(m.filaLlena(0), true);
	}
	@Test
	public void testMaquinaVendingFilaLlenaValidaFalse() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.añadirVariosProductos(polloAlLimon, 0, 9);
		assertEquals(m.filaLlena(0), false);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingFilaLlenaInvalida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.añadirVariosProductos(polloAlLimon, 0, 10);
		m.filaLlena(11);
	}
	@Test
	public void testMaquinaVendingReponerFilaInValida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.reponerFila(polloAlLimon, 0);
		assertEquals(m.getProductoPosicion(0, 9),polloAlLimon);
		assertTrue(m.getFila(0).size()==10);
	}	
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingReponerFilaInvalidaFila() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.reponerFila(polloAlLimon, 15);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingReponerFilaInvalidaFilaNegativa() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.reponerFila(polloAlLimon, -1);
	}
	
	@Test
	public void testMaquinaVendingVaciarFila() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.reponerFila(polloAlLimon, 0);
		m.vaciarFila(0);
		assertEquals(m.filaLlena(0), false);
		
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingVaciarFilaInvalido() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.reponerFila(polloAlLimon, 0);
		m.vaciarFila(0);
		assertEquals(m.filaLlena(15), false);
		
	}
	@Test
	public void testMaquinaVendingAñadirProducto() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.añadirUnProducto(polloAlLimon, 0);
		assertEquals(m.getProducto(0), polloAlLimon);
		
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirProductoVacio() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.añadirUnProducto(null, 0);
		
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirProductoFilainvalida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.añadirUnProducto(polloAlLimon, 11);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirProductoFilaLlena() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"80808080800");
		m.reponerFila(polloAlLimon, 0);
		m.añadirUnProducto(polloAlLimon, 0);
	}
}

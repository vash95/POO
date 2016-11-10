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
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirVariosProductos(polloAlLimon, 0, 10);
		assertEquals(m.filaLlena(0), true);
	}
	@Test
	public void testMaquinaVendingFilaLlenaValidaFalse() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirVariosProductos(polloAlLimon, 0, 9);
		assertEquals(m.filaLlena(0), false);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingFilaLlenaInvalida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirVariosProductos(polloAlLimon, 0, 10);
		m.filaLlena(11);
	}
	@Test
	public void testMaquinaVendingReponerFilaInValida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.reponerFila(polloAlLimon, 0);
		assertEquals(m.getProductoPosicion(0, 9),polloAlLimon);
		assertTrue(m.getFila(0).size()==10);
	}	
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingReponerFilaInvalidaFila() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.reponerFila(polloAlLimon, 15);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingReponerFilaInvalidaFilaNegativa() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.reponerFila(polloAlLimon, -1);
	}
	
	@Test
	public void testMaquinaVendingVaciarFila() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.reponerFila(polloAlLimon, 0);
		m.vaciarFila(0);
		assertEquals(m.filaLlena(0), false);
		
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingVaciarFilaInvalido() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.reponerFila(polloAlLimon, 0);
		m.vaciarFila(0);
		assertFalse(m.filaLlena(15));
		
	}
	@Test
	public void testMaquinaVendingAñadirProducto() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirUnProducto(polloAlLimon, 0);
		assertEquals(m.getProducto(0), polloAlLimon);
		
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirProductoVacio() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirUnProducto(null, 0);
		
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirProductoFilainvalida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirUnProducto(polloAlLimon, 11);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirProductoFilaLlena() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.reponerFila(polloAlLimon, 0);
		m.añadirUnProducto(polloAlLimon, 0);
	}
	@Test
	public void testMaquinaVendingAñadirVariosProductosValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 5);
		assertEquals(m.getProductoPosicion(0, 4),duero);
		assertEquals(m.getSizeFil(0),5);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirVariosProductosProductoNull(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero = null;
		m.añadirVariosProductos(duero, 0, 5);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirVariosProductosIndexNegativo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, -1, 5);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirVariosProductosIndexMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 11, 5);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirVariosProductosCantidadNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, -1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingAñadirVariosProductosCantidadMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 11);
	}
	@Test
	public void testMaquinaVendingQuitaUnoValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.quitaUno(0);
		assertTrue(m.getFila(0).isEmpty());
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingQuitaUnoInvalidoFilaNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.quitaUno(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingQuitaUnoInvalidoFilaMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.quitaUno(11);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingQuitaUnoInvalidoFilaVacia(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.quitaUno(1);
	}
	@Test 
	public void testMaquinaVendingQuitaVariosValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(0, 6);
		assertTrue(m.getFila(0).isEmpty());
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingQuitaVariosCantidadNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(0, -1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingQuitaVariosIndiceNegativo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(-1, 2);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingQuitaVariosIndiceMayorQueElMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(11, 2);
	}
	@Test 
	public void testMaquinaVendingGetProductoValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		assertEquals(duero, m.getProducto(0));
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingGetProductoIndiceInvalidoNegativo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.getProducto(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingGetProductoIndiceMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.getProducto(11);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingGetProductoEnFilaVacia(){
		MaquinaVending m= new MaquinaVending(10,10);
		m.getProducto(0);
	}
	@Test 
	public void testMaquinaVendingPrecioProductoValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		assertEquals(m.getProducto(0).getPrecio(),duero.getPrecio(),0.01);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingPrecioProductoInvalidoIndiceNegativo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.precioProducto(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingPrecioProductoInvalidoIndiceMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.precioProducto(11);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingPrecioProductoInvalidoEnFilaVacia(){
		MaquinaVending m= new MaquinaVending(10,10);
		m.precioProducto(0);
	}
	@Test 
	public void testMaquinaVendingGetSizeMaqValido(){
		MaquinaVending m= new MaquinaVending(10,1);
		assertEquals(m.getSizeMaq(),10);
	}
	@Test
	public void testMaquinaVendingGetSizeFilValido(){
		MaquinaVending m= new MaquinaVending(2,3);
		assertEquals(m.getSizeFil(0),0);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingGetSizeFilFilaNegativa(){
		MaquinaVending m= new MaquinaVending(2,3);
		m.getSizeFil(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testMaquinaVendingGetSizeFilFilaMayorALaMaxima(){
		MaquinaVending m= new MaquinaVending(2,3);
		m.getSizeFil(2);
	}
	@Test
	public void testMaquinaVendingInfoMaquinaValido(){
		MaquinaVending m= new MaquinaVending(2,3);
		Producto p=new Producto("nombre",1.0,"123456789012");
		m.añadirUnProducto(p, 1);
		String s="Hay 1 nombre en la fila 1 con un precio de 1.0 euros.\n";
		assertTrue(s.equals(m.infoMaquina()));
	}
	
	
}
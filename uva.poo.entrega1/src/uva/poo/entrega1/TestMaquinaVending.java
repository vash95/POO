package uva.poo.entrega1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class TestMaquinaVending {

	@Test
	public void testInicializarPorDefectoValida() {
		MaquinaVending m= new MaquinaVending();
		assertEquals(m.getTamMaquina(),1);
		assertEquals(m.getCantidad(),1);
	}
	@Test
	public void testInicializarValido() {
		MaquinaVending m= new MaquinaVending(10,10);
		assertEquals(m.getTamMaquina(),10);
		assertEquals(m.getCantidad(),10);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarConTamañoIvalidoCero() {
		MaquinaVending m= new MaquinaVending(0,10);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarConTamañoInvalidoNegativo() {
		MaquinaVending m= new MaquinaVending(-1,10);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarConCantidadInvalidaCero() {
		MaquinaVending m= new MaquinaVending(10,0);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testInicializarConCantidadInvalidaNegativa() {
		MaquinaVending m= new MaquinaVending(10,-1);
	}
	@Test
	public void testFilaLlenaValidaTrue() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirVariosProductos(polloAlLimon, 0, 10);
		assertEquals(m.filaLlena(0), true);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testFilaLlenaInvalidaMayorAlMaximo() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirVariosProductos(polloAlLimon, 0, 10);
		m.filaLlena(11);
	}
	public void testFilaLlenaInvalidaNegativa() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirVariosProductos(polloAlLimon, 0, 10);
		m.filaLlena(-1);
	}
	@Test
	public void testRellenarFilaValida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.rellenarFila(polloAlLimon, 0);
		assertEquals(m.getProductoPosicion(0, 9),polloAlLimon);
		assertTrue(m.getFila(0).size()==10);
	}	
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingRellenarFilaInvalidaFila() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.rellenarFila(polloAlLimon, 15);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingRellenarFilaInvalidaFilaNegativa() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.rellenarFila(polloAlLimon, -1);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testMaquinaVendingRellenarFilaInvalidaProductoNull() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = null;
		m.rellenarFila(polloAlLimon, 0);
	}
	@Test
	public void testReponerFilaValida() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirUnProducto(polloAlLimon, 0);
		m.reponerFila(0);
		assertEquals(m.getProductoPosicion(0, 9),polloAlLimon);
		assertTrue(m.getFila(0).size()==10);
	}	
	@Test(expected=java.lang.AssertionError.class)
	public void testRponerFilaInvalidaFilaMayorAlMaximo() {
		MaquinaVending m= new MaquinaVending(10,10);
		m.reponerFila(15);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testReponerFilaInvalidaFilaNegativa() {
		MaquinaVending m= new MaquinaVending(10,10);
		m.reponerFila(-1);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testReponerFilaInvalidaFilaVacia() {
		MaquinaVending m= new MaquinaVending(10,10);
		m.reponerFila(0);
	}
	@Test
	public void testVaciarMaquinaValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirVariosProductos(polloAlLimon, 0, 6);
		m.añadirVariosProductos(polloAlLimon, 9, 2);
		m.vaciarMaquina();
		assertTrue(m.getFila(0).isEmpty());
		assertTrue(m.getFila(9).isEmpty());
	}
	@Test
	public void testVaciarFilaValido() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.rellenarFila(polloAlLimon, 0);
		m.vaciarFila(0);
		assertFalse(m.filaLlena(0));
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVaciarFilaInvalidoFilaMayorAlMaximo() {
		MaquinaVending m= new MaquinaVending(10,10);
		assertFalse(m.filaLlena(15));
		
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testVaciarFilaInvalidoFilaMenorAlMaximo() {
		MaquinaVending m= new MaquinaVending(10,10);
		assertFalse(m.filaLlena(-1));
		
	}
	@Test
	public void testAñadirUnProductoValido() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirUnProducto(polloAlLimon, 0);
		assertEquals(m.getProducto(0), polloAlLimon);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testAñadirUnProductoNullInvalido() {
		MaquinaVending m= new MaquinaVending(10,10);
		m.añadirUnProducto(null, 0);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testAñadirUnProductoFilaInvalidaMayorAlMaximo() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.añadirUnProducto(polloAlLimon, 10);
	}
	@Test(expected=java.lang.AssertionError.class)
	public void testAñadirUnProductoFilaLlena() {
		MaquinaVending m= new MaquinaVending(10,10);
		Producto polloAlLimon = new Producto("Pollo al limón",5.0,"123456789012");
		m.rellenarFila(polloAlLimon, 0);
		m.añadirUnProducto(polloAlLimon, 0);
	}
	@Test
	public void testAñadirVariosProductosValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 5);
		assertEquals(m.getProductoPosicion(0, 4),duero);
		assertEquals(m.getSizeFil(0),5);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testAñadirVariosProductosInvalidoProductoNull(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero = null;
		m.añadirVariosProductos(duero, 0, 5);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testAñadirVariosProductosInvalidoFilaNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, -1, 5);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testAñadirVariosProductosFilaMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 10, 5);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testAñadirVariosProductosCantidadNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, -1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testAñadirVariosProductosCantidadMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 11);
	}
	@Test
	public void testQuitaUnoValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.quitaUno(0);
		assertTrue(m.getFila(0).isEmpty());
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testQuitaUnoInvalidoFilaNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.quitaUno(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testQuitaUnoInvalidoFilaMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.quitaUno(10);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testQuitaUnoInvalidoFilaVacia(){
		MaquinaVending m= new MaquinaVending(10,10);
		m.quitaUno(0);
	}
	@Test 
	public void testQuitaVariosValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(0, 6);
		assertTrue(m.getFila(0).isEmpty());
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testQuitaVariosCantidadNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(0, -1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testQuitaVariosInvalidoIndiceNegativo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(-1, 2);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testQuitaVariosInvalidoIndiceMayorQueElMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(11, 2);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testQuitaVariosInvalidoCantitadNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(0, -1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testQuitaVariosInvalidoCantidadMayorAlContenido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirVariosProductos(duero, 0, 6);
		m.quitaVarios(0, 7);
	}
	@Test 
	public void testGetProductoValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		assertEquals(duero, m.getProducto(0));
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetProductoIndiceInvalidoNegativo(){
		MaquinaVending m= new MaquinaVending(10,10);
		m.getProducto(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetProductoIndiceMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.getProducto(10);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetProductoEnFilaVacia(){
		MaquinaVending m= new MaquinaVending(10,10);
		m.getProducto(0);
	}
	@Test 
	public void testPrecioProductoValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		assertEquals(m.getProducto(0).getPrecio(),duero.getPrecio(),0.01);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testPrecioProductoInvalidoIndiceNegativo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.precioProducto(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testPrecioProductoInvalidoIndiceMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.precioProducto(11);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testPrecioProductoInvalidoEnFilaVacia(){
		MaquinaVending m= new MaquinaVending(10,10);
		m.precioProducto(0);
	}
	@Test 
	public void testNombreProductoValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		assertEquals(m.nombreProducto(0),"Duero");
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testNombreProductoInvalidoFilaNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.nombreProducto(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testNombreProductoInvalidoFilaMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.nombreProducto(10);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testNombreProductoInvalidoFilaVacia(){
		MaquinaVending m= new MaquinaVending(10,10);
		m.nombreProducto(0);
	}
	@Test 
	public void testUpcProductoValido(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		assertEquals(m.upcProducto(0),"123456789012");
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testUpcProductoInvalidoFilaNegativa(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.upcProducto(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testUpcProductoInvalidoFilaMayorAlMaximo(){
		MaquinaVending m= new MaquinaVending(10,10);
		Producto duero=new Producto("Duero",0.05,"123456789012");
		m.añadirUnProducto(duero, 0);
		m.upcProducto(10);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testUpcProductoInvalidoFilaVacia(){
		MaquinaVending m= new MaquinaVending(10,10);
		m.upcProducto(0);
	}
	@Test 
	public void testGetSizeMaqValido(){
		MaquinaVending m= new MaquinaVending(10,1);
		assertEquals(m.getSizeMaq(),10);
	}
	@Test
	public void testGetSizeFilValido(){
		MaquinaVending m= new MaquinaVending(2,3);
		assertEquals(m.getSizeFil(0),0);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetSizeFilFilaNegativa(){
		MaquinaVending m= new MaquinaVending(2,3);
		m.getSizeFil(-1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetSizeFilFilaMayorALaMaxima(){
		MaquinaVending m= new MaquinaVending(2,3);
		m.getSizeFil(2);
	}
	@Test
	public void testInfoMaquinaValido(){
		MaquinaVending m= new MaquinaVending(2,3);
		Producto p=new Producto("nombre",1.0,"123456789012");
		m.añadirUnProducto(p, 1);
		String s="Hay 1 nombre en la fila 1 con un precio de 1.0 euros.\n";
		assertTrue(s.equals(m.infoMaquina()));
	}
	@Test
	public void testComprarValido(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipasCaras= new Producto("pipas",20,"123456789012");
		maquinola.añadirUnProducto(pipasCaras,1);
		TarjetaMonedero visa= new TarjetaMonedero("A156Bv09_1zXo894",20.0);
		maquinola.comprar(1, visa);
		assertEquals(maquinola.getSizeFil(1),0);
		assertEquals(visa.getSaldoActual(),0,0.1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testComprarInvalidoProductoIndexNegativo(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipasCaras= new Producto("pipas",20,"123456789012");
		maquinola.añadirUnProducto(pipasCaras,1);
		TarjetaMonedero visa= new TarjetaMonedero("A156Bv09_1zXo894",20.0);
		maquinola.comprar(-1, visa);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testComprarInvalidoProductoIndexMayorAlMaximo(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipasCaras= new Producto("pipas",20,"123456789012");
		maquinola.añadirUnProducto(pipasCaras,1);
		TarjetaMonedero visa= new TarjetaMonedero("A156Bv09_1zXo894",20.0);
		maquinola.comprar(2, visa);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testComprarInvalidoFilaVacia(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		TarjetaMonedero visa= new TarjetaMonedero("A156Bv09_1zXo894",20.0);
		maquinola.comprar(0, visa);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testComprarInvalidoSaldoMenorQuePrecio(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipas= new Producto("pipas",2.0,"123456789012");
		TarjetaMonedero visa= new TarjetaMonedero("A156Bv09_1zXo894",1.0);
		maquinola.añadirUnProducto(pipas, 1);
		maquinola.comprar(1, visa);
	}
	@Test 
	public void testReponerTodoValido(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipas= new Producto("pipas",2.0,"123456789012");
		Producto patatas= new Producto("patatas",2.0,"123456789012");
		maquinola.añadirUnProducto(pipas, 0);
		maquinola.añadirUnProducto(patatas, 1);
		maquinola.reponerTodo();
		assertEquals(maquinola.getSizeFil(0),3);
		assertEquals(maquinola.getSizeFil(1),3);
	}
	@Test
	public void testGetProductoPosicionValido(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipas= new Producto("pipas",2.0,"123456789012");
		maquinola.añadirVariosProductos(pipas, 0, 2);
		assertEquals(maquinola.getProductoPosicion(1, 1),pipas);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetProductoPosicionInvalidoFilaNegativa(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipas= new Producto("pipas",2.0,"123456789012");
		maquinola.añadirUnProducto(pipas, 1);
		maquinola.getProductoPosicion(-1, 0);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetProductoPosicionInvalidoFilaMayorAlTamaño(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipas= new Producto("pipas",2.0,"123456789012");
		maquinola.añadirUnProducto(pipas, 1);
		maquinola.getProductoPosicion(3, 0);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetProductoPosicionInvalidoPosicionMayorACantidadMaxima(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipas= new Producto("pipas",2.0,"123456789012");
		maquinola.añadirUnProducto(pipas, 1);
		maquinola.getProductoPosicion(1, 4);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetProductoPosicionInvalidoPosicionNegativa(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		Producto pipas= new Producto("pipas",2.0,"123456789012");
		maquinola.añadirUnProducto(pipas, 1);
		maquinola.getProductoPosicion(1, -1);
	}
	@Test (expected=java.lang.AssertionError.class)
	public void testGetProductoPosicionInvalidoFilaVacia(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		maquinola.getProductoPosicion(0, 0);
	}
	@Test
	public void getCantidadValido(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		assertEquals(maquinola.getCantidad(), 3);
	}
	@Test
	public void getTamMaquinaValido(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		assertEquals(maquinola.getTamMaquina(), 2);
	}
	@Test
	public void getMaquinaValida(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		ArrayList<ArrayList<Producto>> maquina1=new ArrayList<ArrayList<Producto>>(2);
		for(int i=0;i<2;i++){
			maquina1.add(maquinola.getFila(i));
		}
		assertEquals(maquinola.getMaquina(),maquina1);
	}
	@Test
	public void getFilaValida(){
		MaquinaVending maquinola= new MaquinaVending(2,3);
		ArrayList<ArrayList<Producto>> maquina1 = new ArrayList<ArrayList<Producto>>(2);
		ArrayList<Producto> fila = new ArrayList<Producto>(3);
		maquina1.add(fila);
		assertEquals(maquinola.getFila(0), maquina1.get(0) );
	}
}
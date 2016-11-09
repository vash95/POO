package uva.poo.entrega1;
import java.util.ArrayList;

import fabricante.externo.tarjetas.TarjetaMonedero;
/**
 * Gestión de máquinas vending 
 * Estas máquinas contienen filas, y cada fila debe contener los mismos productos
 * Las filas tienen una cantidad máxima de productos
 * Facilita varios servicios relacionados con la gestión de los productos en la máquina de vending
 * @author Álvaro Benito Navarro
 * @author Miguel Gonzalez Bravo
 * @author Borja Rabadán Martín
 */
public class MaquinaVending {
	private ArrayList<ArrayList<Producto>> maquina ;
	private ArrayList<Producto> fila;
	private int tamMaquina;
	private int cantidad;
   /**
    * Inicializacion de la máquina de vending
    * Se tiene una maquina con una fila y una capacidad de un producto en dicha fila
    */
	public MaquinaVending(){
		tamMaquina = 1;
		cantidad = 1;
		maquina = new ArrayList<ArrayList<Producto>>(tamMaquina);
		fila = new ArrayList<Producto>(cantidad);
		maquina.add(fila);
	}
  /**
   * Inicialización con numero de filas y tamaño indicado por el cliente
   * @param tamMaquina int con el numero de filas de la máquina. debe ser positiva
   * @param cantidad in con la cantidad de productos que caben en la máquina. Debe ser positiva
   * @assert.pre tamMaquina>0
   * @assert.pre cantidad>0
   */
   public MaquinaVending(int tamMaquina, int cantidad){
	   	 assert(tamMaquina>0 && cantidad>0);
	     this.tamMaquina=tamMaquina;
	     this.cantidad=cantidad;
	     maquina=new ArrayList<ArrayList<Producto>>()	;
	     fila=new ArrayList<Producto>();
	     for(int i=0;i<tamMaquina;i++){
	       maquina.add((ArrayList<Producto>)fila.clone()); 
	     }
	   }
  /**
   * Informa con un boolean de si la fila indicada está llena o no
   * Devuelve true si está llena
   * @param index int del número de la fila
   * @return boolean true si la fila está llena
   */
   public boolean filaLlena(int index){
	   assert(index>=0 && index<getTamMaquina());
	   if(getSizeFil(index)==getCantidad()){
	     return true;
	   }else{
	   return false;}
   }
   /**
    * Llena la fila indicada con el producto dado
    * @param producto con el que rellenar la fila
    * @param index int del número de la fila
    */
   public void reponerFila(Producto producto,int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(producto!=null);
	   assert(!filaLlena(index));
	   while(!filaLlena(index)){
		   añadirUnProducto(producto, index);
	   }
   }
   /**
    * Vacía la fila indicada hasta dejarla sin productos
    * @param index int del número de la fila
    */
   public void vaciarFila(int index){
	   assert(index>=0 && index<getTamMaquina());
	   while(!getMaquina().get(index).isEmpty()){
		   quitaUno(index);
	   }
   }
   /**
    * Añade un producto indicado a la fila señalada de la máquina
    * El producto queda el último 
    * @param producto a añadir a la fila
    * @param index int del número de la fila
    */
   public void añadirUnProducto(Producto producto, int index){	
	 assert(producto!=null);
     assert(filaLlena(index)!=true);
     if(!getFila(index).isEmpty() && !producto.equals(getFila(index).get(0))){
	       vaciarFila(index);
	       getFila(index).add(producto);
		     }else{
		       getFila(index).add(producto);}
	   }
   
   /**
    * Indica un producto, una fila y una cantidad, para añadir un número determinado de esos productos a una fila
    * @param producto a añadir a la fila
    * @param index int del número de la fila
    * @param cantidad int de la cantidad de productos que quiere añadir
    */
   public void añadirVariosProductos(Producto producto , int index , int cantidad){
	   assert(producto!=null);
	   assert(index>=0 && index<getTamMaquina());
	   assert(cantidad>0);
	   for(int i =0;i<cantidad;i++){
		   añadirUnProducto(producto,index);
	   }
   }
   /**
    * Quita el primer producto de una fila indicada
    * @param index int del número de la fila
    */
   public void quitaUno(int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(getMaquina().get(index).isEmpty()!=true);
		   getMaquina().get(index).remove(0);
	   
   }
//este metodo necesita un comprobador de si esta vacia
   public void quitaVarios(int index , int cantidad){
	   assert(index>=0 && index<getTamMaquina());
	   assert(cantidad>0);
	   for(int i =0;i<cantidad;i++){
		   quitaUno(index);
	   }
   }
   /**
    * Devuelve el producto que hay en la fila indicada
    * Si la fila está vacía devuelve null
    * @param index int del número de la fila
    * @return pedido el Producto de la fila
    */
   public Producto getProducto(int index) {
	   assert(index>=0 && index<getTamMaquina());
	   assert(getMaquina().get(index).isEmpty()!=true);
	   Producto pedido =getMaquina().get(index).get(0);
		   return pedido;
   }
   /**
    * Informa del precio del Producto que hay en la fila indicada
    * @param index int del número de la fila
    * @return precioProducto double con el precio del producto de la fila
    */
   public double precioProducto(int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(getMaquina().get(index).isEmpty()!=true);
	   double precioProducto=getMaquina().get(index).get(0).getPrecio();
	   return precioProducto;
	  
   }
   /**
    * Devuelve el tamaño de la máquina, el número de filas que tiene
    * @return tam int con el número de filas
    */
   public int getSizeMaq(){
	   int tam=getMaquina().size();
	  return  tam;
   }
   /**
    * Devuelve el número de productos que hay en la fila indicada
    * @param index int del número de la fila
    * @return tamFil int con el número de productos 
    */
   public int getSizeFil(int index){
	   assert(index>=0 && index<getTamMaquina());
	   	int tamFil=getMaquina().get(index).size();
		  return  tamFil;
	   }
   /**
    * Devuelve un String con la información de la máquina (......rellenar..........)
    * @return info, String con la información
    */
   public String infoMaquina(){
	     String info="";
	     int cont=0;
	     for(int i=0;i<getTamMaquina();i++){
	       for(Producto E: getFila(i)){
	         cont++;
	       }
	       if(!getFila(i).isEmpty()){
	         info+="Hay "+cont+" "+getFila(i).get(0).getNombre()+" en la posicion "+i+"\n";
	         cont=0;
	       }
	     }
	     return info;
	   }
   //metodo comprar
   public void comprar(int index,TarjetaMonedero card){
	   assert(getProducto(index)!=null);
	   assert(card.getSaldoActual()<precioProducto(index));
	   card.descontarDelSaldo("6Z1y00Nm31aA-571", precioProducto(index));
	   quitaUno(index);
   }
   public void reponerTodo(){
	   Producto repuesto ;
	   for(int i=0;i<getTamMaquina();i++){
	       if(!getFila(i).isEmpty()){
	    	   while(getSizeFil(i)<getCantidad()){
	    		   	repuesto = getMaquina().get(i).get(0);
	    		    añadirUnProducto(repuesto, i);
	    	  }
	       }
	   }
   }
   
   
   public ArrayList<ArrayList<Producto>> getMaquina() {
	   return maquina;
   }

	public ArrayList<Producto> getFila(int index) {
		assert(index>=0 && index<getTamMaquina());
		return maquina.get(index);
	}

	public int getTamMaquina() {
		return tamMaquina;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setMaquina(ArrayList<ArrayList<Producto>> maquina) {
		assert(maquina!=null);
		this.maquina = maquina;
	}

	public void setFila(ArrayList<Producto> fila) {
		assert(fila!=null);
		this.fila = fila;
	}
   
} 
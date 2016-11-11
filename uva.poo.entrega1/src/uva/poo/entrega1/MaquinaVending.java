package uva.poo.entrega1;
import java.util.ArrayList;
import fabricante.externo.tarjetas.TarjetaMonedero;
/**
 * Gestión de máquinas vending.
 * Estas máquinas contienen filas, y cada fila debe contener los mismos productos
 * Las filas tienen una cantidad máxima de productos
 * Facilita varios servicios relacionados con la gestión de los productos en la máquina de vending
 * @author Álvaro Benito Navarro
 * @author Miguel Gonzalez Bravo
 * @author Borja Rabadán Martín
 */
public class MaquinaVending{
	private ArrayList<ArrayList<Producto>> maquina ;
	private ArrayList<Producto> fila;
	private int tamMaquina;
	private int cantidad;
   /**
    * Inicialización de la máquina de vending
    * Se tiene una máquina con una fila y una capacidad de un producto en dicha fila
    */
	public MaquinaVending(){
		tamMaquina = 1;
		cantidad = 1;
		maquina = new ArrayList<ArrayList<Producto>>(tamMaquina);
		fila = new ArrayList<Producto>(cantidad);
		maquina.add(fila);
	}
  /**
   * Inicialización con número de filas y tamaño indicado por el cliente
   * @param tamMaquina int con el número de filas de la máquina. Debe ser positiva
   * @param cantidad int con la cantidad de productos que caben en la máquina. Debe ser positiva
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
   * @assert.pre index>0
   * @assert.pre index<getTamMaquina()
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
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    * @assert.pre producto!=null
    * @assert.pre filaLlena(index)!=true
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
    * Si la fila está vacía inicialmente, no modificará nada
    * @param index int del número de la fila
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
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
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    * @assert.pre producto!=null
    * @assert.pre filaLlena(index)!=true
    */
   public void añadirUnProducto(Producto producto, int index){
	 assert(index>=0 && index<getTamMaquina());
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
    * @param producto Producto a añadir a la fila
    * @param index int del número de la fila
    * @param cantidad int de la cantidad de productos que se quiere añadir
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    * @assert.pre producto!=null
    * @assert.pre cantidad>0
    */
   public void añadirVariosProductos(Producto producto , int index , int cantidad){
	   assert(index>=0 && index<getTamMaquina());
	   assert(producto!=null);
	   assert(cantidad>0);
	   for(int i =0;i<cantidad;i++){
		   añadirUnProducto(producto,index);
	   }
   }
   /**
    * Quita el primer producto de una fila indicada
    * @param index int del número de la fila
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    * @assert.pre getMaquina().get(index).isEmpty()!=true
    */
   public void quitaUno(int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(getMaquina().get(index).isEmpty()!=true);
		   getMaquina().get(index).remove(0);
	   
   }
   /**
    * Quita de una fila indicada un número dado de productos
    * @param index int del número de la fila
    * @param cantidad int de la cantidad de productos que se quiere quitar
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    * @assert.pre cantidad>0
    */
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
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    * @assert.pre getMaquina().get(index).isEmpty()!=true
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
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    * @assert.pre getMaquina().get(index).isEmpty()!=true
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
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    */
   public int getSizeFil(int index){
	   assert(index>=0 && index<getTamMaquina());
	   int tamFil=getMaquina().get(index).size();
	   return  tamFil;
	   }
   /**
    * Devuelve un String con la información de la máquina (Producto, su precio y número de productos por cada fila)
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
	         info+="Hay "+cont+" "+getProducto(i).getNombre()+" en la fila "+i+" con un precio de "+precioProducto(i)+" euros."+"\n";
	         cont=0;
	       }
	     }
	     return info;
	   }
   /**
    * Permite comprar el primer producto de una fila de la máquina
    * @param index int del número de la fila
    * @param card Tarjeta con la que desea pagar
    * @assert.pre getProducto(index)!=null
    * @assert.pre card.getSaldoActual()<precioProducto(index)
    */
   public void comprar(int index,TarjetaMonedero card){
	   assert(getProducto(index)!=null);
	   assert(card.getSaldoActual()>=precioProducto(index));
	   card.descontarDelSaldo("6Z1y00Nm31aA-571", precioProducto(index));
	   quitaUno(index);
   }
   /**
    * Permite llenar todas las filas de la máquina de los productos que hay en ellas
    * Si una fila está vacía se queda vacía
    */
   public void reponerTodo(){
	   Producto repuesto;
	   for(int i=0;i<getTamMaquina();i++){
	       if(!getFila(i).isEmpty()){
	    		   	repuesto = getMaquina().get(i).get(0);
	    		   	reponerFila(repuesto, i);
	    	  }
	       }
	   }
   /**
    * Devuelve el producto que hay en una posición de la fila indicada
    * @param indexFila int del número de la fila
    * @param indexPosicion int con el número de la posición en la fila
    * @return pedido, Producto pedido
    * @assert.pre indexFila>0
    * @assert.pre indexFila<getTamMaquina()
    * @assert.pre getSizeFil(indexFila)
    */
   public Producto getProductoPosicion(int indexFila, int indexPosicion){
	   assert(indexFila>=0 && indexFila<getTamMaquina());
	   assert(indexPosicion<=getSizeFil(indexFila));
	   assert(getMaquina().get(indexFila).isEmpty()!=true);
	   Producto pedido = getFila(indexFila).get(indexPosicion);
	   return pedido;
   }
   /**
    * Devuelve la máquina de vending
    * @return maquina
    */
   public ArrayList<ArrayList<Producto>> getMaquina() {
	   return maquina;
   }
   /**
    * Devuelve la fila indicada
    * @param index int del número de la fila
    * @return maquina.get(index) La fila indicada de la máquina
    * @assert.pre index>0
    * @assert.pre index<getTamMaquina()
    */
	public ArrayList<Producto> getFila(int index) {
		assert(index>=0 && index<getTamMaquina());
		return getMaquina().get(index);
	}
	/**
	 * Devuelve el número de filas que tiene la máquina de vending
	 * @return tamMaquina int con el tamaño
	 */
	public int getTamMaquina() {
		return tamMaquina;
	}
	/**
	 * Devuelve la cantidad de productos que caben en una fila de la máquina de vending
	 * @return cantidad int con la cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
} 
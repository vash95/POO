package uva.poo.entrega1;
import java.util.ArrayList;
import fabricante.externo.tarjetas.TarjetaMonedero;
/**
 * Gestión de máquinas vending.
 * Estas máquinas contienen filas, y cada fila debe contener los mismos productos
 * Las filas tienen una cantidad máxima de productos
 * Facilita varios servicios relacionados con la gestión de los productos en la máquina de vending
 * @author alvbeni
 * @author miggonz
 * @author borraba
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
   * @param tamMaquina int con el número de filas de la máquina.
   * @param cantidad int con la cantidad de productos que caben en la máquina.
   * @assert.pre tamMaquina>0 - el tamaño debe ser estrictamente positivo
   * @assert.pre cantidad>0 -  la cantidad debe ser estrictamente positiva
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
   * Informa con un boolean de si la fila indicada está llena o no. Devuelve true si está llena
   * @param index int del número de la fila
   * @return boolean true si la fila está llena
   * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
   * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
   */
   public boolean filaLlena(int index){
	   assert(index>=0 && index<getTamMaquina());
	   if(getSizeFil(index)==getCantidad()){
	     return true;
	   }else{
	   return false;}
   }
   /**
    * Añade un producto indicado a la fila señalada de la máquina
    * @param producto Producto a añadir a la fila
    * @param index int del número de la fila.
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina() > index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre producto!=null - El producto no puede ser nulo
    * @assert.pre !filaLlena(index) - La fila no puede estar llena
    */
   public void añadirUnProducto(Producto producto, int index){
	 assert(index>=0 && index<getTamMaquina());
	 assert(producto!=null);
     assert(!filaLlena(index));
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
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre producto!=null - El producto no puede ser nulo
    * @assert.pre !filaLlena(index) - La fila no puede estar llena
    * @assert.pre cantidad>0 - La cantidad no puede ser negativa
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
    * Llena la fila indicada con el producto dado
    * @param producto con el que rellenar la fila
    * @param index int del número de la fila
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre producto!=null - El producto no puede ser nulo
    * @assert.pre !filaLlena(index) - La fila no puede estar llena
    */
   public void rellenarFila(Producto producto,int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(producto!=null);
	   assert(!filaLlena(index));
	   while(!filaLlena(index)){
		   añadirUnProducto(producto, index);
	   }
   }
   /**
    * Llena una fila indicada de los Productos que ya haya en esa fila
    * @param index int fila indicada
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre !filaLlena(index) - La fila no puede estar llena
    */
   public void reponerFila(int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(!filaLlena(index));
	   while(!filaLlena(index)){
		   rellenarFila(getProducto(index), index);
	   }
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
	    		   	rellenarFila(repuesto, i);
	    	  }
	       }
	   }
   /**
    * Quita el primer producto de una fila indicada
    * @param index int del número de la fila
    * @assert.pre index>0
    * @assert.pre getTamMaquina()>index
    * @assert.pre getFila(index).isEmpty()==false - La fila no puede estar vacía
    */
   public void quitaUno(int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(!getFila(index).isEmpty());
		   getMaquina().get(index).remove(0);
   }
   /**
    * Quita de una fila indicada un número dado de productos
    * @param index int del número de la fila
    * @param cantidad int de la cantidad de productos que se quiere quitar
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre cantidad>0 - La cantidad no puede ser negativa
    */
   public void quitaVarios(int index , int cantidad){
	   assert(index>=0 && index<getTamMaquina());
	   assert(cantidad>0);
	   for(int i =0;i<cantidad;i++){
		   quitaUno(index);
	   }
   }
   /**
    * Vacía la fila indicada hasta dejarla sin productos
    * Si la fila está vacía inicialmente, no modificará nada
    * @param index int del número de la fila
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    */
   public void vaciarFila(int index){
	   assert(index>=0 && index<getTamMaquina());
	   while(!getMaquina().get(index).isEmpty()){
		   quitaUno(index);
	   }
   }
   /**
    * Vacía todas las filas de la máquina 
    * Si está vacía no modifica nada
    */
   public void vaciarMaquina(){
	   for(int i=0;i<getTamMaquina();i++){
		   vaciarFila(i);
	   }
   }
   /**
    * Devuelve el producto que hay en la fila indicada
    * Si la fila está vacía devuelve null
    * @param index int del número de la fila
    * @return pedido Producto de la fila
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getFila(index).isEmpty()==false - La fila no puede estar vacía
    */
   public Producto getProducto(int index) {
	   assert(index>=0 && index<getTamMaquina());
	   assert(getFila(index).isEmpty()!=true);
	   Producto pedido =getMaquina().get(index).get(0);
		   return pedido;
   }
   /**
    * Devuelve el producto que hay en una posición de la fila indicada
    * @param indexFila int del número de la fila
    * @param indexPosicion int con el número de la posición en la fila
    * @return pedido, Producto pedido
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getSizeFil(indexFila)>=indexPosicion - La posición debe ser menor o igual al número de productos que ya hay en ella
    * @assert.pre indexPosicion>=0 - La posicion no debe ser negativa
    * @assert.pre getFila(index).isEmpty()==false - La fila no puede estar vacía
    * 
    */
   public Producto getProductoPosicion(int indexFila, int indexPosicion){
	   assert(indexFila>=0 && indexFila<getTamMaquina());
	   assert(indexPosicion>=0&&indexPosicion<getSizeFil(indexFila));
	   assert(!getFila(indexFila).isEmpty());
	   Producto pedido = getFila(indexFila).get(indexPosicion);
	   return pedido;
   }
   /**
    * Devuelve el nombre del producto de la fila indicada
    * @param index int fila indicada
    * @return nombre String nombre del producto
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getFila(index).isEmpty()==false - La fila no puede estar vacía
    */
   public String nombreProducto(int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(!getFila(index).isEmpty());
	   String nombre = getProducto(index).getNombre();
	   return nombre;
   }
   /**
    * Informa del precio del Producto que hay en la fila indicada
    * @param index int del número de la fila
    * @return precioProducto double con el precio del producto de la fila
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getFila(index).isEmpty()==false - La fila no puede estar vacía
    */
   public double precioProducto(int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(getFila(index).isEmpty()!=true);
	   double precioProducto=getMaquina().get(index).get(0).getPrecio();
	   return precioProducto;
   }
   /**
    * Devuelve el upc del producto de la fila indicada
    * @param index int fila indicada
    * @return nombre String upc del producto
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index- El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getFila(index).isEmpty()==false La fila no puede estar vacía
    */
   public String upcProducto(int index){
	   assert(index>=0 && index<getTamMaquina());
	   assert(!getFila(index).isEmpty());
	   String upc = getProducto(index).getUpc();
	   return upc;
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
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    */
   public int getSizeFil(int index){
	   assert(index>=0 && index<getTamMaquina());
	   int tamFil=getMaquina().get(index).size();
	   return  tamFil;
	   }
   /**
    * Devuelve un String con la información de la máquina (Producto, su precio y número de productos por cada fila)
    * Si está vacía no devuelve nada
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
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getFila(index).isEmpty()==false La fila no puede estar vacía
    * @assert.pre precioProducto(index)>card.getSaldoActual() - El saldo debe ser mayor o igual al precio del producto
    */
   public void comprar(int index,TarjetaMonedero card){
	   assert(index>=0 && index<getTamMaquina());
	   assert(!getFila(index).isEmpty());
	   assert(card.getSaldoActual()>=precioProducto(index));
	   card.descontarDelSaldo("6Z1y00Nm31aA-571", precioProducto(index));
	   quitaUno(index);
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
    * @assert.pre index>=0 - El índice debe entrar en el rango de las filas que tiene la máquina
    * @assert.pre getTamMaquina()>index - El índice debe entrar en el rango de las filas que tiene la máquina
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
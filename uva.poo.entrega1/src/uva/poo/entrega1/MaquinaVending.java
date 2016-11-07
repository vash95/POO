package uva.poo.entrega1;

import java.util.ArrayList;

import fabricante.externo.tarjetas.TarjetaMonedero;

public class MaquinaVending {

   private ArrayList<ArrayList<Producto>> maquina ;
   private ArrayList<Producto> fila;
   private int tamMaquina;
   private int cantidad;
   
   public MaquinaVending(){
     tamMaquina=1;
     cantidad=1;
     maquina=new ArrayList<ArrayList<Producto>>(tamMaquina);
     fila= new ArrayList<Producto>(cantidad);
     maquina.add(fila);
   }
  
   public MaquinaVending(int tamMaquina, int cantidad){
	   	 assert(this.tamMaquina>0&&this.cantidad>0);
	     this.tamMaquina=tamMaquina;
	     this.cantidad=cantidad;
	     maquina=new ArrayList<ArrayList<Producto>>()	;
	     fila=new ArrayList<Producto>();
	     for(int i=0;i<tamMaquina;i++){
	       maquina.add((ArrayList<Producto>)fila.clone()); 
	     }
	   }
   public boolean filaLlena(int index){
	   if(getMaquina().get(index).get(getCantidad()-1)!=null){
		   if(getMaquina().get(index).get(getCantidad())==null){
			   return true;
		   }
	   }
	   return false;
   }
   public void reponerFila(Producto producto,int index){
	   assert(!filaLlena(index));
	   while(!filaLlena(index)){
		   añadirUnProducto(producto, index);
	   }
   }
   public void vaciarFila(int index){
	   while(!getMaquina().get(index).isEmpty()){
		   quitaUno(index);
	   }
   }
   //hola
   //Funciones de añadir/eleminar uno o varios 
   public void añadirUnProducto(Producto producto, int linea){
	   assert(filaLlena(linea)!=true);
	   getMaquina().get(linea).add(producto);
   }
   
   public void añadirVariosProductos(Producto producto , int linea , int cantidad){
	   for(int i =0;i<cantidad;i++){
		   añadirUnProducto(producto,linea);
	   }
   }
   public void quitaUno(int linea){
	   assert(getMaquina().get(linea).isEmpty()!=true);
		   getMaquina().get(linea).remove(0);
	   
   }
   public void quitaVarios(int linea , int cantidad){
	   for(int i =0;i<cantidad;i++){
		   quitaUno(linea);
	   }
   }
   //obtener el producto
   public Producto getProducto(int linea) {
	   assert(getMaquina().get(linea).isEmpty()!=true);
	   Producto pedido =getMaquina().get(linea).get(0);
		   return pedido;
   }
   //obtener el precioProducto de un producto 
   public double precioProducto(int linea){
	   assert(getMaquina().get(linea).isEmpty()!=true);
	   double precioProducto=getMaquina().get(linea).get(0).getPrecio();
	   return precioProducto;
	  
   }
   //el tamaño de la maquina
   public int getSizeMaq(){
	   int tam=getMaquina().size();
	  return  tam;
   }
   //la cantidad de productos
   public int getSizeFil(int index){
	   	int tamfil=getMaquina().get(index).size();
		  return  tamfil;
	   }
   
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

   public ArrayList<ArrayList<Producto>> getMaquina() {
	   return maquina;
   }

	public ArrayList<Producto> getFila(int index) {
		return maquina.get(index);
	}

	public int getTamMaquina() {
		return tamMaquina;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setMaquina(ArrayList<ArrayList<Producto>> maquina) {
		this.maquina = maquina;
	}

	public void setFila(ArrayList<Producto> fila) {
		this.fila = fila;
	}
   
} 
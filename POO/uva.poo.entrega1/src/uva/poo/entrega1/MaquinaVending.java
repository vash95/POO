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
	     this.tamMaquina=tamMaquina;
	     this.cantidad=cantidad;
	     maquina=new ArrayList<ArrayList<Producto>>()	;
	     fila=new ArrayList<Producto>();
	     for(int i=0;i<tamMaquina;i++){
	       maquina.add((ArrayList<Producto>)fila.clone()); 
	     }
	   }
   //Funciones de añadir/eleminar uno o varios 
   public void añadirUnProducto(Producto producto, int linea){
     maquina.get(linea).add(producto);
   }
   public void añadirVariosProductos(Producto producto , int linea , int cantidad){
	   for(int i =0;i<cantidad;i++){
		   añadirUnProducto(producto,linea);
	   }
   }
   public void removeOne(int linea){
	   if(maquina.get(linea).isEmpty()!=true){
		   maquina.get(linea).remove(0);
	   }
   }
   public void removeVariosProductos(int linea , int cantidad){
	   for(int i =0;i<cantidad;i++){
		   removeOne(linea);
	   }
   }
   //obtener el producto
   public Producto getProducto(int linea) {
	   if(maquina.get(linea).isEmpty()!=true){
		   return maquina.get(linea).get(0);
	   }
	    return null;
   }
   //obtener el precio de un producto 
   public double precio(int linea){
	   if(maquina.get(linea).isEmpty()!=true){
	   return maquina.get(linea).get(0).getPrecio();
	   }
	   return 0;
   }
   //el tamaño de la maquina
   public int getSizeMaq(){
	  return  maquina.size();
   }
   //la cantidad de productos
   public int getSizeFil(int index){
		  return  maquina.get(index).size();
	   }
   //metodo comprar
   public void comprar(int index,TarjetaMonedero card){
	   if(getProducto(index)!=null){
		   if(card.getSaldoActual()>=precio(index)){
			   card.descontarDelSaldo("6Z1y00Nm31aA-571", precio(index));
			   removeOne(index);
			   System.out.println("aqui tines tu polla , sorry digo tu pollo");
		   }else{
			   System.out.println("No tienes DInero puta");
		   }
	   }else{
		   System.out.println("NO hay puta");
	   }
	   
   }
} 
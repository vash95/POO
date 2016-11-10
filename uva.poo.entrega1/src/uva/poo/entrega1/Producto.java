package uva.poo.entrega1;
/**
 * Implementación de productos que tienen nombre, precio y UCP.
 * Práctica 1 de POO
 * @author Álvaro Benito Navarro
 * @author Miguel González Bravo
 * @author Borja Rabadán Martín
 *
 */
public class Producto {
	//Atributos de la clase
	private String nombre;
	private double precio;
	private String upc;
	/**
	 * Inicializa una instancia de la clase Producto con unos valores por defecto
	 */
	public Producto(){
		this.nombre=null;
		this.precio=0;
		this.upc=null;
	}
	/**
	 * Inicializa una instancia de la clase Producto con los valores dados como argumento
	 * El dígito de control se calcula automáticamente
	 * @param nombre String con el nombre
	 * @param precio double que indica el precio de un producto en euros
	 * @param upc String con los dígitos 12 del UPC, incluyendo el de control
	 * @assert.pre nombre!=""
	 * @assert.pre precio>0.00
	 * @assert.pre upc.length()==12
     * @assert.pre UPCValido(upc)
	 */
	public Producto(String nombre, double precio, String upc){
		assert (nombre!="");
		assert (precio>0.00);
		assert (upc.length()==12):"upc no valido";
		assert (UPCValido(upc));
		assert(DigitoDeControl(upc));
		this.nombre=nombre;
		this.precio=precio;
		this.upc=upc;
	}
	
	private boolean DigitoDeControl(String upc){
		//Método que cambia el valor de UPC para añadir el dígito de control 
		int s=0,a,m;
		String r;
		for(int i =0;i<11;i++){
			a=((int)upc.charAt(i))-48;
			if(i%2==0){
				s+=a*3;
			}else{
				s+=a;
			}
		}
		m=10-(s%10);  
		r=String.valueOf(m%10);
		if(r.equals(Character.toString(upc.charAt(11)))){
			return true;
			}
		return false;
	}
	
	private static boolean UPCValido(String cad){
		//Comprueba si un String que contiene el UPC es solo números
		boolean valido=true;
		for (int i=0; i<cad.length(); i++){
			//Comprueba que el digito sea un numero
			if((int)cad.charAt(i)<48 || (int)cad.charAt(i)>57){
				valido=false;
			}
		}return valido;
	}
    /**
     * Devuelve el nombre del producto
     * @return nombre String con el nombre
     */
	public String getNombre() {
            return nombre;
	}
    /**
     * Cambia el nombre del producto
     * @param nombre String nombre del producto
     * @assert.pre nombre!=""
     */
	public void setNombre(String nombre) {
			assert (nombre!="");
            this.nombre = nombre;
	}
    /**
     * Devuelve el precio del producto en euros
     * @return precio double en euros
     */
	public double getPrecio() {
            return precio;
	}
	/**
	 * Cambia el precio del producto
	 * @param precio double con el nuevo precio en euros
	 * @assert.pre precio>0
	 */
	public void setPrecio(double precio) {
            assert (precio>0.0);
            this.precio = precio;
	}
    /**
     * Devuelve el upc del producto
     * @return upc String con el upc
     */
	public String getUpc() {
            return upc;
	}
    /**
     * Cambia el upc del producto
     * @param upc String con el nuevo upc
     * @assert.pre upc.length()==12
     * @assert.pre UPCValido(upc)
     */
	public void setUpc(String upc) {
		assert (upc.length()==12);
		assert (UPCValido(upc));
		assert(DigitoDeControl(upc));
		this.upc = upc;
	}
	/**
	 * Devuelve un String con la información del producto
	 */
	public String toString(){
		return "Nombre del producto: "+getNombre()+", precio: "+getPrecio()+" euros, UPC: "+getUpc();
	}
	/**
	 * Indica si dos productos son iguales o no
	 * @param otro Producto para comparar
	 * @return boolean true si son los dos productos iguales
	 */
	public boolean equals(Producto otro){
		if(this.nombre==otro.nombre && this.precio==otro.precio && this.upc==otro.upc){
			return true;
		}
		else
		return false;
	}
}
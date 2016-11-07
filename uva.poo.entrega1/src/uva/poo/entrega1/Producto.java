package uva.poo.entrega1;
/**
 * Implementación de productos que tienen nombre, precio y UCP.
 * Práctica 1 de POO
 * @author Álvaro Benito Navarro
 * @author Miguel Gonzalez Bravo
 * @author Borja Rabadán Martín
 *
 */
public class Producto {
	//Atributos de la clase, nombre, double y upc
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
	 * Inicializa una instancia de la clase Producto con los valores que se pasan por parametro
	 * @param nombre String con el nombre
	 * @param precio int que indicará el precio en céntimos
	 * @param upc long que será un número de 11 digitos, serán modificados por la clase y se añadirá el dígito de control
	 * @assert.pre nombre!=""
	 * @assert.pre precio>0
	 * @assert.pre upc.length()==11
     * @assert.pre UPCValido(upc)
	 */
	public Producto(String nombre, double precio, String upc){
		assert (nombre!="");
		assert (precio>0.0);
		assert (upc.length()==11):"upc no valido";
		assert (UPCValido(upc));
		this.nombre=nombre;
		this.precio=precio;
		this.upc=upc;
		DigitoDeControl();
	}
	
	//Metodo que cambia el valor de UPC para añadir el digito de control 
	private void DigitoDeControl(){
		int s=0,a,m;
		String r;
		for(int i =0;i<11;i++){
			a=((int)getUpc().charAt(i))-48;
			if(i%2==0){
				s+=a*3;
			}else{
				s+=a;
			}
		}
		m=10-(s%10);  
		r=String.valueOf(m%10);
		upc=(getUpc()+r);
		}
    
	//Comprueba si un String que contiene el UPC es válido
	private static boolean UPCValido(String cad){
		boolean valido=true;
		//Recorre la cadena
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
     * @param nombre String con el nuevo nombre
     * @assert.pre nombre!=""
     */
	public void setNombre(String nombre) {
			assert (nombre!="");
            this.nombre = nombre;
	}
    /**
     * Devuelve el precio del producto en centimos
     * @return precio int con el precio  en centimos
     */
	public double getPrecio() {
            return precio;
	}
	/**
	 * Cambia el precio del producto
	 * @param precio int con el nuevo precio
	 * @assert.pre precio>0
	 */
	public void setPrecio(double precio) {
            assert (precio>0.0);
            this.precio = precio;
	}
    /**
     * Devuelve el upc del producto
     * @return upc long con el upc
     */
	public String getUpc() {
            return upc;
	}
    /**
     * Cambia el upc del producto
     * @param upc long con el nuevo upc
     * @assert.pre upc.length()==11
     * @assert.pre UPCValido(upc)
     */
	public void setUpc(String upc) {
		assert (upc.length()==11);
		assert (UPCValido(upc));
		this.upc = upc;
		DigitoDeControl();
	}
	/**
	 * Devuelve un String con la información del producto
	 */
	public String toString(){
		return "Nombre del producto: "+getNombre()+", precio: "+getPrecio()+" euros, UPC: "+getUpc();
	}
	/**
	 * Devuelve un boolean que indica si dos productos son iguales (no tienen por que ser el mismo)
	 * @param otro Producto para comparar
	 * @return boolean true si son los dos objetos iguales
	 */
	public boolean equals(Producto otro){
		if(this.nombre==otro.nombre && this.precio==otro.precio && this.upc==otro.upc){
			return true;
		}
		else
		return false;
	}
}
package mio;

public class fecha {

	public static void main(String args[]){
		  int anyo=1995,mes=8,dia=1;
		  int a, y, m, dia1;
		  int b;
		 
		  a = (14-mes) / 12;
		  
		  y = anyo - a;
		  
		  m = mes + (12*a) - 2;
		  b=(dia + y+ (y/4)  - (y/100)+ (y/400)+(31*m) / 12)%7;
		  System.out.println(b);
		  dia1 = (dia + y + (y/4) - (y/100) + (y/400) + (31*m) / 12) % 7;
		  System.out.println(dia1);
		  if (dia1==0) {
		    dia1=7;
		  }

	}	
}

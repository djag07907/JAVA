import java.util.Random;
import java.util.Scanner;


public class juegodificil {
	private int [][]m_tabla;
	private boolean [][]cover_tabla;
	private int m_nMinas;
	private boolean[][] marcar_tabla;
	private boolean revelado;
	 int contador=300;
	public  juegodificil(int sizetabla, int numMinas) {
		m_tabla = new int[sizetabla][sizetabla];
		cover_tabla = new boolean[sizetabla][sizetabla];
		marcar_tabla= new boolean[sizetabla][sizetabla];
		
		m_nMinas = numMinas;
		Random rnd = new Random();
		int numerominas = 100;
		;
		int colocarmina = numerominas;
		while (colocarmina > 0) {
			int i = rnd.nextInt(sizetabla);
			int j = rnd.nextInt(sizetabla);
			if (m_tabla[i][j] == 0) {
				colocarmina = colocarmina - 1;
				m_tabla[i][j] = 9;
			}

		}

		for (int i = 0; i < m_tabla.length; i++) {
			for (int j = 0; j < m_tabla.length; j++) {

				if (!chekearCacilla(i, j)) {
					if (chekearCacilla(i + 1, j + 1)) {
						m_tabla[i][j] = m_tabla[i][j] + 1;
					}
					if (chekearCacilla(i - 1, j)) {
						m_tabla[i][j] = m_tabla[i][j] + 1;
					}
					if (chekearCacilla(i, j - 1)) {
						m_tabla[i][j] = m_tabla[i][j] + 1;
					}
					if (chekearCacilla(i - 1, j - 1)) {
						m_tabla[i][j] = m_tabla[i][j] + 1;
					}

					if (chekearCacilla(i, j + 1)) {
						m_tabla[i][j] = m_tabla[i][j] + 1;
					}

					if (chekearCacilla(i + 1, j)) {
						m_tabla[i][j] = m_tabla[i][j] + 1;
					}
					if (chekearCacilla(i - 1, j + 1)) {
						m_tabla[i][j] = m_tabla[i][j] + 1;
					}
					if (chekearCacilla(i + 1, j - 1)) {
						m_tabla[i][j] = m_tabla[i][j] + 1;
					}

				}

			}
		}

		 
		 
		 
	}
	
		 

 private boolean chekearCacilla(int i, int j) {
		int tamTabla = m_tabla.length;
		if(i<0|| j<0|| i>=tamTabla||j>=tamTabla)
		{
			return false;
		}
		
		if(m_tabla[i][j] == 9)
		{
			return true;
		}
		return false;
		
	}
 
public void vertabla(){
	
	 System.out.println("                         ");
	for (int i=0;i<m_tabla.length;i++){
		System.out.println( );
	for(int j=0;j<m_tabla.length;j++){
		if(cover_tabla[i][j]){
			System.out.print(" " + m_tabla[i][j]);
			
		}else{  
			   if (marcar_tabla[i][j]){
				   System.out.print(" ?");
			}
			else{
				 System.out.print(" *");
			}
			
			
		}
		}
	 
	
	
      }
 }	
 public boolean leerteclado(){
	 Scanner nombre=new Scanner (System.in);
	 System.out.println("                               ");
	  System.out.println("________________________________");
	  System.out.println("1.destapar");
      System.out.println("2.marcar");
      System.out.println("3.desmarcar");
      System.out.println("4.salir");
      System.out.println("________________________________");
      int resp=nombre.nextInt();
      if(resp==1){
    	  System.out.println("* ingrese numero de fila ");
    	  int fila=nombre.nextInt();
    	  System.out.println("* ingrese el numero de columna");
    	  int columna=nombre.nextInt();
    	  
    	  if (fila>19 && columna>19){
    		 System.out.println("no puede exeder el numero de filas 19 ni columnas 19"); 
    		 leerteclado();
    	  }
    	  else if (fila<0 &&columna <0){
    		  System.out.println("no puede exeder el numero de filas 19 ni columnas 19"); 
     		 leerteclado();
    	  }
    	  else if(fila<19 &&columna >19){
    		  System.out.println("no puede exeder el numero de filas 19 ni columnas 19"); 
     		 leerteclado();
    	  }
    	  else if(fila>19 &&columna <19){
    		  System.out.println("no puede exeder el numero de filas 19 ni columnas 19"); 
     		 leerteclado();
    	  }
    	  else if(fila<0 && columna <19){
    		  System.out.println("no puede exeder el numero de filas 19 ni columnas 19"); 
     		 leerteclado();
    	  }
    	  
    	  else if(fila<19 && columna <0){
    		  System.out.println("no puede exeder el numero de filas 19 ni columnas 19"); 
     		 leerteclado();
    	  }
    	     
    	   if(marcar_tabla[fila][columna]){
    		  System.out.println("esta seguro que decea destaparla, porque posiblemente aqui se encuentre una mina");
    		  System.out.println("1.si \n 2.no");
    		  int pregunta=nombre.nextInt();
    		   if ( pregunta==1){
    			  destapar(fila,columna);  
    		  }
    		  else{
    			  vertabla();
    			  leerteclado();
    		  }  
    	  }
    	  
    	  destapar(fila,columna);
    	  
    	  vertabla();
    	  if(contador<=0){ 
    		  System.out.println(   ); 
    		  System.out.println("ud gano fin del juego");
    		  System.exit(0) ;
    	  }else  if (m_tabla[fila][columna] == 9){
    		  System.out.println(   );   
    		  System.out.println("perdio gracias por participar ");
    		  System.exit(0) ;
    	  }
    	  else {
    	  leerteclado();
    	  }
      }
      if(resp==2){
    	  System.out.println("* ingrese numero de fila ");
    	  int fila=nombre.nextInt();
    	  System.out.println("* ingrese el numero decolumna");
    	  int columna=nombre.nextInt();
    	 marcar(fila,columna);
    	  vertabla();
    	  leerteclado();
      }
      if(resp==3){
    	  System.out.println("* ingrese numero de fila ");
    	  int fila=nombre.nextInt();
    	  System.out.println("* ingrese el numero de columna");
    	  int columna=nombre.nextInt();
    	 desmarcar(fila,columna);
    	  
    	  vertabla();
          leerteclado();
      }
    if(resp==4){
    	 System.out.println(" (° ---- °) ");
    	 System.out.println("  si ud sale perdera el juego  ");
    	 System.out.println("desea seguir jugando \n 1.si\n 2.no");
    	 int retornar =nombre.nextInt(); 
    	 if(retornar==1){
    		 vertabla();
    		 leerteclado(); 
    	 }
    	 else
    	 {
    		 System.out.println("gracias por participar");
    	 }
    	 
    	
    }
    if (resp<=0 || resp>4){
    	System.out.println("no puede ingresar menores a 4 ");
    	vertabla();
    	leerteclado();
    }
	 return false;
 }
 private void desmarcar(int fila, int columna) {
	 if(!esValida(fila,columna)){
		  return ;
	}
		if(!cover_tabla[fila][columna]==false){
	 	   return ;
	    }
		if (marcar_tabla[fila][columna]=false){
			return ;
		}
		if (marcar_tabla[fila][columna]=true){
			marcar_tabla[fila][columna]=false;
				
			}

}

private void marcar(int fila, int columna) {
if(!esValida(fila,columna)){
  return ;
}
if(!cover_tabla[fila][columna]==false){
	   return ;
}
else{
 	     marcar_tabla[fila][columna]=true;
		
	}
}


	private void destapar(int fila, int columna) {
		if(!esValida(fila,columna)){
		return;
		}
          if(!cover_tabla[fila][columna]==false){
        	   return ;
           }
		
		cover_tabla[fila][columna]=true;
  			contador=contador-1;
          
		if (m_tabla[fila][columna] == 0) {
			destapar(fila + 1, columna);
			destapar(fila-1,columna);
			destapar(fila+1,columna+1);
			destapar(fila+1,columna-1);
			destapar(fila-1,columna+1);
			destapar(fila,columna+1);
			destapar(fila,columna-1);
			destapar(fila-1,columna-1);

		} else if (m_tabla[fila][columna] == 9) {
			System.out.println("lo siento esta fila y columna es una mina ud perdio");;
		} 
		
	}


	


	private boolean esValida(int fila, int columna) {
		if(fila >= 0 && columna >=0 && fila<m_tabla.length && columna<m_tabla.length){
			return true;
		}
	
		    return false;
		
		    
	}

}

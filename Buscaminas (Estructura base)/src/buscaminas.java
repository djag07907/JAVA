import java.util.Scanner;

public class buscaminas {
	public static void main(String[] args){
		Scanner nombre=new Scanner (System.in);
		juego j=new juego(9,10);
		
		System.out.println(".............Buscamminas......... ");
		System.out.println("....Escoja el nivel de dificultad....");
		
		System.out.println("1.Faci");
		System.out.println(" ");
		System.out.println("2.Normal");
		System.out.println(" ");
		System.out.println("3.Dificil");
		int res= nombre.nextInt();
		if (res==1){
			do{
				j.vertabla();
			
			} while(j.leerteclado());
		
		}
		
		juegonormal k = new juegonormal(14,14);
		if (res==2){
			do{ 
				k.vertabla();
			
			} while(k.leerteclado());
		
		}
		juegodificil z = new juegodificil(19,19);
		if (res==3){
			do{
				z.vertabla();
			
			} while(z.leerteclado());
		
		}
		
		
		
		
		
	}
	
	
	
}
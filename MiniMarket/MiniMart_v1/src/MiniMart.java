import java.util.Scanner;

public class MiniMart 
{
	private final int OPCIÓN_HUEVOS = 1;
	private final int OPCIÓN_LECHE = 2;
	private final int OPCIÓN_CEREAL = 3;
	private final int OPCIÓN_CHURROS = 4;
	private final int OPCIÓN_FINALIZAR_COMPRA = 5;
	
	private Scanner mSC;
	private boolean CicloCompraCliente;
	
	private float mSubTotal;
	private float mImpuesto;
	private float mTotal;
	private float mGanancia;
	private float mImpuestoTotal;
	
	private float ISV = 0.15f;
	
	//Función Accesora
	public float getTotal()
	{
		return mTotal;
	}
	
	//Función Mutadora
	private void setTotal(float Total, float Impuesto, float SubTotal, float ImpuestoTotal, float Ganancia)
	{
		mSubTotal = SubTotal;
		mImpuesto = Impuesto;
		mTotal = Total;
		mGanancia = Ganancia;
		mImpuestoTotal = ImpuestoTotal;
	}
	
	public void init()
	{
		mTotal = 0;
		mImpuesto = 0;
		mSC = new Scanner(System.in);
	}
	
	public void run()
	{
		int Opción2;
		
		do
		{
			Bienvenida();
		
			CicloCompraCliente = true;
			
			mSubTotal = 0;
			mImpuesto = 0;
			mTotal = 0;
			
			do
			{
				PresentarOpciones();
				ProcesarOpciones();
			}
			while(CicloCompraCliente);
			
			ImprimirSubTotal(mSubTotal);
			ImprimirImpuesto(mImpuesto);
			ImprimirTotal(mTotal);
			MostrarDespedida();
		
			Opción2 = mSC.nextInt();
		}
		while (Opción2 == 1);
		
		GananciaTotal(mGanancia);
		ImpuestoTotal(mImpuestoTotal);
	}
	
	public void finish()
	{
		mSC.close();
	}

	private void Bienvenida()
	{
		System.out.println("\t\t ¡Bienvenido al MiniMart!");
		System.out.println();
		System.out.println();
	}
	
	private void PresentarOpciones()
	{
		System.out.println("¿Qué desea comprar?");
		System.out.println();
		System.out.println("1. Huevos: L.2");
		System.out.println("2. Leche: L.20");
		System.out.println("3. Cereal: L.100");
		System.out.println("4. Churros: L.7");
		System.out.println("5. FINALIZAR COMPRA");
	}
	
	private void ProcesarOpciones() 
	{
		int Opción = mSC.nextInt();
		float SubTotal = 0;
		
		switch (Opción)
		{
		case OPCIÓN_HUEVOS:
		
			int OpciónDocena;
			
			System.out.println("¿Cuántos huevos desea comprar?	1. Docena	2. Ingresar cantidad");
			OpciónDocena = mSC.nextInt();
			
			if (OpciónDocena == 1)
			{
				SubTotal+= 12*2.0f;
			}
			else
			{
				int Cantidad;
				
				do
				{
					System.out.println("¿Cuántos huevos desea?: ");

					Cantidad = mSC.nextInt();

					if (Cantidad <= 31)
					{	
						SubTotal+= Cantidad*2.0f;
					}
					else
					{
						System.out.println("Su compra no es válida por escasez");
						System.out.println();
					}
				}
				while(Cantidad > 31);
			}
			
			mSubTotal+= SubTotal;
			mImpuesto+= SubTotal * ISV;
			mTotal+= SubTotal * 1.15;
			mGanancia+= SubTotal;
			mImpuestoTotal+= SubTotal * ISV;
			
			break;
			
		case OPCIÓN_LECHE:
			SubTotal+= 20.0f; 
			
			mSubTotal+= SubTotal;
			mImpuesto+= SubTotal * ISV;
			mTotal+= SubTotal * 1.15;
			mGanancia+= SubTotal;
			mImpuestoTotal+= SubTotal * ISV;
			
			break;
			
		case OPCIÓN_CEREAL:
			SubTotal+= 100.0f;
			
			mSubTotal+= SubTotal;
			mImpuesto+= SubTotal * ISV;
			mTotal+= SubTotal * 1.15;
			mGanancia+= SubTotal;
			mImpuestoTotal+= SubTotal * ISV;
			
			break;
			
		case OPCIÓN_CHURROS:
			SubTotal+= 7.0f;
			
			mSubTotal+= SubTotal;
			mImpuesto+= SubTotal * ISV;
			mTotal+= SubTotal * 1.15;
			mGanancia+= SubTotal;
			mImpuestoTotal+= SubTotal * ISV;
			
			break;
		
		case OPCIÓN_FINALIZAR_COMPRA:
		default:
			CicloCompraCliente = false;
			break;
		}
	}
	
	private void ImprimirSubTotal(float SubTotal)
	{
		System.out.println();
		System.out.print("Sub Total: ");
		System.out.println((int) SubTotal);
	}
	
	private void ImprimirImpuesto(float Impuesto)
	{
		System.out.println();
		System.out.print("I.S.V.: ");
		System.out.println((int) Impuesto);
	}
	
	private void ImprimirTotal(float Total)
	{
		System.out.println();
		System.out.print("Su total es: ");
		System.out.println((int) Total);
	}
	
	private void MostrarDespedida()
	{
		System.out.println();
		System.out.println("¡Gracias por su preferencia! Lo esperamos pronto.");
		System.out.println();
		System.out.println("¿Desea hacer otra facura?	1.Si	2.No");
		System.out.println();
		System.out.println();
	}
	
	private void GananciaTotal(float Ganancia)
	{
		System.out.println();
		System.out.print("Ganancia del Día: ");
		System.out.println((int) Ganancia);
	}
	
	private void ImpuestoTotal(float ImpuestoTotal)
	{
		System.out.println();
		System.out.print("Impuesto a pagar a la DEI: ");
		System.out.println((int) ImpuestoTotal);
	}
}
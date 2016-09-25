public class Retirement2{
	public static void main(String[] args){
		
		int[] tab = {1, 2, 3, 4, 5};
		int x=5;
		
		
		System.out.println("Przed zmianą:");
		System.out.println("x=" + x);
		for(int x1 : tab)
			System.out.print(x1 + " ");
		
		resetNumbers(tab, x);
		
		System.out.println("Po zmianie:");
		System.out.println("x=" + x);
		for(int x1 : tab)
			System.out.print(x1 + " ");
		
//		Czworokat czworokat = new Czworokat();
//		
//		System.out.println("Czworokąt to kwadrat: " + czworokat.isKwadrat());
//		System.out.println("Nazywa się " + czworokat.getNazwa());
//		
//		resetCzworokat(czworokat);
//		
//		System.out.println("Czworokąt to kwadrat: " + czworokat.isKwadrat());
//		System.out.println("Nazywa się " + czworokat.getNazwa());
	}
  
	private static void resetNumbers(int[] a, int x)
	{
		for(int i=0; i<a.length; ++i)
			a[i]=0;
		x=0;
	}
	
//	private static void resetCzworokat (Czworokat czworokat)
//	{
//		czworokat.setKwadrat(true);
//		czworokat.setNazwa("Mój czworokąt");
//	}
}
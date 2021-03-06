//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class segregacja {
//	
//	public static void main(String[] args) {
//		try {
//			Scanner scanner = new Scanner(new File("C:/Users/Bartek/Desktop/qwe.txt"));
//			segregation(scanner);
//		} catch (FileNotFoundException e) {
//			System.out.println("Unable to open file");
//			e.printStackTrace();
//		}
//	}
//	
//	static void segregation(Scanner scanner){
//		while(scanner.hasNext())
//		{
//			System.out.println(scanner.nextLine());
//		}
//	}
//}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
 
public class segregacja{
	public static void main(String[] args) throws FileNotFoundException{
	  
	ArrayList<String> strings = new ArrayList<String>();
    Scanner odczyt = new Scanner(new File("qwe.txt"));
    String string;
      
    while(odczyt.hasNext())
    {
    	string = odczyt.nextLine();
    	System.out.println(string);
    	strings.add(string);
    }
    
    System.out.println("Lista wszystkiego:");
    System.out.println(strings);
    Collections.sort(strings, new Comparator<String>() {

		@Override
		public int compare(String s1, String s2) {
			return s1.compareToIgnoreCase(s2);
		}
	});
    
    System.out.println("Po posortowaniu:");
    System.out.println(strings);
    
    odczyt.close();
    
    PrintWriter writer = new PrintWriter(new File("result.txt"));
    for(String s : strings)
    	writer.println(s);
    
	writer.close();
	}
}
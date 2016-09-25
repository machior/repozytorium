import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Unikod {

	public static void main(String[] args) {
		
		try {
			Scanner skaner = new Scanner(new FileReader("unikod.txt"));
			PrintWriter ostream = new PrintWriter("unikodTranslated.txt");
			
			translate(skaner, ostream);
			
			skaner.close();
			ostream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem z wczytaniem pliku");
			e.printStackTrace();
		}
	}

	private static void translate(Scanner skaner, PrintWriter ostream) {
		
		StringBuilder text = new StringBuilder();
		String line = "";
		
		while(skaner.hasNextLine())
		{
			line = skaner.nextLine().replace("\\", "");
			String[] splittedLine = line.split("u");
			StringBuilder textLine = new StringBuilder();
			
			for(String s : splittedLine)
			{
				boolean space = false;
				if(s.startsWith("0"))
				{
					if(s.length()>4){
						s = s.substring(0, 4);
						space = true;
					}
					int x = Integer.parseInt(s, 16);
					textLine.append( Character.toString((char)x) );
					if(space) textLine.append(" ");
				}
				else
					textLine.append(s);
			}
			ostream.println(textLine);
			text.append(textLine + "\r");
			System.out.println(textLine);
		}
		
//		System.out.println(text.toString());
	}
}

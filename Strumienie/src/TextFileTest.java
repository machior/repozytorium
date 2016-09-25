import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.naming.RefAddr;

/**
 * @version 1.0
 * @author Bartek
 */

public class TextFileTest {

	public static void main(String[] args) 
	{
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		try {
			//zapisuje wszystkie rekordy pracowników w pliku employee.dat
			PrintWriter out = new PrintWriter("employee.txt");
			writeData(staff, out);
			out.close();
			
			//wczytuje wszystkie rekordy pracowników do nowej tablicy
			Scanner in = new Scanner(new FileReader("employee.txt"));
			Employee[] newStaff = readData(in);
			in.close();
			
			//wyświetla wszystkie wczytane rekordy
			for(Employee e : newStaff)
				System.out.println(e);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Zapisuje dane wszystkich obiektów klasy Employee
	 * umieszczonych w tablicy do obiektu klasy PrintWriter
	 * @param staff tablica obiektów klasy Employee
	 * @param out obiekt klasy PrintWriter
	 */
	private static void writeData(Employee[] staff, PrintWriter out)  
	{
		//zapisuje liczbę obiektów
		out.println(staff.length);
		
		for(Employee e : staff)
			e.writeData(out);
	}
	/**
	 * Wczytuje tablicę obiektów klasy Employee
	 * @param in obiekt klasy Scanner
	 * @return tablica obiektów klasy Employee
	 */
	private static Employee[] readData(Scanner in) {
		//pobirera rozmiar tablicy
		int n = in.nextInt();
		in.nextLine(); //pobiera znak nowego wiersza
		
		Employee[] employees = new Employee[n];
		for(int i=0; i<n; i++)
		{
			employees[i] = new Employee();
			employees[i].readData(in);
		}
		
		return employees;
	}
	
	

	static class Employee
	{
		public Employee(){}
		
		public Employee(String n, double s, int year, int month, int day)
		{
			name = n;
			salary = s;
			GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
			hireDay = calendar.getTime();
		}
		
		public String getName() { return name;	}
		public double getSalary() { return salary; }
		public Date getHireDay() { return hireDay; } 
		
		public void raiseSalary(double byPercent)
		{
			salary += salary * byPercent / 100;
		}
		
		public String toString()
		{
			return getClass().getName() + "[name=" + name + ".salary=" + salary + ".hireDay=" + hireDay + "]";
		}
		
		/**
		 * Zapisuje stan obiektu klasy Employee
		 * do obiektu klasy PrintWriter
		 * @param out obiekt klasy PrintWriter
		 */
		public void writeData(PrintWriter out)
		{
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTime(hireDay);
			out.println(name + 
					"|" + salary + 
					"|" + calendar.get(Calendar.YEAR) + 
					"|" + (calendar.get(Calendar.MONTH) + 1) + 
					"|" + calendar.get(Calendar.DAY_OF_MONTH));
		}
		
		public void readData(Scanner in)
		{
			String line = in.nextLine();
			String[] tokens = line.split("\\|");
			name = tokens[0];
			salary = Double.parseDouble(tokens[1]); 
			int y = Integer.parseInt(tokens[2]);
			int m = Integer.parseInt(tokens[3]);
			int d = Integer.parseInt(tokens[4]);
			GregorianCalendar calendar = new GregorianCalendar(y, m-1, d);
			hireDay = calendar.getTime();
		}
		
		private String name;
		private double salary;
		private Date hireDay;
	}
}

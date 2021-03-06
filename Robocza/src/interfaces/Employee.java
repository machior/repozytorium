package interfaces;

import java.util.Date;

public class Employee implements Comparable<Employee>, Cloneable
{
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee(String n, double s)
	{
		name = n;
		salary = s;
		hireDay = new Date();
	}
	
	public Employee clone() throws CloneNotSupportedException
	{
		Employee cloned = (Employee) super.clone();
		cloned.hireDay = (Date) hireDay.clone();
		return cloned;
	}
	
	public String getName()	{	return name;	}
	public double getSalary()	{	return salary;	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	
	/**
	* Porównuje pracowników według wysokości pensji.
	* @param other inny obiekt klasy Employee
	* @return wartość ujemna, jeśli pracownik ma niższą pensję niż inny (other) pracownik,
	* 0, jeśli pensje są równe, w przeciwnym razie liczba dodatnia
	*/
	@Override
	public int compareTo(Employee other)
	{
		return Double.compare(salary, other.salary);
	}
}
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.lang.System.*;

public class Kalendarz 
{
	public static void main(String[] args) 
	{
		GregorianCalendar calendar = new GregorianCalendar();
		
		int today = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		int firstDayOfWeek = calendar.getFirstDayOfWeek();
		int indent = 0;
		
		while(weekDay != firstDayOfWeek)
		{
			indent++;
			calendar.add(Calendar.DAY_OF_WEEK, -1);
			weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		}
		
		String[] weekDays = new DateFormatSymbols().getShortWeekdays();
		
		do{
			out.printf("%4s", weekDays[weekDay]);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		}while(weekDay != firstDayOfWeek);
		System.out.println();
		
		if(calendar instanceof GregorianCalendar) out.println("calendar jest instancją GregorianCalendar");
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		for(int i=0; i<indent; ++i)
			System.out.print("    ");
		
		do{
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3s", day);
			
			if(day==today) System.out.print("*");
			else System.out.print(" ");
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			weekDay = calendar.get(Calendar.DAY_OF_WEEK);
			
			if(weekDay==firstDayOfWeek) System.out.println();
		}while(month == calendar.get(Calendar.MONTH));
		
		if(weekDay!=firstDayOfWeek) System.out.println();
	}
}

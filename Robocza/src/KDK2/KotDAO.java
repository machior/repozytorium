package KDK2;

import java.util.ArrayList;

public class KotDAO {
	
	ArrayList<Kot> koty = new ArrayList<Kot>();
	
	public void dodajKota(Kot kot)
	{
		koty.add(kot);
	}
	
	public void pokazKoty()
	{
		for(Kot x : koty)
			System.out.println(x.przedstawSie());
	}

}

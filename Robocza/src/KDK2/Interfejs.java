package KDK2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interfejs {

    static Scanner sc = new Scanner(System.in);
    static KotDAO kotDAO = new KotDAO();
    
    private static void dodawanieKota()
    {
    	Kot kot = new Kot();

        System.out.print("Podaj imię kota: ");
        kot.setImie(getUserInput());

        Pattern wzorzecDaty = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String dataUrodzeniaWczytana;
        do {
            System.out.print("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            dataUrodzeniaWczytana = getUserInput();
            if (wzorzecDaty.matcher(dataUrodzeniaWczytana).matches()) {
            	try {
            		kot.setDataUrodzenia(sdf.parse(dataUrodzeniaWczytana));
            	} catch (ParseException pe) {
            		System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
            	}
            }
        } while (kot.getDataUrodzenia()==null);
        
        Pattern wzorzecWagi = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String wagaWczytana;
        do {
            System.out.print("Podaj wagę kota: ");
            wagaWczytana = getUserInput();
            
            if (wzorzecWagi.matcher(wagaWczytana).matches()) {
                kot.setWaga(Float.valueOf(wagaWczytana));
            }
        } while (kot.getWaga() == null);

        System.out.print("Podaj kto jest opiekunem kota: ");
        kot.setImieOpiekuna(getUserInput());

        System.out.println("Dziękuję, teraz wiem o kocie naprawdę wszystko!");
        
        kotDAO.dodajKota(kot);

    }
    
    private static void przegladKotow()
    {
    	
    }

    public static void main(String[] args) {
    	
    	System.out.println("Siemanko. Podaj czy chcesz dodać koty (1)\nobejżeć koty (2) \nczy zamknąć program (x)");
    	
    	boolean repeat=true;
		while(true) {
			repeat=false;
			switch (getUserInput()) {
			case "1":
				dodawanieKota();
				break;
			case "2":
				kotDAO.pokazKoty();
				break;
			case "x":
				System.exit(0);
			}
			
			System.out.println("Podaj czy chcesz dodać koty (1)\nobejżeć koty (2) \nczy zamknąć program (x)");
		}
    	
    }

    public static String getUserInput() {
        return sc.nextLine().trim();
    }

}

package hr.table.vsite.kruno;

import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;


/**
 * Klasa provjere
 * <p>U ovoj klasi su navedene neke od metoda koje æe vršiti provjere
 *  ili æe generirati neke podatke kao pomoæ u korištenju tablice</p> 
 *  <br>
 *  
 * @author Krunoslav
 *
 */
public class Provjere {
	
	/**
	 * Metoda provjere formata datuma
	 * 
	 * @param x to parametar koji se prosljeðuje metodi nad kojim æe se vršiti provjera korisnièkog unosa podatka(datuma) u textfield (textDob)
	 * @return vraæa true ako je korisnik unio ispravan format datuma a inaèe false ako je unijet krivi potpis datuma
	 */
	public static boolean checkDatePotpis(String x) {
		DateFormat format = new SimpleDateFormat("d.M.yyyy");
 
    try {
        format.parse(x);
    } 
    catch (ParseException e) {
    	
        return false;
}
   return true;
		
		
	}
/**
 * Metoda provjere stringa
 * <p>Provjera da li je korisnik unio stringovnu vrijednost ili brojèanu</p>
 * @param input metodi se prosljeðuje parametar tipa String nad kojim æe se vršiti provjera
 * @return vraæa true ako je istinito da je proslijeðeni string u brojèanom obliku, a false ako je stringovna vrijednost
 */
	
	
	static boolean provjeraStringa(String input)
	{
	    try
	    {
	        Integer.parseInt(input);
	    }
	    catch(NumberFormatException ex)
	    {
	        return false;
	    }
	    return true;
	}

	
	/**
	 * Metoda generiranja random broja
	 * <p> Metoda koja se poziva nakon odabira gumba za generiranje random broja. Korisniku je omoguæeno da sam ili uz pomoæ generatora odabere broj za id korisnika</p>
	 *
	 * @return metoda vraæa sluèajno generirani broj
	 */
	public static int getRandomNumberInts(){
	    Random random = new Random();
	    
		// Obtain a number between [0 - 49].
	    int n = random.nextInt(2550)+1;
	    return n;

	
}

	
}


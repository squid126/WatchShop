/**
 * 
 */
package watch;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Utilities for working with Watch objects.
 *
 * @author your name, id, email here
 * @version 2022-10-04
 */
public class WatchUtils {
		public static watch  getwatch(final Scanner keyboard) {

		// your code here
	    System.out.print("Brand: ");
	    String MBrand = keyboard.nextLine();
	    
	    System.out.print("Model: ");
	    String Mmodel = keyboard.nextLine();
	    
	    System.out.print("Year: ");
	    int myear = keyboard.nextInt();
	    keyboard.nextLine();
	    System.out.print("Price: ");
	    double mprice = keyboard.nextDouble();
	    System.out.print("Stock: ");
	    int mstock = keyboard.nextInt();
	    keyboard.nextLine();
	    System.out.print("Reference number: ");
	    String mref = keyboard.nextLine();
	  
	    watch w =new watch(MBrand,Mmodel,mprice,mstock,myear,mref);
	    
		return w;
	    }
		/**
	     * Creates a list of watches whose year is equal to the year parameter.
	     *
	     * @param watches List of watches.
	     * @param year  Year to compare against.
	     * @return List of watchs of year.
	     */
	    public static ArrayList<watch> getbYear(final ArrayList<watch> watches, final int year) {

	    	ArrayList<watch> mo = new ArrayList<>();
	    	for (final watch m : watches) {
	    		if (m.getYear()==year) {
	    			mo.add(m);
	    		}
	    		
	    		
	    	}

		return mo;
	    }
	    /**
	     * Creates a list of watches by brand .
	     *
	     * @param watches List of watches.
	     * @param Brand  brand of watches.
	     * @return List of watchs by brand.
	     */
	    public static ArrayList<watch> getbyBrand(final ArrayList<watch> watches, final String brand) {

	    	ArrayList<watch> mo = new ArrayList<>();
	    	for (final watch m : watches) {
	    		if (m.getBrand().equals(brand)) {
	    			mo.add(m);
	    		}
	 
	    	}
	    	for (final watch m : mo) {
	  	    	  System.out.println(m);
	  	      	}

		return mo;
	    }
	    /**
	     * Creates a list of watches by Model .
	     *
	     * @param watches List of watches.
	     * @param model  model of watches.
	     * @return List of watchs by model.
	     */
	    public static ArrayList<watch> getbyModel(final ArrayList<watch> watches, final String model) {

	    	ArrayList<watch> mo = new ArrayList<>();
	    	for (final watch m : watches) {
	    		if (m.getModel().equals(model)) {
	    			mo.add(m);
	    		}
	    		
	    		
	    	}
	    	return mo;
	    	
	    }
	    /**
	     * Creates a list of watches by that are greater than or equal to a price .
	     *
	     * @param watches List of watches.
	     * @param Brand  brand of watches.
	     * @return List of watchs by brand.
	     */
	    public static ArrayList<watch> getbyPrice(final ArrayList<watch> watches, final double price) {

	    	ArrayList<watch> mo = new ArrayList<>();
	    	for (final watch m : watches) {
	    		if (m.getPrice()>=price) {
	    			mo.add(m);
	    		}
	    		
	    		
	    	}

		return mo;
	    }

    	/**
	     * Creates a list of watches by Refrence number .
	     *
	     * @param watches List of watches.
	     * @param model  model of watches.
	     * @return List of watchs by model.
	     */
	    public static watch getbyRef(final ArrayList<watch> watches, final String ref) {

	    	
	    	for (final watch m : watches) {
	    		if (m.getRef().equals(ref)) {
	    			
	    			watch mo = new watch(m.getBrand(),m.getModel(),m.getPrice(),m.getStock(),m.getYear(),m.getRef());
	    			return mo;
	    		}
	    		
	    		
	    	}

	    	return null;
	    }
	    public static watch ReadWatch(final String line) {
	    	String[] result=line.split("[|]");//split using delimter
	    	
	    	//convert to proper type
	    	watch new_watch = new watch(result[0],result[1], Double.parseDouble(result[2]),Integer.parseInt(result[3]), Integer.valueOf(result[4]),(result[5]));
	    	return new_watch;
	    }
	    public static ArrayList<watch> ReadWatchs(final Scanner fileIn) {
	    	ArrayList<watch> watches = new ArrayList<>();
	    	
	    	String data;
	    	while (fileIn.hasNextLine()) {
	    		data=fileIn.nextLine();
	    		watches.add(WatchUtils.ReadWatch(data));
	    		
	    	}

	    	return watches;
	    }
}

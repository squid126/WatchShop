/**
 * 
 */
package watch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




/**
 * @author darwi
 *
 */
public class Watchmain {
	
	public static final String ROLEX = "Rolex";
	public static final String RM = "Richard Mille";
	public static final String AP = "Audemars Piguet";
	public static final String[] BRANDS = {ROLEX,RM,AP};
	public static void main(final String[] args) {
		ArrayList<watch> all_watches= new ArrayList<>();
		all_watches=allwatches();
		Scanner input = new Scanner(System.in);
	    int choice;
	    
	    do {
	      System.out.println("1. Display all products");
	      System.out.println("2. Search");//add a search method
	      System.out.println("3. Buy");
	      System.out.println("6. Exit");
	      System.out.print("Enter your choice: ");
	      
	      choice = input.nextInt();
	      switch(choice) {
	        case 1:
	        	for (final watch m : all_watches) {
	       		  System.out.println(m);
	        	}
	        	break;
	        case 2:
	        	search(input,all_watches);
	        	break;
	        case 3:
	        	//buy screen
	        	break;
	        case 6:
	        	System.out.println("Goodbye!");
	            break;
	        default:
	            System.out.println("Invalid choice, please try again");
	        }
	      } while(choice != 6);
	    input.close();
	}
	public static void buy(Scanner input,ArrayList<watch> watches){
		
		
	}
	public static void search(Scanner input,ArrayList<watch> watches) {
		
		
		ArrayList<watch> wat = new ArrayList<>();
	    int choice;
	    
	    
	    do {
	      System.out.println("1. Search by Brand");
	      System.out.println("2. Search by Model");
	      System.out.println("3. Search by Price");
	      System.out.println("4. Search by Year of release");
	      System.out.println("5. Search by Refrence number");
	      System.out.println("6. Back");
	      System.out.print("Enter your choice: ");
	      
	      choice = input.nextInt();
	      switch(choice) {
	        case 1:
	    		//get by brand
	        
	        	wat=Watchmain.byBrand(watches, input);
	        	printwatches(wat);
	        	break;
	        case 2:
	    		//get by moedel
	        	input.nextLine();
	        	wat=Watchmain.byModel(watches, input);
	        	
	        	//print watches
	        	
	        	break;
	        case 3:
	    		//get by price
	        	System.out.println("Enter a min price ");
		        choice = input.nextInt();
		        wat=WatchUtils.getbyPrice(watches, choice);
		      //print watches
	        	printwatches(wat);
		        
	        	break;
	        case 4:
	    		//get by year
	        	 System.out.println("Enter year");
	        	choice = input.nextInt();
	        	wat=WatchUtils.getbYear(watches, choice);
	        	//print watches
	        	printwatches(wat);
	        	break;
	        case 5:
	        	//get by ref
	        	input.nextLine();
	        	Watchmain.byRef(watches, input);
	        	
	        	break;
	        case 6:
	        	System.out.println("Goodbye!");
	            break;
	        default:
	            System.out.println("Invalid choice, please try again");
	        }
	     
	    			
	    		
	      } while(choice != 6);
	   
	}
	public static void printwatches(ArrayList<watch> watc) {
		if (watc != null) {
			for (final watch m : watc) {
		    	  System.out.println(m);
		      	}
		}
		
	}
	
	public static ArrayList<watch> allwatches() {
		ArrayList<watch> watches = null;
		try {
		    final File file = new File("testing.txt");
		    Scanner fileIn = new Scanner(file);
		    watches = WatchUtils.ReadWatchs(fileIn);
		    fileIn.close();
		} catch (FileNotFoundException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		//for (final watch m : watches) {
		 //   System.out.println(m);
		//}
		return watches;
	}
	
	public static ArrayList<watch> byBrand(final ArrayList<watch> watches,Scanner input) {
		
		ArrayList<watch> wat = null;
		int i_input=0;
	  
	
		//get by Brand
		do {
			
			//print out the brand names
			for (int i=0;i<BRANDS.length;i++) {
				System.out.printf("%d Brand: %s\r\n",i,BRANDS[i]);
			}
			System.out.printf("3 to go back\r\n ");
			System.out.printf("Enter your choice: ");
			//user entered a number
			if (input.hasNextInt()==true) {
				i_input=input.nextInt();
				input.nextLine();
				switch(i_input) {
				case 0:
					wat = WatchUtils.getbyBrand(watches, ROLEX);
					
					break;
				case 1:
					wat = WatchUtils.getbyBrand(watches, RM);
				

					break;
				case 2:
					wat = WatchUtils.getbyBrand(watches, AP);
					break;
				default:
					System.out.println("Invalid choice, please try again");
				}
				
			}
			
			
		} while (i_input!=3);
		
    	return wat;
		
	}
	public static ArrayList<watch> byModel(final ArrayList<watch> watches,Scanner input) {
		
		ArrayList<watch> wat = null;
		String s_input;
		int tick=0;
		do {
			if (tick==0) {
				System.out.printf("Enter the model or enter 0 to go back: ");
			}
			else {
				System.out.printf("Press 0 to go back or enter another model number:  ");
			}
			s_input = (input.nextLine());
			wat = WatchUtils.getbyModel(watches, s_input);
			printwatches(wat);
			if (wat.isEmpty()==true &&s_input.equals("0")==false) {
				System.out.printf("sorry we do not have this model ");
			}
			
			tick=1;
			s_input=s_input.trim();
			
		}while  (s_input.equals("0")!=true);//if flag is true it is a type int and we can convert it
		
		
	  
	
		//get by model
		
		
    	return wat;
		
	}
	
	
	public static void byRef(final ArrayList<watch> watches,Scanner input) {
		
		watch wat= null;
		String s_input;
		int tick=0;
		do {
			if (tick==0) {
				System.out.printf("Enter the Refrence number or enter 0 to go back: ");
			}
			else {
				System.out.printf("Press 0 to go back or enter another Refrence number:  ");
			}
			s_input = (input.nextLine());
			
			wat = WatchUtils.getbyRef(watches, s_input);
			if (wat!=null) {
				System.out.println(wat);
			}
			if (wat==null &&s_input.equals("0")==false) {
				System.out.printf("sorry we do not have this refrence number ");
			}
			
			tick=1;
			s_input=s_input.trim();
			
		}while  (s_input.equals("0")!=true);//if flag is true it is a type int and we can convert it
		
		
    	
		
	}
}
	
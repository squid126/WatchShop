package watch;



/**
 * Movie class definition.
 *
 * @author darwin
 * @version 2022-10-04
 */
public class watch implements Comparable<watch> {
	//Attributes
	private String Brand="";
	private String Model="";
	private double Price=0.0;
	private int Stock=0;
	private int Year=0;
	private String Ref="";
	/**
     * Instantiates a watch object.
     *
     * @param Brand   Brand
     * @param year    Year of release.
     * @param Model   Model.
     * @param Stock   how many we have
     * @param Price   How much it cost.
     */
	public watch(final String Brand, final String Model, final double Price, final int Stock, final int Year,final String Ref) {

		// your code here
		this.Brand=Brand;
		this.Model=Model;
		this.Price=Price;
		this.Stock=Stock;
		this.Year=Year;
		this.Ref=Ref;

		return;
	    }

	
	/**
	 * @return the ref
	 */
	public String getRef() {
		return Ref;
	}


	/**
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		Ref = ref;
	}


	/**
	 * @return the brand
	 */
	public String getBrand() {
		return Brand;
	}


	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		Brand = brand;
	}


	/**
	 * @return the model
	 */
	public String getModel() {
		return Model;
	}


	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		Model = model;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return Price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		Price = price;
	}


	/**
	 * @return the stock
	 */
	public int getStock() {
		return Stock;
	}


	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		Stock = stock;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return Year;
	}


	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		Year = year;
	}


	@Override
	public int compareTo(watch o) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
     * Creates a formatted string of watch key data in the format "brand, model price and year". Ex:
     * .
     *
     * @return A watch key as a string.
     */
	 @Override
	    public String toString() {

		// your code here
	    	String mo=String.format(
	    			 "Brand:    %s\r\n"
	    			+"Model:    %s\r\n"
	    			+"Refrence: %s\r\n"
	    			+"Stock:    %d\r\n"
	    			+"Year:     %d\r\n"
	    			+"Price:    $%2.1f\r\n"
	    			,this.Brand,this.Model,this.Ref,this.Stock,this.Year,this.Price
	    			);

		return mo;
	    }
}

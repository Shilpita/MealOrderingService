/**
 * @createdFor : Recipe object are created from the textFiles
 */
package roy.assign2.pkg.recipes;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public class Recipe {
	//data members
	private String name;
	private String description;
	private double cost;
	private int calories;
	
	/* Default Constructor */
	public Recipe(){
		this.name 			= "not set";
		this.description	= "not set";
		this.cost			= 0;
		this.calories		= 0;
	}
	
	/**
	 *  Parameterized Constructor
	 * @param name
	 * @param description
	 * @param cost
	 * @param calories
	 */
	public Recipe(String name, String description, double cost, int calories){
		if(name != null) 		this.name 			= name;
		if(description != null) this.description	= description;
		if(cost >=0)			this.cost			= cost;
		if(calories >=0)        this.calories		= calories;
	}
	
	/**Access Methods**/
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	
	public double getCost(){
		return cost;
	}
	
	public int getCalories(){
		return calories;
	}
	
	/**Setter Methods**/
	@SuppressWarnings("unused")
	private void setName(String name){
		if(name != null)
			this.name = name;
	}
	
	@SuppressWarnings("unused")
	private void setDescription(String description){
		if(description != null) 
			this.description = description;
	}
	
	
	@SuppressWarnings("unused")
	private void setCost(double cost){
		if(cost >=0) 
			this.cost = cost;
	}
	
	@SuppressWarnings("unused")
	private void setCalories(int calories){
		if(calories >=0) 
			this.calories= calories;
	}
}

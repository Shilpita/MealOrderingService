/**
 * Diet Plan of Type LOW_CARB
 */
package roy.assign2.pkg.diet;

import roy.assign2.pkg.mealcategories.*;
import roy.assign2.pkg.mealtype.*;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public class LowCarbDietPlan  extends ParentDietPlan implements DietPlan{

	private MealCategory lowCarbMeal;
	
	// Default Constructor
	public LowCarbDietPlan(){
		super();
		this.lowCarbMeal= new LowCarbMeal();
	}
	
	/**
	 * Parameterized Constructor creates the recipe list from the parsed file creates a lunch an dinner object
	 * @param filename
	 * @param dayOfWeek
	 */
	public LowCarbDietPlan(String filename , int dayOfWeek){
		//this.filename = filename;
		super(filename,dayOfWeek);
		this.lowCarbMeal = new LowCarbMeal();;
		lowCarbMeal.loadRecipes(this.fileName);
		this.lunch 	= new Lunch(lowCarbMeal);
		lowCarbMeal.removeRecipeFromList(lunch.getARecipe()); //the recipe selected for lunch is removed from list to avoid repetition
		this.dinner = new Dinner(lowCarbMeal);
	}


}

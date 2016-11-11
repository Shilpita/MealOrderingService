/**
 * Diet Plan for HIGH_CARB category
 */
package roy.assign2.pkg.diet;

import roy.assign2.pkg.mealcategories.*;
import roy.assign2.pkg.mealtype.*;


/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public class HighCarbDietPlan extends ParentDietPlan implements DietPlan{

	private MealCategory highCarbMeal;
	
	// Default Constructor
	public HighCarbDietPlan(){
		super();
		this.highCarbMeal= new HighCarbMeal();
	}
	
	/**
	 *  Parameterized Constructor creates the recipe list from the parsed file creates a lunch an dinner object
	 * @param filename
	 * @param dayOfWeek
	 */
	public HighCarbDietPlan(String filename , int dayOfWeek){
		//this.filename = filename;
		super(filename,dayOfWeek);
		this.highCarbMeal= new HighCarbMeal();
		highCarbMeal.loadRecipes(this.fileName);
		this.lunch 	= new Lunch(highCarbMeal);
		highCarbMeal.removeRecipeFromList(lunch.getARecipe());//the recipe selected for lunch is removed from list to avoid repetition
		this.dinner = new Dinner(highCarbMeal);
	}


}

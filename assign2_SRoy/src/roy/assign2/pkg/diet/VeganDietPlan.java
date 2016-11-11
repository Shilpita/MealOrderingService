/**
 * Diet plan of type VEGAN 
 */
package roy.assign2.pkg.diet;

import roy.assign2.pkg.mealcategories.*;
import roy.assign2.pkg.mealtype.*;


/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public class VeganDietPlan extends ParentDietPlan implements DietPlan{

	private MealCategory veganMeal;
	
	// Default Constructor
	public VeganDietPlan(){
		super();
		this.veganMeal= new VeganMeal();
	}
	
	/**
	 * Parameterized Constructor creates the recipe list from the parsed file creates a lunch an dinner object
	 * @param filename
	 * @param dayOfWeek
	 */
	public VeganDietPlan(String filename , int dayOfWeek){
		//this.filename = filename;
		super(filename,dayOfWeek);
		this.veganMeal = new VeganMeal();
		veganMeal.loadRecipes(this.fileName);
		this.lunch 	= new Lunch(veganMeal);
		veganMeal.removeRecipeFromList(lunch.getARecipe());// the recipe selected for lunch is remove from the list to avoid repetition
		this.dinner = new Dinner(veganMeal);
	}

}

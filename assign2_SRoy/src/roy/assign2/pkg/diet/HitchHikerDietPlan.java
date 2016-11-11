/**
 * Diet Plan for Hitch Hiker
 */
package roy.assign2.pkg.diet;

import roy.assign2.pkg.mealcategories.*;
import roy.assign2.pkg.mealtype.*;


/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public class HitchHikerDietPlan extends ParentDietPlan implements DietPlan{

	private MealCategory hitchHikerMeal;
	
	// Default Constructor
	public HitchHikerDietPlan(){
		super();
		this.hitchHikerMeal= new HitchHikerMeal();
	}
	
	/**
	 *  Parameterized Constructor creates the recipe list from the parsed file creates a lunch an dinner object
	 * @param filename
	 * @param dayOfWeek
	 */
	public HitchHikerDietPlan(String filename , int dayOfWeek){
		super(filename,dayOfWeek);
		this.hitchHikerMeal= new HitchHikerMeal();
		hitchHikerMeal.loadRecipes(this.fileName);
		this.lunch 	= new Lunch(hitchHikerMeal);
		hitchHikerMeal.removeRecipeFromList(lunch.getARecipe());//the recipe selected for lunch is removed from list to avoid repetition
		this.dinner = new Dinner(hitchHikerMeal);
	}


}

/**
 * Abstract Parent class for the Meal type
 */
package roy.assign2.pkg.mealtype;

import roy.assign2.pkg.mealcategories.MealCategory;
import roy.assign2.pkg.recipes.Recipe;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public abstract class ParentMeal implements Meal {
	protected Recipe recipe;
	protected MealCategory mealCategory;
	
	
	/**
	 * Default Constructor
	 */
	public ParentMeal(){
		this.recipe = null;
		this.mealCategory = null;
	}

	/**
	 * Parameterized Constructor creates the meal of given category and selects recipe from the available meal
	 * @param mealCategory
	 */
	public ParentMeal(MealCategory mealCategory){
        this.mealCategory = mealCategory;
        this.recipe = mealCategory.getARecipe();	
	}
	
	/**
	 * To get the selected recipe for the meal
	 * @return selected recipe
	 */
	@Override
	public Recipe getARecipe() {
		return recipe;
	}
	
	/**
	 * To get the calories of selected recipe for the meal by calling getCalories() function
	 * @return calories
	 */
	@Override
	public int showCalories() {
		return recipe.getCalories();
	}

	
	/**
	 * To get the cost of selected recipe for the meal by calling getCost() function
	 * @return calories
	 */
	@Override
	public double showCost() {
		return recipe.getCost();
	}


}

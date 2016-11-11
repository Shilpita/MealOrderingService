/**
 * Interface for Meal type: Lunch or Dinner
 */
package roy.assign2.pkg.mealtype;

import roy.assign2.pkg.recipes.Recipe;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public interface Meal {
	
	public int showCalories();
	public double showCost();
	public String getDetails();
	public Recipe getARecipe();
}

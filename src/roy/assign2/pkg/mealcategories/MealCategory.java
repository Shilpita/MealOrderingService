/**
 * @createFor : Interface MealCategory for recipes
 */
package roy.assign2.pkg.mealcategories;

import java.util.ArrayList;

import roy.assign2.pkg.recipes.Recipe;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public interface MealCategory {
	
	public ArrayList<Recipe> showRecipes();
	public Recipe getARecipe();
	public void loadRecipes(String fileName);
	public void removeRecipeFromList(Recipe lunchRecipe);
	
}

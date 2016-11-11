/**
 * Abstract Parent Class for Meal Categories
 */
package roy.assign2.pkg.mealcategories;

import java.io.*;
import java.util.*;

import roy.assign2.pkg.recipes.Recipe;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */

public abstract class  ParentMealCategory implements MealCategory {
	protected ArrayList<Recipe> recipeList; //array list to store parsed recipes
	
	public static final int INDEX_RECIPE_NAME = 0;
	public static final int INDEX_RECIPE_DESCRIPTION = 1;
	public static final int INDEX_RECIPE_COST = 2;
	public static final int INDEX_RECIPE_CALORIES = 3;
	
	/**Default Constructor*/
		public ParentMealCategory(){
			this.recipeList = new ArrayList<Recipe>() ;
		}
	
	/**
	 * @return : recipeList
	 * Returns the ArrayList of the recipes created
	 */
	@Override
	public ArrayList<Recipe> showRecipes() {
		return recipeList;	
	}

	
	/**
	 * @return Recipe 
	 * Returns a randomly selected Recipe from RecipeList 
	 */
	@Override
	public Recipe getARecipe() {
		Random r = new Random();
		int low = 0;
		int high = recipeList.size();
		int result = r.nextInt(high-low) + low;
		return showRecipes().get(result);
	}

	/**
	 * @param : fileName
	 * Reads the text file with the name 'filename' line by line 
	 * parses the lines and creates recipes objects to be added to the recipeList.
	 */
	@Override
	public void loadRecipes(String fileName) {
		FileInputStream fstream = null;
		BufferedReader br		= null;
		String strLine;
		String delimiter = ":";
		try {
				fstream  = new FileInputStream(fileName);
				br 		 = new BufferedReader(new InputStreamReader(fstream));
				//Read File Line By Line
				while ((strLine = br.readLine()) != null)   {
						String[] tokens = strLine.split(delimiter);
						if(tokens.length == 4){
							    // instance of recipe created and added to recipe list
								recipeList.add(new Recipe(tokens[INDEX_RECIPE_NAME]
														 ,tokens[INDEX_RECIPE_DESCRIPTION] 
										                 ,Double.parseDouble(tokens[INDEX_RECIPE_COST]) 
										                 ,Integer.parseInt(tokens[INDEX_RECIPE_CALORIES])
										                 ));
						}
				}
			} catch (FileNotFoundException e) {
						e.printStackTrace();
			} catch (IOException e) {
						e.printStackTrace();
			}finally{
				//Close the input stream
				if (br != null )
						try {
								br.close();
						} catch (IOException e) {
								e.printStackTrace();
						}
				if(fstream != null)
						try {
								fstream.close();
						} catch (IOException e) {
								e.printStackTrace();
						}
			}
	}
	
	
	/**
	 * @param : Reciepe
	 * Removes the Already create Recipe from list to avoid repetition
	 */
	@Override
	public void removeRecipeFromList(Recipe lunchRecipe) {
		showRecipes().remove(lunchRecipe);
	}



}

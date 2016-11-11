/**
 * Class for the Meal Type Lunch
 */
package roy.assign2.pkg.mealtype;

import roy.assign2.pkg.mealcategories.MealCategory;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public class Lunch extends ParentMeal {
	
	/**Default Constructor*/
	public Lunch(){
		super();
	}

	/**
	 * Parameterized Constructor to create meal of given meal category
	 * @param mealCategory
	 */
	public Lunch(MealCategory mealCategory){
        super(mealCategory);
	}
	
	/**
	 * @return lunch details with recipe, cost and calories
	 */
	@Override
	public String getDetails() {
		return "LUNCH : "+ super.recipe.getName()
			   + "\nDESCRIPTION : " + recipe.getDescription()
			   + "\nCALORIES : "+ showCalories() +"cal"
			   + "\nCOST : $"+ showCost();
	}



}

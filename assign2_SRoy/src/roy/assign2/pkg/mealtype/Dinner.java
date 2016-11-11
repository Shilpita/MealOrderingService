/**
 * Class for the Meal Type Dinner
 */
package roy.assign2.pkg.mealtype;

import roy.assign2.pkg.mealcategories.MealCategory;

/**
 * @author ShilpitRoy(W1190513)
 */
public class Dinner extends ParentMeal {

	protected boolean delivery;
	protected double deliveryFee;
	private static final int MAX_FEE =5; // default delivery fees
	
	/**
	 * Default Constructor
	 */
	public Dinner(){
		super();
		this.delivery = false;
		this.deliveryFee = 0;
	}

	/**
	 * Parameterized Constructor creates dinner object with given meal category and set delivery fees to default
	 * @param mealCategory
	 */
	public Dinner(MealCategory mealCategory){
		super(mealCategory);
        this.delivery = false;
        this.deliveryFee = MAX_FEE;
	}
	
	/**
	 * @return Dinner details with recipe, cost and calories
	 */
	@Override
	public String getDetails() {
		return "DINNER : "+ super.recipe.getName()
		   + "\nDESCRIPTION : " + recipe.getDescription()
		   + "\nCALORIES : "+ showCalories() +" cal"
		   + "\nCOST : $"+ recipe.getCost()
		   + "\nDELIVERY FEE : $"+ getDeliveryFee()
		   + "\nTOTAL MEAL COST: $"+ showCost();
	}
	
	/**
	 * @return total cost of meal and delivery fees
	 */
	@Override
	public double showCost() {
		return recipe.getCost()+ getDeliveryFee();
	}
	
	/**
	 * Setter function for delivery fees checks the input is not negative
	 * @param fee
	 */
	@SuppressWarnings("unused")
	private void setDeliveryFee(double fee){
		if(fee >= 0)
			deliveryFee = fee;
	}
	
	/**
	 * Getter function for delivery fees
	 * @return delivery fees
	 */
	public double getDeliveryFee(){
		return deliveryFee;
	}
	
}

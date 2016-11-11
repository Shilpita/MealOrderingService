/**
 * Abstract parent class for Diet Plan
 */
package roy.assign2.pkg.diet;

import roy.assign2.pkg.mealtype.Dinner;
import roy.assign2.pkg.mealtype.Lunch;
import roy.assign2.pkg.mealtype.Meal;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public abstract class ParentDietPlan implements DietPlan {
	protected Meal lunch;
	protected Meal dinner;

	protected String dayOfWeek;
	protected String fileName;
	private static final String[] WEEKDAYS ={"Sunday"
								,"Monday"
								,"Tueday"
								,"Wednesday"
								,"Thrusday"
								,"Friday"
								,"Saturday"
								};
	
	/**Default constructor */
	public ParentDietPlan(){
			this.fileName 	= "not set";
			this.dayOfWeek	= WEEKDAYS[0];
			this.lunch 	= new Lunch();
			this.dinner = new Dinner();
	}
	
	/**
	 * Parameterize constructor sets day of week and file name while sets the meal references to null 
	 * Specific meals(lunch dinner objects) created in child classes
	 * @param filename
	 * @param dayOfWeek
	 */
	public ParentDietPlan(String filename , int dayOfWeek){
				this.fileName 	= filename;
				this.dayOfWeek	= WEEKDAYS[dayOfWeek];
				this.lunch 	= null;
				this.dinner = null;
		}
	
	/**
	 * @return details of the lunch and dinner along with total diet plan cost and day of week
	 */
	@Override
	public String showPlan() {
		return "\n"+lunch.getDetails()+"\n\n"+ dinner.getDetails() 
				+"\n\nTOTAL COST OF PLAN : $"+ getCostOfPlan()
				+"\nDAY OF WEEK : "+ dayOfWeek.toUpperCase();
	}

	/**
	 * @return total plan cost including lunch and dinner
	 */
	@Override
	public double getCostOfPlan() {
		return lunch.showCost()+ dinner.showCost();
	}
}

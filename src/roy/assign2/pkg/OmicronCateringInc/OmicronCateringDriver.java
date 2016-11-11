/**
 * The driver function to order meals from Omicron Catering Inc.
 * @author ShilpitaRoy(W1190513)
 */
package roy.assign2.pkg.OmicronCateringInc;

import roy.assign2.pkg.order.DietPlanOrder;
import roy.assign2.pkg.order.MealType;


public class OmicronCateringDriver {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		boolean paymentStatus ;
		System.out.println("=================================VEGAN MEAL=====================================");
		DietPlanOrder planOrder1 = new DietPlanOrder("Mary Jones", MealType.VEGAN,"VeganRecipes.txt");
		paymentStatus    = planOrder1.acceptPayment("Visa", "412 183 395 5555", 100);		
		planOrder1.generateInvoice();
		
		System.out.println("=================================LOW CARB MEAL=====================================");
		DietPlanOrder planOrder2 = new DietPlanOrder("Jimmy Fallon", MealType.LOW_CARB,"LowCarbRecipes.txt");
		paymentStatus    = planOrder2.acceptPayment("Visa", "412 124 656 5", 100);		
		planOrder2.generateInvoice();
		
		System.out.println("=================================HIGH CARB MEAL=====================================");
		DietPlanOrder planOrder3 = new DietPlanOrder("Saptarshi Sen", MealType.HIGH_CARB,"HighCarbRecipes.txt");
		paymentStatus    = planOrder3.acceptPayment("Master card", "512 123 345 5555", 100);		
		planOrder3.generateInvoice();
		
		System.out.println("=================================VEGAN MEAL=====================================");
		DietPlanOrder planOrder4 = new DietPlanOrder("Vanita Ray", MealType.VEGAN,"VeganRecipes.txt");
		paymentStatus    = planOrder4.acceptPayment("Visa", "512  2343 565555", 100);		// Invalid Visa card format
		planOrder4.generateInvoice();
		System.out.println();
		paymentStatus    = planOrder4.acceptPayment("Visa", "412312343456555523", 100);		// Invalid visa card length
		planOrder4.generateInvoice();
		System.out.println();
		paymentStatus    = planOrder4.acceptPayment("Visa", "4123123434565555", 0);		//Insufficient funds
		planOrder4.generateInvoice();
		System.out.println();
		paymentStatus    = planOrder4.acceptPayment("Mastercard", "4123123434565555", 100);		// Invalid master card format
		planOrder4.generateInvoice();
		System.out.println();
		paymentStatus    = planOrder4.acceptPayment("Master Card", "5923123434565555", 100);	// Invalid master card format	
		planOrder4.generateInvoice();
		System.out.println();
		paymentStatus    = planOrder4.acceptPayment("Master Card", "51231234347555", 100);		// Invalid master card length
		planOrder4.generateInvoice();
		System.out.println();
		paymentStatus    = planOrder4.acceptPayment("Master Card", "512 123 345 5235", 100);	// Valid payment	
		planOrder4.generateInvoice();
		
		System.out.println("\n** VANITA'S NEXT VEGAN ORDER **\n");
		planOrder4 = new DietPlanOrder("Vanita Ray", MealType.VEGAN,"VeganRecipes.txt"); // next order created
		paymentStatus    = planOrder4.acceptPayment("Visa", "412 234 565 5551", 100);		
		planOrder4.generateInvoice();
		
	}

}

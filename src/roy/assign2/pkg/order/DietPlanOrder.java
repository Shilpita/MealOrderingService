/**
 * 
 */
package roy.assign2.pkg.order;

import java.util.*;
import roy.assign2.pkg.diet.*;

/**
 * @author ShilpitaRoy(W1190513)
 *
 */
public class DietPlanOrder {
	
	private String customerName;
	private DietPlan plan;
	private boolean paymentStatus;

	private static final int MATERCARD_LENGTH = 16; // the valid master card length is 16
	private static final int VISACARD_LENGTH = 13; // the valid visa card length is 13 or 16
	private static final ArrayList<String> CARDTYPE = new ArrayList<>(Arrays.asList("Master Card","Visa")); // the accepted card types
	
	private static Date date = new Date(); //get current date time with Date()
	//private static final int TOTAL_WEEK_DAY= 7;
	private String ERROR_CODE; // To display error messages
	
	//Default constructor
	public DietPlanOrder(){
		this.customerName = "No name";
		this.paymentStatus= false;
	}
	
	/**
	 * Parameterized Constructor initiates data members and created meal depending on MealType
	 * @param customerName
	 * @param mealType
	 * @param fileName
	 */
	public DietPlanOrder(String customerName, MealType mealType ,String fileName){
		this.customerName = customerName;
		this.paymentStatus= false;
		
		switch(mealType){
		case VEGAN :
			this.plan = new VeganDietPlan(fileName,getDayOfWeek());
			break;
		case LOW_CARB :
			this.plan = new LowCarbDietPlan(fileName,getDayOfWeek());
			break;
		case HIGH_CARB :
			this.plan = new HighCarbDietPlan(fileName,getDayOfWeek());
			break;
		}
	}
	
	/**
	 * 
	 * @return day of the week between 0(SUNDAY) to 6(SATURDAY)
	 */
	
	private int getDayOfWeek(){
		/*Random r = new Random();
		int low = 0;
		int high = TOTAL_WEEK_DAY;
	    return r.nextInt(high-low) + low;*/
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_WEEK)-1;
	}
	
	/**
	 * Setter function for payment status
	 * @param status
	 */
	
	private void setPaymentStatus(boolean status){
		  paymentStatus= status;
	}
	
	/**
	 * The total cost of plan is obtained by calling getCostOfPlan() method on object DietPlan
	 * @return Total cost of the plan
	 */
	protected double getCost(){
		return plan.getCostOfPlan();
	}
	
	/**
	 * Getter function to return payment status of order.
	 * @return paymentStatus
	 */
	
	public boolean getPaymentStatus(){
		  return paymentStatus;
	}
	
	/**
	 * Getter function to return customer name.
	 * @return customerName
	 */
	public String getCustomerName(){
		  return customerName;
	}
	
	/**
	 * Validates the payment details as follows-
	 * 		if the received amount is sufficient to cover the cost of the order else show insufficient funds
	 * 		if the entered card is not either master card or visa card with valid length and format show invalid card error
	 *      if everything is correct the set payment status true. 
	 * @param cardName
	 * @param cardNumber
	 * @param amount
	 * @return paymentStatus
	 */
	
	public boolean acceptPayment(String cardName, String cardNumber , double amount){
		if (amount >= getCost()){
				if(cardName.equalsIgnoreCase(CARDTYPE.get(0))){
							if(cardNumber.length() == MATERCARD_LENGTH){
									if(Integer.parseInt(cardNumber.substring(0,1)) == 5 && 
									     (Integer.parseInt(cardNumber.substring(1,2)) >= 1 && Integer.parseInt(cardNumber.substring(1,2))<= 5))
										 		setPaymentStatus(true); 
									else
										ERROR_CODE = "INVALID MASTER CARD NUMBER";
							}else
								ERROR_CODE = "INVALID MASTER CARD LENGTH";
				}else if(cardName.equalsIgnoreCase(CARDTYPE.get(1))){
							if(cardNumber.length() == MATERCARD_LENGTH || cardNumber.length() == VISACARD_LENGTH){
									if(Integer.parseInt(cardNumber.substring(0,1))== 4)
										setPaymentStatus(true); 
									else
										ERROR_CODE = "INVALID VISA CARD NUMBER";
										
							}else
								ERROR_CODE = "INVALID VISA CARD LENGTH";
				}else{
						setPaymentStatus(false);
						ERROR_CODE = "ENTER VALID MASTER OR VISA CARD";
				}
		}else{
			setPaymentStatus(false);
			ERROR_CODE = "NOT ENOUGH BALANCE ON CARD";
		}
		return getPaymentStatus();
	}
	
	/**
	 * The invoice for the order is generated showing
	 *     - customer name
	 *     - today date
	 *     - order details for lunch and dinner
	 *     - total cost of order
	 *     - Day of week
	 */
	
	public void generateInvoice(){
		if(getPaymentStatus()){
			System.out.println("CUSTOMER_NAME: "+ getCustomerName()
							+"\nTODAY'S DATE : "+ date
							+"\n-----------DETAILS OF MEAL PLAN-----------"+ plan.showPlan());
		}else
			System.out.println(ERROR_CODE);
	}

}

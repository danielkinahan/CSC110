/*
* Name: Daniel Kinahan
* ID: V00887329
* Date: 03/10/2017
* Filename: CarbonFootprint.java
* Details: \CSC110\ Assignment 3
*/

import java.util.Scanner;
public class CarbonFootprint
{
	/*
	* The class CarbonFootprint contains methods for
	* performing basic calculations with multiple
	* variables based on lifestyle  of the user in
	* order to calculate a rough estimate of CO2
	* produced per year.
	*/
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);

		//Interaction with transportation method
		System.out.println("How many kilometres do you drive per day?");
		double kPD = input.nextDouble();
		System.out.println("What is the fuel efficiency of your car in km/L?");
		double effic = input.nextDouble();
		double trans = transportationFootprint(kPD, effic);
		System.out.println("Your carbon footprint with respect to transportation is " + trans + " kgCO2/year.");
		System.out.println();

		//Interaction with electricity method
		System.out.println("How many kilowatt hours per month do you use?");
		double kwHours = input.nextDouble();
		System.out.println("How many people are in your household?");
		int num = input.nextInt();
		double elec = electricityFootprint(kwHours, num);
		System.out.println("Your carbon footprint with respect to electricity is " + elec + " kgCO2/year.");
		System.out.println();
		
		//Interaction with food method
		System.out.println("What percentage of your diet is meat and fish?");
		double meat = input.nextDouble();
		System.out.println("What percentage of your diet is dairy?");
		double dairy = input.nextDouble();
		System.out.println("What percentage of your diet is fruit and vegetables?");
		double fv = input.nextDouble();
		System.out.println("What percentage of your diet is carbohydrates?");
		double carb = input.nextDouble();
		//Percentages cannot add to more than 100, this will stop the code when the user inputs incorrect values
		if((meat + dairy + fv + carb)!=100)
		{
			System.out.println("Sum of percentages does not equal 100%");
			System.exit(0);
		}
		double food = foodFootprint(meat, dairy, fv, carb);
		System.out.println("Your carbon footprint with respect to food consumption is " + food + " kgCO2/year.");
		System.out.println();
		
		//Interaction with the method that totals the 3 other methods
		double total = totalFootprint(trans, elec, food);
		System.out.println("Your total carbon footprint is " + total + " metric tons of CO2 per year.");
		
	}

	/*
	* Converts Kilometres driven daily and fuel efficiency to CO2/year.
	* input: Kilometres and fuel efficiency.
	* returns : CO2/year attributed to transportation.
	*/
	public static double transportationFootprint(double kPD, double effic)
	{
		double kmPerDay = kPD;
		double fuelEfficiency = effic;
		double litresUsedPerYear = 365 * (kmPerDay/fuelEfficiency);
		litresUsedPerYear *= 2.3;
		return litresUsedPerYear;
	}

	/*
	* Converts kwHours used yearly and household residents to CO2/year.
	* input: KwHours and household residents.
	* returns : CO2/year attributed to electricity usage.
	*/
	public static double electricityFootprint(double kwHours, int num)
	{
		double kWhPerMonth = (kwHours * 12 * 0.257);
		int numPeopleInHome = num;
		return (kWhPerMonth/numPeopleInHome);
	}

	/* Converts diet makeup by percentage to CO2/year.
	* input: Percentage of diet that is divided between the four food groups.
	* returns : CO2/year attributed to food consumption.
	*/
	public static double foodFootprint(double meat, double dairy, double fv, double carb)
	{
		double meatPrint = meat * 0.531;
		double dairyPrint = dairy * 0.138;
		double fruitPrint = fv * 0.076;
		double carbPrint = carb * 0.031;
		return (meatPrint + dairyPrint + fruitPrint + carbPrint);
	}

	/* Combines all methods and returns CO2/year in metric tons.
	* input: All methods used to calculate CO2/year in specific aspects of users life.
	* returns : CO2/year in total, in metric tons.
	*/
	public static double totalFootprint(double trans, double elec, double food)
	{	
		double transportationFootprint = trans;
		double electricityFootprint = elec;
		double foodFootprint = food;
		return ((transportationFootprint + electricityFootprint + foodFootprint)/1000);
	}
}
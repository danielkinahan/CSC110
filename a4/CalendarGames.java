/*
* Name: Daniel Kinahan
* ID: V00887329
* Date: 23/10/2017
* Filename: CalendarGames.java
* Details: \CSC110\ Assignment 4
*/

import java.util.Scanner;

/*
* The class CalendarGames contains a method for
* performing basic deduction of birth date
* using temporary data and counting variables.
*/
public class CalendarGames
{
	public static void main(String[] args)
	{
		guessMyBirthday();
	}

	/*
	* Converts month integer to month String.
	* input: The month represented as an integer.
	* returns : The converted month as a String.
	*/
	public static String monthToString(int month)
	{
		String monthString = "";
		switch (month) 
		{
           		case 1:  monthString = "January";
			break;
            		case 2:  monthString = "February";
			break;
            		case 3:  monthString = "March";
			break;
            		case 4:  monthString = "April";
			break;
           		case 5:  monthString = "May";
			break;
           		case 6:  monthString = "June";
			break;
            		case 7:  monthString = "July";
			break;
            		case 8:  monthString = "August";
			break;
            		case 9:  monthString = "September";
			break;
            		case 10: monthString = "October";
			break;
            		case 11: monthString = "November";
			break;
            		case 12: monthString = "December";
			break;
            		default: monthString = "Invalid month";
			break;
		}
		return monthString;
	}

	/*
	* Gives a boolean statement based on if it is a leap year.
	* input: The users birth year.
	* returns : True/false depending on the year.
	*/
	public static boolean isLeapYear(int year)
	{
		if (year%4!=0)
		{
			return false;
		}
		else if (year%100!=0)
		{
			return true;
		}
		else if (year%400!=0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/*
	* Gives the amount of days in a month based on year and month using isLeapYear().
	* input: The month and the year which it falls in.
	* returns : The amount of days in that month.
	*/
	public static int numDaysInMonth(int month, int year)
	{
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
		{
			return 31;
		}
		else if(month==2)
		{
			if(isLeapYear(year))
			{
				return 29;
			}
			else
			{
				return 28;
			}
		}
		else
		{
			return 30;
		}
			
	}

	/*
	* Performs two while loops to guess the birthday of
	* the user relying on the numDaysInMonth() and the
	* monthToString() methods.
	*/
	public static void guessMyBirthday()
	{	
		Scanner input = new Scanner(System.in);
		String user;
		//Birth year will be used for isLeapYear() method.
		System.out.println("What is your birth year?");
		int year = input.nextInt();
		int counter = 0;
		int month = -1;
		int x = 3; //Variable that is added or subtracted to monthGuess
		int monthGuess = 6;
		int day = -1;
		int dayGuess = 16;
		int y = 8; //Variable that is added or subtracted to dayGuess
		
		//Guesses month of birthday until user assigns a month to be correct.
		while (month<0)
		{
			counter++;
			System.out.println("Is your birthday in " + monthToString(monthGuess) + "? (yes/no)");
			user = input.next();
			if (user.equals("yes"))
			{
				month = monthGuess;
			}
			else //user enters "no"
			{
				System.out.println("Is your birthday after this month? (yes/no)");
				user = input.next();
				if(user.equals("yes"))
				{
					monthGuess += x;
					//While loop is for correcting the date if it doesn't exist
					while(monthGuess>12)
					{
						monthGuess--;
					}

				}
				else //user enters "no"
				{
					monthGuess -= x;
					//While loop is for correcting the date if it doesn't exist
					while(monthGuess<0)
					{
						monthGuess++;
					}
				}
			}
			if(x>0)
			{
				x--;
			}
		}
		
		//Guess day of birthday until user assigns a day to be correct.
		while (day<0)
		{
			counter++;
			System.out.println("Is your birthday in " + monthToString(month) + " " + dayGuess + "? (yes/no)");
			user = input.next();
			if (user.equals("yes"))
			{
				day = dayGuess;
			}
			else //user enters "no"
			{
				System.out.println("Is your birthday after this day? (yes/no)");
				user = input.next();
				if(user.equals("yes"))
				{
					dayGuess += y;
					//While loop is for correcting the date if it doesn't exist
					while(dayGuess>numDaysInMonth(month, year))
					{
						dayGuess--;
					}
				}
				else //user enters "no"
				{
					dayGuess -= y;
					//While loop is for correcting the date if it doesn't exist
					while(dayGuess<0)
					{
						dayGuess++;;
					}
				}
			}
			y=y/2;
		}
		System.out.println("It took " + counter + " guesses to find your birthday, which is " + monthToString(month) + " " + day);
	}
}
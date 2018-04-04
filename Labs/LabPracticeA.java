import java.util.Scanner;

public class LabPracticeA
{
	public static void printer()
	{
		System.out.println("Hello");
	}
	
	public static void main(String[] args)
	{
		printer();
		Scanner inputName = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = inputName.nextLine();
		System.out.println("Pleasure to meet you " + name + "!");
		System.out.println("I have no name for I am simply a product of code displayed on your screen.");
		Scanner inputAge = new Scanner(System.in);
		System.out.println("Enter your age human: ");
		String age = inputAge.nextLine();
		System.out.println("Your information has been processed and will be sold to the following ad companies.");
	}
}

import java.util.Scanner;

public class LabPracticeB
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n,fact=1;
		System.out.println("Enter an integer to calculate the factorial:");
		int c=input.nextInt();
		for(n=1;n<=c;n++)
		{
			fact=fact*n;
		}
		System.out.println("Factorial of " + c + " is: " + fact);
	}
}
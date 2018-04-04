import java.util.Scanner;
public class SecondProgram
{
	public static void main(String[] args)
	{
		printMessage();
		areaCircle();
		printOwl();
	}
		
	public static void printMessage()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("What does the owl say?");
		String message=input.nextLine();
		System.out.println();
		int boxLength = (message.length() + 4);
		String boxSide = "";
		for(int i=1;i <= boxLength;i++)
		{
			boxSide += "*";
		}
			
		System.out.println(boxSide);
		System.out.println("| " + message + " |");
		System.out.println(boxSide);
	}
	public static void printOwl()
	{
		System.out.println("     \\");
		System.out.println("      \\");		
		System.out.println("        ^...^  ");
		System.out.println("       / o,o \\");
		System.out.println("       |):::(| ");
		System.out.println("      ===w=w===");	
	}
	public static void areaCircle()
	{
		double nextTerm = 1;
		double denominator = 1;
		double series = 0;
		
		for(int i=0;i<1000000;i++)
		{
			series += (nextTerm/denominator);
			denominator += 2;
			nextTerm *= -1;
		}
		series *= 4;
		Scanner input=new Scanner(System.in);
		System.out.println("What's the radius?");
		double radius=input.nextDouble();
		System.out.println();
		double area = (Math.pow(radius, 2.0) * series);
		System.out.println("The area of a circle with the radius " + radius + " is: " + area);
	}
}

//third floor bette bultena
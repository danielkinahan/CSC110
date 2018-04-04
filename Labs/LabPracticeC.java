import java.util.Scanner;
public class LabPracticeC
{
	public static void sayHello(String name)
	{
		System.out.println("Hello " + name);
	}
	
	public static void Add(int a, int b)
	{
		System.out.println(a+b);
	}

	public static int Add(int a, int b, int c)
	{
		return a + b + c;
	}

	public static void main(String[] args)
	{
		sayHello("Daniel");
		sayHello("Big Moe");
		sayHello("Fiona");
		Add(1,2);
		Add(50,55);
		int sum = Add(1, 2, 3);
		System.out.println(sum);
		while(sum<100000000)
		{
			sum = Add(sum, 20, 30);
			System.out.println(sum);
			int length = sum % 60;
			for(int i = 0; i<length; i++)
			{
				//System.out.print("1");
			}
		}
	}
}
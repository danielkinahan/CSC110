import java.util.Scanner;
public class LabPracticeD
{
	public static void main(String[] args)
	{
		int[] x = {5,9,3,7,2,9,5,3,8,9,5};
		System.out.println(sum(x));
		System.out.println(find(9, x));
		System.out.println(findLongest(x));
		printArray(x);
	}

	public static int sum(int[] arr)
	{
		int x = 0;
		for(int i = 0; i<arr.length;i++)
		{
			x += arr[i];
		}
		return x;
	}
	
	public static boolean find(int target, int[] strings)
	{
		boolean x = false;
		for(int i=0; i<strings.length;i++)
		{
			if(strings[i]==target)
			{
				x = true;
			}
		}
		return x;
	}
	
	public static int findLongest(int[] strings)
	{
		int longest = 0;
		for(int i=0; i<strings.length;i++)
		{
			if(strings[i]>longest)
			{
				longest = strings[i];
			}
		}
		return longest;
	}

	public static void printArray(int[] strings)
	{
		System.out.println("The array contains the following: ");
		for(int i=0; i<strings.length;i++)
		{
			System.out.println(strings[i]);
		}
	}
}
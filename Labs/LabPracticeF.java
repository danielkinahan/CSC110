import java.util.Scanner;
import java.util.InputMismatchException;

public class LabPracticeF
{
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6,7,9,8,10};
		//printArray(arr);
		sortByValue(arr);
		//printArray(arr);
		
		Scanner user = new Scanner(System.in);
		int[] arr2 = stack(user);
		//sortByValue(arr2);
		//printArray(arr2);
		
	}
	
	//selection sort
	public static void sortByValue(int[] a)
	{
		for (int i = 0; i < a.length; i++)
 		{
			int minVal = i;
			for (int j = i+1; j < a.length; j++)
			{
				if (a[j] < a[minVal])
         			{
					minVal = j;
         			}
     			}
 
			if (minVal != i) 
     			{
				int temp = a[minVal];
				a[minVal] = a[i];
				a[i] = temp;
     			}
 		}

	}

	public static void printArray(int[] strings)
	{
		//System.out.println("The array contains the following: ");
		for(int i=0; i<strings.length;i++)
		{
			System.out.print(strings[i] + ", ");
		}
		System.out.println();
	}

	public static int[] stack(Scanner user)
	{
		// push = place integer in array
		// pop = delete previous integer
		// exit = done
		
		int[] stacker = new int[0];
		String command = "";
		while(!command.equals("exit"))
		{
			System.out.println("Enter push, pop or exit: ");
			command = user.next();
			if(command.equals("push"))
			{
				try
				{
					int input = user.nextInt();
					int[] temp = new int[stacker.length+1];
					for(int i = 0; i<stacker.length; i++)
					{
						temp[i] = stacker[i];
					}
					temp[stacker.length] = input;
					stacker = temp;
					printArray(stacker);
				}
				catch(InputMismatchException e)
				{
					System.out.println("ERROR: Bad Input");
				}
			}
			else if(command.equals("pop"))
			{
				int[] temp = new int[stacker.length-1];
				for(int i = 0; i<temp.length; i++)
				{
					temp[i] = stacker[i];
				}
				stacker=temp;
				printArray(stacker);
			}
			else if(command.equals("exit"))
			{
				System.out.println("Goodbye!");
			}
			else
			{
				System.out.println("ERROR: Bad Input");
			}
		}
		return stacker;
	}
}
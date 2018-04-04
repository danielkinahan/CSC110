import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LabPracticeE
{
	public static void main(String[] args)
	{
		int[] arr = {10, 1, 3, 2, 5, 9, 8, 7, 4, 6, 0,};
		printArray(arr);
		sortByValue(arr);
		printArray(arr);
	}
	
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
		System.out.println("The array contains the following: ");
		for(int i=0; i<strings.length;i++)
		{
			System.out.println(strings[i]);
		}
	}

	public static void printTwoDimArray(int[][] x)
	{
		for(int i = 0; i<x.length;i++)
		{
			for(int j = 0; j<x[0].length;j++)
			{
				System.out.print(x[i][j]);
			}
			System.out.println();
		}
	}

	public static void printDiagonal(int[][] x)
	{
		int j = 0;
		for(int i = 0; i<x.length;i++)
		{
			System.out.println(x[i][j]);
			j++;
		}
	}
}